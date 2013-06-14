package actors.modules

import akka.actor._
import common.Messages._
import akka.util.Timeout
import concurrent.ExecutionContext
import twirl.api.Html
import common.Messages.ModuleHTMLRequest
import scala.Some
import spray.routing.HttpServiceActor
import collection.mutable
import common.ModuleType
import akka.cluster._
import akka.cluster.ClusterEvent._
import common.Messages.ChangeModule
import common.Messages.ModuleJsonRequest
import common.Messages.ModuleHTMLRequest
import common.Messages.AddModule
import scala.Some
import common.ModuleType
import akka.pattern.ask

import akka.contrib.pattern.ClusterSingletonManager
import com.typesafe.config.ConfigFactory
import actors.cougar.CougarClientsRepository


class ModuleRepository extends Actor with HttpServiceActor with ActorLogging {
  import scala.collection.mutable.Map
  import context.dispatcher
  implicit val timeout = Timeout(5000)

  var modules     = Map.empty[ModuleType, ActorRef]
  val cluster     = Cluster(context.system)
  val cougarRepo  = context.actorOf(Props[CougarClientsRepository], "cougar_repo")



  override def postStop(): Unit = cluster.unsubscribe(self)

  override def preStart() = {
    initializeMockModules()
    cluster.subscribe(self, classOf[MemberUp])
  }

  def initializeMockModules() = {
    modules  = Map.empty[ModuleType, ActorRef]
    modules += (ModuleType("header")        -> context.actorOf(Props(new Header(cougarRepo)) , "header_actor"))
    modules += (ModuleType("sidebar")       -> context.actorOf(Props(new Sidebar(cougarRepo)) , "sidebar_actor"))
    modules += (ModuleType("infobar")       -> context.actorOf(Props(new Infobar(cougarRepo)) , "infobar_actor"))
    modules += (ModuleType("footer")        -> context.actorOf(Props(new Footer(cougarRepo)) , "footer_actor"))
    modules += (ModuleType("maincontainer") -> context.actorOf(Props(new MainContainer(cougarRepo)) , "maincontainer_actor"))
  }

  def receive = {
    case ModuleHTMLRequest(name,_) => {
      (modules.get(ModuleType(name))) match {
          case None        => l("fuck off")  // TODO: some kind of error handling here
          case Some(actor) => actor forward name
      }
    }
    case ModuleJsonRequest(name, path, params, _) => {
      (modules.get(ModuleType(name))) match {
        case None        => l("fuck off")
        case Some(actor) => actor forward ModuleJsonRequest(name,path,params, 10)
      }
    }
    case AddModule()    => l("TBD")
    case ChangeModule() => l("TBD")
    case state: CurrentClusterState =>
      l("cluster state: " + state)
    case MemberUp(m) ⇒ l("registering " + m)
    case m : ClusterDomainEvent => l("cluster domain event: " + m)
  }




  val TAG = "[ModuleRepository] "
  def l(s: String) : Unit = { println(TAG+s) }


}

object ModuleRepository  {

  def main(args: Array[String]): Unit = {

    if (args.nonEmpty) System.setProperty("akka.remote.netty.tcp.port", args(0))

    val system = ActorSystem("ClusterSystem")
    var repository = system.actorOf(Props(new ClusterSingletonManager(
      singletonProps = handOverData ⇒ Props[ModuleRepository],
      singletonName = "module-repository",
      terminationMessage = PoisonPill)),
      name = "singleton")
    println("Initiated repository:  " + repository.path.toString)
    //system.actorOf(Props[ModuleRepository], "my-modulerepository")
  }
}



//#messages
case class TransformationJob(text: String)
case class TransformationResult(text: String)
case class JobFailed(reason: String, job: TransformationJob)
case object BackendRegistration
//#messages

object TransformationFrontend {
  def main(args: Array[String]): Unit = {
    var params = "akka.remote.netty.tcp.port = "
    if(args.nonEmpty) params += args(0)
    else params += "0"
    // Override the configuration of the port when specified as program argument
    val config = ConfigFactory.parseString(params)

    val system = ActorSystem("ClusterSystem", config)
    val frontend = system.actorOf(Props[TransformationFrontend], name = "frontend")

    import system.dispatcher
    implicit val timeout = Timeout(5000)
    for (n ← 1 to 120) {
      (frontend ? TransformationJob("hello-" + n)) onSuccess {
        case result ⇒ println(result)
      }
      // wait a while until next request,
      // to avoid flooding the console with output
      Thread.sleep(2000)
    }
    system.shutdown()
  }
}

//#frontend
class TransformationFrontend extends Actor {

  var backends = IndexedSeq.empty[ActorRef]
  var jobCounter = 0

  def receive = {
    case job: TransformationJob if backends.isEmpty ⇒
      sender ! JobFailed("Service unavailable, try again later", job)

    case job: TransformationJob ⇒
      jobCounter += 1
      backends(jobCounter % backends.size) forward job

    case BackendRegistration if !backends.contains(sender) ⇒
      context watch sender
      backends = backends :+ sender

    case Terminated(a) ⇒
      backends = backends.filterNot(_ == a)
  }
}



object TransformationBackend {
  def main(args: Array[String]): Unit = {
    // Override the configuration of the port when specified as program argument
    var params =
      """
        |akka.actor.provider = "akka.cluster.ClusterActorRefProvider"
        |
      """.stripMargin + "akka.remote.netty.tcp.port = "
    if(args.nonEmpty) params += args(0)
    else params += "0"
    val config = ConfigFactory.parseString(params)

    val system = ActorSystem("ClusterSystem", config)
    system.actorOf(Props[TransformationBackend], name = "backend")
  }
}

//#backend
class TransformationBackend extends Actor {

  val cluster = Cluster(context.system)

  // subscribe to cluster changes, MemberUp
  // re-subscribe when restart
  override def preStart(): Unit = cluster.subscribe(self, classOf[MemberUp])
  override def postStop(): Unit = cluster.unsubscribe(self)

  def receive = {
    case TransformationJob(text) ⇒ sender ! TransformationResult(text.toUpperCase)
    case state: CurrentClusterState ⇒
      println("cluster state: " + state)
    case MemberUp(m) ⇒ println("member up: " + m)
  }
}
//#backend
