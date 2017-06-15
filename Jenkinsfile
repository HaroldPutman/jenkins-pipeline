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
    String key = null
    def status = readJSON text: '{}'
    def now = (new Date()).getTime()
    if (params.key == NEXT) {
      echo 'Finding the next'
      if (fileExists(STATFILE)) {
        status = readJSON file: STATFILE
        def oldest = now
        for (i = 0; i < status.size(); i++) {
          def k = status.names().getString(i)
          def t = status.get(k)
          if (t < oldest) {
            oldest = t
            key = k
          }
        }
      } else {
        // No stat file start at the top.
        key = keys[1]
      }

    } else {
      key = params.key
    }
    status.put(key, now)
    writeJSON json: status, file: STATFILE
    echo "Building ${key}"
  }
}
