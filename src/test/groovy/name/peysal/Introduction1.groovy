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
}



