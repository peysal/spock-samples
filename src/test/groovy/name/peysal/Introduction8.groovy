package name.peysal

/**
 * Groovy introduction closure 1) default it parameter 2) parameter more than 1 3) passing closure to method
 */

def myCodeBlock1 = {println it; it}    //closure with 1 parameter
myCodeBlock1("test")
assert myCodeBlock1("test") == "test"

def myCodeBlock2 = {a,b -> a+b}
assert myCodeBlock2(1,2) == 3

def list = ['a','b','c','d']
def newList = []
def clos = { it.toUpperCase() }    //accept 1 argument
list.collect( newList, clos )    //passing closure as part of parameter
assert newList == ["A", "B", "C", "D"]
