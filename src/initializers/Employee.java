package initializers;

/**
 * @author Stefan Ohlsson
 * @author Erik Olsson
 */
public abstract class Employee {

    private String firstName;
    private String lastName;
    private int birthYear;
    private int salary;
    private String sex;
    private static int total = 1;
    private int employeeNumber;
    private String department;
    private String employeeCategory;
    private int bonus;

    public Employee(String firstName, String lastName, int birthYear, int salary, String sex, String department,
            String employeeCategory) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.salary = salary;
        this.sex = sex;
        this.department = department;
        this.employeeCategory = employeeCategory;
        this.employeeNumber = total;
        total++;
    }

    public Employee(String firstName, String lastName, int birthYear, int salary, String sex, String department) {

        this.department = department;
        this.firstName = firstName;
        this.lastName = lastName;
        this.birthYear = birthYear;
        this.salary = salary;
        this.sex = sex;
        this.employeeNumber = total;
        total++;

    }

    public String profession() {
        return employeeCategory;
    }

    public static int getTotal() {
        return total;
    }

    public static void setTotal(int total) {
        Employee.total = total;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getNumber() {
        return employeeNumber;
    }

    public static int getiD() {
        return total;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getBirthYear() {
        return birthYear;
    }

    public int getSalary() {
        return salary;
    }

    public String getSex() {
        return sex;
    }

    @Override
    public String toString() {
        return "Employee{" + "firstName=" + firstName + ", lastName=" + lastName + ", birthYear=" + birthYear
                + ", salary=" + salary + ", sex=" + sex + ", department=" + department + ", employeeNumber="
                + employeeNumber + ", employeeCategory=" + employeeCategory + ", bonus=" + bonus + '}';

    }

    public String toString2() {
        if (department == "IT") {
            return "Nr: " + employeeNumber + "\tName: " + firstName + " " + lastName + "\t\tBorn: " + birthYear + "\tSex: " + sex + "\tDepartement: " + department + "\t\t\tCategory: " + employeeCategory + "\t\t\tSalary: " + salary + "\tBonus: " + bonus;
        } else if (department == "Management") {
            return "Nr: " + employeeNumber + "\tName: " + firstName + " " + lastName + "\t\tBorn: " + birthYear + "\tSex: " + sex + "\tDepartement: " + department + "\t\tCategory: " + employeeCategory + "\tSalary: " + salary + "\tBonus: " + bonus;
        } else {
            return "Nr: " + employeeNumber + "\tName: " + firstName + " " + lastName + "\t\tBorn: " + birthYear + "\tSex: " + sex + "\tDepartement: " + department + "\t\tCategory: " + employeeCategory + "\t\tSalary: " + salary + "\tBonus: " + bonus;
        }
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setBirthYear(int birthYear) {
        this.birthYear = birthYear;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getEmployeeCategory() {
        return employeeCategory;
    }

    public void setEmployeeCategory(String employeeCategory) {
        this.employeeCategory = employeeCategory;
    }

    public void setBonus(int bonus) {
        this.bonus = bonus;
    }

}
