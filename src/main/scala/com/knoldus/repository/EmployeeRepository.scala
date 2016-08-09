package com.knoldus.repository
import com.knoldus.connection.MySqlDBComponent.ctx
import com.knoldus.repository.Designation
trait EmployeeRepository{

  import ctx._

  def getDesignationByEmpId(empId: Int): String = {
    def getDesignationByEmpIdQuery(empId : Int) = quote {
      for {
        emp <- query[Employee] if emp.id == lift(empId)
        desig <- query[Designation] if desig.id == emp.designation
      } yield {
        desig.name
      }
    }
    val result = ctx.run(getDesignationByEmpIdQuery(empId))
    result.head
  }

  def getEmployeeDetails(empId: Int): Employee = {
    def getEmployeeDetailsQuery(empId : Int) =
    quote {
      query[Employee].filter(emp => emp.id == lift(empId))
    }
    ctx.run(getEmployeeDetailsQuery(empId)).head
  }

  def getAllEmployeesWithDesignation(dId: Int): List[Employee] = {
    def findQuery(dId: Int) = {
      quote {
        query[Employee].filter(emp => emp.designation == lift(dId))
      }
    }
    ctx.run(findQuery(dId))
  }

  def insertEmployee(emp: Employee): Long = {
    val q = quote(query[Employee].insert)
    ctx.run(q)(List(emp)).head
  }

  def deleteEmployee(empId: Int): Long = {
    val deleteQuery = quote{
      query[Employee].filter(emp => emp.id == lift(empId)).delete
    }
    ctx.run(deleteQuery)
  }

  def deleteEmployeesWithDesignation(dId :Int)={
    def deleteQuery(dId :Int) = {
      quote{
        query[Employee].filter(emp => emp.designation == lift(dId)).delete
      }
    }
    ctx.run(deleteQuery(dId))
  }

}

object EmployeeOperations extends EmployeeRepository

case class Employee(id: Int, name: String, age: Int, designation: Int)

