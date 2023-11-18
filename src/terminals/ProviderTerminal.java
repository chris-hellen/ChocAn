// @Author Caleb Dochow
package terminals;

import accounts.Provider;
import controllers.AccountsController;
import controllers.ProviderController;
import services.Service;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

// GOAL: Need to create a validate member function for the provider terminal
public class ProviderTerminal {
    Provider provider;
    ProviderController controller = new ProviderController();

    ProviderTerminal(AccountsController accounts, List<Service> providerDirectory, Scanner scanner) { 
        boolean running = true;
        while (running) {
            System.out.println("Provider Terminal");
            System.out.println("[1] Bill ChocAn");
            System.out.println("[2] Validate Member");
            System.out.println("[3] Request Provider Directory");
            System.out.println("[Quit] Return to Main Menu");
            String terminal = scanner.nextLine();

            if (Objects.equals(terminal, "1")) {
                if (verifyProvider(accounts, scanner)) {
                    controller.billChocAn(accounts, provider, scanner);
                }
            } else if (Objects.equals(terminal, "2")) {
                if (verifyProvider(accounts, scanner)) {
                    controller.validateMember(accounts, scanner);
                }
            } else if (Objects.equals(terminal, "3")) {
                if (verifyProvider(accounts, scanner)) {
                        controller.requestProviderDirectory();
                    }
            } else if (Objects.equals(terminal.toLowerCase(), "quit")) {
                running = false;
            }
        }
    }

    public boolean verifyProvider(AccountsController accounts, Scanner scanner) {
        boolean found = false;
        System.out.println("Enter Provider Number:");
        int providerNum = scanner.nextInt();
        List<Provider> providers = accounts.getProviders();
        for(Provider temp: providers){
            if(temp.getNumber() == providerNum){
                found = true;
                provider = temp;
            }
        }
        if (found) {
            return true;
        } else {
            System.out.println("Incorrect Provider Number.");
            return false;
        }
    }
}
