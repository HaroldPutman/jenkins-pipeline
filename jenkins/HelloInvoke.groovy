def Hello
node ('master') {
    def workspace = pwd()
    Hello = load "../${workspace}@script/jenkins/hello.groovy"
}
Hello.say()
