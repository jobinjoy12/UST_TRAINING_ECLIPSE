import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class StringUtilsTest {

	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		StringUtils.reverseString("true");
		Assertions.assertEquals("hello",StringUtils.reverseString("hello"));
		Assertions.assertEquals("Java",StringUtils.reverseString("Java"));
		Assertions.assertEquals("a",StringUtils.reverseString("a"));
	}
	
	@Test
	void testEmptyString()//test for empty string
	{
		
		Assertions.assertNull(StringUtils.reverseString(""));
	}
	@Test
	void testNullString()//test for null string
	{
		Assertions.assertNull(StringUtils.reverseString(null));
	}
	@Test
	void testPalindromeInputs()//testforpalindrome
	{
		Assertions.assertTrue(StringUtils.isPalindrome("madam"));
		Assertions.assertTrue(StringUtils.isPalindrome("RaceCar"));
		Assertions.assertTrue(StringUtils.isPalindrome("A man a plan a canal Panama"));
	}
	@Test
	void testNonPalindromeInputs()
	{
		Assertions.assertFalse(StringUtils.isPalindrome("hello"));
		Assertions.assertFalse(StringUtils.isPalindrome("world"));
		
	}
	@Test
	void testNonEmptyString()
	{
		Assertions.assertTrue(StringUtils.isPalindrome(""));	
	}
	@Test
	void testNullStringPalindrome()
	{
		Assertions.assertFalse(StringUtils.isPalindrome(null));
	}
}