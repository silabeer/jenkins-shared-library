import org.junit.*
import static org.junit.Assert.*
import com.lesfurets.jenkins.unit.*

class SayHelloTest extends BasePipelineTest {
    def sayHello 

    @Before
    void setUp() {
        super.setUp()
        sayHello = loadScript("vars/sayHello.groovy")
    }

    @Test
    void 'sayHello test'() {
        sayHello.call("test")
        printCallStack()
        assertEquals(1, helper.methodCallCount('echo'))
        assertTrue(helper.getCallStack()[1].args[0].toString().contains("Hello"))
        printCallStack()
    }
}
