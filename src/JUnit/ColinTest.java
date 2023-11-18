package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import accounts.Operator;
import accounts.Provider;

public class ColinTest {
	Operator op;
	Provider prv;
	
	@Before
	public void setUp() throws Exception {
		prv = new Provider("Bob", 123123444, "1435 Trace Crossings", "Bham", "AL", 35021);
		op = new Operator("admin", "admin", "Testing123");
	}

	//my method
	@Test
	public void testOperatorGetUsername() {
		assertEquals(op.getUsername(), "admin");
	}

	//my method
	@Test
	public void testOperatorGetPassword() {
		assertNotEquals("admin", op.getPassword());
	}
	
	//other method
	@Test
	public void testProviderGetTotalFees() {
		prv.addFees(50);
		assertEquals(50, prv.getTotalFees());
	}
	

}
