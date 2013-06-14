package actors.modules

import akka.actor.{ActorRef, Props, Actor}
import common.Messages.{ModuleJsonRequest, RenderedModule, ModuleHTML}
import spray.json._
import DefaultJsonProtocol._
import spray.client._
import actors.modules.interface.ModuleActor



class Header(cougarRepo: ActorRef) extends ModuleActor("modules/header.conf", cougarRepo) {
  val TAG = "[HeaderActor] "
  val data : ModuleHTML = ModuleHTML(html.header.render(), html.header_head.render("header.css", "header.js"))
}

class Sidebar(cougarRepo: ActorRef) extends ModuleActor("modules/sidebar.conf", cougarRepo) {
  val TAG = "[SidebarActor] "
  val data : ModuleHTML = ModuleHTML(html.sidebar.render("Bob", 42), html.header_head.render("sidebar.css", "sidebar.css"))
}

class Infobar(cougarRepo: ActorRef) extends ModuleActor("modules/infobar.conf", cougarRepo) {
  val TAG = "[InfobarActor] "
  val data : ModuleHTML = ModuleHTML(html.infobar.render(), html.infobar_head.render("infobar.css", "infobar.js"))
}

class Footer(cougarRepo: ActorRef) extends ModuleActor("modules/footer.conf", cougarRepo) {
  val TAG = "[FooterActor] "
  val data : ModuleHTML = ModuleHTML(html.footer.render(), html.footer_head.render("footer.css", "footer.js"))
}

class MainContainer(cougarRepo: ActorRef) extends ModuleActor("modules/maincontainer.conf", cougarRepo) {
  val TAG = "[MainContainerActor] "
  val data : ModuleHTML = ModuleHTML(html.maincontainer.render(), html.maincontainer_head.render("maincontainer.css", "maincontainer.js"))
}

