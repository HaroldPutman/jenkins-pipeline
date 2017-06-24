stage('preload') {
  node('linux') {
    checkout scm
    jenkinsfile = load 'jenkins/mainer.groovy'
    stash name:'all', includes: './**'
  }
}
jenkinsfile.start()
