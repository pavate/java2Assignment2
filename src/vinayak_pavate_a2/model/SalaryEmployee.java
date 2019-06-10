package vinayak_pavate_a2.model;

/**
 *
 * @author Vinayak Pavate This is a salary employee class we create a instance
 * of this class with only a salary extended to Employee class
 */
public class SalaryEmployee extends Employee {

    private final double salary;

    //getter for salary
    public double getSalary() {
        return salary;
    }

    //Constructor to create a salary employee
    public SalaryEmployee(double salary, int Id, String firstName, String lastName) {
        super(Id, firstName, lastName);       
        this.salary = salary;
        
    }

    //method to calculte pay
    @Override
    public double calculatePay() {
        double sal;
        sal = salary / 52;
        return sal;
    }

}
