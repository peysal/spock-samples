package name.peysal

/**
 * @author peysal
 * Groovy introduction: 1) list 2) operator overloading 3) method pointer
 */
def list = []
assert list.isEmpty()
list.add("ayam")
list.add "babun"    //optional parentheses, except if it doesnt have any argument
list << "cicak"    //operator overloading
assert list.size == 3
println list

def tambah = list.&add    //method pointer in action
tambah "dugong"
println list

assert list.size == 4
