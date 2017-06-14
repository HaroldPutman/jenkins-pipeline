def jenkinsfile

stage('build') {
  node('linux') {
    checkout scm
    def props = readJSON file: 'jenkins/keys.json'
    String[] keys = props.toArray(new String[props.size()])
    properties([parameters([choice(choices: keys.join('\n'), description: 'Pick one', name: 'key')])])
  }
}
