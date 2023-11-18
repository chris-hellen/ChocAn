package controllers;

import services.*;
import accounts.*;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class ProviderController {

	ProviderDirectory providerDirectory;
	List<Service> serviceList;
	Service service;
	ServiceProvided serviceProvided;
    Member member;    
	String serviceDate, comments, serviceName;
	int fee, code;    

    public ProviderController() {
		providerDirectory = new ProviderDirectory();
		serviceList = providerDirectory.services;
    }

    public void billChocAn(AccountsController accounts, Provider provider, Scanner scanner) {

		// ensure membership status is valid
		if (!validateMember(accounts, scanner)) {
			return;
		}

		// read date from input and store for service
		scanner.nextLine();
		System.out.println("Enter Date (MM-DD-YYY): ");
		serviceDate = scanner.nextLine();

		// while loops takes service code from input until provider verifies correct service is displayed
		boolean unverified = true;
		System.out.println("Enter service code: ");

		while (unverified) {

			int serviceCode = scanner.nextInt();

			for(Service curr : serviceList){
				if (curr.getCode() == serviceCode){
					service = curr;
					if (curr.getName().length() < 20) {
						System.out.println(curr.getName());
					}
					else {
						for (int i = 0; i < 20; i++) {
							System.out.print(curr.getName().charAt(i));
						}
						System.out.print('\n');
					}
					
					break;
				}
				System.out.println("Service Code not Found");
				return;
			}

			System.out.println("Verify service:");
			System.out.println("[1] Correct");
			System.out.println("[2] Incorrect");	
		
			int verification = scanner.nextInt();

			if (Objects.equals(verification, 1)) {
				unverified = false;
			}
			else if (Objects.equals(verification, 2)) {
				System.out.println("Reenter service code:");
				unverified = true;
			}
			else {
				System.out.println("Invalid input");
				unverified = true;
			}
		}

		//prints fee associated with input serviceCode's service
		System.out.println("Amount billed to ChocAn: $" + service.getFee());

		//gives provider option to enter comments
		System.out.println("Enter comments");
		System.out.println("[1] Yes");
		System.out.println("[2] No");

		int option = scanner.nextInt();		

		//sets service's comments field equal to input from provider, else returns
		if (option == 1) {
			System.out.println("Enter comments:");
			String enteredComments = scanner.nextLine();
			comments = enteredComments;
		}
		else if (option == 2) {
			comments = null;
		}
		else {
			System.out.println("Invalid input");
		}
		
		serviceProvided = new ServiceProvided(service, serviceDate, provider.getName(), provider.getNumber(), member.getNumber(), member.getName(), comments);
		member.addServiceUsed(serviceProvided);
		provider.addServicesProvided(serviceProvided);
	}

	public void requestProviderDirectory() {
		providerDirectory.printDirectory();
	}

	public boolean validateMember(AccountsController accounts, Scanner scanner) {
        System.out.println("Enter Member Number:");
        int memberNum = scanner.nextInt();
		// set member equal to Member object with that memberNum
		member = accounts.getMember(memberNum);

		//print member status and return boolean value for valid status or invalid and reason
		if (member.getMemberStatus() == null) {
			System.out.println("Invalid number");
			return false;
		}
        else if (member.getMemberStatus().equals("Valid")) {
			System.out.println("Validated");
			return true;
		}
		else if (member.getMemberStatus().equals("Suspended")) {
			System.out.println("Suspended");
			return false;
		}
		else {
			return false;
		}
    }
}
