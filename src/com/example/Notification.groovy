package com.example

class Notification {
    String token
    String message
    String chatID
    
    def steps
    Notification(steps) {
        this.steps = steps
    }
   def sendMessage(chatID,token,message) {
      steps.println "Start send message to Telegram"
      sh "curl -v https://api.telegram.org"
      steps.println "End send message to Telegram"
   }
}