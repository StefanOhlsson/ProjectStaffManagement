package menusandprograms;

/**
 * @author Stefan Ohlsson
 * @author Erik Olsson
 */
import initializers.Management;
import initializers.Sales;
import initializers.Employee;
import initializers.IT;
import mainstart.Main;

public class StaffStatistics {

    public static void printMenu() {

        System.out.println("\tStatistic");
        System.out.println("***********************");
        System.out.println("1. Salary");
        System.out.println("2. Bonus");
        System.out.println("3. Total ");
        System.out.println("0. Main Menu");

        String decision = Main.sc.nextLine();

        switch (decision) {
            case "1":
                salaryStatisticDecision();
                break;
            case "2":
                bonusStatisticDecision();
                break;
            case "3":
                totalStatisticDecision();
                break;
            case "0":
                MainMenu.printMainMenu();
                break;
        }
    }

    private static void salaryStatisticDecision() {

        System.out.println("1. Employee with highest salary :");
        System.out.println("2. Employee with lowest salary : ");
        System.out.println("3. Total salary :");
        System.out.println("4. Average Salary");

        String decision = Main.sc.nextLine();

        switch (decision) {

            case "1":
                getHighestSalary();
                break;
            case "2":
                getLowestSalary();
                break;
            case "3":
                getTotalSalary();
                break;
            case "4":
                getAverageSalary();
                break;
            case "0":
                printMenu();
                break;
        }

    }

    private static void getHighestSalary() {

        int max = Integer.MIN_VALUE;
        Employee highestSalary = null;
        for (Employee employee : Main.employeeList) {

            if (max < employee.getSalary()) {
                max = employee.getSalary();
                highestSalary = employee;
            }
        }

        System.out.println(highestSalary);
        printMenu();
    }

    private static void getLowestSalary() {

        int min = Integer.MAX_VALUE;
        Employee lowestSalary = null;
        for (Employee employee : Main.employeeList) {

            if (min > employee.getSalary()) {
                min = employee.getSalary();
                lowestSalary = employee;
            }

        }

        System.out.println(lowestSalary);
        printMenu();
    }

    private static void getTotalSalary() {

        int sum = 0;
        for (Employee employee : Main.employeeList) {
            sum += employee.getSalary();
        }
        System.out.println("Total salary in the whole company is :");
        System.out.println(sum + " SEK");
        System.out.println("Based on " + Main.employeeList.size() + " employees");
        printMenu();
    }

    private static void getAverageSalary() {

        int average = 0;
        for (Employee employee : Main.employeeList) {

            average += employee.getSalary();
        }
        average = average / Main.employeeList.size();
        System.out.println("Average salary in the whole company is :");
        System.out.println(average + " SEK");
        System.out.println("Based on " + Main.employeeList.size() + " employees");
        printMenu();
    }

    private static void bonusStatisticDecision() {

    }

    private static void totalStatisticDecision() {

        System.out.println("1. Total Salary");
        System.out.println("2. Total of Women");
        System.out.println("3. Total of Men");
        System.out.println("4. Total of Employees");

        String decision = Main.sc.nextLine();
        switch (decision) {

            case "1":
                getTotalSalary();
                break;
            case "2":
                getTotalWomen();
                break;
            case "3":
                getTotalMen();
                break;
            case "4":
                getTotalEmployees();
                break;
        }

    }

    private static void getTotalEmployees() {
        System.out.println("Total Employees :" + Main.employeeList.size());
        printMenu();
    }

    private static void getTotalMen() {
        int menCounter = 0;
        int menItCounter = 0;
        int menSalesCounter = 0;
        int menMangementCounter = 0;
        for (Employee employee : Main.employeeList) {

            if (employee.getSex().equalsIgnoreCase("female")) {
                menCounter++;
                if (employee instanceof IT) {
                    menItCounter++;
                }
                if (employee instanceof Sales) {
                    menSalesCounter++;
                }
                if (employee instanceof Management) {
                    menMangementCounter++;
                }

            }
        }

        double percent = (double) menCounter / Main.employeeList.size();
        percent *= 100;
        System.out.println("Men in the IT department :" + menItCounter);
        System.out.println("Men in the Sales department :" + menSalesCounter);
        System.out.println("Men in the Management department :" + menMangementCounter);
        System.out.println("Total of Men : " + (int) percent + "%");
        System.out.println("Total of Men in the company " + menCounter);
        printMenu();
    }

    private static void getTotalWomen() {
        int womanCounter = 0;
        int womanItCounter = 0;
        int womanSalesCounter = 0;
        int womanMangementCounter = 0;
        for (Employee employee : Main.employeeList) {

            if (employee.getSex().equalsIgnoreCase("female")) {
                womanCounter++;
                if (employee instanceof IT) {
                    womanItCounter++;
                }
                if (employee instanceof Sales) {
                    womanSalesCounter++;
                }
                if (employee instanceof Management) {
                    womanMangementCounter++;
                }

            }
        }

        double percent = (double) womanCounter / Main.employeeList.size();
        percent *= 100;
        System.out.println("Women in the IT department :" + womanItCounter);
        System.out.println("Women in the Sales department :" + womanSalesCounter);
        System.out.println("Women in the Management department :" + womanMangementCounter);
        System.out.println("Total of women : " + (int) percent + "%");
        System.out.println("Total of women in the company " + womanCounter);
        printMenu();
    }

}
