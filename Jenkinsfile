import static Constants.*

class Constants {
    static final NEXT = '<next>'
    static final STATFILE = '_stat.json'
    static final KEYFILE = 'jenkins/keys.json'
}

String[] keys

stage('init') {
  node('linux') {
    checkout scm

    def props = readJSON file: KEYFILE
    keys = new String[props.size() + 1]
    keys[0] = NEXT
    for (i = 0; i < props.size(); i++) {
      keys[i + 1] = props[i]
    }
    properties([parameters([choice(choices: keys.join('\n'), description: 'Pick one', name: 'key')])])
  }
}

stage('next') {
  node('linux') {
    String key
    def status = readJSON text: '{}'
    if (params.key == NEXT) {
      echo 'Finding the next'
      key = keys[1]
      try {
        status = readJSON file: STATFILE
      } catch (Exception ex) {
        println ex
      }
    } else {
      key = params.key
    }
    def now = new Date()
    status.put(key, now.getTime())
    writeJSON json: status, file: STATFILE
    echo "Building ${key}"
  }
}
