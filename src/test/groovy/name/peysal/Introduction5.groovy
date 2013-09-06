package name.peysal

/**
 * @author peysal
 * List in groovy
 */

def teamMembers1 = ["p1", "p2", "p3"]    //by default arrayList
teamMembers1 << "p4"
assert teamMembers1.size() == 4

teamMembers2 = ["b1", "b2"] as Set    //setting the type
teamMembers2 << "b1"
assert teamMembers2.size() == 2

emptyList = []    //empty list
assert emptyList.size() == 0

teamMembers1.each{ println it}    //iterating with only 1 default variable.

teamMembers2.eachWithIndex{value, i -> println "position ${i}:${value}"}    //iterate with position and value

teamMembers1.reverse()    //return a new list

teamMembers1.sort()    //change the underlying structure

wholeTeam = teamMembers1 += teamMembers2
assert wholeTeam.size() == 6

assert wholeTeam.findAll{ it.startsWith("b")}.size() == 2    //return new list
assert wholeTeam.each{ if(it.startsWith("b")) print it} != 2    //not returning value
