#!/usr/bin.env groovy

pipeline {   
    agent any
    stages {
        stage("test") {
            steps {
                script {
                    echo "Testing the application..."

                }
            }
        }
        stage("build") {
            steps {
                script {
                    echo "Building the application..."
                }
            }
        }

        stage("deploy") {
            steps {
                script {
                    def dockerCmd = 'docker run -d -p 8080:8080 hamsamuxumed/priv-docker-images:jma4.0'
                    echo "Deploying the application..."
                    sshagent(['ec2-server-key']) {
                        sh "ssh -o StrictHostKeyChecking=no ec2-user@13.42.19.18 ${dockerCmd}"
                    }
                }
            }
        }               
    }
} 
x
