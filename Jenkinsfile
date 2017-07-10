stage('preload') {
  node('linux') {
    def scmVars = checkout scm
    echo scmVars.GIT_BRANCH
    jenkinsfile = load 'jenkins/mainer.groovy'
    sh 'ls -lR'
    stash name:'all', includes: '**'
  }
}
jenkinsfile.start()
