package com.example

class Notification {
    String name
    Integer age
    def steps
    Notification(steps) {
        this.steps = steps
    }
   def increaseAge(Integer years) {
      this.age += years
      steps.println "Hello from Telegram"
   }
}