package com.example

class Telegram {
    String name
    Integer age
    def steps
    Telegram(steps) {
        this.steps = steps
    }
   def increaseAge(Integer years) {
      this.age += years
      steps.println "Hello from Telegram"
   }
}