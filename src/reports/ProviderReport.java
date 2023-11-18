/*
 * @Author Chris Hellen
 */

package reports;
import accounts.Provider;
import services.ServiceProvided;
import java.io.*;
import java.util.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class ProviderReport {

	private String providerName;
	private int providerNumber;
	private String address;
	private String city;
	private String state;
	private int zipCode;
	private int numberOfConsultations;
	private int totalFees;
    private List<ServiceProvided> servicesProvided;
    private String formattedReport;
    private String currDate;
    
    //Constructor for the ProviderReport class
	//@params provider provider that the report is based off of
	public ProviderReport (Provider provider){
	    this.providerName = provider.getName();
		this.providerNumber = provider.getNumber();
        this.address = provider.getAddress();
        this.city = provider.getCity();
        this.state = provider.getState();
        this.zipCode = provider.getZipCode();
        this.numberOfConsultations = provider.getNumberOfConsultations();
        this.totalFees = provider.getTotalFees();
        this.servicesProvided = provider.getServicesProvided();

        LocalDate date = LocalDate.now(); 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        currDate = date.format(format);

        this.formattedReport = 
        "Provider Name: " + providerName + '\n' +
        "Provider Number: " + providerNumber + '\n' +
        "Provider Street Address: " + address + '\n' +
        "Provider City: " + city + '\n' +
        "Provider State: " + state + '\n' +
        "Provider Zip Code: " + zipCode + '\n';

        for (ServiceProvided service :  servicesProvided){
            this.formattedReport += 
            "\tDate of Service: " + service.getServiceDate() + '\n' +
            "\tDate and time data were recieved by the computer: " + service.getCurrentDate() + '\n' + 
            "\tMember Name: " + service.getMemberName() + '\n' + 
            "\tMember Number: " + service.getMemberNumber() + '\n' + 
            "\tService Code: " + service.getServiceCode() + '\n' +
            "\tFee to be paid: $" + service.getFee() + '\n' + '\n';
        }
        
        this.formattedReport += 
        "Total number of Consultations with Members: " + numberOfConsultations + '\n' +
        "Total Fee for the Week: $" + totalFees;
	}

    //Uses the formatted report for the given provider and writes it to the ProviderReport.txt file
	public boolean print(){
        File report = new File(providerName + currDate + ".txt");

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
