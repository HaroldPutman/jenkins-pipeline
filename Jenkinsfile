String[] keys
def userInput

stage('build') {
  node('linux') {
    checkout scm
    def props = readJSON file: 'jenkins/keys.json'
    keys = props.toArray(new String[props.size()])
  }
  userInput = input(
    id: 'userInput', message: 'Let\'s promote?', parameters: [
      [$class: 'ChoiceParameterDefinition',
        choices: keys.join('\n'),
        description: 'Select a key',
        name: 'choice1']
        ])
}

stage('next') {
  node('linux') {
    echo userInput.choice1
  }
}
