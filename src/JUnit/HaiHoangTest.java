package JUnit;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import accounts.Member;
import services.Service;

public class HaiHoangTest {

	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testMemberCreate() {
		Member x = new Member("John Doe",123456789,"123 1st Street","Tuscaloosa","AL",12345);
	}

	@Test
	public void testSetMemberInformation() {
		Member x = new Member("John Doe",123456789,"123 1st Street","Tuscaloosa","AL",12345);
		x.setMemberInformation("James Doe", "123 2nd Street", "Houston", "TX", 78932, "Invalid");
	}

	@Test 
	public void testServiceCreate() {
		Service x = new Service("Jumping", 12345, 100);
	}

}
