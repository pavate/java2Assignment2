package vinayak_pavate_a2;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;
import vinayak_pavate_a2.model.CommissionEmployee;
import vinayak_pavate_a2.model.Employee;
import vinayak_pavate_a2.model.HourlyEmployee;
import vinayak_pavate_a2.model.SalaryEmployee;

/**
 *
 * @author acer
 */
public class Vinayak_Pavate_A2 {

    public static void main(String[] args) {
        //this vaiable is used for the amount of creation loop
        boolean idChoice;

        //Creating a new arraylist of employee
        ArrayList<Employee> employees = new ArrayList<>();
        //A dummy object is created
        Employee employee0 = new Employee(0, " ", " ");
        //added to the array list
        employees.add(employee0);
        Scanner create = new Scanner(System.in);

        System.out.print("How many employees would you like to create?\n");
        int noOfEmployees = 0;

        //starts the loop to add number of employees
        do {
            if (create.hasNextInt()) {
                noOfEmployees = create.nextInt();

                idChoice = true;
            } else {
                System.out.println("Please enter a valid number to create");
                idChoice = false;
            }
            create.nextLine();
            //end of loop to add number of employees
        } while (idChoice = false);
        System.out.println("You have selected " + noOfEmployees
                + " number of employees to add to the database\n");

        //Start loop to create objects according to the user input
        for (int count = 1; count <= noOfEmployees;) {
            Scanner input = new Scanner(System.in);

            System.out.println("Employee data for employee " + count + " of " + noOfEmployees);
            //Ask the user what kind of employee they want to add
            System.out.println("Choose type of employee to add.");
            System.out.println("1. Salaried");
            System.out.println("2. Hourly");
            System.out.println("3. Comission");

            if (input.hasNextInt()) {

                int addType = input.nextInt();
                //this variable is used to loop the object creation 
                boolean addChoice;

                //start loop to do task according to the no of employees
                //the user wants.
                do {
                    try {
                        try {
                            if (addType == 1) {
                                //Creates and adds to array list in a row by passing 
                                //the array list employees through it
                                employees.add(createSalaryEmployee(employees));

                                addChoice = true;
                                count++;
                            }
                            if (addType == 2) {
                                employees.add(createHourlyEmployee(employees));

                                addChoice = true;
                                count++;

                            }
                            if (addType == 3) {
                                employees.add(createCommisionEmployee(employees));

                                addChoice = true;
                                count++;

                            }
                        } catch (InputMismatchException e) {
                            System.out.println("Invalid input, Try again");
                            addChoice = false;
                        }
                    } catch (Throwable e) {
                        System.out.println(e.getMessage());
                        System.out.println("\n");
                        addChoice = false;

                    }
                    // end of loop to create objects
                } while (addChoice = false);

            }

        }
        //Remove the dummy object in the first location
        //of the array list
        employees.remove(0);
        int reportType;
        //start loop for report
        do {
            System.out.println(
                    "Choose a report");
            System.out.println(
                    "1. Employee listing");
            System.out.println(
                    "2. Payroll listing");
            System.out.println(
                    "3. Exit");
            Scanner report = new Scanner(System.in);

            reportType = report.nextInt();
            switch (reportType) {

                case 1:
                    displayEmployeeInfo(employees);
                    break;

                case 2:
                    displayEmployeePayroll(employees);
                    break;

                case 3:
                    System.out.println("You have choosen to Exit");
                    break;

                default:
                    System.out.println("Enter a valid report type");

            }
            //end loop for report
        } while (reportType != 3);
    }

    /**
     *
     * @param employees This is the array list passed through.
     * @return returns a salary employee object Creates a new object of a Salary
     * employee and adds it to a constructor
     */
    public static Employee createSalaryEmployee(ArrayList<Employee> employees) {

        Scanner create1 = new Scanner(System.in);
        boolean sameId;
        int id = isEmployeeeIdUsed(employees);
        System.out.println("First Name: ");
        String firstName = create1.nextLine();
        System.out.println("Last Name: ");
        String lastName = create1.nextLine();
        System.out.println("Salary: ");
        double salary = create1.nextDouble();
        Employee employee = new SalaryEmployee(salary, id, firstName, lastName);
        return employee;

    }

