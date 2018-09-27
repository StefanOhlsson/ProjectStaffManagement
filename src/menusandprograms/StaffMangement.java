package menusandprograms;

/**
 * @author Stefan Ohlsson
 * @author Erik Olsson
 */
import mainstart.Main;
import initializers.*;

public class StaffMangement {

    public static void printMenu() {

        System.out.println("\tEmployeeMangement");
        System.out.println("********************************");
        String decision;
        do {
            System.out.println("1. Add or Delete Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Search Employee");
            System.out.println("4. Display Employee");
            System.out.println("0. Main Menu");

            decision = Main.sc.nextLine();

            switch (decision) {
                case "1":
                    addOrDeleteDecision();
                    break;
                case "2":
                    updateDecision();
                    break;
                case "3":
                    searchDecision();
                    break;
                case "4":
                    displayDecision();
                case "0":
                    MainMenu.printMainMenu();
                    break;
                default:
                    System.out.println("Please make a decision...");

            }
        } while (!(decision.equals("1") || decision.equals("2") || decision.equals("3") || decision.equals("4")));
    }

    private static void addOrDeleteDecision() {

        boolean loop = true;
        System.out.println("Add or Delete? '+' or '-'");
        do {
            String decision = Main.sc.nextLine();

            if (decision.equalsIgnoreCase("+") || decision.equalsIgnoreCase("add")) {
                loop = false;
                add();
            } else if (decision.equalsIgnoreCase("-") || decision.equalsIgnoreCase("delete")) {
                loop = false;
                // Method for DELETE
                delete();
            } else {
                System.out.println("Please do char '+' or '-'");
                System.out.println("Do you want to go back? y or n");

                String decision2 = Main.sc.nextLine();
                if (decision2.equalsIgnoreCase("y")) {
                    printMenu();
                } else {
                    System.out.println("Add or Delete? '+' or '-'");
                }
            }

        } while (loop);
    }

    private static void add() {
        System.out.println("ADD EMPLOYEE");
        System.out.println("****************");

        String firstName = addFirstName();

        String lastName = addLastName();

        int birthYear = addBirthYear();

        int salary = addSalary();

        String sex = addSex();

        addDepartment(firstName, lastName, birthYear, salary, sex);
        printMenu();
        addAnother();
    }

    private static void addDepartment(String firstName, String lastName, int birthYear, int salary, String sex) {
        System.out.println("Department");
        System.out.println("IT , Management or Sales?");
        String department;
        do {
            department = Main.sc.nextLine();

            if (department.equalsIgnoreCase("it")) {

                addITEmployee(firstName, lastName, birthYear, salary, sex);

            } else if (department.equalsIgnoreCase("management")) {

                addManagementEmployee(firstName, lastName, birthYear, salary, sex);

            } else if (department.equalsIgnoreCase("sales")) {

                addSalesEmployee(firstName, lastName, birthYear, salary, sex);

            } else {
                System.out.println("IT , Management or Sales?");
            }
        } while (!((department.equalsIgnoreCase("it")) || (department.equalsIgnoreCase("management"))
                || (department.equalsIgnoreCase("sales"))));

        if (department.equalsIgnoreCase("it")) {
            System.out.println(department.toUpperCase() + " Employee added to the ArrayList");
        } else {
            System.out.println(
                    department.toUpperCase().charAt(0) + department.substring(1) + " Employee added to the Array");
        }
    }

    private static String addSex() {
        boolean loop;
        System.out.println("Male/Female : ");
        loop = true;
        String sex = null;
        while (loop) {
            sex = Main.sc.nextLine();
            if (!(sex.equalsIgnoreCase("male") || sex.equalsIgnoreCase("female"))) {
                System.out.println("MALE OR FEMALE?");
            } else {
                loop = false;
            }
        }
        return sex;
    }

    private static int addSalary() {
        boolean loop;
        boolean hasNext;
        System.out.println("Salary : ");
        loop = true;
        int salary = 0;
        while (loop) {
            hasNext = Main.sc.hasNextInt();

            if (hasNext) {
                salary = Main.sc.nextInt();

                if (salary < 0) {
                    System.out.println("Invalid salary!");
                    Main.sc.nextLine();
                } else {
                    loop = false;
                    Main.sc.nextLine();
                }
            } else {
                System.out.println("Thats not even a number!");
                Main.sc.nextLine(); // ERROR MESSAGE FOR !INT
            }
        } // END OF LOOP
        return salary;
    }

