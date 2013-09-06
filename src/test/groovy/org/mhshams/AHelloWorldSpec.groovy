package org.mhshams

import spock.lang.Specification

/**
 *  - Extends from Specification class
 *  - "Spec" vs "Test"
 *  - Method definition "method"
 *  - the keyword or label "expect"
 *  - Normal boolean expressions, no need for assertion.
 */
class HelloWorldSpec extends Specification {

    def "say hello to World"() {
        expect:
        new HelloWorld().sayHello() == "Hello World!"
    }

    def "say hello to someone"() {
        expect:
        new HelloWorld().sayHello("Mohammad") == "Hello Mohammad!"
    }

    def "say hello to all"() {
        def hw = new HelloWorld()

        expect:
        hw.sayHello() == "Hello World!"
        hw.sayHello("Mohammad") == "Hello Mohammad!"
    }

    def "make a mistake and say hello to someone else"() {
        expect:
        new HelloWorld().sayHello("Mohammad") == "Hello Mohamad!"
    }
}


class HelloWorld {

    String sayHello(String name = "World") {
        return "Hello $name!"
    }
}

