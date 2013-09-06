package org.mhshams

import spock.lang.Specification

class MethodsSpec extends Specification {
    //fields
    def i = 0

    def setupSpec() {
        println ".....setupSpec"
    }

    def setup() {
        println "..........setup"
    }

    def "a feature(test) method"() {
        println "....................a feature method"
        helper()
        anotherHelper()

        expect:
        i == 0
    }

    def "another feature(test) method"() {
        println "....................another feature method"
        helper()
        anotherHelper()

        expect:
        i != 1
    }

    def cleanup() {
        println "..........cleanup"
    }

    def cleanupSpec() {
        println ".....cleanupSpec"
    }

    def helper() {
        println "..............................a helper method"
    }

    def anotherHelper() {
        println "..............................another helper method"
    }
}
