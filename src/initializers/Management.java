package initializers;

/**
 * @author Stefan Ohlsson
 * @author Erik Olsson
 */
public class Management extends Employee {

    private boolean leadership;

    public Management(String firstName, String lastName, int birthYear, int salary, String sex, boolean leadership,
            String department) {
        super(firstName, lastName, birthYear, salary, sex, department);
        this.leadership = leadership;
    }

    public Management(String firstName, String lastName, int birthYear, int salary, String sex, String department,
            String employeeCategory) {
        super(firstName, lastName, birthYear, salary, sex, department, employeeCategory);
    }

    public boolean isLeadership() {
        return leadership;
    }

    public void setLeadership(boolean leadership) {
        this.leadership = leadership;
    }

}
