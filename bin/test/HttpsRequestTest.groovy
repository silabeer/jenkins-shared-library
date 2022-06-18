package com.example

import org.junit.Before
import org.junit.Ignore
import org.junit.Test
import groovy.json.JsonSlurper
import static groovy.test.GroovyAssert.*


class HttpsRequestTest {
  def http
  def json
  def var 

  @Before
  void setUp() {
    http = new HttpsRequest()
    json = new JsonSlurper()
    http.setTestMode(true)
  }

  @Test
  void testGet() {
    def expect = json.parseText('{"hello":"slurm"}')
    def (result, error) = http.get("https://run.mocky.io/v3/0bd64f74-1861-4833-ad9d-80110c9b5f25")
    if (error != null) {
      println(error)
    }
    assertEquals "result:", expect, result
  }


  @Test
  void testBadLink() {
    def (result, error) = http.get("https://run.mocky.io/v3/0bd64f74-1861-4833-ad9d-80110c9b5f2aa")
    if (error != null) {
      println(error)
    }
    assertEquals "result:",-1, result
  }

  @Test
  void testPost() {
    def expect = json.parseText('{"hello":"slurm"}')
    def (result, error) = http.post("https://run.mocky.io/v3/0bd64f74-1861-4833-ad9d-80110c9b5f25", null)
    if (error != null) {
      println(error)
    }

    assertEquals "result:", expect, result
  }
}