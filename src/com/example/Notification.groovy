package com.example
import groovy.text.SimpleTemplateEngine

class Notification {

def steps
    Notification(steps) {
        this.steps = steps
    }
def sendMessage(env, Map config = [:]) {
    def token = config.token
    def chatID = config.chatID ?: '177385570'    
    def message = steps.libraryResource 'message'
    def bindMap = [buildID: env.BUILD_NUMBER, logs: env.BUILD_URL]
    def telegramText = new SimpleTemplateEngine().createTemplate(message).make(bindMap)
    steps.println "Start send message to Telegram"
    steps.sh "curl -s -X POST https://api.telegram.org/bot$token/sendMessage -d chat_id=$chatID -d text=\"$telegramText\""
   }
}