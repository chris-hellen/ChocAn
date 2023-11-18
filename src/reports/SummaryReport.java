/*
 * @Author Chris Hellen
 */

package reports;
import accounts.Provider;
import java.io.*;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SummaryReport {
    private int totalProviders;
    private int totalConsultations;
    private int overallFeeTotal;
    private String formattedReport = "";
    private String currDate;

	/*
	 * Contructs a report of all the providers and how much they made
	 * @params providerList list of all providers
	 */
    public SummaryReport (List<Provider> providerList){

        LocalDate date = LocalDate.now(); 
        DateTimeFormatter format = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        currDate = date.format(format);

        this.totalProviders = providerList.size();
        for (Provider provider : providerList){
            this.totalConsultations += provider.getNumberOfConsultations();
        }
        for (Provider provider : providerList){
            this.overallFeeTotal += provider.getTotalFees();
        }

        for (Provider provider : providerList){
            this.formattedReport += 
            "Provider: " + provider.getName() + '\n' +
            "\tNumber of Consultations: " + provider.getNumberOfConsultations() + '\n' +
            "\tTotal Fee: " + provider.getTotalFees() + '\n' + '\n';
        }

        this.formattedReport += 
        "Total number of Providers: " + totalProviders + '\n' +
        "Total number of Consultations: " + totalConsultations + '\n' +
        "Overall Total Fee: " + overallFeeTotal;
    }

	//prints out formatted summary report to its own file
    public boolean print(){
        File report = new File("SummaryReport" + currDate + ".txt");

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
