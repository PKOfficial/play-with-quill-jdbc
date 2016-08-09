package com.knoldus.connection

import io.getquill.{JdbcContext, MySQLDialect, SnakeCase}

trait MySqlDBComponent extends DBComponent{

  val ctx = new JdbcContext[MySQLDialect, SnakeCase]("ctx")

}

object MySqlDBComponent extends MySqlDBComponent