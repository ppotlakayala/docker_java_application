pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Gitcode checkout') {
            steps {
                withCredentials([string(credentialsId: 'github-pat', variable: 'GITHUB_TOKEN')]) {
                }
            }
        }
        //stage('Vulnerability Scan') {
            //steps {
                //sh 'dependency-check --project MyApp --scan . --format HTML --out dependency-check-report'
                //--nvdApiKey 17dc303e-74ca-4342-9c88-1f7b0e3163cc
            //}
        //}
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('SonarQubeServer') {
                    sh 'SonarQubeScanner -Dsonar.projectKey=docker_java_application -Dsonar.sources=.'
                }
            }
        }
    }
}
