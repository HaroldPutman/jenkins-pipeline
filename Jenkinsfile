def jenkinsfile

stage('preload') {
  node('linux') {
    dir ('.script') {
      checkout scm
    }
    def branchName = scm.branches[0]
    echo "BRANCH: ${branchName}"
    sh 'ls -Rl'
  }
}
stage('build') {
  node('linux') {
    echo 'Building...'
    echo 'Release 2'
  }
}
