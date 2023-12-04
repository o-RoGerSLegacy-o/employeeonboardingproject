package controller;

import dao.EmployeeDao;
import services.EmployeeService;

import java.util.Scanner;

public class EmployeeController {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        EmployeeDao employeeDao = new EmployeeDao();
        EmployeeService employeeService = new EmployeeService(employeeDao, scanner);

        try {
            while (true) {
                printMenu();
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        employeeService.addEmployee();
                        break;
                    case 2:
                        employeeService.getEmployeeById();
                        break;
                    case 3:
                        employeeService.deleteEmployee();
                        break;
                    case 4:
                        employeeService.updateEmployee();
                        break;
                    case 5:
                        employeeService.fetchEmployees();
                        break;
                    case 0:
                        System.out.println("Exiting program. Goodbye!");
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            }
        } finally {
            scanner.close();
        }
    }

    private static void printMenu() {
        System.out.println("1. Add Employee");
        System.out.println("2. Get Employee by ID");
        System.out.println("3. Delete Employee");
        System.out.println("4. Update Employee");
        System.out.println("5. Fetch All Employees");
        System.out.println("0. Exit");
        System.out.print("Enter your choice: ");
    }
}