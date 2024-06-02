<<<<<<< HEAD
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
                script {
                    gv.buildJar()

                }
            }
        }

        stage("build image") {
            steps {
                script {
                    gv.buildImage()
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    gv.deployApp()
                }
            }
        }               
    }
} 
=======
def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9'
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
                script {
                    gv.buildJar ()
                }
            }
        }
        stage("build image") {
            steps {
                script {
                   gv.buildImage ()
                }
            }
        }
        stage("deploy") {
            steps {
                script {
                    gv.deployApp
                }
            }
        }
    }
}
>>>>>>> 9fb488106918b583982f2d7ed351d65904895e0e
