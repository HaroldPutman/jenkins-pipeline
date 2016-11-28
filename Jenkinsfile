#!groovy

node("linux") {
  stage("checkout") {
    if (!params.containsKey('BRANCH')) {
      properties([parameters([string(name: 'BRANCH', defaultValue: 'master')])])
    }
    git url: 'https://github.com/HaroldPutman/jenkins-pipeline.git', branch: params.BRANCH
  }
  stage("work") {
//    sh "find /scmjenkins -name blargo-mustard.marker"
    sh "find /home -name blargo-mustard.marker"
    sh "find /lexbuild -name blargo-mustard.marker"
    sh "find /tmp -name blargo-mustard.marker"
    sh "find /var -name blargo-mustard.marker"
    sh "find /etc -name blargo-mustard.marker"

    echo pwd()
    echo """
currentBuild.number = ${currentBuild.number}
currentBuild.displayName = ${currentBuild.displayName}
currentBuild.fullDisplayName = ${currentBuild.fullDisplayName}
currentBuild.projectName = ${currentBuild.projectName}
currentBuild.fullProjectName = ${currentBuild.fullProjectName}
currentBuild.timeInMillis = ${currentBuild.timeInMillis}
currentBuild.startTimeInMillis = ${currentBuild.startTimeInMillis}
currentBuild.duration = ${currentBuild.duration}
currentBuild.description = ${currentBuild.description}
currentBuild.previousBuild.number = ${currentBuild.previousBuild.number}
currentBuild.nextBuild = ${currentBuild.nextBuild}
"""

    echo """
Environment
===========
env.BUILD_NUMBER = ${env.BUILD_NUMBER}
env.BUILD_ID = ${env.BUILD_NUMBER}
env.BUILD_URL = ${env.BUILD_URL}
env.JOB_URL = ${env.JOB_URL}
env.BUILD_USER = ${env.BUILD_USER}
env.NODE_NAME = ${env.NODE_NAME}
env.JOB_NAME = ${env.JOB_NAME}
env.BUILD_TAG = ${env.BUILD_TAG}
env.JENKINS_URL = ${env.JENKINS_URL}
env.EXECUTOR_NUMBER = ${env.EXECUTOR_NUMBER}
env.JAVA_HOME = ${env.JAVA_HOME}
env.WORKSPACE = ${env.WORKSPACE}
env.JENKINS_HOME = ${env.JENKINS_HOME}
"""
  echo """
parameters
==========
"""
    for ( p in params ) {
      println "params.${p.key} = ${p.value}"
    }
    wrap([$class: 'BuildUser']) {
      echo "env.BUILD_USER = ${env.BUILD_USER}"
    }
    def text = readFile file: "jenkins/resource.txt", encoding: 'UTF-8'
    println text
    def atext = readFile file: "${env.WORKSPACE}@script/jenkins/resource.txt", encoding: 'UTF-8'
    println atext

  }

}
