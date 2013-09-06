package name.peysal
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

//no accessors method

Person person = new Person()
person.name = "goku"
println "helloo ${person.name}"
assert person.name == "goku"
assert person["name"] == "goku"

person = new Person(name:"gohan")    //passing constructor value
assert person.name == "gohan"
println "helloo ${person.name}"


