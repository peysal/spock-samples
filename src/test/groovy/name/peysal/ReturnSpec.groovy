package name.peysal

import spock.lang.Specification

/**
 * @author peysal
 * Introduction to groovy 1) duck typing 2) return is optional, last statement will be taken
 *
 * Warning!! metaprogramming in action. Overwriting the get property.
 */

class ReturnSpec extends Specification {
    def person

    def "return statement is optional" () {
        Person.metaClass.getProperty = {String name ->
            def metaProperty = Person.metaClass.getMetaProperty(name)
            def nameValue = metaProperty.getProperty(delegate)
            "will not be printed"
            "my name is ${nameValue}"    //return is optional, last statement is taken
        }
        person = new Person(name:"goku")

        expect:
            "hello " + person.name == "hello my name is goku"
            "hello " + person.name == "hello ${person.name}"
    }
}
