package JUnit;

import org.junit.Test;

import accounts.Member;
import accounts.Provider;
import controllers.AccountsController;
import controllers.ProviderController;
import services.Service;
import services.ProviderDirectory;
import org.junit.Before;
import static org.junit.Assert.*;

import java.util.Scanner;

public class KaraMoranTest {
    //ProviderController providerController;
    ProviderDirectory providerDirectory;
    AccountsController accounts;
    ProviderController providerController;
    Scanner scanner = new Scanner(System.in);
    // test functions bill chocAn and request provider directory
    // test get service code

    // create service to test

    @Before
    public void setUp() {
        //ProviderController providerController = new ProviderController();

        //ProviderDirectory services = new ProviderDirectory();
       // services.addService("Chocolate Web Addiction", 909090, 50);
        //int listSize = services.size();

        accounts.addMember("Kara Moran", 123456, "myAddress", "myCity", "myState", 35404);

    }

    // checks whether 
    @Test
    public void requestProviderDirectoryTest(ProviderDirectory providerDirectory) {
        //int listSize = providerDirectory.services.size();
    }

    @Test
    public void validateMemberTest(AccountsController accounts) {
        assertEquals(true, providerController.validateMember(accounts, scanner));
    }

    @Test 
    public void testServiceGetName(){
        Service service = new Service("Service 1", 123456, 100);
        assertEquals("Service1", service.getName());
    }
}
