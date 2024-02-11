def gv

pipeline {
    agent any
    parameters {
        choice(name: 'VERSION', choices: ['1.1.0', '1.2.0', '1.3.0'], description: 'version to deploy on prod')
        booleanParam(name: 'executeTest', defaultValue: true, description: ' ')
    }
    stages {
        stage('init') {
            steps {
               script {
                   gv = load "script.groovy"
               }
            }
        }
        stage('build') {
            steps {
               script {
                   gv.buildApp()
               }
            }
        }
        stage('test') {
            when {
               expression {
                  params.executeTests
               }
            }
            steps {
               script {
                   gv.testApp()
               }
            }
        }
        stage('deploy') {
            steps {
                script {
                   env.ENV = input message: "Select the environment to deploy to", ok "Done", parameters: [choice(name: 'ONE', choices: ['dev', 'stage', 'prod'], description: 'env to deploy')]
                   gv.deployApp()
                   echo "Deploying to ${ENV}"
               }
            }
        }
    }
}

