/*
 * @Author Chris Hellen
 */

package reports;
import services.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.util.*;

import accounts.Member;

public class MemberReport{

    private String memberName;
    private int memberNumber;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private List<ServiceProvided> servicesUsed;
    public String formattedReport;
    private String currDate;

	/*
	 * Contructs the member report
	 * @params member the member the report is based off of
	 */
    public MemberReport(Member member){
        this.memberName = member.getName();
		this.memberNumber = member.getNumber();
        this.address = member.getAddress();
        this.city = member.getCity();
        this.state = member.getState();
        this.zipCode = member.getZipCode();
		this.servicesUsed = member.getServicesUsed();
        
        LocalDate date = LocalDate.now(); 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        currDate = date.format(format);

        formattedReport = 
        "Member Name: " + memberName + '\n' +
        "Member Number: " + memberNumber + '\n' +
        "Member Street Address: " + address + '\n' +
        "Member City: " + city + '\n' +
        "Member State: " + state + '\n' +
        "Member Zip Code: " + zipCode + '\n';

        for (ServiceProvided service : servicesUsed){
            this.formattedReport +=
            "\tDate of Service: " + service.getServiceDate() + '\n' +
            "\tProvider Name: " + service.getProviderName() + '\n' + 
            "\tService Name: " + service.getServiceName() + '\n' + '\n';
        }
    }

	/*
     * Prints out the formatted member report to its file
     */
    public boolean print(){
        File report = new File(memberName + currDate + ".txt");

        try {
            FileWriter writer = new FileWriter(report.getName());
            writer.write(formattedReport);
            writer.close();
			return true;
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
		return false;
	}
}
