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
    withCredentials([usernamePassword(credentialsId: 'docker-credentials', passwordVariable: 'PASS', usernameVariable: 'USER')]) {
        sh "docker build -t hamsamuxumed/priv-docker-images:jma5.0 ."
        sh "echo $PASS | docker login -u $USER --password-stdin"
        sh "docker push hamsamuxumed/priv-docker-images:jma5.0"
    }
}


def deployApp() {
    
    echo 'deploying the application..'
}


return this
