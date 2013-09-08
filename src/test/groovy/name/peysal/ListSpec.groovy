package name.peysal

import spock.lang.Specification

/**
 * @author peysal
 * List in groovy
 */

class ListSpec extends Specification {
    def teamMembers1 = [1, 2, 3]
    def teamMembers2 = ["b1", "b2"] as Set

    def "adding item" () {
        when:
            teamMembers1 << "p4"
        then:
            teamMembers1.size() == 4
    }

    def "adding things into set" () {
        when:
            teamMembers2 << "b1"
        then:
            teamMembers2.size() == 2
    }

    def "iterate" () {
        int total = 0
        when:
            teamMembers1.each { it -> total += it}
        then:
            total == 6

        when:
            teamMembers2.eachWithIndex{entry, int i -> total += i}
        then: "existing total is 6 + (0+1)"
            total == 7
    }

    def "reverse" () {
        expect:
            teamMembers1.reverse() == [3,2,1]
    }

    def "sort" () {
        expect:
            teamMembers1.sort()  == [1,2,3]
    }

    def "list add to list" () {
        def wholeTeam

        when:
            wholeTeam = teamMembers1 += teamMembers2
        then:
            wholeTeam.size() == 6
    }

    def "find all" () {
        expect:
            teamMembers2.findAll {it.startsWith("b")} == ["b1", "b2"] as Set
    }
}
