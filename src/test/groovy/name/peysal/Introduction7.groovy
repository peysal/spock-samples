package name.peysal

/**
 * introduction to groovy 1) range declaration 2) iterate range 3) contains and reverse 4) size, from, to
 */

def myRange = 1..3
assert myRange.size() == 3
(1..3).each{it -> println it}    //iterate range
myRange.each{println it}

assert myRange.from == 1
assert myRange.to == 3
assert myRange.contains(2)

assert myRange.reverse() == [3,2,1]
