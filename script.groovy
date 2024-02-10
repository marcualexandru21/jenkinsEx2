def testApp() {
    
    echo 'testing the application..'
    echo "Executing pipeline branch for $BRANCH_NAME"
}

def buildJar() {
 
    echo 'building the application..'
    sh "mvn package"
}

def buildImage() {
    
    echo 'building the image..'
    withCredentials([
        usernamePassword(credentialsID: 'docker-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')
    ])
        sh "docker build -t priv-docker-images:jma3.0"
        sh "echo $PASSWORD | docker login -u $USER --password-stdin"
        sh "docker push priv-docker-images:jma3.0"
}


def deployApp() {
    
    echo 'deploying the application..'
}


return this
