package org.mhshams

import spock.lang.FailsWith
import spock.lang.Ignore
import spock.lang.IgnoreRest
import spock.lang.Specification
import spock.lang.Timeout

/**
 * @author me
 */
class EMoreAnnotationsSpec extends Specification {

    @Ignore("this test is not ready")
    def "ignore me"() {
        expect:
        true
    }

    //@IgnoreRest
    def "ignore reset"() {
        expect:
        true
    }

    @Timeout(1)
    def "timeout"() {
        Thread.sleep(2000)

        expect:
        true
    }

    @FailsWith(value=IllegalArgumentException.class, reason="I don't know")
    def "fails with"() {
        throw new IllegalArgumentException("a test")

        expect:
        true
    }
}
