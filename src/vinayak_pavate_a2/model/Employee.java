package vinayak_pavate_a2.model;

/**
 *
 * @author Vinayak Pavate This is the super class of all the child classes id ,
 * first name and last name are set here version 1.0
 */
public class Employee {

    private int Id;
    private String firstName;
    private String lastName;

    //Super constructor of the super class
    public Employee(int Id, String firstName, String lastName) {
        this.Id = Id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    //getter for id
    public int getId() {
        return Id;
    }

    //setter to set id
    public void setId(int Id) {
        this.Id = Id;
    }

    //getter to get the first name
    public String getFirstName() {
        return firstName;
    }

    //used to set the first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    //to get last name
    public String getLastName() {
        return lastName;
    }

    //used to set the last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    //overridden for the tostring
    @Override
    public String toString() {
        String format = "Employee %d: %s, %s";
        return String.format(format, Id, lastName, firstName);
    }

    //Creted so the other classes can override this
    public double calculatePay() {
        return -1;
    }
}
