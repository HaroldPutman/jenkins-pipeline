def jenkinsfile

stage('preload') {
  node('linux') {
    dir ('.script') {
      checkout scm
    }
    echo "BRANCH: ${BRANCH_NAME}"
    sh 'ls -Rl'
  }
}
stage('build') {
  node('linux') {
    echo 'Building...'
  }
}
