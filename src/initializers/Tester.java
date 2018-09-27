package initializers;

/**
 * @author Stefan Ohlsson
 * @author Erik Olsson
 */
public class Tester extends IT {

    public Tester(String firstName, String lastName, int birthYear, int salary, int bonus, String sex,
            String department, String employeeCategory) {
        super(firstName, lastName, birthYear, salary, sex, department, employeeCategory);
        this.setBonus(bonus);
    }

}
