pipeline {
    agent any
    stages {
        stage('Checkout Code') { // Clones the repository
            steps {
                git 'https://github.com/ppotlakayala/docker_java_application.git'
            }
        }

        stage('Build with Maven') { // Builds the project and creates JAR/WAR
            steps {
                sh 'mvn clean package'
            }
        }
    }
}