    private static int addBirthYear() {
        System.out.println("Birth Year : yyyy ");
        boolean loop = true;
        boolean hasNext;
        int birthYear = 0;
        while (loop) {

            hasNext = Main.sc.hasNextInt();
            if (hasNext) {
                birthYear = Main.sc.nextInt();
                if ((hasNext) && (birthYear > 2018) || (birthYear < 1900)) {
                    System.out.println("You are too young or too old!");
                    System.out.println("Birthday : yyyy ");
                    Main.sc.nextLine();
                } else {
                    loop = false;
                    Main.sc.nextLine();
                }

            } else {
                System.out.println("Thats not even a number!");
                Main.sc.nextLine();
                // ERROR MESSAGE FOR !INT
            }
        } // END OF LOOP
        return birthYear;
    }

    private static String addLastName() {
        System.out.println("Last name : ");
        String lastName = Main.sc.nextLine();
        lastName = lastName.toUpperCase().charAt(0) + lastName.substring(1);
        return lastName;
    }

    private static String addFirstName() {
        System.out.println("First name : ");
        String firstName = Main.sc.nextLine();
        firstName = firstName.toUpperCase().charAt(0) + firstName.substring(1);
        return firstName;
    }

    private static void delete() {
        System.out.println("DELETE EMPLOYEE");
        System.out.println("****************");

        Employee del = getEmployee();
        System.out.println(del);
        System.out.println("Are you sure?");
        String decision = Main.sc.nextLine();
        if (decision.equalsIgnoreCase("yes") || decision.equalsIgnoreCase("y")) {
            int index = del.getNumber() - 1;
            Main.employeeList.remove(index);
            System.out.println("Employee : " + del.getLastName() + ", " + del.getFirstName() + " deleted!");
        }

        printMenu();
    }

    private static Employee getEmployee() {

        System.out.println("Enter ID number :");
        int index = Main.sc.nextInt();
        Main.sc.nextLine();
        index--; // Array Index Modifier

        if ((index < 0) || (index > Main.employeeList.size())) {
            System.out.println("ID NUMBER DOSENT EXIST");
            System.out.println("WAS PRINTED AS DEFAULT");
            index = 0;
            return Main.employeeList.get(index);
        }

        return Main.employeeList.get(index);
    }

    private static void updateDecision() {

        System.out.println("\tUpdate Employee");
        System.out.println("*********************************");

        Employee getEmployee = getEmployee();
        System.out.println("What do you want to change?");

        System.out.println("1. First name : " + getEmployee.getFirstName());
        System.out.println("2. Last Name : " + getEmployee.getLastName());
        System.out.println("3. Birth year : " + getEmployee.getBirthYear());
        System.out.println("4. Salary : " + getEmployee.getSalary());
        System.out.println("5. Sex :" + getEmployee.getSex());
        System.out.println("6. Department");
        System.out.println("0. Menu");

        String decision = Main.sc.nextLine();
        switch (decision) {
            case "1":
                updateFirstName(getEmployee);
                break;
            case "2":
                updateLastName(getEmployee);
                break;
            case "3":
                updateBirthYear(getEmployee);
                break;
            case "4":
                updateSalary(getEmployee);
                break;
            case "5":
                updateSex(getEmployee);
                break;
            case "6":
                updateDepartment(getEmployee);
                break;
            case "0":
                printMenu();
                break;
        }

    }

    private static void updateFirstName(Employee employee) {
        int index = employee.getNumber() - 1;
        System.out.println("Enter new First Name :");
        String newFirstName = Main.sc.nextLine();

        Main.employeeList.get(index).setFirstName(newFirstName);
        System.out.println(employee.toString2());
    }

    private static void updateLastName(Employee employee) {
        int index = employee.getNumber() - 1;
        System.out.println("Enter new Last Name :");
        String newLastName = Main.sc.nextLine();

        Main.employeeList.get(index).setLastName(newLastName);

    }

    private static void updateBirthYear(Employee employee) {
        int index = employee.getNumber() - 1;
        System.out.println("Enter new birth year :");
        int newBirthYear = Main.sc.nextInt();
        Main.sc.nextLine();
        Main.employeeList.get(index).setBirthYear(newBirthYear);
        printMenu();
    }

