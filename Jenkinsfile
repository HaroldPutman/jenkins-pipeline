def jenkinsfile

stage('build') {
  node('linux') {
    checkout scm 
    def props = readJSON file: 'jenkins/keys.json'
    properties([parameters([choice(choices: props, description: 'Pick one', name: 'key')])])
  }
}
