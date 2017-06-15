import static Constants.*

class Constants {
    static final NEXT = '<next>'
}

stage('init') {
  node('linux') {
    checkout scm

    def props = readJSON file: 'jenkins/keys.json'
    String[] keys = new String[props.size() + 1]
    keys[0] = NEXT
    for (i = 0; i < props.size(); i++) {
      keys[i + 1] = props[i]
      def stampfile = "_stamp/${props[i]}.x"
      if (!fileExists(stampfile)) {
        touch stampfile
      }
    }
    properties([parameters([choice(choices: keys.join('\n'), description: 'Pick one', name: 'key')])])
  }
}

stage('next') {
  node('linux') {
    if (params.key == NEXT) {
      echo 'Finding the next'
      def out = sh script:"ls -ort *.x | head -n 1", returnStdout: true
      echo out.trim()
    } else {
      echo params.key
    }
  }
}
