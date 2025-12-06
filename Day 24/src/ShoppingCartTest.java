import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ShoppingCartTest {
	private ShoppingCart cart;
	@BeforeAll
	static void setUpBeforeClass() throws Exception {
		
	}

	@AfterAll
	static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	void setUp() throws Exception {
		ShoppingCart cart = new ShoppingCart();
		System.out.println("Setting up a new shopping cart for a test...");
	}

	@AfterEach
	void tearDown() throws Exception {//throws exception
		cart = null;
		System.out.println("Cleaning up shopping cart resources after test...");
		
	}

	@Test
	void testAddItem() {
		cart.addItem("Pencil",10.0);
		cart.addItem("Pen",20.0);//adding item pen
		Assertions.assertEquals(2,cart.getItemCount());
		Assertions.assertEquals(30.0,cart.getTotalPrice());
	}
	
	@Test
	void testRemoveItem()
	{//test cases to remove items
		cart.addItem("Eraser",20.0);
		cart.addItem("scale",15.0);
		cart.removeItem("Eraser",20.0);
		Assertions.assertEquals(3,cart.getItemCount());
		Assertions.assertEquals(15.0,cart.getTotalPrice());
		
	}
	
	@Test
	void testEmptyCartInitially()
	{//assertEqual check if its correct or not
		Assertions.assertEquals(0,cart.getItemCount());
		Assertions.assertEquals(0.0,cart.getTotalPrice());	
	}

}
