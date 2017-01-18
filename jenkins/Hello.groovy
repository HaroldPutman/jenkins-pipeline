import org.codehaus.groovy.runtime.InvokerHelper
import org.jenkinsci.plugins.workflow.cps.CpsScript
class Hello extends CpsScript {
    def run2() {
        println 'Goodbye world!'
    }

    def run() {
        println 'Hello world!'
        return this
    }

    static void main(String[] args) {
        println 'In Main';
        InvokerHelper.runScript(Hello, args)
    }
}
