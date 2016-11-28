#!groovy

def jenkinsfile

node("linux") {
  dir (".script") {
    git url: 'https://github.com/HaroldPutman/jenkins-pipeline.git', branch: 'rds'
  }
  jenkinsfile = load 'jenkins/main.groovy'
}
jenkinsfile.build()