    private static void updateSalary(Employee employee) {
        int index = employee.getNumber() - 1;
        System.out.println("Enter new Salary :");
        int newSalary = Main.sc.nextInt();
        Main.sc.nextLine();
        Main.employeeList.get(index).setSalary(newSalary);
        System.out.println("New salary added!");
        printMenu();
    }

    private static void updateSex(Employee employee) {
        int index = employee.getNumber() - 1;
        System.out.println("Enter new sex:");
        String newSex = Main.sc.nextLine();

        Main.employeeList.get(index).setSex(newSex);
        System.out.println("New sex added!");
        printMenu();
    }

    private static void updateDepartment(Employee employee) {
        int index = employee.getNumber() - 1; // Array Index Modifier
        int remove = Main.employeeList.size();

        System.out.println("To what Department :");
        System.out.println("1. IT");
        System.out.println("2. Sales");
        System.out.println("3. Mangement");

        String decision = Main.sc.nextLine();
        switch (decision) {
            case "1":
                // IT
                updateITDepartment(employee, index, remove);
                break;
            case "2":
                // Sales
                updateSalesEmployee(employee, index, remove);
                break;
            case "3":
                // Management
                updateMangementEmployee(employee, index, remove);
                break;
        }

        printMenu();
    } // end of method

    private static void updateMangementEmployee(Employee employee, int index, int remove) {
        System.out.println("To wich employee Cathegory??");
        System.out.println("1. Chief Executive Officer");
        System.out.println("2. Chief Financial Officer");
        System.out.println("3. Chief Operations Officer");

        String decision3 = Main.sc.nextLine();
        switch (decision3) {

            case "1":
                if (employee instanceof ChiefExecutiveOfficer) {
                    System.out.println("Employee already in that cathegory!");
                    break;
                }
                ChiefExecutiveOfficer updatedCEO = new ChiefExecutiveOfficer(employee.getFirstName(),
                        employee.getLastName(), employee.getBirthYear(), employee.getSalary(), 0, employee.getSex(),
                        "Management", "ChiefExecutiveOfficer");
                Main.employeeList.add(updatedCEO);
                Main.employeeList.set(index, updatedCEO);
                Main.employeeList.remove(remove);
                break;

            case "2":
                if (employee instanceof ChiefFinancialOfficer) {
                    System.out.println("Employee already in that cathegory!");
                    break;
                }
                ChiefFinancialOfficer updatedCFO = new ChiefFinancialOfficer(employee.getFirstName(),
                        employee.getLastName(), employee.getBirthYear(), employee.getSalary(), 0, employee.getSex(),
                        "Management", "ChiefFinancialOfficer");
                Main.employeeList.add(updatedCFO);
                Main.employeeList.set(index, updatedCFO);
                Main.employeeList.remove(remove);
                break;

            case "3":
                if (employee instanceof ChiefOperationsOfficer) {
                    System.out.println("Employee already in that cathegory!");
                    break;
                }
                ChiefOperationsOfficer updatedCOO = new ChiefOperationsOfficer(employee.getFirstName(),
                        employee.getLastName(), employee.getBirthYear(), employee.getSalary(), 0, employee.getSex(),
                        "Management", "ChiefOperationsOfficer");
                Main.employeeList.add(updatedCOO);
                Main.employeeList.set(index, updatedCOO);
                Main.employeeList.remove(remove);
                break;
        }
    }

    private static void updateSalesEmployee(Employee employee, int index, int remove) {
        System.out.println("To wich employee Cathegory??");
        System.out.println("1. Account Manager");
        System.out.println("2. Market Manager");

        String decision2 = Main.sc.nextLine();
        switch (decision2) {

            case "1":
                if (employee instanceof AccountManager) {
                    System.out.println("Employee already in that cathegory!");
                    break;
                }

                AccountManager updatedAccountManager = new AccountManager(employee.getFirstName(), employee.getLastName(),
                        employee.getBirthYear(), employee.getSalary(), 0, employee.getSex(), "Sales", "Account Manager");
                Main.employeeList.add(updatedAccountManager);
                Main.employeeList.set(index, updatedAccountManager);
                Main.employeeList.remove(remove);
                break;

            case "2":
                if (employee instanceof MarketManager) {
                    System.out.println("Employee already in that cathegory!");
                    break;
                }
                MarketManager updatedMarketManager = new MarketManager(employee.getFirstName(), employee.getLastName(),
                        employee.getBirthYear(), employee.getSalary(), 0, employee.getSex(), "Sales", "Market Manager");
                Main.employeeList.add(updatedMarketManager);
                Main.employeeList.set(index, updatedMarketManager);
                Main.employeeList.remove(remove);
                break;
        }
    }

