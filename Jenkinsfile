#!/user/bin/env groovy
@Library('jenkins-shared-library')
def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9.9'
    }

    stages {

        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build jar") {
            steps {
                script{
                    buildJar()
                }                
            }
        }
        
        stage("build the docker image") {
            steps {   
                script{
                    buildImage 'mbradu/demo-app-twn:jma-6.0'
                    dockerLogin()
                    dockerPush 'mbradu/demo-app-twn:jma-6.0'
                }            
            }
        }

        stage("deploy app") {
            steps {
                script{
                    gv.deployApp()
                }                
            }
        }
    
    }

}
