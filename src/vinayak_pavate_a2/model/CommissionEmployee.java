package vinayak_pavate_a2.model;

/**
 *
 * @author Vinayak Pavate This is the commission employee class, we create a
 * instance of this class with rate and sales getters no setters have been
 * placed. extends to Employee class version 1.5
 */
public class CommissionEmployee extends Employee {

    private final double rate;
    private final double sales;

    //Contructor for the employee with commission
    public CommissionEmployee(double rate, double sales, int Id, String firstName, String lastName) {
        super(Id, firstName, lastName);
        this.rate = rate;
        this.sales = sales;
    }

    //getter to get rate
    public double getRate() {
        return rate;
    }

    //get the sales of the employee
    public double getSales() {
        return sales;
    }

    //overridden method to create pay
    @Override
    public double calculatePay() {
        double sal;
        sal = (sales * (rate / 100));
        return sal;
    }

}
