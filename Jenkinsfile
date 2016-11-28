#!groovy

node("linux") {
  dir ("scr1pt") {
    git url: 'https://github.com/HaroldPutman/jenkins-pipeline.git', branch: 'rds'
  }
  dir ("workspace") {
    git url: 'https://github.com/HaroldPutman/jenkins-pipeline.git', branch: params.BRANCH
  }
}
