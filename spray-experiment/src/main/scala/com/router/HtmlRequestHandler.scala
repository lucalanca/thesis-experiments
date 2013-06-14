package com.router

import common.Messages.{ModuleJsonRequest, PageRequest}
import concurrent.Await
import akka.actor.{Actor, ActorRef}
import akka.util.Timeout
import akka.pattern.ask
import twirl.api.Html
import spray.routing.HttpServiceActor
import spray.http.MediaTypes._
import common.Messages.ModuleJsonRequest
import common.Messages.PageRequest
import spray.http.DateTime

class HtmlRequestHandler(pagesRepo: ActorRef, modulesRepo: ActorRef) extends Actor with HttpServiceActor {
  val TAG = "[MyRouter] "
  def l(s: String) : Unit = { println(TAG+s) }

  implicit val timeout = Timeout(5000)

  def receive = runRoute {
    path("") {
      respondWithMediaType(`text/html`) {complete(viewFor("index")) }
    } ~
    path(PathElement) { _ =>
      respondWithMediaType(`text/html`) {complete(viewFor("exchange")) }
    }
  }

  def viewFor(path: String) : String = {
    var future = pagesRepo ? PageRequest(path, 10)
    Await.result(future, timeout.duration).asInstanceOf[Html].toString
  }
}
