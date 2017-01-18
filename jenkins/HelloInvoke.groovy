def Hello
node {
    def workspace = pwd()
    Hello = load "${workspace}@script/jenkins/hello.groovy"
}
Hello.say()
