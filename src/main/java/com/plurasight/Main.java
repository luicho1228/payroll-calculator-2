package com.plurasight;

import java.io.*;
import java.util.Scanner;

public class Main {
    private static Employee[] employees;
    public static void main(String[] args) {
        employees = new Employee[8];
        promptUser();
    }

    public static void promptUser(){
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the name of the file employee file to process: ");
        String employeeFileName = scanner.nextLine();
        String filePath = employeeFileName;
        readFile(filePath);
        System.out.print("Enter the name of the payroll file to create: ");
        String payrollFileName = scanner.nextLine();
        writeFile(payrollFileName);
    }
    public static void writeFile(String payrollFileName){
        try {
            FileWriter fileWriter = new FileWriter(payrollFileName);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id|" + "name|" + "gross pay \n");
            String fileContent = "";
            for(Employee employee: employees){
                fileContent = String.format("%d| %s| $%.2f \n",employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
                bufferedWriter.write(fileContent);
            }
            System.out.println("File created successfully");
            bufferedWriter.close();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static void readFile(String filePath) {
        System.out.println("================================\n"
                + "       Employee Dataset\n" +
                "================================");
        System.out.println("Employee ID| Name| Gross Pay");
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String inputFile;
            int index = -1;
            while ((inputFile = bufferedReader.readLine()) != null) {
                if (index >= 0) {
                    Employee employee = populateEmployee(inputFile);
                    employees[index] = employee;
                }
                index++;
            }
            bufferedReader.close();
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static Employee populateEmployee(String inputFile) {
        Employee employee = new Employee();
        String[] fileParts = inputFile.split("\\|");
        int employeeId = Integer.parseInt(fileParts[0]);
        employee.setEmployeeId(employeeId);
        String name = fileParts[1];
        employee.setName(name);
        double hoursWorked = Double.parseDouble(fileParts[2]);
        employee.setHoursWorked(hoursWorked);
        double payRate = Double.parseDouble(fileParts[3]);
        employee.setPayRate(payRate);
        System.out.printf("%d| %s| $%.2f \n",employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
        return employee;
    }
}