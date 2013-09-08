package name.peysal

import spock.lang.Specification

/**
 * introduction to groovy 1) range declaration 2) iterate range 3) contains and reverse 4) size, from, to
 */
class RangeSpec extends Specification {
    def myRange = 1..3

    def "contains" () {
        expect:
        myRange.contains(2)
    }

    def "from and range" () {
        expect:
        myRange.from == 1
        myRange.to == 3
    }
}
