pipeline {
    agent any

    tools {
        maven 'Maven 3.8.1'   // Replace with your configured Maven name in Jenkins
        jdk 'JDK 11'          // Replace with the JDK installed on Jenkins
    }

    environment {
        CHROME_BIN = "/usr/bin/google-chrome"
        CHROMEDRIVER_PATH = "/usr/local/bin/chromedriver"
    }

    stages {
        stage('Checkout Code') {
            steps {
                git 'https://github.com/sachin123/FlipkartSelenium.git' // Replace with your actual repo
            }
        }

        stage('Build with Maven') {
            steps {
                sh 'mvn clean install'
            }
        }

        stage('Run Tests') {
            steps {
                // Optionally run headless if running on a server
                sh '''
                export DISPLAY=:99
                google-chrome --version
                chromedriver --version
                mvn exec:java -Dexec.mainClass="com.example.App"
                '''
            }
        }
    }

    post {
        always {
            echo 'Pipeline completed.'
        }
        success {
            echo 'Build and test successful.'
        }
        failure {
            echo 'Build or test failed.'
        }
    }
}
