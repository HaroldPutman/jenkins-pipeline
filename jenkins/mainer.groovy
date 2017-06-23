
def start() {
  stage('main') {
      node('linux') {
        dir('.script') {
          step ([$class: 'CopyArtifact',
                  projectName: currentBuild.projectName,
                  filter: 'jenkins/**',
                  selector: [$class: 'SpecificBuildSelector', buildNumber: currentBuild.number.toString()]
                ]);
        }
        sh 'ls -R .script'
      }
  }
}
this
