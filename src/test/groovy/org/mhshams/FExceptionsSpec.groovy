package org.mhshams

import spock.lang.Specification

/**
 * @author me
 */
class FExceptionsSpec extends Specification {

    def "throws an exception"() {
        when:
        aMethodThatCanThrowException()

        then:
        thrown(RuntimeException)
    }

    def "checking exception info"() {
        when:
        aMethodThatCanThrowException()

        then:
        def e = thrown(RuntimeException)
        e.message == "something bad happened"
    }

    def "another way of handling exceptions"() {
        when:
        aMethodThatCanThrowException()

        then:
        RuntimeException e = thrown()
        e.message == "something bad happened"
    }


    def "check not thrown any exception"() {
        when:
        try { aMethodThatCanThrowException() } catch (e) {}

        then:
        notThrown(RuntimeException)
    }

    def aMethodThatCanThrowException() {
        throw new RuntimeException("something bad happened")
    }
}

