package com.knoldus.connection

import io.getquill.context.sql.idiom.SqlIdiom
import io.getquill.{H2Dialect, JdbcContext, MySQLDialect, SnakeCase}

trait DBComponent {

  val ctx: JdbcContext[_ >: MySQLDialect with H2Dialect <: SqlIdiom, SnakeCase]

}
