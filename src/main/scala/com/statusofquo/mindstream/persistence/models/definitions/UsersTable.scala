package models.definitions

import models.{UserId, User}
import slick.driver.PostgresDriver.api._

class UsersTable(tag: Tag) extends Table[User](tag: "users") {
  def id = column[UserId]("id", O.PrimaryKey, O.AutoInc)
  def username = column[String]("username")
  def password = column[String]("password")
  def firstname = column[String]("firstname")
  def lastname = column[String]("lastname")
  def * = (id.?, username, password, firstname, lastname) <> (User.apply_).tupled, User.unapply)
}
