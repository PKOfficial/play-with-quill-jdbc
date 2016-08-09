package com.knoldus.repository

import com.knoldus.connection.MySqlDBComponent.ctx

trait DesignationRepository {

  import ctx._

  def getDesignationByEmpId(empId: Int): String = {
    def getDesignationByEmpIdQuery(empId: Int) = quote {
      for {
        emp <- query[Employee] if emp.id == lift(empId)
        designation <- query[Designation] if designation.id == emp.designation
      } yield {
        designation.name
      }
    }
    val result = ctx.run(getDesignationByEmpIdQuery(empId))
    result.head
  }

  def getDesignationName(id: Int) = {
    def getQuery(id: Int) = {
      quote {
        query[Designation].filter(designation => designation.id == lift(id))
      }
    }
    ctx.run(getQuery(id))
  }

  def insertDesignation(designation: Designation) = {
    val q = quote(query[Designation].insert)
    ctx.run(q)(List(designation)).head
  }

  def deleteDesignation(id: Int): Long = {
    EmployeeOperations.deleteEmployeesWithDesignation(id)
    val deleteQuery = quote {
      query[Designation].filter(designation => designation.id == lift(id)).delete
    }
    ctx.run(deleteQuery)
  }

}

object DesignationOperation extends DesignationRepository

case class Designation(id: Int, name: String)
