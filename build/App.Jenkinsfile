#!groovy
     
pipeline {
     
	agent {
        label 'host'
    }
      
    options {
		buildDiscarder(logRotator(numToKeepStr: '10', daysToKeepStr: '7'))
        disableConcurrentBuilds()
    }
      
    stages {
     
        stage("Set Build Parameters") {
          steps {
            script {
              currentBuild.displayName = "Build_App .${BUILD_NUMBER}";
            }
          }
        }
     
        stage("Build") {
          steps {
				sh 'docker run --dns ${IPADDRESS} --rm  -v ${PWD}/:/work -e SERVER=http://sonarqube.service.lidop.local:8084/sonarqube -e PROJECT_KEY=  registry.service.lidop.local:5000/lidop/sonarscanner:latest'

		   }
        }
             
    	stage("Dependency Check") {
          steps {
    	    sh 'rm -rf ${PWD}/result'
    	    sh 'mkdir -m 777 ${PWD}/result'
    	    sh 'docker run -v ${PWD}:/src -v ${PWD}/result/:/result melaniealwardt/dependency-check:latest --scan /src --format "ALL" --project app --out /result --noupdate'
          }
        }
     
        stage("Code Quality") {
          steps {
            dir(".") {
              withSonarQubeEnv('Sonarqube') {
                withCredentials([usernamePassword(credentialsId: 'lidop', passwordVariable: 'rootPassword', usernameVariable: 'rootUser')]) {
                  sh 'docker run --dns ${IPADDRESS} --rm  -v ${PWD}/:/work -e SERVER=http://sonarqube.service.lidop.local:8084/sonarqube -e PROJECT_KEY=juice-shop  registry.service.lidop.local:5000/lidop/sonarscanner:latest'
                }
              }
              timeout(time: 1, unit: 'HOURS') {
                waitForQualityGate abortPipeline: true
              }
              
              sh 'rm -rf result'
     
            }
          }
        }
            
    }
     
}