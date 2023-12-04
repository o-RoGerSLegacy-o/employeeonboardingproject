package services;

import entitys.EmployeeEntity;

import java.util.ArrayList;
import java.util.Scanner;

import dao.EmployeeDao;

public class EmployeeService {
    private EmployeeDao employeeDao;
    private Scanner scanner;

    public EmployeeService(EmployeeDao employeeDao, Scanner scanner) {
        this.employeeDao = employeeDao;
        this.scanner = scanner;
    }

    public void addEmployee() {
        try {
            System.out.println("Enter employee details:");

            System.out.print("UID: ");
            long uId = scanner.nextLong();

            // Consume the newline character
            scanner.nextLine();

            System.out.print("Username: ");
            String userName = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Designation: ");
            String designation = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Location: ");
            String location = scanner.nextLine();
            scanner.nextLine();
            System.out.print("Phone Number: ");
            long phoneNumber = scanner.nextLong();
            scanner.nextLine();
            System.out.print("Salary: ");
            long salary = scanner.nextLong();

            EmployeeEntity employee = new EmployeeEntity(uId, userName,  designation, location,  phoneNumber,  salary);
            employeeDao.insertEmployeeDetails(employee);
            System.out.println("Employee added successfully.");
        } catch (Exception e) {
            System.err.println("Error while adding employee: " + e.getMessage());
            e.printStackTrace();  
        }
    }

    public void getEmployeeById() {
        try {
            System.out.print("Enter UID to get employee details: ");
            int uId = scanner.nextInt();

            EmployeeEntity employee = employeeDao.getEmployeeById(uId);

            if (employee != null) {
                System.out.println("Employee details: " + employee);
            } else {
                System.out.println("Employee not found");
            }
        } catch (Exception e) {
            System.err.println("Error while retrieving employee details: " + e.getMessage());
            e.printStackTrace(); 
        }
    }

    public void deleteEmployee() {
        try {
            System.out.print("Enter UID to delete employee: ");
            int uId = scanner.nextInt();

            employeeDao.deleteEmployee(uId);
            System.out.println("Employee deleted successfully.");
        } catch (Exception e) {
            System.err.println("Error while deleting employee: " + e.getMessage());
            e.printStackTrace();  // Print the stack trace for debugging
        }
    }

    public void updateEmployee() {
        try {
            System.out.print("Enter UID to update employee: ");
            int uId = scanner.nextInt();

            EmployeeEntity employee = employeeDao.getEmployeeById(uId);

            if (employee != null) {
                System.out.println("Enter updated details:");

                System.out.print("Username: ");
                employee.setUserName(scanner.next());

                System.out.print("Designation: ");
                employee.setDesignation(scanner.next());

                System.out.print("Location: ");
                employee.setLocation(scanner.next());

                System.out.print("Phone Number: ");
                employee.setPhoneNumber(scanner.nextLong());

                System.out.print("Salary: ");
                employee.setSalary(scanner.nextLong());

                employeeDao.updateEmployee(employee);
                System.out.println("Employee updated successfully.");
            } else {
                System.out.println("Employee not found");
            }
        } catch (Exception e) {
            System.err.println("Error while updating employee: " + e.getMessage());
            e.printStackTrace();  // Print the stack trace for debugging
        }
    }

    public void fetchEmployees() {
        try {
            ArrayList<EmployeeEntity> employees = employeeDao.fetchEmployees();

            System.out.println("Employee List:");
            for (EmployeeEntity employee : employees) {
                System.out.println(employee);
            }
        } catch (Exception e) {
            System.err.println("Error while fetching employees: " + e.getMessage());
            e.printStackTrace(); 
        }
    }
}
