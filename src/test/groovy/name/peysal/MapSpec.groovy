package name.peysal

import spock.lang.Specification

/**
 * Introduction to groovy 1) empty map 2) adding things to map 3) concat map to map 4) iterating
 */
class MapSpec extends Specification {
    def emptyMap = [:]

    def "adding things into map" () {
        when:
        emptyMap << ["person1":"peysal"]
        then:
        emptyMap.size() == 1

        when:
        emptyMap.put "person2","firra"
        then:
        emptyMap.size() == 2
    }

    def "getting things from map" () {
        emptyMap = ["person1":"test1", "person2":"test2"]
        expect:
        emptyMap.person1 == "test1"
        emptyMap.get("person2") == "test2"
    }

    def "iterating map" () {
        String result = ""
        emptyMap = ["person1":"test1", "person2":"test2"]
        when:
        emptyMap.each{ k,v ->  result+=k}
        then:
        result == "person1person2"
    }

    def "concat map to existing map" () {
        emptyMap = ["test1":1]

        when:
        emptyMap += ["newTests1":2]
        then:
        emptyMap.size() == 2

        when: "adding more things to the previous operation"
        emptyMap << ["moreNewTest1":3]
        then:
        emptyMap.size() == 3
    }
}
