package initializers;

/**
 * @author Stefan Ohlsson
 * @author Erik Olsson
 */
public class ChiefExecutiveOfficer extends Management {

    public ChiefExecutiveOfficer(String firstName, String lastName, int birthYear, int salary, int bonus, String sex,
            String department, String employeeCategory) {
        super(firstName, lastName, birthYear, salary, sex, department, employeeCategory);
        this.setBonus(bonus);
    }

    @Override
    public void setBonus(int bonus) {
        super.setBonus(bonus * 3);
    }

}
