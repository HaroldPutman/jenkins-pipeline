
stage('init') {
  node('linux') {
    checkout scm

    def props = readJSON file: 'jenkins/keys.json'
    String[] keys = ['<next>']
    for (i = 0; i < props.size(); i++) {
      keys[i + 1] = props[i]
    }
    properties([parameters([choice(choices: keys.join('\n'), description: 'Pick one', name: 'key')])])
  }
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
