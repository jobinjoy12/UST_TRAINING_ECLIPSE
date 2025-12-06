import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtilsTest2 {

    @BeforeAll
    static void setUpBeforeClass() throws Exception {
        System.out.println("Starting StringUtils tests...");
    }

    @AfterAll
    static void tearDownAfterClass() throws Exception {
        System.out.println("Finished StringUtils tests.");
    }

    @BeforeEach
    void setUp() throws Exception {
        System.out.println("Setting up before test...");
    }

    @AfterEach
    void tearDown() throws Exception {
        System.out.println("Cleaning up after test...");
    }

    @Test
    void testReverseValidInputs() {
        assertEquals("avaJ", StringUtility.reverseString("Java"));
        assertEquals("madam", StringUtility.reverseString("madam")); // palindrome
        assertEquals("a", StringUtility.reverseString("a"));
        assertEquals("", StringUtility.reverseString(""));
    }

    @Test
    void PreConditiontest() {
        // Expect assertion error when input is null
        assertThrows(AssertionError.class, () -> {
            StringUtility.reverseString(null);
        }, "Input string cannot be null");
    }
}