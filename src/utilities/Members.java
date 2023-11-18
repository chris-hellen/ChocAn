package utilities;

import java.util.*;
import accounts.Member;
import services.*;

public class Members {
    ProviderDirectory providerDirectory;
    List<Service> serviceList;
    public List<Member> memberList;
    public Members(){
        this.providerDirectory = new ProviderDirectory();
        this.serviceList = providerDirectory.services;
        this.memberList = new ArrayList<Member>();
        Member mem1 = new Member("Hai Hoang", 12235, "1234 Meadow Ln", "Tuscaloosa", "AL", 12345);
        Member mem2 = new Member("Colin Klich", 12114, "1234 Meadow Ln", "Tuscaloosa", "AL", 12345);
        Member mem3 = new Member("Sam Wisnoff", 12345, "1234 Meadow Ln", "Tuscaloosa", "AL", 12345);
        ServiceProvided service1 = new ServiceProvided(serviceList.get(0), "11-14-2023", "Chris Hellen", 66979, mem1.getNumber(), mem1.getName(), null);
        ServiceProvided service2 = new ServiceProvided(serviceList.get(1), "11-14-2023", "Chris Hellen", 66979, mem2.getNumber(), mem2.getName(), null);
        mem1.addServiceUsed(service1);
        mem1.addServiceUsed(service2);
        mem2.addServiceUsed(service1);
        mem2.addServiceUsed(service2);
        mem3.addServiceUsed(service1);
        mem3.addServiceUsed(service2);
        this.memberList.add(mem1);
        this.memberList.add(mem2);
        this.memberList.add(mem3);
    }
}
