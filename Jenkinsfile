String[] keys
def userInput

stage('build') {
  node('linux') {
    checkout scm
    def props = readJSON file: 'jenkins/keys.json'
    keys = props.toArray(new String[props.size()])
  }
  properties([parameters([choice(choices: keys.join('\n'), description: 'Pick one', name: 'key')])])
}

stage('next') {
  node('linux') {
    if (params.key) {
      echo params.key
    } else {
      echo 'No key'
    }
  }
}
