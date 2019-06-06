package vinayak_pavate_a2.model;

/**
 *
 * @author Vinayak Pavate This is the hourly employee class, we create a
 * instance of this class with number of hours and hourly rate no setters have
 * been placed. version 1.0
 */
public class HourlyEmployee extends Employee {

    protected double numHours;
    protected double hourlyRate;

    public HourlyEmployee(double numHours, double hourlyRate, int Id, String firstName, String lastName) {
        super(Id, firstName, lastName);
        this.numHours = numHours;
        this.hourlyRate = hourlyRate;
    }

    //getter for the number of hours
    public double getNumHours() {
        return numHours;
    }

    //getter for the hourly rate of employee
    public double getHourlyRate() {
        return hourlyRate;
    }

    //overridden method to calculate pay fo employee
    @Override
    public double calculatePay() {
        double sal;
        sal = numHours * hourlyRate;
        return sal;
    }

}
