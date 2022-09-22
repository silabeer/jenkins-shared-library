package com.example

class Notification {

def steps
    Notification(steps) {
        this.steps = steps
    }
def sendMessage(Map config = [:]) {
    def token = config.token
    def chatID = config.chatID
    def message = config.message ?: 'Test message'

    steps.println "Start send message to Telegram"
    steps.sh "curl -s -X POST https://api.telegram.org/bot$token/sendMessage -d chat_id=$chatID -d text=\"$message\""
    steps.println "End send message to Telegram"
   }

def readPropFile() {
    def scriptcontents = libraryResource 'test.properties'
    def props = readProperties text: scriptcontents
    steps.println props.chatID
}
}