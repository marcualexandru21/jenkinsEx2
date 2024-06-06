def gv

pipeline {   
    agent any
    tools {
        maven 'maven-3.9'
    }
    stage('build app') {
                steps {
                    script {
                        echo 'building the application...'
                        sh 'mvn package'
                    }
                }
            }
            stage('build image') {
                steps {
                    script {
                        echo "building the docker image..."
                        withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]){
                            sh "docker build -t nanatwn/demo-app:${IMAGE_NAME} ."
                            sh 'echo $PASS | docker login -u $USER --password-stdin'
                            sh "docker push nanatwn/demo-app:${IMAGE_NAME}"
                        }
                    }
                }
            }
            stage('deploy') {
                steps {
                    script {
                        echo 'deploying docker image...'
                    }
                }
            }
    }
} 
