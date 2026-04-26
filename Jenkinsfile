pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                        url: 'https://github.com/Vincenzo0297/ParaBank-TestNg-Frontend-Automation.git'
            }
        }

        stage('Build & Test') {
            steps {
                // Run your TestNG tests
                sh 'mvn clean test'
            }
        }
    }

    post {
        always {
            // Publish TestNG results in Jenkins
            junit 'target/surefire-reports/*.xml'
        }

        success {
            echo 'All tests passed ✅'
        }

        failure {
            echo 'Some tests failed ❌'
        }
    }
}