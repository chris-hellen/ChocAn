//Colin Klich
package terminals;

import java.io.IOException;
import java.text.ParseException;
import utilities.*;
import java.util.*;
import accounts.*;
import controllers.AccountsController;
import services.*;

public class MainTerminal {

    public static AccountsController accounts = new AccountsController();
    static ProviderDirectory pd = new ProviderDirectory();
    static Members members = new Members();
    static List<Member> memberList = members.memberList;
    static Providers providers = new Providers();
    static List<Provider> providersList = providers.providerList;
    static MainAccountingProcedure MAP = new MainAccountingProcedure(providersList, memberList);

    public static void main(String[] args) throws ParseException, IOException {
        //imports user accounts
        //importData();
        //create services in directory
        Scanner terminalInput = new Scanner(System.in);

        boolean running = true;

        while (running) {
            System.out.println("Welcome to ChocAn!");
            System.out.println("Please Choose a Terminal:");
            System.out.println("[1] Provider Terminal");
            System.out.println("[2] Manager Terminal");
            System.out.println("[3] Operator Terminal");
            System.out.println("[End] Close ChocAn");
            String terminal = terminalInput.nextLine();

            if (Objects.equals(terminal, "1")) {
                new ProviderTerminal(accounts, pd.services, terminalInput);
            } else if (Objects.equals(terminal, "2")) {
                new ManagerTerminal(accounts);
            } else if (Objects.equals(terminal, "3")) {
                new OperatorTerminal(accounts);
            } else {
                running = false;
                //storeData();
                System.out.println("Have a Great Day!!!");
                terminalInput.close();
                break;
            }
        }
        return;
    }

    /*private static void storeData() {
        List<Member> members = accounts.getMembers();
        for (Member member : members) {
            member.writeToFile();
        }
        List<Provider> providers = accounts.getProviders();
        for (Provider provider : providers) {
            provider.writeToFile();
        }
    }

    private static void importData() throws IOException {
    	String path = System.getProperty("user.dir")+File.separator+"src\\accounts\\accounts_storage\\Member_accounts";
        File dirFile = new File(path);
        File listOfFiles[] = dirFile.listFiles();    	
        for (File file : listOfFiles) {
            try {
                Scanner myReader = new Scanner(file);
                String name = myReader.nextLine();
                int number = Integer.valueOf(myReader.nextLine());
                String address = myReader.nextLine();
                String city = myReader.nextLine();
                String state = myReader.nextLine();
                int zipCode = Integer.valueOf(myReader.nextLine());
                accounts.addMember(name, number, address, city, state, zipCode);
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        for (File file : listOfFiles) {
        	if(!file.isDirectory()) {
        		file.delete();
        		}
        }

        

        String path2 = System.getProperty("user.dir")+File.separator+"src\\accounts\\accounts_storage\\Provider_accounts";
        File dirFile2 = new File(path2);
        File listOfFiles2[] = dirFile2.listFiles();    	
        for (File file : listOfFiles2) {
            try {
                Scanner myReader = new Scanner(file);
                String name = myReader.nextLine();
                int number = Integer.valueOf(myReader.nextLine());
                String address = myReader.nextLine();
                String city = myReader.nextLine();
                String state = myReader.nextLine();
                int zipCode = Integer.valueOf(myReader.nextLine());
                accounts.addProvider(name, number, address, city, state, zipCode);
                myReader.close();
            } catch (FileNotFoundException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
        for (File file : listOfFiles2) {
        	if(!file.isDirectory()) {
        		file.delete();
        		}
        }


    }*/
}

