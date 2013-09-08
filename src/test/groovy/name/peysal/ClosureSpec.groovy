package name.peysal

import spock.lang.Specification

/**
 * Groovy introduction closure 1) default it parameter 2) parameter more than 1 3) passing closure to method
 */

class ClosureSpec extends Specification {
    def myCodeBlock1 = {it}
    def myCodeBlock2 = {a,b -> a+b}

    def "closure with 1 parameter" () {
        expect:
            myCodeBlock1("test") == "test"
    }

    def "closure with 2 parameter" () {
        expect:
            myCodeBlock2(1,2) == 3
    }

    def "passing closure into method" () {
        def list = ['a','b','c','d']
        def newList = []
        def clos = { it.toUpperCase() }

        when:
            list.collect( newList, clos )
        then:
            newList == ["A", "B", "C", "D"]
    }
}
