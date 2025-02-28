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
                    gv.buildJar()
                }                
            }
        }
        
        stage("build the docker image") {
            steps {   
                script{
                    gv.buildAndPushImage()
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
