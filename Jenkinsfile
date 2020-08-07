pipeline {
    agent any
    tools {
        maven 'mavenAutomatic'
    }
    stages {
        stage('SCM') {
            steps {
                echo 'Copying repository ftom GitHub...'
                git 'https://github.com/mounamukhar/edureka-final-project-UAT.git'
            }
        }
        stage('Compile') {
            steps {
                echo 'Compiling code...'
                sh 'mvn clean compile'
            }
        }
        stage("SonarQube analysis") {
          steps {
             withSonarQubeEnv('SonarDemoServer') {
                sh 'mvn sonar:sonar'
             }
          }
        }
        stage('Test') {
            steps {
                echo 'Testing..'
            }
        }
    }
}
