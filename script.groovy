def buildJar() {
    echo "Building the jar"
    sh 'mvn package'
}

def buildAndPushImage() {
    echo "Building the docker image"
    withCredentials([usernamePassword(credentialsId: 'docker-hub-repo', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh 'docker build -t mbradu/demo-app-twn:jma-2.0 .'
        sh "echo ${PASS} | docker login -u ${USER} --password-stdin"
        sh 'docker push mbradu/demo-app-twn:jma-2.0'
    }
}

def deployApp() {
    echo 'deploying the application...'
}

return this
