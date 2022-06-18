
package com.example 

import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import static groovy.test.GroovyAssert.*

class GlobalVariableTest {
  def var 

  @Before
  void setUp() {
    var = new GlobalVars()
  }

  @Test
  void testVar() {
    def expect = "bar"
    assertEquals expect, var.foo
  }
}