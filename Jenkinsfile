pipeline {
    agent any
    tools {
        maven "3.8.5"
    }
    stages {
        stage('Clean and Compile') {
            steps {
                // Run Maven on a Unix agent.
                sh "mvn clean compile"
            }
        }
        /*stage('Test') {
            steps {
                sh "mvn test"
            }
        }*/
        stage('deploy') {
            steps {
                sh "mvn package"
            }
        }
        stage('Build Docker image'){
            steps {
                echo "Hello Stock API"
                sh 'ls'
                sh 'docker build -t  lucaskienast/docker_jenkins_springboot:${BUILD_NUMBER} .'
            }
        }
        stage('Docker Login'){
            steps {
                 withCredentials([string(credentialsId: 'lucaskienast', variable: 'Dockerpwd')]) {
                    sh "docker login -u lucaskienast -p ${Dockerpwd}"
                }
            }
        }
        stage('Docker Push'){
            steps {
                sh 'docker push lucaskienast/docker_jenkins_springboot:${BUILD_NUMBER}'
            }
        }
        stage('Docker deploy'){
            steps {
                sh 'docker run -itd -p  8081:8080 lucaskienast/docker_jenkins_springboot:${BUILD_NUMBER}'
            }
        }
        stage('Archving') {
            steps {
                 archiveArtifacts '**/target/*.jar'
            }
        }
    }
}
