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
                   // def matcher = readFile('pom.xml') =~ '<version>(.+)</version>'
                   // def version = matcher[0][1]
                    def version = sh(script: "mvn help:evaluate -Dexpression=project.version -q -DforceStdout", returnStdout: true).trim()
                    env.IMAGE_NAME = "${version}-${BUILD_NUMBER}"

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

        stage('commit version update') {
            steps {
                script {
                    withCredentials([usernamePassword(credentialsId: 'git-push-token-as-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
                        sh 'git config user.email "marcualexandru21@gmail.com"'
                        sh 'git config user.name "marcualexandru21"'

                        sh 'git status'
                        sh 'git branch'
                        sh 'git config --list'

                        sh "git remote set-url origin https://${USER}:${PASS}@github.com/marcualexandru21/jenkinsEx2.git"
                        sh 'git add .'
                        sh 'git commit -m "ci: version bump"'
                        sh 'git push origin HEAD:jenkins-shared-library'
                    }
                }
            }
        }

    }

}