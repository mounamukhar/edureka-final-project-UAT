pipeline {
    agent any
    tools {
        maven 'mavenAutomatic'
    }
    stages {
        stage('SCM') {
            steps {
                echo 'Copying repository ftom GitHub...'
                git 'https://github.com/mounamukhar/cyborgAutomation.git'
            }
        }
        stage("SonarQube analysis") {
          steps {
             withSonarQubeEnv('SonarDemoServer') {
                sh 'mvn clean package sonar:sonar'
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
