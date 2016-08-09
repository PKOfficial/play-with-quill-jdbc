package com.knoldus.connection

import io.getquill._//{H2Dialect, JdbcContext, SnakeCase}

trait H2DBComponent {

  val ctx = new JdbcContext[H2Dialect, SnakeCase]("ctx")

}

