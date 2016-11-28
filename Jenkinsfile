#!groovy

def jenkinsfile

node("linux") {
  deleteDir()
  dir (".script") {
    git url: 'https://github.com/HaroldPutman/jenkins-pipeline.git', branch: 'rds'
  }
  jenkinsfile = load '.script/jenkins/main.groovy'
}
jenkinsfile.build()
