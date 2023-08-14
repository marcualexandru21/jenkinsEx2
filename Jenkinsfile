pipeline {   
    agent any
    tools {
        maven 'maven-3.9.4'
    }
    stages {
        stage("built jar") {
            steps {
                script {
                    echo "building the application..."
                    sh 'mvn package'
                }
            }
        }
        stage("build image") {
            steps {
                script {
                    echo "building the docker image"
                    withCredentials ( [usernamePassword(credentialsId:'docker-hub-repo', passwordVariable:"PASS", usernameVariable:'USER')])
                    sh 'docker build -t mydockeranca/demo-app:jma:2.0 .'
                    sh 'docker login -u $USER --password- stdin'
                    sh 'docker push mydockeranca/demo-app:jma:2.0'
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
