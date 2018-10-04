package controllers

import javax.inject._
import play.api.mvc._

import play.api.data._
import play.api.data.Forms._

import services._

class TodoController @Inject()(todoService: TodoService, mcc: MessagesControllerComponents) extends MessagesAbstractController(mcc) {
  def helloworld() = Action{ implicit request: MessagesRequest[AnyContent] =>
    // ここのOKはステータスコード200で引数を返しますよってこと404ならNotFound()
    Ok("Hello World!")
  }

  def list() = Action { implicit request: MessagesRequest[AnyContent] =>
    val items: Seq[Todo] = todoService.list()
    Ok(views.html.list(items))
  }
}