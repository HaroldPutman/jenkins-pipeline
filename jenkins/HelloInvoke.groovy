def Hello

node('linux') {
  Hello = load 'hello.groovy'
  Hello.run2()
}
