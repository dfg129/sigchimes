package com.statusofquo.container
package docker

import akka.actor.{ Actor, ActorSystem }
import akka.event.Logging
import akka.testkit.{ TestKit, TestActorRef, ImplicitSender }
import org.scalatest.concurrent.ScalaFutures
import org.scalatest.{ BeforeAndAfterAll, Matchers, WordSpecLike }
import akka.stream.ActorMaterializer
import scala.concurrent.Await
import scala.concurrent.duration._
import com.typesafe.scalalogging._


class ContainerInfoSpec() extends TestKit(ActorSystem())
  with ImplicitSender
  with WordSpecLike
  with Matchers
  with ScalaFutures
  with LazyLogging
  with BeforeAndAfterAll {

  //override implicit val system = ActorSystem("docker")

//  val actorSystem = ActorSystem("docker")

val testRef = system.actorOf(ContainerInfoActor.props(testActor))


   "A test" should {
       "run test1" in {
         info("####    testing 1")
       }
   }

   "A docker info actor" should {
    "return return docker machine info" in {
      val actorRef = TestActorRef(ContainerInfoActor.props(testActor))

      DockerRemoteComm.init
      DockerRemoteComm.getDockerInfo(actorRef)
    }
  }
}
