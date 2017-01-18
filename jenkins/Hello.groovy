import org.codehaus.groovy.runtime.InvokerHelper
class Hello extends Script {
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
