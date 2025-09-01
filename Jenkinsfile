pipeline {
  agent any
  stages {
    stage('Build & Test') {
      steps {
        // Windows: bat 'mvn -B clean test package'
        // Linux:   sh 'mvn -B clean test package'
        // Cross-platform fallback:
        script {
          def isWindows = System.getProperty('os.name').toLowerCase().contains('win')
          if (isWindows) {
            bat 'mvn -B clean test package'
          } else {
            sh 'mvn -B clean test package'
          }
        }
      }
    }
  }
  post {
    always {
      junit 'target/surefire-reports/*.xml'
      archiveArtifacts artifacts: 'target/*.jar', fingerprint: true
    }
  }
}
