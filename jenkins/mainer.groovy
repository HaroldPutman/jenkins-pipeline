
def start() {
  stage('init') {
    node('linux') {
      dir('.script') {
        step ([$class: 'CopyArtifact',
          projectName: currentBuild.projectName,
          filter: 'jenkins/**',
          selector: [$class: 'SpecificBuildSelector', buildNumber: currentBuild.number.toString()]
        ]);
      }
    stash name:'jenkins', includes: 'jenkins/**'
    sh 'ls -lR'
    }
  }
  stage('checkout') {
    node('linux') {
      checkout scm
    }
  }
  stage('main') {
    node('linux') {
      unstash 'jenkins'
      sh 'ls -lR'
      // do the things
    }
  }
}

this
