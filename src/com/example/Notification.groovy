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
      steps.sh "curl -s -X POST https://api.telegram.org/bot${token}/sendMessage -d chat_id=${chatID} -d text=${message}"
      steps.println "End send message to Telegram"
   }
}