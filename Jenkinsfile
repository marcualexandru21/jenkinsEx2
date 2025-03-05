#!/user/bin/env groovy

library identifier: 'jenkins-shared-library@master', retriever: modernSCM(
    [$class: 'GitSCMSource',
    remote: 'https://github.com/marcualexandru21/jenkins-shared-library.git',
    credentialsId: 'github-credentials'])

def gv

pipeline {
    agent any
    tools {
        maven 'maven-3.9.9'
    }

    stages {

        stage("increment version") {
            steps {
                script {
                   sh 'mvn build-helper:parse-version versions:set \
                   -DnewVersion=\\\${parsedVersion.majorVersion}.\\\${parsedVersion.minorVersion}.\\\${parsedVersion.nextIncrementalVersion} \
                   versions:commit'
                }
            }
        }

        stage("init") {
            steps {
                script {
                    gv = load "script.groovy"
                }
            }
        }

        stage("build jar") {
            steps {
                script{
                    buildJar()
                }
            }
        }

        stage("build the docker image") {
            steps {
                script{
                    def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                    def version = matcher[0][1]
                    IMAGE_NAME = "${version}-${BUILD_NUMBER}"

                    buildImage "mbradu/demo-app-twn:jma-${IMAGE_NAME}"
                    dockerLogin()
                    dockerPush "mbradu/demo-app-twn:jma-${IMAGE_NAME}"
                }
            }
        }

        stage("deploy app") {
            steps {
                script{
                    gv.deployApp()
                }
            }
        }

    }

}