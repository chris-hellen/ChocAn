//@Author Caleb Dochow
package terminals;

import accounts.*;

import controllers.*;
import java.io.InputStream;
import java.util.Objects;
import java.util.Scanner;

public class ManagerTerminal {
    private boolean verified = false;
    private ManagerController reports;
    private Scanner scanner;

    Manager admin = new Manager("admin", "admin", "testing123");

    public ManagerTerminal(AccountsController accounts) {
        reports = new ManagerController(accounts);
        this.scanner = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Manager Terminal");
            System.out.println("[1] Login");
            System.out.println("[Quit] Return to Main Menu");
            String terminal = scanner.nextLine();

            if (Objects.equals(terminal.toLowerCase(), "quit")) { // QUIT
                running = false;
            } else if (Objects.equals(terminal, "1")) { // LOGIN
                verified = verifyManager(admin);
                if (verified) {

                    System.out.println("Manager Terminal");
                    System.out.println("[1] Generate Reports");
                    System.out.println("[Quit] Return to Main Menu");
                    String choice = scanner.nextLine();

                    if (Objects.equals(choice, "1")) { // GENERATE REPORTS
                        generateReports(reports, accounts);
                    }

                    if (Objects.equals(choice.toLowerCase(), "quit")) { // QUIT
                        running = false;
                    }
                }
            }
        }
    }

    // Method to set the input source
    public void setInputSource(InputStream inputStream) {
        this.scanner = new Scanner(inputStream);
    }

    public boolean verifyManager(Manager admin) { // Verifies Manager Status via Login
        System.out.println("Enter Username:");
        String username = scanner.nextLine();

        System.out.println("Enter Password:");
        String password = scanner.nextLine();

        if (Objects.equals(admin.getUsername(), username) && Objects.equals(admin.getPassword(), password)) {
            return true;
        } else {
            System.out.println("Incorrect Username or Password.");
            return false;
        }
    }

    public void generateReports(ManagerController reportInformation, AccountsController accounts) {
        boolean running = true;
        while (running) {
            // Display report options
            System.out.println("Generate Reports");
            System.out.println("[1] Get Provider Report");
            System.out.println("[2] Get Member Report");
            System.out.println("[3] Get Summary Report");
            System.out.println("[Quit] Return to Manager Menu");

            // Get user input
            String choice = scanner.nextLine();
            int num; // Holds value of provider number or member number

            switch (choice.toLowerCase()) { // switch for each report
                case "1":
                    System.out.println("Enter Provider Number");
                    num = Integer.valueOf(scanner.nextLine());
                    Provider provider = accounts.getProvider(num);
                    reportInformation.printProviderReport(provider);
                    break;
                case "2":
                    System.out.println("Enter Member Number");
                    num = Integer.valueOf(scanner.nextLine());
                    Member member = accounts.getMember(num);
                    reportInformation.printMemberReport(member);
                    break;
                case "3":
                    reportInformation.printSummaryReport();
                    break;
                case "quit":
                    running = false;
                    break;
            }
            break;
        }
    }
}