    /**
     *
     * @param employees This is the array list passed through.
     * @return returns a hourly employee object Creates a new object of a Hourly
     * employee and adds it to a constructor
     */
    public static Employee createHourlyEmployee(ArrayList<Employee> employees) {

        Scanner create2 = new Scanner(System.in);
        int id = isEmployeeeIdUsed(employees);
        System.out.println("First Name: ");
        String firstName = create2.nextLine();
        System.out.println("Last Name: ");
        String lastName = create2.nextLine();
        System.out.println("Hours Worked");
        double numHours = create2.nextDouble();
        System.out.println("Hourly Rate");
        double hourlyRate = create2.nextDouble();
        Employee employee = new HourlyEmployee(numHours, hourlyRate, id, firstName, lastName);
        return employee;

    }

    /**
     *
     * @param employees This is the array list passed through.
     * @return returns a commission employee object Creates a new object of a
     * commission employee and adds it to a constructor
     */
    public static Employee createCommisionEmployee(ArrayList<Employee> employees) {

        Scanner create3 = new Scanner(System.in);
        int id = isEmployeeeIdUsed(employees);
        System.out.println("First Name: ");
        String firstName = create3.nextLine();
        System.out.println("Last Name: ");
        String lastName = create3.nextLine();
        System.out.println("Commision Rate: ");
        double rate = create3.nextDouble();
        System.out.println("Sales: ");
        int sales = create3.nextInt();
        Employee employee = new CommissionEmployee(rate, sales, id, firstName, lastName);
        return employee;

    }

    /**
     *
     * @param emp This is the array list passed through. This method is used to
     * display the Info of all the employees
     */
    public static void displayEmployeeInfo(ArrayList<Employee> emp) {
        for (int i = 0; i < emp.size(); i++) {
            System.out.println(emp.get(i).toString());
            if (emp.get(i) instanceof SalaryEmployee) {
                System.out.println("Salary: $"
                        + ((SalaryEmployee) emp.get(i)).getSalary());

            }
            if (emp.get(i) instanceof HourlyEmployee) {

                System.out.println("Hours: "
                        + ((HourlyEmployee) emp.get(i)).getNumHours());
                System.out.println("Rate: $"
                        + ((HourlyEmployee) emp.get(i)).getHourlyRate());
            }
            if (emp.get(i) instanceof CommissionEmployee) {
                System.out.println("Commission Rate: "
                        + ((CommissionEmployee) emp.get(i)).getRate());
                System.out.println("Sales: "
                        + ((CommissionEmployee) emp.get(i)).hashCode());
            }

        }

    }

    /**
     *
     * @param emp This is the array list passed through. This method is used to
     * display the payroll of all the employees
     */
    public static void displayEmployeePayroll(ArrayList<Employee> emp) {
        for (int i = 0; i < emp.size(); i++) {
            if (emp.get(i) instanceof SalaryEmployee) {
                String format = "Weekly pay for %s, %s employee id %d is $%.2f";
                System.out.println(String.format(format, emp.get(i).getLastName(),
                        emp.get(i).getFirstName(), emp.get(i).getId(), emp.get(i).calculatePay()));

            }
            if (emp.get(i) instanceof HourlyEmployee) {
                String format = "Weekly pay for %s, %s employee id %d is $%.2f";
                System.out.println(String.format(format, emp.get(i).getLastName(),
                        emp.get(i).getFirstName(), emp.get(i).getId(), emp.get(i).calculatePay()));

            }
            if (emp.get(i) instanceof CommissionEmployee) {
                String format = "Weekly pay for %s, %s employee id %d is $%.2f";
                System.out.println(String.format(format, emp.get(i).getLastName(),
                        emp.get(i).getFirstName(), emp.get(i).getId(), emp.get(i).calculatePay()));
            }
        }
    }

    /**
     *
     *
     * @param employees This is the array list passed through.
     * @return It returns a integer with the id when a unique ID is selected
     * This is a method to check if the employee Id is used if it is used it
     * requests the user to try again
     */
    public static int isEmployeeeIdUsed(ArrayList<Employee> employees) {
        Scanner scan = new Scanner(System.in);
        int newId = 0;
        boolean correctId;
        do {

            System.out.println("Employee ID: ");
            int updatedId = scan.nextInt();
            correctId = false;

            for (int i = 0; i < employees.size(); i++) {
                if (updatedId == employees.get(i).getId()) {
                    correctId = true;
                    System.out.println("Alreadyused");
                }
            }
            if (!correctId) {
                newId = updatedId;
            }

        } while (correctId);
        return newId;

    }

}
