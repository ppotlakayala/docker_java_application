pipeline {
    agent any
    options {
        skipStagesAfterUnstable()
    }
    stages {
        stage('Gitcode checkout') {
            steps {
                git url: 'https://github.com/ppotlakayala/docker_java_application.git',
                    branch: 'main',
                    credentialsId: 'ef28cd2e-1610-4dea-9a5e-c7d376f0e231'
            }
        }
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
    }
}
