import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

class TemperatureConverterTest {
	public TemperatureConverter tc;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		tc = new TemperatureConverter();
	}

	@AfterEach
	void tearDown() throws Exception {
	}
	
	@ParameterizedTest
	@MethodSource("celsiusToFahrenheit")
	void celsiusToFahrenheitChecker(double celsius , double expected)
	{
		double result = TemperatureConverter.celsiusToFahrenheit(celsius);
		Assertions.assertEquals(expected , result);
	}
	
	List<Double[]> celsiusToFahrenheit()
	{
		List<Double[]> list = new ArrayList<>();
		list.add(new Double[] {0.0,32.0});
		list.add(new Double[] {100.0,212.0});
		list.add(new Double[] {-10.0,14.0});
		list.add(new Double[] {25.0,77.0});
		
		return list;
	}
	
	
	
	@Test
	void test() {
		fail("Not yet implemented");
	}

}
