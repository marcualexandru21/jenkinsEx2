def buildJar() {
 
    echo 'building the application..'
    sh "mvn package"
}

def buildImage() {
    
    echo 'building the image..'
    withCredentials([usernamePassword(credentialsID: 'docker-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')])
        sh "docker build -t priv-docker-images:jma3.0"
        sh "echo $PASSWORD | docker login -u $USER --password-stdin"
        sh "docker push priv-docker-images:jma3.0"
}


def deployApp() {
    
    echo 'build deployed..'
}


return this
