package com.knoldus

import com.knoldus.repository.{Designation, Employee, EmployeeOperations}

object Application extends App{

  val emp = Employee(1, "Prabhat", 24, 1)
  val design = Designation(1, "CEO")
  val result = EmployeeOperations.getEmployeeDetails(1)
  println(result)
  val empList = EmployeeOperations.getAllEmployeesWithDesignation(1)
  println(empList)
  val desig = EmployeeOperations.getDesignationByEmpId(1)
  println(desig)

}
