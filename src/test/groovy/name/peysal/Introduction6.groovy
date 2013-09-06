package name.peysal

/**
 * Introduction to groovy 1) empty map 2) adding things to map 3) concat map to map 4) iterating
 */

def emptyMap = [:]
assert emptyMap.size() == 0
def notEmptyMap = ["person1":"john", "person2":"mus"]
assert notEmptyMap.size() == 2

notEmptyMap.put "person3","test"    //adding to existing one
assert notEmptyMap.size() == 3
notEmptyMap["person4"] = "beth"
assert notEmptyMap.size() == 4

assert notEmptyMap.get("person1") == "john"    //accessing the value
assert notEmptyMap.person1 == "john"
assert notEmptyMap["person1"] == "john"

notEmptyMap.each{ k,v -> println "key=${k}: value=${v}"}    //iterating
notEmptyMap.each{ it -> println "key=${it.key}:value${it.value}"}

def toBeRemove = ["person3" :"oh","person4":"la"]
assert toBeRemove.each{it -> notEmptyMap.remove(it.key) }.size() == 2
notEmptyMap += toBeRemove    //concat
assert notEmptyMap.size() == 4
