@Library('jenkins-shared-library') _

import com.example.GlobalVariables
import com.example.SampleClass

pipeline {
    agent any
    stages {
        stage('Demo') {
            steps {
                echo 'The foo is : ' + GlobalVariables.foo
                script {
                    def buddy = new SampleClass()
                    buddy.age = 22
                    buddy.increaseAge(10)
                    echo 'Finally age, is now : ' + buddy.age
                }
            }
        }
    }
}