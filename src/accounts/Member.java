package accounts;

import java.io.File;  
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import services.ServiceProvided;


public class Member  {
    private String memberName;
    private int memberNumber;
    private String address;
    private String city;
    private String state;
    private int zipCode;
    private String memberStatus;
    private List<ServiceProvided> servicesUsed;


    public Member(String name, int memberNumber, String address, String city,  String state, int zipCode){
        this.memberName = name;
        this.memberNumber = memberNumber;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.setMemberStatus("Valid");
        this.servicesUsed = new ArrayList<ServiceProvided>();
    }

    public Member(){
        this.memberName = null;
        this.memberNumber = -1;
        this.address = null;
        this.city = null;
        this.state = null;
        this.zipCode = -1;
        this.setMemberStatus(null);
        this.servicesUsed = null;
    }

    public String getName() {
        return memberName;
    }

    public int getNumber() {
        return memberNumber;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getState() {
        return state;
    }

    public int getZipCode() {
        return zipCode;
    }

	public String getMemberStatus() {
		return memberStatus;
	}

    public List<ServiceProvided> getServicesUsed(){
        return servicesUsed;
    }

	public void setMemberStatus(String memberStatus) {
		this.memberStatus = memberStatus;
	}
	
	public void setMemberNumber(int memberNumber) {
        this.memberNumber = memberNumber;
	}
	
	public void addServiceUsed(ServiceProvided service) {
        this.servicesUsed.add(service);
	}
	
	public void deleteAllServiceUsed() {
		this.servicesUsed = new ArrayList<ServiceProvided>();
	}
	
	public void setMemberInformation(String name, String address, String city,  String state, int zipCode, String status) {
		this.memberName = name;
        this.address = address;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
        this.setMemberStatus(status);
	}
	
	public void writeToFile() {
		   try {
            File dirFile = new File(System.getProperty("user.dir")+"\\src\\accounts\\accounts_storage\\Member_accounts");
	     		File memberFile = new File(dirFile,this.memberName+".txt");
	            memberFile.delete();
	            memberFile = new File(dirFile,this.memberName+".txt");
	            FileWriter memberWrite;
	    			memberWrite = new FileWriter(memberFile);
	    	        memberWrite.write(this.memberName+"\n"); 
	    	        memberWrite.write(this.memberNumber+"\n"); 
	    	        memberWrite.write(this.address+"\n");
	    	        memberWrite.write(this.city+"\n");
	    	        memberWrite.write(this.state+"\n"); 
	    	        memberWrite.write(this.zipCode+"\n");
	    	        memberWrite.write(this.memberStatus+"\n"); 
	    	        memberWrite.close();
	    		} catch (IOException e) {
	    			System.out.println("Error");
	    			e.printStackTrace();
	    		}
	}
}
