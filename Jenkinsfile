def gv

pipeline {
    agent any
    environment {
        NEW_VERSION='1.3.0'
        SERVER_CREDENTIALS = credentials('server-credential')
    }

    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: '')
        booleanParam(name: 'executeTests', defaultValue: true, description: '')
    }

    stages {
        stage('init') {
            script {
                gv = load "script.groovy"
            }
        }

        stage('build') {
            script {
                gv.buildApp
            }
        }
        stage('test') {
            when {
                expression {
                    params.executeTests
                }
            }
            script {
                gv.testApp
            }
        }
        stage('deploy') {
            steps {
                script {
                    gv.deployApp
                }
                echo "deploying version ${params.VERSION}"
            }
        }
        
    }
}
