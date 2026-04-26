pipeline {
    agent any

    stages {

        stage('Checkout') {
            steps {
                git branch: 'main',
                        url: 'https://github.com/Vincenzo0297/ParaBank-TestNg-Frontend-Automation.git'
            }
        }

        stage('Build Docker Image') {
            steps {
                bat 'docker build -t selenium-testng .'
            }
        }

        stage('Run Tests in Docker') {
            steps {
                bat 'docker run -t selenium-testng'
            }
        }
    }

    post {
        always {
            junit allowEmptyResults: true,
                    testResults: 'target/surefire-reports/*.xml'
        }

        success {
            echo 'Docker tests passed ✅'
        }

        failure {
            echo 'Docker tests failed ❌'
        }
    }
}