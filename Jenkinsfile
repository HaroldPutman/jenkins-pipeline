
def jenkinsfile

stage('preload') {
  stash name: 'pipeline-scripts' includes:'jenkins/**'
}
stage('build') {
  node('linux') {
    unstash 'pipeline-scripts'
    sh 'ls -al'
  }
}
