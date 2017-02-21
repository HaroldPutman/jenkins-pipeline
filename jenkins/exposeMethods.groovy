#!groovy
/**
 * This script hits all the methods that are used by the AEM builds.
 * (build, allow, repeat) until it completes successfully.
 * For best results you should fetch this from SCM.
 */
import groovy.json.JsonSlurperClassic
import hudson.AbortException

//+ staticMethod org.codehaus.groovy.runtime.EncodingGroovyMethods encodeBase64 byte[]
//+ method java.lang.String getBytes
def creds = 'user:password'
String auth = creds.bytes.encodeBase64().toString()
println("$auth is `dXNlcjpwYXNzd29yZA==`")

//+ new groovy.json.JsonSlurperClassic
//+ method groovy.json.JsonSlurperClassic parseText java.lang.String
@NonCPS
def jsonParse(def json) {
    new JsonSlurperClassic().parseText(json)
}
println jsonParse('{ "FOO": "yes"}')

//+ staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods findAll java.lang.String java.lang.String
def result = """
Now you see me
- Now you don't
"""
println result.findAll(/(?m)^[^\-].*$/).join('\n')

//+ staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods contains java.lang.Object[] java.lang.Object
def projects = 'one,two,three,four'
def projectList = projects.split(',')
if (projectList.contains('four')) {
  echo 'four is here'
}

//+ staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods find java.lang.String java.lang.String groovy.lang.Closure
@NonCPS
def getStatus(text) {
  text.find(/<status code="(\d+)">(.+)<\/status>/) { fullMatch, code, msg ->
    return "${code}:${msg}"
  }
}
println getStatus('<output><status code="404">Not Found</status></output>')

//+ new groovy.text.StreamingTemplateEngine
//+ method groovy.text.Template make java.util.Map
//+ method groovy.text.TemplateEngine createTemplate java.lang.String
@NonCPS
def renderTemplate(input, vars) {
  def engine = new groovy.text.StreamingTemplateEngine()
  def template = engine.createTemplate(input).make(vars)
  return template.toString()
}
renderTemplate('Hello ${planet}', [ planet: 'World' ])

//+ method groovy.lang.GString getBytes
def vartext = "Special"
println "Something ${vartext}".getBytes()

//+ method hudson.plugins.git.GitSCM getBranches
//+ method hudson.plugins.git.BranchSpec getName
try {
  def branch = scm.branches[0].name
} catch(AbortException ex) {
  println ex
}

//+ method org.jenkinsci.plugins.workflow.steps.FlowInterruptedException getCauses
//+ method org.jenkinsci.plugins.workflow.support.steps.input.Rejection getUser
try {
  def derp = 'yes'
} catch(FlowInterruptedException err) {
  def user = err.getCauses()[0].getUser()
}

//+ new java.util.Date
def today = new Date()
println today.format('w').toInteger() + 103

//+ staticMethod org.codehaus.groovy.runtime.DefaultGroovyMethods getCount java.util.regex.Matcher
def matcher = ('hayneedlestack' =~ /needle/)
println matcher.getCount()

/**
 * Trust me, it's safe to ignore this warning...
 * "Approving this signature may introduce a security vulnerability! You are
 * advised to deny it."
 */
//+ method org.jenkinsci.plugins.workflow.support.steps.build.RunWrapper getRawBuild
//+ method org.jenkinsci.plugins.workflow.job.WorkflowRun getChangeSets
println currentBuild.rawBuild.changeSets
