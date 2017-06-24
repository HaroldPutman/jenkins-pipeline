
def start() {
  stage('init') {
    node('linux') {
      unstash 'all'
      sh 'ls -lR'
      sh 'cat jenkins/resource.txt'
    }
  }
  stage('checkout') {
    node('linux') {
      checkout scm
    }
  }
  stage('main') {
    node('linux') {
      unstash 'all'
      sh 'ls -lR'
      sh 'cat jenkins/resource.txt'
    }
  }
}

this
