package db.repository

import db.connection.MySqlAdapter
import db.model.User

import scala.concurrent.Future

trait UserRepository extends UserTable {this: MySqlAdapter =>
  import driver.api._

  /**
    * @param user
    * create new user
    */
  def create(user: User): Future[Int] = db.run { userTableAutoInc += user }

  /**
    * @param user
    * update existing user
    */
  def update(user: User): Future[Int] = db.run { userTableQuery.filter(_.id === user.id.get).update(user) }

  /**
    * @param id
    * Get user by id
    */
  def getById(id: Int): Future[Option[User]] = db.run { userTableQuery.filter(_.id === id).result.headOption }

  /**
    * @return
    * Get all users
    */
  def getAll(): Future[List[User]] = db.run { userTableQuery.to[List].result }

  /**
    * @param id
    * delete user by id
    */
  def delete(id: Int): Future[Int] = db.run { userTableQuery.filter(_.id === id).delete }
}

trait UserTable { this: MySqlAdapter =>
//private[repository] trait UserTable { this: MySqlAdapter =>

  import driver.api._

  private[UserTable] class UserTable(tag: Tag) extends Table[User](tag, "user") {
    val id = column[Int]("id", O.PrimaryKey, O.AutoInc)
    val name = column[String]("name")
    def * = (id.?, name) <> (User.tupled, User.unapply)

  }

  protected val userTableQuery = TableQuery[UserTable]

  protected def userTableAutoInc = userTableQuery returning userTableQuery.map(_.id)

}
