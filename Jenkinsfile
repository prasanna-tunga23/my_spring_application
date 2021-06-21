pipeline {
    agent {
        docker {
            image 'maven:3-alpine'
            args '-v /root/.m2:/root/.m2'
        }
    }

    triggers {
        pollSCM '* * * * *'
    }
    stages {
        stage('Build') {
            steps {
                sh 'mvn assemble'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
    }
}
