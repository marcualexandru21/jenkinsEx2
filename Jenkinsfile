pipeline {
    agent any
    stages {
        stage('test') {
            steps {
               script {
                   echo 'testing the app'
                   echo "Executing pipeline for branch $BRANCH_NAME"
               }
            }
        }
        stage('build') {
            steps {
               script {
                   echo 'building the app'
                
               }
            }
        }
        stage('deploy') {
            steps {
                script {
                   echo 'deploying the app'
               }
            }
        }
    }
}

