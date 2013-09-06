package name.peysal

/**
 * @author peysal
 * Introduction to groovy 1) duck typing 2) return is optional, last statement will be taken
 *
 * Warning!! metaprogramming in action. Overwriting the get property.
 */

Person.metaClass.getProperty = {String name ->
    def metaProperty = Person.metaClass.getMetaProperty(name)
    def nameValue = metaProperty.getProperty(delegate)
    "will not be printed"
    "my name is ${nameValue}"    //return is optional, last statement is taken
}

person = new Person(name:"goku")

println "hello " + person.name
assert "hello " + person.name == "hello my name is goku"
assert "hello " + person.name == "hello ${person.name}"
