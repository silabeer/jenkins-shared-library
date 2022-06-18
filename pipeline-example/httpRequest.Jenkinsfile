@Library('jenkins-shared-library') _

import com.example.HttpsRequest

pipeline {
    agent any
    stages {
        stage('Demo') {
            steps {
                script {
                    def http = new HttpsRequest()
                    def (result, error) = http.get("https://run.mocky.io/v3/0bd64f74-1861-4833-ad9d-80110c9b5f25")
                    if (error != null) {
                        println(error)
                    } else {
                        println result
                    }
                    
                }
            }
        }
    }
}