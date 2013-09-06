package org.mhshams

import spock.lang.Specification
import spock.lang.Unroll

/**
 * @author me
 */
class DMoreAboutBDDSpec extends Specification {

    def "another BDD style"() {
        given: "optional"
        def i = 3
        def j = 7

        when:
        def k = Math.max(i, j)

        then:
            k == j
    }

    def "data driven"() {
        when:
        def r = Math.max(i, j)

        then:
        r == exr

        where:
        i | j || exr
        0 | 1 || 1
        8 | 7 || 8
        9 | 3 || 3
        4 | 6 || 6
    }

    @Unroll
    def "data driven with Unroll annotation"() {
        when:
        def r = Math.max(i, j)

        then:
        r == exr

        where:
        i | j || exr
        0 | 1 || 1
        8 | 7 || 8
        9 | 3 || 3
        4 | 6 || 6
    }

    @Unroll("Maximum of #i and #j must be #exr")
    def "maximum of given numbers"() {
        when:
        def r = Math.max(i, j)

        then:
        r == exr

        where:
        i | j || exr
        0 | 1 || 1
        8 | 7 || 8
        9 | 3 || 3
        4 | 6 || 6
    }

    @Unroll
    def "Maximum of #i and #j must be #exr"() {
        when:
        def r = Math.max(i, j)

        then:
        r == exr

        where:
        i | j || exr
        0 | 1 || 1
        8 | 7 || 8
        9 | 3 || 3
        4 | 6 || 6
    }

    //If multiple feature methods are using "Unroll" annotation. you can annotate the class.
}
