package name.peysal

import spock.lang.Specification

/**
 * Expando spec.
 * @author peysal
 */
class ExpandoSpec extends Specification {

    def originalMethod = Utils.metaClass.static.printLogMessage

    def "static method will be replace by our implementation inside this test case"() {
        given: "take note of the argument being supply inside closure"
            Utils.metaClass.static.printLogMessage = { String message ->
                String newMessage = "++${message}++"
                println newMessage
                return newMessage
            }
        when:
            String result = Utils.printLogMessage("test")
        then:
            result == "++test++"
    }

    def "static method will return to its original behaviour"() {
        when:
            Utils.metaClass.static.printLogMessage = null
            String result = Utils.printLogMessage("test")
        then:
            result == "--test--"

    }
}
