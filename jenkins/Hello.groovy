import org.jenkinsci.plugins.workflow.cps.CpsScript

class Hello extends CpsScript {
    def say() {
        println 'Goodbye world!'
    }

    /**
     * This methods runs when calling load or when running directly
     */
    def run() {
        println 'Hello world'
        return this
    }
}
