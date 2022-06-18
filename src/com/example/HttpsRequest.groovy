package com.example

import groovy.json.JsonSlurper
import javax.net.ssl.HttpsURLConnection
import javax.net.ssl.SSLContext
import javax.net.ssl.TrustManager
import javax.net.ssl.X509TrustManager
import java.security.cert.CertificateException
import java.security.cert.X509Certificate

class HttpsRequest {

  def get(String uri) {
    httpInternal(uri, null, false)
  }

  def post(String uri, String body) {
    httpInternal(uri, body, true)
  }

  def httpInternal(String uri, String body, boolean isPost) {
    def response = [:]
    def error
    try {
      
      def http = new URL(uri).openConnection() as HttpsURLConnection
      if (isPost) {
        http.setRequestMethod('POST')
        http.setDoOutput(true)
        if (body) {
          http.outputStream.write(body.getBytes("UTF-8"))
        }
      }

      http.setRequestProperty("Accept", 'application/json')
      http.setRequestProperty("Content-Type", 'application/json')
      http.connect()

      if (http.responseCode == 200) {
        response = new JsonSlurper().parseText(http.inputStream.getText('UTF-8'))
      } else {
        response = -1
      }
    } catch (Exception e) {
      println(e)
      error = e
    }
    return [response, error]
  }
}
