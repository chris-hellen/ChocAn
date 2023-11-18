package services;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ProviderDirectory {
    public List<Service> services;
    String formattedReport = "";

    public ProviderDirectory(){
        this.services =  new ArrayList<Service>();
        Service s1 = new Service("aerobics exercise", 883948, 30);
        Service s2 = new Service("dietician session", 598470, 50);
        this.services.add(s1);
        this.services.add(s2);
    }

    public boolean printDirectory() {
        File report = new File("ProviderDirectory.txt");
        for (Service service : services){
            formattedReport += 
            "Service Name: " + service.getName() + '\n' +
            "\tCode: " + service.getCode() + '\n' +
            "\tFee: " + service.getFee() + '\n';
        }

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