    private static void updateITDepartment(Employee employee, int index, int remove) {
        System.out.println("To wich employee Cathegory??");
        System.out.println("1. Tester");
        System.out.println("2. Analyst");
        System.out.println("3. Developer");
        String decision1 = Main.sc.nextLine();
        switch (decision1) {

            case "1":
                if (employee instanceof Tester) {
                    System.out.println("Employee already in that cathegory!");
                    break;
                }
                Tester updatedTest = new Tester(employee.getFirstName(), employee.getLastName(), employee.getBirthYear(),
                        employee.getSalary(), 0, employee.getSex(), "IT", "Tester");
                Main.employeeList.add(updatedTest);
                Main.employeeList.set(index, updatedTest);
                Main.employeeList.remove(remove);
                break;

            case "2":
                if (employee instanceof Analyst) {
                    System.out.println("Employee already in that cathegory!");
                    break;
                }
                Analyst updatedAnalyst = new Analyst(employee.getFirstName(), employee.getLastName(),
                        employee.getBirthYear(), employee.getSalary(), 0, employee.getSex(), "IT", "Analyst");
                Main.employeeList.add(updatedAnalyst);
                Main.employeeList.set(index, updatedAnalyst);
                Main.employeeList.remove(remove);
                break;

            case "3":
                if (employee instanceof Developer) {
                    System.out.println("Employee already in that cathegory!");
                    break;
                }
                Developer updatedDeveloper = new Developer(employee.getFirstName(), employee.getLastName(),
                        employee.getBirthYear(), employee.getSalary(), 0, employee.getSex(), "IT", "Developer");
                Main.employeeList.add(updatedDeveloper);
                Main.employeeList.set(index, updatedDeveloper);
                Main.employeeList.remove(remove);
                break;
        }
    }

    private static void searchDecision() {
        System.out.println("SEARCH EMPLOYEE");
        System.out.println("****************");

        System.out.println("Search by :");
        System.out.println("1. First name");
        System.out.println("2. Last name");
        System.out.println("3. Birth Year");
        System.out.println("4. Department");
        System.out.println("0. Back to Menu");

        String decision = Main.sc.nextLine();

        switch (decision) {

            case "1":
                searchFirstName();
                break;
            case "2":
                searchLastName();
                break;
            case "3":
                searchBirthYear();
                break;
            case "4":
                searchDepartment();
                break;
            case "0":
                printMenu();
                break;
        }

    }

    private static void searchFirstName() {

        System.out.println("Search by first name");
        System.out.println("*********************");
        String decision;
        do {
            String getName;
            System.out.println("Enter first name :");
            getName = Main.sc.nextLine();
            for (Employee employee : Main.employeeList) {

                if (getName.equalsIgnoreCase(employee.getFirstName())) {
                    System.out.println(employee);
                }
            }

            System.out.println("Do another search?");
            decision = Main.sc.nextLine();
        } while (decision.equalsIgnoreCase("yes") || (decision.equalsIgnoreCase("y")));

        searchDecision();

    }

    private static void searchLastName() {

        System.out.println("Search by last name");
        System.out.println("*********************");
        String decision;
        do {
            System.out.println("Enter last name :");
            String getName = Main.sc.nextLine();
            for (Employee employee : Main.employeeList) {

                if (getName.equalsIgnoreCase(employee.getLastName())) {
                    System.out.println(employee);
                }
            }

            System.out.println("Do another search?");
            decision = Main.sc.nextLine();
        } while (decision.equalsIgnoreCase("yes") || (decision.equalsIgnoreCase("y")));

        searchDecision();

    }

    private static void searchBirthYear() {

        System.out.println("Search by Birth Year");
        System.out.println("*********************");
        String decision;
        do {
            System.out.println("Enter birth year : yyyy");
            String getYear = Main.sc.nextLine();
            for (Employee employee : Main.employeeList) {
                if (getYear.equals(String.valueOf(employee.getBirthYear()))) {
                    System.out.println(employee);
                }

            }
            System.out.println("Do another search?");
            decision = Main.sc.nextLine();
        } while (decision.equalsIgnoreCase("yes") || (decision.equalsIgnoreCase("y")));

        searchDecision();
    }

