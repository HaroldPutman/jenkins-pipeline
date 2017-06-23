
def start() {
  stage('main') {
      node('linux') {
        step ([$class: 'CopyArtifact',
                projectName: 'other-project',
                filter: 'myapp.jar',
                selector: [$class: 'SpecificBuildSelector', buildNumber: currentBuild.number]
              ]);
        sh 'cat jenkins/keys.json'
      }
  }
}
