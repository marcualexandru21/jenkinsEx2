pipeline {   
    agent any
    stages {
        stage("test") {
            steps {
                script {
                    echo "Testing the application...."
                    echo  "Executing pipeline for branch $BRANCH_NAME"
                }
            }
        }
        
        stage("build") {
            when {
                expression{
                      BRANCH_NAME=="MASTER"
                }
            }
            steps {
                script {
                    echo "Building the application...."
                }
            }
        }

        stage("deploy") {
              when {
                expression{
                      BRANCH_NAME=="MASTER"
                }
            }
            steps {
                script {
                    def dockerCmd = 'docker run -p 3080:3080 -d vmcgtlx/cgtlx-nana:5.0 '
                   sshagent(['ade94bf7-b25d-40de-929b-7bf1d38efcbc']) {

                     sh "ssh -o StrictHostKeyChecking=no ubuntu@18.188.120.79 ${dockerCmd}"  
    // some block
}
                }
            }
        }               
    } // Closes 'stages' block
} // Closes 'pipeline' block

