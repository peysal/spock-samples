package org.mhshams

import spock.lang.Specification

class MockingSpec extends Specification {
    def "try it first without any mocking"() {
        given:
        Subscriber s1 = new Collector()
        Subscriber s2 = new Collector()

        Publisher p = new Publisher()
        p.subscribe(s1)
        p.subscribe(s2)

        when:
        p.send("first message")

        then:
        s1.isReceived("first message")
        s2.isReceived("first message")

        when:
        p.send("another message")

        then:
        s1.isReceived("another message")
        s2.isReceived("another message")
    }

    def "we can mock the subscriber"() {
        given:
        def s1 = Mock(Subscriber)
        Subscriber s2 = Mock()

        Publisher p = new Publisher()
        p.subscribe(s1)
        p.subscribe(s2)

        when:
        p.send("first message")

        then:
        1 * s1.receive("first message")
        1 * s2.receive("first message")
    }

    def "check for number of method calls"() {
        given:
        Subscriber s = Mock(Subscriber)
        Subscriber another = Mock(Subscriber)

        Publisher p = new Publisher()
        p.subscribe(s)

        when:
        p.send("first message")
        p.send("second message")
        p.send("second message")
        p.send("second message")

        then:
        0 * another.receive("first message")
        1 * s.receive("first message")
        3 * s.receive("second message")
    }

    def "number of calls can be given as range"() {
        given:
        Subscriber s = Mock(Subscriber)
        Subscriber another = Mock(Subscriber)

        Publisher p = new Publisher()
        p.subscribe(s)

        when:
        p.send("first message")
        p.send("second message")

        then:
        (0..3) * another.receive("first message")
        (1.._) * s.receive("first message")
        (_..3) * s.receive("second message")
    }

    def "we can do more about parameters"() {
        given:
        Subscriber s = Mock(Subscriber)
        Subscriber another = Mock(Subscriber)

        Publisher p = new Publisher()
        p.subscribe(s)

        when:
        p.send("first message")
        p.send("second message")

        then:
        0 * another.receive(_)
        1 * s.receive("first message")
        1 * s.receive(!"first message")

        //            !null  : any non-null argument
        //       _ as String : any String
        //         _ as Foo  : any instance of Foo
        //                *_ : any argument list
        // { it.size() > 3 } : any argument that satisfy given condition
    }

    def "stub and check the expected result"() {
        Subscriber s = Mock(Subscriber)

        s.isReceived("hello") >> true
        s.isReceived("bye") >> false

        expect:
        s.isReceived("hello") == true
        s.isReceived("bye") == false
        s.isReceived("hello") == true
    }

    def "can return different values"() {
        Subscriber s = Mock(Subscriber)

        s.isReceived(_) >>> [true, true, false, true, false]

        expect:
        s.isReceived("hello")
        s.isReceived("bye")
        !s.isReceived("hello")
        s.isReceived("hello")
        !s.isReceived("hello")
    }

    def "we can even use closure in stubbing"() {
        Subscriber s = Mock(Subscriber)

        s.isReceived(_) >> { String m -> m.size() > 3}

        expect:
        s.isReceived("hello")
        !s.isReceived("bye")
        s.isReceived("ok lah")
        !s.isReceived("ok")
        s.isReceived("hello world")
    }

    def "stubbing & mocking together"() {
        Subscriber s = Mock(Subscriber)

        2 * s.isReceived(_) >> true

        expect:
        s.isReceived("hello")
        s.isReceived("bye")
        //s.isReceived("ok")
    }
}

class Publisher {
    private Set<Subscriber> subscribers = [] as Set<Subscriber>

    void send(String message) {
        subscribers.each { it.receive(message)}
    }

    void subscribe(Subscriber subscriber) {
        subscribers << subscriber
    }
}

interface Subscriber {
    void receive(String message)
    boolean isReceived(String message)
}

class Collector implements Subscriber {
    private Set messages = [] as Set

    @Override  void receive(String message) {
        messages << message
    }

    @Override boolean isReceived(String message) {
        return messages.contains(message)
    }
}
