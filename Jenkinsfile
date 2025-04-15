pipeline {
	agent any

    tools {
		MAVEN_HOME 'Maven 3.9.9'
        JAVA_HOME 'JDK 17'
    }

    environment {
		MAVEN_OPTS = "-Dmaven.test.failure.ignore=true"
    }

    triggers {
		cron('49 23 * * *')  // Her akşam 23:40'da otomatik çalışır
    }

    stages {
		stage('Checkout') {
			steps {
				git 'https://github.com/sezginmert/InsiderOptimusProject.git'
            }
        }

        stage('Install Dependencies') {
			steps {
				sh 'mvn clean install -DskipTests'
            }
        }

        stage('Run Tests') {
			steps {
				sh 'mvn test'
            }
        }

        stage('Allure Report') {
			steps {
				sh 'mvn allure:report'
            }
        }

        stage('Publish Allure Report') {
			steps {
				allure includeProperties: false, jdk: '', reportBuildPolicy: 'ALWAYS'
            }
        }
    }

    post {
		always {
			junit '**/target/surefire-reports/*.xml'
        }
        failure {
			mail to: 'sezginmertt@gmail.com',
                 subject: "❌ Build Failed - ${env.JOB_NAME} #${env.BUILD_NUMBER}",
                 body: "Something went wrong!\n\nCheck it here: ${env.BUILD_URL}"
        }
    }
}
