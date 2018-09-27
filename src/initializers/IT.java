package initializers;

/**
 * @author Stefan Ohlsson
 * @author Erik Olsson
 */
public class IT extends Employee {

    private String computer;

    public IT(String firstName, String lastName, int birthYear, int salary, String sex, String department,
            String employeeCategory) {
        super(firstName, lastName, birthYear, salary, sex, department, employeeCategory);
    }

    public String getComputer() {
        return computer;
    }

    public void setComputer(String computer) {
        this.computer = computer;
    }

}
