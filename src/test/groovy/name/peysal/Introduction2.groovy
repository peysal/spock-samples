package name.peysal

import spock.lang.Specification

/**
 * @author peysal
 * Groovy introduction: 1) list 2) operator overloading 3) method pointer
 */
class Introduction2 extends Specification {

    def "Many way adding thing into list" () {
        def list = []
        expect:
            list.isEmpty()

        when: "Use add method with parentheses"
            list.add("ayam")
        then:
            list.size() == 1

        when: "User add method"
            list.add "babun"
        then:
            list.size() == 2

        when: "User use the overloading operator <<"
            list << "cicak"
        then:
            list.size() == 3

        when: "method pointer in action for add"
            def tambah = list.&add
            tambah "dugong"
        then:
            list.size() == 4
    }
}

