stage('preload') {
  node('linux') {
    checkout scm
    jenkinsfile = load 'jenkins/mainer.groovy'
    sh 'ls -lR'
    stash name:'all', includes: '**'
  }
}
jenkinsfile.start()
