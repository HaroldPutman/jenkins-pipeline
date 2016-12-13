import groovy.transform.Field

@Field
def mailVars = [:]

def build() {

  node('linux') {
    dir('main') {
      stage('checkout') {

        mailVars << [
          JONES: "Martha Stewart",
          DOG: "Bingo"
        ]
        if (!params.containsKey('BRANCH')) {
          properties([parameters([string(name: 'BRANCH', defaultValue: 'master')])])
        }
        git url: 'https://github.com/HaroldPutman/jenkins-pipeline.git', branch: params.BRANCH
      }
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
env.JENKINS_HOME = ${env.JENKINS_HOME}
env.GIT_COMMIT = ${env.GIT_COMMIT}
env.GIT_PREVIOUS_SUCCESSFUL_COMMIT = ${env.GIT_COMMIT}
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
        def atext = readFile file: "${env.WORKSPACE}/.script/jenkins/resource.txt", encoding: 'UTF-8'
        println atext
        println getChangeString()
        showmailVars()
      }
    }
  }
}

return this

/**
 * This requires approval for rawBuild which is recommended against by Jenkins.
 */
@NonCPS
def getChangeString() {
    MAX_MSG_LEN = 100
    def changeString = ""

    echo "Gathering SCM changes"
    def changeLogSets = currentBuild.rawBuild.changeSets
    for (int i = 0; i < changeLogSets.size(); i++) {
        def entries = changeLogSets[i].items
        for (int j = 0; j < entries.length; j++) {
            def entry = entries[j]
            truncated_msg = entry.msg.take(MAX_MSG_LEN)
            println entry.affectedPaths
            changeString += " - ${truncated_msg} [${entry.author}]\n"
        }
    }

    if (!changeString) {
        changeString = " - No new changes"
    }
    return changeString
}

def showmailVars() {
  println mailVars.JONES
}
