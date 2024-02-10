def buildApp() {
    
    echo 'building the application..'
    sh "mvn install"
    echo "Build version ${params.VERSION}"
}

return this

def deployApp() {
    echo 'deploying the application...'
}

return this
