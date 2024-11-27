pipeline {
    agent any
    tools {
        maven 'maven-3.9' // Ensure this matches the Maven installation name in Jenkins
    }
    stages {
        stage('Build') {
            steps {
                echo 'Building the application...'
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                echo 'Running tests...'
                sh 'mvn test'
            }
        }
        stage('Build Image') {
            steps {
                echo 'Building Docker image...'
                // Add Docker commands here, e.g.:
                // sh 'docker build -t myapp:latest .'
            }
        }
    }
}
