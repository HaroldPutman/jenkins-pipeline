
def start() {
  stage('main') {
    node('linux') {
      unstash 'all'
      sh 'ls -lR'
      sh 'cat jenkins/resource.txt'
    }
  }
}

this
