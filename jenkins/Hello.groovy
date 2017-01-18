import org.jenkinsci.plugins.workflow.cps.CpsScript

class Hello extends CpsScript {
    def run2() {
        println 'Goodbye world!'
    }

    def run() {
        println 'Hello world!'
        return this
    }
}
