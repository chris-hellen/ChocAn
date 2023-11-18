//@Author Caleb Dochow
package JUnit;

import static org.junit.Assert.*;
import accounts.*;
import org.junit.Before;
import org.junit.Test;

public class CalebDochowTest {
    Provider provider;
    Member member;
    

    @Before
    public void setUp() throws Exception {
		provider = new Provider("Jane Doe", 123123123, "123 2nd Street", "Tuscaloosa", "AL", 35405);
		member = new Member("John Doe",123456789,"123 1st Street","Tuscaloosa","AL",35405);

    }

    @Test
    public void getCity() {
        assertEquals("Tuscaloosa", provider.getCity());
    }

    @Test
    public void getState() {
        assertEquals("AL", provider.getState());
    }

    @Test //Hai's
    public void getZipCodeTest() {
        assertEquals(35405, member.getZipCode());
    }


}