    private static void searchDepartment() {

        System.out.println("Search by Department");
        System.out.println("*********************");
        String decision;
        do {
            System.out.println("Wich department?");
            System.out.println("1. IT");
            System.out.println("2. Sales");
            System.out.println("3. Mangement");

            decision = Main.sc.nextLine();

            switch (decision) {

                case "1":
                case "it":
                    displayIT();
                    break;
                case "2":
                case "sales":
                    displaySales();
                    break;
                case "3":
                case "management":
                    displayMangement();
                    break;
            }
            System.out.println("Do another search?");
            decision = Main.sc.nextLine();
        } while (decision.equalsIgnoreCase("yes") || (decision.equalsIgnoreCase("y")));

        searchDecision();
    }

    private static void displayDecision() {

        System.out.println("Display Employees");
        System.out.println("*****************");

        System.out.println("1. IT-Department");
        System.out.println("2. Sales-Department");
        System.out.println("3. Mangement-Department");
        System.out.println("4. Everyone");
        System.out.println("0. Back to Menu");

        String decision = Main.sc.nextLine();
        switch (decision) {
            case "1":
            case "it":
                displayIT();
                break;
            case "2":
            case "sales":
                displaySales();
                break;
            case "3":
            case "mangement":
                displayMangement();
                break;
            case "4":
            case "all":
                displayAll();
                break;
            case "0":
            case "back":
                printMenu();
                break;
        }

        displayDecision();

    }

    private static void displayAll() {
        int counter = 0;

        for (Employee employee : Main.employeeList) {
            System.out.println(employee.toString2());
            counter++;
        }
        System.out.println(counter + " people in the Company at the moment");
    }

    private static void displayMangement() {
        int counter = 0;
        for (Employee employee : Main.employeeList) {
            if (employee instanceof Management) {
                System.out.println(employee.toString2());
                counter++;
            }
        }
        System.out.println(counter + " people in the Mangement department at the moment");
    }

    private static void displaySales() {
        int counter = 0;
        for (Employee employee : Main.employeeList) {
            if (employee instanceof Sales) {
                System.out.println(employee.toString2());
                counter++;
            }
        }
        System.out.println(counter + " people in the Sales department at the moment");
    }

    private static void displayIT() {
        int counter = 0;
        for (Employee employee : Main.employeeList) {
            if (employee instanceof IT) {
                System.out.println(employee.toString2());
                counter++;
            }
        }
        System.out.println(counter + " people in the IT department at the moment");
    }

    private static void addITEmployee(String firstName, String lastName, int birthYear, int salary, String sex) {
        String department = "IT";
        System.out.println("\tAdd IT Employee");
        System.out.println("What employee cathegory?\n \n1. Developer\n2. Tester\n3. Analyst");

        String decision;
        do {

            decision = Main.sc.nextLine();

            switch (decision) {
                case "1":
                    String cathegory = "Developer";
                    int bonus = bonusControl();
                    Developer developer = new Developer(firstName, lastName, birthYear, salary, bonus, sex, department,
                            cathegory);
                    Main.employeeList.add(developer);
                    System.out.println("New " + cathegory + " added");
                    break;
                case "2":
                    cathegory = "Tester";
                    bonus = bonusControl();
                    Tester tester = new Tester(firstName, lastName, birthYear, salary, bonus, sex, department, cathegory);
                    Main.employeeList.add(tester);
                    System.out.println("New " + cathegory + " added");
                    break;
                case "3":
                    cathegory = "Analyst";
                    bonus = bonusControl();
                    Analyst analyst = new Analyst(firstName, lastName, birthYear, salary, bonus, sex, department,
                            cathegory);
                    Main.employeeList.add(analyst);
                    System.out.println("New " + cathegory + " added");
                    break;

                default:
                    System.out.println("Please make a decision...");

            }
        } while (!(decision.equals("1") || decision.equals("2") || decision.equals("3")));

        addAnother();
    }

