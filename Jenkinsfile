stage('preload') {
  node('linux') {
    archiveArtifacts 'jenkins/**'
    jenkinsfile = load 'jenkins/mainer.groovy'
  }
}
jenkinsfile.start(branch, repo)
