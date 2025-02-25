@@ -1,39 +1,41 @@
def gv

pipeline {   
    agent any
    tools {
        maven 'Maven'
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
                script {
                    gv.buildJar()

                }
            }
        }

        stage("build image") {
            steps {
                script{
                script {
                    gv.buildImage()
                }
            }
        }

        stage("deploy") {
            steps {
                script{
                script {
                    gv.deployApp()
                }
            }
        }               
    }
} 