    private static void addManagementEmployee(String firstName, String lastName, int birthYear, int salary,
            String sex) {
        String department = "Management";
        System.out.println("\tAdd Management Employee");
        System.out.println(
                "What employee cathegory?\n \n1. Chief Executive Officer\n2. Chief Financial Officer\n3. Chief Operations Officer");

        String decision;
        do {

            decision = Main.sc.nextLine();

            switch (decision) {
                case "1":
                    String cathegory = "Chief Executive Officer";
                    int bonus = bonusControl();
                    ChiefExecutiveOfficer chiefExecutiveOfficer = new ChiefExecutiveOfficer(firstName, lastName, birthYear,
                            salary, bonus, sex, department, cathegory);
                    Main.employeeList.add(chiefExecutiveOfficer);
                    System.out.println("New " + cathegory + " added");
                    break;
                case "2":
                    cathegory = "Chief Financial Officer";
                    bonus = bonusControl();
                    ChiefFinancialOfficer chiefFinancialOfficer = new ChiefFinancialOfficer(firstName, lastName, birthYear,
                            salary, bonus, sex, department, cathegory);
                    Main.employeeList.add(chiefFinancialOfficer);
                    System.out.println("New " + cathegory + " added");
                    break;
                case "3":
                    cathegory = "Chief Operations Officer";
                    bonus = bonusControl();
                    ChiefOperationsOfficer chiefOperationsOfficer = new ChiefOperationsOfficer(firstName, lastName,
                            birthYear, salary, bonus, sex, department, cathegory);
                    Main.employeeList.add(chiefOperationsOfficer);
                    System.out.println("New " + cathegory + " added");
                    break;

                default:
                    System.out.println("Please make a decision...");

            }
        } while (!(decision.equals("1") || decision.equals("2") || decision.equals("3")));

        addAnother();
    }

    private static void addSalesEmployee(String firstName, String lastName, int birthYear, int salary, String sex) {
        String department = "Sales";
        System.out.println("\tAdd Sales Employee");
        System.out.println("What employee cathegory?\n \n1. Account Manager\n2. Chief Financial Officer");

        String decision;
        do {

            decision = Main.sc.nextLine();

            switch (decision) {
                case "1":
                    String cathegory = "Account Manager";
                    int bonus = bonusControl();
                    AccountManager accountManager = new AccountManager(firstName, lastName, birthYear, salary, bonus, sex,
                            department, cathegory);
                    Main.employeeList.add(accountManager);
                    System.out.println("New " + cathegory + " added");
                    break;
                case "2":
                    cathegory = "Market Manager";
                    bonus = bonusControl();
                    MarketManager marketManager = new MarketManager(firstName, lastName, birthYear, salary, bonus, sex,
                            department, cathegory);
                    Main.employeeList.add(marketManager);
                    System.out.println("New " + cathegory + " added");
                    break;

                default:
                    System.out.println("Please make a decision...");

            }
        } while (!(decision.equals("1") || decision.equals("2")));

        addAnother();
    }

    public static void addAnother() {
        System.out.println("Do you want to add another?");
        System.out.println("Yes or no ?");
        String decision = Main.sc.nextLine();

        if (decision.equalsIgnoreCase("yes") || (decision.equalsIgnoreCase("y"))) {
            add();
        } else if (decision.equalsIgnoreCase("no") || (decision.equalsIgnoreCase("n"))) {

            System.out.println("Wich menu?");
            System.out.println("1. StaffMangementMenu");
            System.out.println("2. Main Menu");

            do {
                decision = Main.sc.nextLine();
                switch (decision) {
                    case "1":
                        printMenu();
                        break;
                    case "2":
                        MainMenu.printMainMenu();
                        break;
                    default:
                        System.out.println("1. StaffMangementMenu");
                        System.out.println("2. Main Menu");
                }
            } while (!(decision.equals("1") || decision.equals("2")));
        }

    }

    public static int bonusControl() {
        boolean loop;
        boolean hasNext;
        System.out.println("Bonus. Please supply bonus points: ");
        loop = true;
        int bonus = 0;
        while (loop) {
            hasNext = Main.sc.hasNextInt();

            if (hasNext) {
                bonus = Main.sc.nextInt();

                if (bonus < 0) {
                    System.out.println("Invalid bonus!");
                    Main.sc.nextLine();
                } else {
                    loop = false;
                    Main.sc.nextLine();
                }
            } else {
                System.out.println("Thats not even a number!");
                Main.sc.nextLine(); // ERROR MESSAGE FOR !INT
            }
        } // END OF LOOP
        return bonus;
    }

}
