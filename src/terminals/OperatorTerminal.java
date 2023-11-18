//Colin klich
package terminals;

import accounts.Operator;
import controllers.AccountsController;
import java.text.ParseException;
import java.util.Objects;
import java.util.Scanner;

public class OperatorTerminal {
    private boolean verified = false;

    Scanner myObj = new Scanner(System.in);
    Operator admin = new Operator("admin", "admin", "testing123");

    OperatorTerminal(AccountsController accounts){
        boolean running = true;
        while (running) {
            System.out.println("Operator Terminal");
            System.out.println("[1] Login");
            System.out.println("[Quit] Return to Main Menu");
            String terminal = myObj.nextLine();

            if (Objects.equals(terminal, "1")) {
                verified = verifyOperator(admin);
                if (verified) {
                    System.out.println("Operator Terminal");
                    System.out.println("[1] Manage Member");
                    System.out.println("[2] Manage Provider");
                    System.out.println("[Quit] Return to Main Menu");
                    String choice = myObj.nextLine();
                    if (Objects.equals(choice, "1")) {
                        manageMember(accounts);
                    } else if (Objects.equals(choice, "2")) {
                        manageProvider(accounts);
                    } else {
                        running = false;
                    }
                }
            } else {
            	running = false;
            }
        }
    }

    public boolean verifyOperator(Operator admin) {
        System.out.println("Enter Username:");
        String username = myObj.nextLine();
        System.out.println("Enter Password:");
        String password = myObj.nextLine();
        if (Objects.equals(admin.getUsername(), username)
                && Objects.equals(admin.getPassword(), password)) {
            return true;
        } else {
            System.out.println("Incorrect Username or Password.");
            return false;
        }
    }

    public void manageMember(AccountsController accounts){
        boolean running = true;
        while (running) {
            System.out.println("Manage Member");
            System.out.println("[1] Add Member");
            System.out.println("[2] Delete Member");
            System.out.println("[3] Update Member");
            //System.out.println("[4] Display All Members");
            System.out.println("[Quit] Return to Operator Menu");
            String choice = myObj.nextLine();
            if (Objects.equals(choice, "1")) {
                accounts.createMember();
            } else if (Objects.equals(choice, "2")) {
                System.out.println("What is the name of the member you would like to delete?");
                String name = myObj.nextLine();
                accounts.deleteMember(name);
            } else if (Objects.equals(choice, "3")) {
                System.out.println("What is the name of the member you would like to update?");
                String name = myObj.nextLine();
                try {
                    accounts.updateMember(name);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else {
                running = false;
            }
        }
    }

    public void manageProvider(AccountsController accounts){
        boolean running = true;
        while (running) {
            System.out.println("Manage Provider");
            System.out.println("[1] Add Provider");
            System.out.println("[2] Delete Provider");
            System.out.println("[3] Update Provider");
            //System.out.println("[4] Display All Provider");
            System.out.println("[Quit] Return to Operator Menu");
            String choice = myObj.nextLine();
            if (Objects.equals(choice, "1")) {
                accounts.createProvider();
            } else if (Objects.equals(choice, "2")) {
                System.out.println("What is the name of the Provider you would like to delete?");
                String name = myObj.nextLine();
                accounts.deleteProvider(name);
            } else if (Objects.equals(choice, "3")) {
                System.out.println("What is the name of the Provider you would like to update?");
                String name = myObj.nextLine();
                try {
                    accounts.updateProvider(name);
                } catch (ParseException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
            else {
                running = false;
            }
        }
    }
    
}
