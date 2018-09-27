package initializers;

/**
 * @author Stefan Ohlsson
 * @author Erik Olsson
 */
public class MarketManager extends Sales {

    public MarketManager(String firstName, String lastName, int birthYear, int salary, int bonus, String sex,
            String phone, String department) {
        super(firstName, lastName, birthYear, salary, sex, phone, department);
        this.setBonus(bonus);
    }

    @Override
    public void setBonus(int bonus) {
        super.setBonus(bonus * 5); // To change body of generated methods, choose Tools | Templates.

    }

}
