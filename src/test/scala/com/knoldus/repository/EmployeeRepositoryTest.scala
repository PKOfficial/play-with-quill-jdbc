package com.knoldus.repository

import org.scalatest.FunSuite
import com.knoldus.connection.H2DBComponent
/**
  * Created by prabhat on 9/8/16.
  */
class EmployeeRepositoryTest extends FunSuite with H2DBComponent {

  test("this test"){
    val result = EmployeeOperations.getEmployeeDetails(1)
    assert(result.id == 1)
  }

}
