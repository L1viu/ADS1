package application;

public class Employee {
    
	/**Placeholder for employee details*/
    private int employeeNumber;  /**Employee number (ID)*/
    private String name;         /**Employee Name*/
    private int yearsWorking;    /**Number of years worked*/
    private String trainingCourse;  /**Training courses done by an employee*/

    /**Constructor for employee details*/
    public Employee(int employeeNumber, String name, int yearsWorking, String trainingCourse) {
        /**Validator to make sure the employee has 5+ years of experience*/
        if (yearsWorking < 5) {
            throw new IllegalArgumentException("Employee must have more than 5 years of experience.");
        }
        /**Make sure training courses start with FOOD*/
        if (trainingCourse != null && !trainingCourse.startsWith("FOOD")) {
            this.trainingCourse = "ERROR"; /**If training course is wrong replace course with ERROR*/
        } else {
            this.trainingCourse = trainingCourse; 
        }
      
        this.employeeNumber = employeeNumber;
        this.name = name;
        this.yearsWorking = yearsWorking;
    }

    /**Set default values to 0*/
    public Employee() {
        this.employeeNumber = 0;
        this.name = "";
        this.yearsWorking = 0;
        this.trainingCourse = "";
    }

    /**Getters + Setters*/
    public int getEmployeeNumber() {
        return employeeNumber;  
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;  
    }

    public String getName() {
        return name;  
    }

    public void setName(String name) {
        this.name = name;  
    }

    public int getYearsWorking() {
        return yearsWorking;  
    }

    public void setYearsWorking(int yearsWorking) {
        this.yearsWorking = yearsWorking;  
    }

    public String getTrainingCourse() {
        return trainingCourse;  
    }

    public void setTrainingCourse(String trainingCourse) {
        /**Set the training course*/
        if (trainingCourse != null && !trainingCourse.startsWith("FOOD")) {
            this.trainingCourse = "ERROR";  
        } else {
            this.trainingCourse = trainingCourse;  
        }
    }

    /**Display all employee details*/
    public void displayEmployeeDetails() {
        System.out.println("Employee Number: " + employeeNumber);
        System.out.println("Name: " + name);
        System.out.println("Years Working: " + yearsWorking);
        System.out.println("Training Course: " + trainingCourse);
    }

    /**Compare the employees by their employee number */
    public boolean isSameEmployee(Employee other) {
        return this.employeeNumber == other.employeeNumber;  
    }

   /**toString to display employee details*/
    @Override
    public String toString() {
        return "Employee Number: " + employeeNumber + ", Name: " + name + ", Years Working: " + yearsWorking + ", Course: " + trainingCourse;
    }
}
