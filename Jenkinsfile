#!groovy

node("linux") {
  deleteDir()
  dir ("scr1pt") {
    git url: 'https://github.com/HaroldPutman/jenkins-pipeline.git', branch: 'rds'
  }
  dir ("w0rk") {
    git url: 'https://github.com/HaroldPutman/jenkins-pipeline.git', branch: params.BRANCH
  }
}
