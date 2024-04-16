pipeline {
    agent any
    
    stages {
        stage('Build a Maven Project') {
            steps {
                echo 'Starting to checkout the GitHub repository'
                git branch: 'main', credentialsId: 'your-credentials-id', url: 'https://github.com/hacker123shiva/first-springboot-maven-jenkins'
                echo 'Cleaning the project'
                bat 'mvn clean install'
            }
        }
        
           stage ('Build SpringApp Docker Image ') {
            steps{
                script {
                    echo 'Checking if docker service is available ...' 
                    echo 'Starting Docker Image building'
                    bat 'docker build -t hacker123shiva/springbt-in-docker:latest .'
                }
            }
        }
        
        stage('Pushing the SpringApp Docker Image to Docker Registry') {
            steps {
                echo 'Logging to Docker registry.....'
               
                
                withCredentials([string(credentialsId: 'mycredit', variable: 'dockerhubpwd')]) {
                   bat 'docker login -u hacker123shiva -p %dockerhubpwd%'
}
                echo 'Starting the push of Docker Image ....'
                bat 'docker push hacker123shiva/springbt-in-docker:latest'
            }
        }
        
   stage('Testing the deployment') {
    steps {
        script {
            echo 'Removing existing container and image...'
            bat 'docker rm -f springapp || true' // Remove container if exists, ignore if not found
            bat 'docker rmi -f hacker123shiva/springbt-in-docker:latest || true' // Remove image if exists, ignore if not found
        }
        echo 'Starting a local container of the App ....'
        bat 'docker run -dit --name springapp -p 2000:8080 hacker123shiva/springbt-in-docker:latest'
        echo 'The App is now available at Port 2000 ....'
    }
}

        
    }
}
