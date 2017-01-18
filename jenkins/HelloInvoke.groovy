def Hello
Hello = load "${JENKINS_HOME}@script/jenkins/hello.groovy"

Hello.say()
