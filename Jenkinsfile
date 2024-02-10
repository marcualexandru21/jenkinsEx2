def gv

pipeline {   
    agent any
    tools {
        maven 'Maven-3.9.6'
    }

    stages {
        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("test") {
            steps {
                script {
                    gv.testApp()
                }
            }
        }

        stage("build jar") {
            when {
                expression {
                    BRANCH_NAME == "master"
                }
            }
            steps {
                script {
                    gv.buildJar()

                }
            }
        }

        stage("build image") {
            when {
                expression {
                    BRANCH_NAME == "master"
                }
            }
            steps {
                script {
                    gv.buildImage()
                }
            }
        }

        stage("deploy") {
            when {
                expression {
                    BRANCH_NAME == "master"
                }
            }
            
            steps {
                script {
                    gv.deployApp()
                }
            }
        }               
    }
