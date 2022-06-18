package com.example

import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import static groovy.test.GroovyAssert.*

class SampleClassTest {
  def sampleClass

  @Before
  void setUp() {
    sampleClass = new SampleClass()
  }

  @Test
  void testIncrease() {
    sampleClass.age = 7  
    def expect = 10
    assertEquals expect, sampleClass.increaseAge(3)
  }
}