pipeline {
    agent any
    tools{
        maven 'maven-3.9.9'
    }

    stages {

        stage("build jar"){
            steps{
                echo "Building the jar"
                sh 'mvn package'
            }
        }
        
        stage("build the docker image"){
            steps{
                echo "Building the docker image"
                withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                    sh 'docker build -t mbradu/demo-app-twn:jma-2.0 .'
                    sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
                    sh 'docker push mbradu/demo-app-twn:jma-2.0'
                }
                
            }
        }
    
    }

}
