package db.connection

import slick.jdbc.MySQLProfile

trait MySqlAdapter {
  val driver = MySQLProfile

  import driver.api._

  val db: Database = DbConfig.connectionPool
}

private[connection] object DbConfig {
  import slick.jdbc.MySQLProfile.api._
  val connectionPool = Database.forConfig("mysql")
}
