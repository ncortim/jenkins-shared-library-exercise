#!/user/bin/env groovy

def call() {
    echo "building the docker image..."
    withCredentials([usernamePassword(credentialsId: 'docker-hub', passwordVariable: 'PASS', usernameVariable: 'USER')]){
        sh "docker image build -t ncortim/app:${IMAGE_NAME} ."
        sh 'echo ${PASS} | docker login -u ${USER} --password-stdin'
        sh "docker push ncortim/app:${IMAGE_NAME}"

    }
}
