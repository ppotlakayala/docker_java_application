pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    //tools {
        //sonar 'SonarQube Scanner 7.3.0.5189' //
    //}
    stages {
        stage('Gitcode checkout') {
            steps {
                git branch: 'main',
                    credentialsId: 'github-pat',
                    url: 'https://github.com/ppotlakayala/docker_java_application.git'
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
                sh 'mvn clean sonar:sonar'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('SonarQube analysis') {
            steps {
                script {
                    def scannerHome = tool 'SonarQube Scanner 7.3.0.5189'
                    withSonarQubeEnv('SonarQubeServer') {
                        sh "${scannerHome}/bin/sonar-scanner -Dsonar.projectKey=docker_java_application -Dsonar.sources=."
                    }
                }
            }
        }
    }
}
