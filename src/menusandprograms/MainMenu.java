package menusandprograms;

/**
 * @author Stefan Ohlsson
 * @author Erik Olsson
 */
import mainstart.Main;

public class MainMenu {

    public static void printMainMenu() {
        System.out.println("Welcome to the Employee Management Program");

        System.out.println("**************************************************");
        System.out.println("1. EmployeeMangement (Create,Remove,Update,Delete)");
        System.out.println("2. EmployeeStatistics (Average,High,Low)");
        System.out.println("0. Exit");

        boolean loop = true;
        do {
            String decision = Main.sc.nextLine();

            switch (decision) {

                case "1":
                    // Method Call PrintStaffMangement Menu
                    loop = false;
                    StaffMangement.printMenu();
                    break;
                case "2":
                    // Method Call PrintStaffStatiticsMenu
                    loop = false;
                    StaffStatistics.printMenu();
                    break;
                case "0":
                    // Method Call EXIIIIIITTTTT
                    loop = false;
                    System.out.println("Closing Scanner....");
                    Main.sc.close();
                    System.out.println("Exit system......");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Please choose your Menu...");
                    System.out.println("1. EmployeeMangement (Create,Remove,Update,Move");
                    System.out.println("2. EmployeeStatistics (Average,High,Low");
                    System.out.println("0. Exit");
            }
        } while (loop);
    }
}
