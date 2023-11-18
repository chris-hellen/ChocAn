package utilities;


import services.*;
import accounts.Provider;
import java.util.*;

public class Providers {
    ProviderDirectory providerDirectory;
    List<Service> serviceList;
    public List<Provider> providerList;
    public Providers(){
        providerDirectory = new ProviderDirectory();

        this.serviceList = providerDirectory.services;
        this.providerList = new ArrayList<Provider>();

        Provider prov1 = new Provider("Chris Hellen", 66979, "1234 Meadow Ln", "Tuscaloosa", "AL", 12345);
        Provider prov2 = new Provider("Caleb Dochow", 12158, "1234 Meadow Ln", "Tuscaloosa", "AL", 12345);
        Provider prov3 = new Provider("Kara Moran", 60246, "1234 Meadow Ln", "Tuscaloosa", "AL", 12345);
        
        ServiceProvided service1 = new ServiceProvided(serviceList.get(0), "11-14-2023", "Chris Hellen", 66979, 12345, "Hai Hoang", null);
        ServiceProvided service2 = new ServiceProvided(serviceList.get(1), "11-14-2023", prov1.getName(), prov1.getNumber(), 12345, "Hai Hoang", null);

        prov1.addServicesProvided(service1);
        prov1.addServicesProvided(service2);

        prov2.addServicesProvided(service1);
        prov2.addServicesProvided(service2);

        prov3.addServicesProvided(service1);
        prov3.addServicesProvided(service2);

        this.providerList.add(prov1);
        this.providerList.add(prov2);
        this.providerList.add(prov3);
    }
}