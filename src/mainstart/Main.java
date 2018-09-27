package mainstart;

/**
 * @author Stefan Ohlsson
 * @author Erik Olsson
 */
import initializers.MarketManager;
import initializers.ChiefOperationsOfficer;
import initializers.Tester;
import initializers.Analyst;
import initializers.Developer;
import initializers.Employee;
import initializers.AccountManager;
import initializers.ChiefExecutiveOfficer;
import initializers.ChiefFinancialOfficer;

import java.util.ArrayList;
import java.util.Scanner;

import menusandprograms.MainMenu;

public class Main {

    public static Scanner sc = new Scanner(System.in);
    public static ArrayList<Employee> employeeList = new ArrayList<>();

    public static void main(String[] args) {

        // IT
        Developer d1 = new Developer("Bill", "Gates", 1937, 350000, 4000, "male", "IT", "Developer");
        Developer d2 = new Developer("Larry", "Ellison", 1927, 670000, 5000, "male", "IT", "Developer");
        Developer d3 = new Developer("Linus", "Torvalds", 1961, 88976, 321, "male", "IT", "Developer");
        Analyst a1 = new Analyst("Analys", "Elfbergs", 1933, 88000, 5555, "female", "IT", "Analyst");
        Tester t1 = new Tester("Testulla", "Testson", 1998, 23000, 3456, "female", "IT", "Tester");
        // Management
        ChiefExecutiveOfficer ceo1 = new ChiefExecutiveOfficer("Ceolisa", "Ceson", 1956, 23477, 3342, "female", "Management", "Chief Executive Officer");
        ChiefFinancialOfficer cfo1 = new ChiefFinancialOfficer("Cefoman", "Cefon", 1943, 55379, 9753, "male", "Management", "Chief Financial Officer");
        ChiefOperationsOfficer coo1 = new ChiefOperationsOfficer("Coooman", "cofon", 1983, 346643, 224, "female", "Management", "Chief Operations Officer");
        // Sales
        AccountManager am1 = new AccountManager("Accman", "Acsom", 1901, 22333, 555, "male", "Sales", "Account Manager");
        MarketManager mm1 = new MarketManager("Market", "Marketson", 1907, 77666, 999, "female", "Sales", "Market Manager");

        employeeList.add(d1);
        employeeList.add(d2);
        employeeList.add(d3);
        employeeList.add(a1);
        employeeList.add(t1);

        employeeList.add(ceo1);
        employeeList.add(cfo1);
        employeeList.add(coo1);

        employeeList.add(am1);
        employeeList.add(mm1);

        MainMenu.printMainMenu();

    }

}
