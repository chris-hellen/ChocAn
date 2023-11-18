package JUnit;
import reports.*;
import accounts.*;
import utilities.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class ChrisHellenTest {

    Member member;
    Provider provider;
    MemberReport memberReport;
    ProviderReport providerReport;
    SummaryReport summaryReport;
    EFTReport eftReport;
    Providers providers;
    Members members;
    
    @Before
    public void setUp() throws Exception {
        members = new Members();
        member = members.memberList.get(0);
        memberReport = new MemberReport(member);
        providers = new Providers();
        provider = providers.providerList.get(0);
        providerReport = new ProviderReport(provider);
        summaryReport = new SummaryReport(providers.providerList);
        eftReport =  new EFTReport(providers.providerList);
    }

    @Test
    public void memberFormatReportTest() {
        assertEquals(true, memberReport.print());
    }

    @Test
    public void providerFormatReportTest() {
        assertEquals(true, providerReport.print());
    }   
    
    @Test
    public void summaryFormatReportTest() {
        assertEquals(true, summaryReport.print());
    }

    @Test
    public void eftFormatReportTest() {
        assertEquals(true, eftReport.print());
    }

    @Test 
    public void memberGetNameTest(){
        assertEquals("Hai Hoang", member.getName());
    }

}
