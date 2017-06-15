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
    }
    properties([parameters([choice(choices: keys.join('\n'), description: 'Pick one', name: 'key')])])
  }
}

stage('next') {
  node('linux') {
    if (params.key == NEXT) {
      echo 'Finding the next'
      if (fileExists('status.json')) {
        echo 'File'
      } else {
        echo 'No file'
        def obj = readJSON text: '{ "foo": "bar" }'
        obj.put('foo', 'base')
        writeJSON json: obj, file: 'status.json'
      }
    } else {
      echo params.key
    }
  }
}
