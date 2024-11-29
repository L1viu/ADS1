package application;

import util.LinkedList;
import java.util.Scanner;

public class TrainingCourses {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedList<Employee> employees = new LinkedList<>();  /** LinkedList to store Employee objects*/

        /**1. Allow the user to input up to 10 employees*/
        System.out.println("Enter the number of employees (max 10):");
        int numEmployees = scanner.nextInt();
        scanner.nextLine();  
        while (numEmployees < 1 || numEmployees > 10) {
            System.out.println("Must be at least 1 employee and no more than 10.");
            numEmployees = scanner.nextInt();
            scanner.nextLine();  
        }

        /**2. Add employees to the list*/
        for (int i = 0; i < numEmployees; i++) {
            System.out.println("Enter details for Employee " + (i + 1) + ":");
            System.out.print("Employee Number: ");
            int employeeNumber = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("Name: ");
            String name = scanner.nextLine();
            System.out.print("Years Working: ");
            int yearsWorking = scanner.nextInt();
            scanner.nextLine();  
            System.out.print("Training Course: ");
            String trainingCourse = scanner.nextLine();

            try {
                Employee employee = new Employee(employeeNumber, name, yearsWorking, trainingCourse);
                employees.add(employee);  
            } catch (IllegalArgumentException e) {
                System.out.println("Error: " + e.getMessage());  /**Error for invalid employees*/
            }
        }

        /**3. Display all employee details*/
        System.out.println("\nEmployee Details:");
        employees.displayAll();

        /**4. Delete all employees from a specific course*/
        System.out.print("\nEnter employee number to remove: ");
        int employeeNumberToRemove = scanner.nextInt();
        scanner.nextLine();  
        Employee removedEmployee = employees.removeByEmployeeNumber(employeeNumberToRemove);
        if (removedEmployee != null) {
            System.out.println("Removed: " + removedEmployee); /**Display details of the removed employee*/
        }

        /**5.Display updated employee details*/
        System.out.println("\nUpdated Employee Details:");
        employees.displayAll();

        /**6.Personalised function- move employee to a new course*/ 
        System.out.print("\nEnter employee number to move to new course: ");
        int employeeNumberToMove = scanner.nextInt();
        scanner.nextLine();  
        System.out.print("Enter new course name: ");
        String newCourse = scanner.nextLine();
        employees.moveEmployeeToNewCourse(employeeNumberToMove, newCourse);  

       /**7.Display all employees after the course has been changed*/
        System.out.println("\nUpdated Employee Details after move:");
        employees.displayAll();
    }
}
