package controllers;

import java.util.List;

import accounts.Member;
import accounts.Provider;
import reports.*;
/*
 * @Author Samuel Wisnoff
 */
public class ManagerController{
	//Goal: design a control system designed solely for Managers
	//Objective #1: Need to have a member report retrieval function
	/*
	 * Need to have options so that you can pick what report you want
	 * Needs to access the current state of the report as designed by the Weekly Accounting Procedure
	 * EDIT: Not using the current state of a dynamic report, instead I am using static dummy data gained through the get Method
	 */
	private List<Provider> providerList;
	public List<Member> memberList;
	
	MemberReport memberReport;
	ProviderReport providerReport;
	SummaryReport summaryReport;
	
	public ManagerController(AccountsController accounts) {
		providerList = accounts.getProviders();
		memberList = accounts.getMembers();
	}
	
	
	public void printSummaryReport() {
		SummaryReport summary = new SummaryReport(providerList);
		summary.print();
	}

	public void printProviderReport(Provider provider) {
		ProviderReport report = new ProviderReport(provider);
		report.print();
	}

	public void printMemberReport(Member member) {
		MemberReport report = new MemberReport(member);
		report.print();
	}

}
