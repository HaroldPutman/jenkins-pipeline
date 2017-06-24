stage('preload') {
  node('linux') {
    checkout scm
    archiveArtifacts 'jenkins/**'
    jenkinsfile = load 'jenkins/mainer.groovy'
    // stash name:'jenkins', includes: 'jenkins/**'
  }
}
jenkinsfile.start()
