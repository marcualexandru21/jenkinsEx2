def gv
pipeline {
    agent any
    tools{
        maven 'maven-3.9.9'
    }

    stages {

        stage("init"){
            steps{
                script{
                    gv = load "script.groovy"
                }
            }
        }

        stage("build jar"){
            steps{
                gv.buildJar()
            }
        }
        
        stage("build the docker image"){
            steps{                
                gv.buildAndPushImage()                
            }
        }

        stage("deploy app"){
            steps{
                gv.deployApp()
            }
        }
    
    }

}
