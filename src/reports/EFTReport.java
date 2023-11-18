/*
 * @Author Chris Hellen
 */
package reports;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import accounts.Provider;

public class EFTReport {
    List<Provider> providerList;
    int grossIncome;
    String formattedReport;

    /*
     * Creates the EFT banking report
     * @params providerList a list of all providers needed to be payed this week
     */
    public EFTReport(List<Provider> providerList){
        this.providerList = providerList;

        for (Provider provider : providerList){
            this.grossIncome += provider.getTotalFees();
        }

        this.formattedReport = "Gross Income: $" + this.grossIncome + '\n';
        this.formattedReport += "Routing Information: \n";

        for (Provider provider : providerList){
            this.formattedReport += 
            "\tProvider: " + provider.getName() + '\n' +
            "\t\tRouting Number: " + provider.getNumber() + '\n' +
            "\t\tRouting Amount: $" + provider.getTotalFees() + '\n' + '\n';
        }
    }

    /*
     * Prints out the formatted eft report to its file
     */
    public boolean print(){
        File report = new File("EFTReport.txt");

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
