#!groovy
node {
  stage("work") {
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
"""
    wrap([$class: 'BuildUser']) {
      echo "env.BUILD_USER = ${env.BUILD_USER}"
    }
    def text = readFile file: "jenkins/resource.txt", encoding: 'UTF-8'
    println text    
  }

}
