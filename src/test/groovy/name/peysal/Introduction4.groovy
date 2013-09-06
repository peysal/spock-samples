package name.peysal

/**
 * Introduction to groovy. Safe deferencing and auto boxing
 */

candidate1 = new Person(name:"bill", spouse: new Person(name:"lengloy"))
candidate1.spouse.spouse = candidate1
assert candidate1.spouse.spouse != null

candidate2 = new Person(name:"bull")
assert candidate2.spouse?.name == null //defendsive programming groovy style. Safe dereferencing

candidate1.age = 32
assert candidate1.age.class == Integer.class

candidate2.age = 30.5
assert candidate2.age.class == BigDecimal.class
