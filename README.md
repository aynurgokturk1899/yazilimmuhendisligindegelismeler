pipeline {
    agent any

    environment {
        IMAGE_NAME = "pb-quiz-app"
        CONTAINER_NAME = "pb-quiz-container"
        REPO_URL = "https://github.com/aynurgokturk1899/yazilimmuhendisligindegelismeler.git"
    }

    stages {
        stage('Checkout') {
            steps {
                git branch: 'main', url: "${REPO_URL}"
            }
        }

        stage('Docker Build & Deploy') {
            steps {
                script {
                    // Windows üzerinde 'sh' yerine 'bat' kullanmalısın
                    bat "docker stop ${CONTAINER_NAME} || exit 0"
                    bat "docker rm ${CONTAINER_NAME} || exit 0"

                    // Projen 'docker' klasörü içindeyse dizine girip build et
                    dir('docker') { 
                        bat "docker build -t ${IMAGE_NAME} ."
                    }

                    bat "docker run -d --name ${CONTAINER_NAME} -p 9090:9090 ${IMAGE_NAME}"
                }
            }
        }
    }

    post {
        success {
            echo 'Uygulama port 9090 üzerinde yayında!'
        }
        failure {
            echo 'Hata oluştu. Docker\'ın yüklü ve çalışır olduğundan emin ol.'
        }
    }
}
