def Hello

node('linux') {
  Hello = load 'jenkins/hello.groovy'
  Hello.run2()
}
