import spock.lang.Specification
import com.redbard.resources.HelloWorldResource;


class HelloWorldSpec extends Specification {
	def HELLO_WORLD = "Hello! How are you today?"
	def HELLO_WORLD_REVERSED = "?yadot uoy era woH !olleH"
	
	// Depending on scenario, I may have this reset for each test, but the use case is simple here so leaving as is.
	def helloWorldResource = new HelloWorldResource(HELLO_WORLD)
	

	def "helloWorld() should equal helloWorld"() {
		given: "The HelloWorldResource is constructed with HELLO_WORLD"
		expect:
		HELLO_WORLD == helloWorldResource.helloWorld()
	}
	
	def "helloWorldFormat(true) should equal helloWorldReversed"() {
		given: "The HelloWorldResource is constructed with HELLO_WORLD"
		expect:
		HELLO_WORLD_REVERSED == helloWorldResource.helloWorldFormat(true)
	}
	
	def "helloWorldFormat(false) should equal helloWorld"() {
		given: "The HelloWorldResource is constructed with HELLO_WORLD"
		expect:
		HELLO_WORLD == helloWorldResource.helloWorldFormat(false)
	}
	
	// Could add more variety and fault scenarios, such as if the contructor passed null, etc.
}