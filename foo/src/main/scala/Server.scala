import akka.actor.ActorSystem
import akka.actor.Status.{Failure, Success}
import akka.stream.ActorMaterializer

import scala.concurrent.ExecutionContext
import akka.http.scaladsl.Http
import akka.http.scaladsl.model.{ContentTypes, HttpEntity}
import akka.http.scaladsl.server.Directives._
import akka.stream.ActorMaterializer

import scala.io.StdIn

object Server extends App {






  override def main(args: Array[String]): Unit = {

    val host = "0.0.0.0"
    val port = 9000

    implicit val system: ActorSystem = ActorSystem("helloworld")
    implicit val executor: ExecutionContext = system.dispatcher
    implicit val materializer: ActorMaterializer = ActorMaterializer()



    val bindingFuture = Http().bindAndHandle(route, host, port)

    bindingFuture.onComplete {
      case scala.util.Success(serverBinding) => println(s"listening to ${serverBinding.localAddress}")
      case scala.util.Failure(error) => println(s"error: ${error.getMessage}")
    }

  }

  def route = path("hello") {
    get {
      complete("Hello, World!")
    }
  }



}
