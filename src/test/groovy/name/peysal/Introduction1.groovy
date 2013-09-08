package name.peysal

import spock.lang.Specification

/**
 * @author peysal
 * Groovy introduction: 1) no accessors method 2) gString 3) accessing object
 * 4) equality operator not referring to memory address extra: can change the value to make wrong assertion just to
 * show groovy trace
 */
class Person {
    String name
    def age
    def spouse
}

class PersonSpec extends Specification {
    Person person
    def  candidate1, candidate2

    def "Accessing the value" () {
        person = new Person()

        when: "assign value"
            person.name = "goku"
        then:
            person.name == "goku"
            person['name'] == "goku"

        when:
            person = new Person(name:"gohan")
        then:
            person.name == "gohan"
    }

    def "Safe derefencing" () {
        candidate1 = new Person(name:"bill", spouse: new Person(name:"lengloy"))
        candidate1.spouse.spouse = candidate1
        candidate2

        expect:
            candidate1.spouse.spouse != null

        when:
            candidate2 = new Person(name:"bull")
        then:
            candidate2.spouse?.name == null
    }

    def "auto boxing in action" () {
        candidate1 = new Person(age: 32)
        candidate2 = new Person(age: 30.5)

        expect:
            candidate1.age.class == Integer.class
            candidate2.age.class == BigDecimal.class
    }
}



