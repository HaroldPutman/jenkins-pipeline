stage('preload') {
  node('linux') {
    checkout scm
    archiveArtifacts 'jenkins/**'
    jenkinsfile = load 'jenkins/mainer.groovy'
  }
}
jenkinsfile.start(branch, repo)
