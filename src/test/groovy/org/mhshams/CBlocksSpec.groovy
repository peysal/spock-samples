package org.mhshams

import spock.lang.Specification

class BlocksSpec extends Specification {

    def "simple feature method"() {
        setup: "an optional text to explain..."
        def i = 1

        expect: "an optional text to explain..."
        i == 1
        i != 0
    }

    def "even simpler feature method"() {
        def i = 1

        expect: "'i' should be 1 and it shouldn't be 0"
        i == 1
        i != 0
    }

    def "you can't have feature method with no block"() {
        def i = 0
    }

    def "feature method with cleanup"() {
        setup: "let's connect to a database and work it."
        def db = new DBConnection()
        db.open()

        expect: "some interaction with db"
        db.query() == "something"

        cleanup: "clean up resources"
        db.close()
    }

    def "feature method  where block"() {
        setup:
        def db = new DBConnection()
        db.open()

        expect:
        result == db.query(i)

        cleanup: "clean up resources"
        db.close()

        where:
        i = 3
        result = "not found"
    }

    def "data-driven feature with where block"() {
        setup:
        def db = new DBConnection()
        db.open()

        expect:
        result == db.query(i)

        cleanup: "clean up resources"
        db.close()

        where:
        /*i << [1, 2, 3, 4, 5, 6]
        result << ["item #1", "item #2", "not found", "item #4", "item #5", "not found"]
        */
        i | result
        1 | "item #1"
        2 | "item #2"
        3 | "not found"
        4 | "item #4"
        5 | "item #5"
        6 | "not found"
    }

    def "BDD style (given, when, then)"() {
        given: "or setup"
        def i = 45
        def j = 20

        when: "no need for 'expect' anymore"
        def k = i + j

        then: "when & then always come together"
        k == 65

        when: "you can have multiple when/then blocks in a feature method"
        def l = i - j

        then:
        l == 25
    }

    def "BDD style with where block"() {
        given:
        def db = new DBConnection()
        db.open()

        when:
        def actual = db.query(i)

        then:
        actual == expected

        cleanup:
        db.close()

        where:
        i | expected
        1 | "item #1"
        2 | "item #2"
        3 | "not found"
    }

    def "more blocks"() {
        given: "we have a database"
        def db = new DBConnection()
        and: "db is open"
        db.open()

        when: "we query for an item"
        def f = db.query(i)
        and: "for another item"
        def s = db.query(i + 1)

        then: "the first result must be"
        f == first
        and: "second result must be"
        s == second

        cleanup: "close and free the expensive resources"
        db.close()

        where: "given data is:"
        i | first       | second
        1 | "item #1"   | "item #2"
        2 | "item #2"   | "not found"
        3 | "not found" | "item #4"

    }
}

class DBConnection {

    def open() {
        println "db is open"
    }

    def query() {
        println "db is being used...."
        return "something"
    }

    def query(i) {
        return i % 3 == 0 ? "not found" : "item #$i"
    }

    def close() {
        println "db is closed"
    }
}