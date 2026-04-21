package com.plurasight;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filePath = "src/main/java/com/plurasight/employees.txt";
        System.out.println("================================\n"
                + "        Employees Dataset\n" +
                "================================\n");
        loadFile(filePath);

    }

    public static void loadFile(String filePath) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(filePath));
            String inputFile;
            while ((inputFile = bufferedReader.readLine()) != null) {
                populateEmployee(inputFile);
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
        System.out.printf("employee ID: %d, name: %s, gross pay: $%.2f \n",employee.getEmployeeId(), employee.getName(), employee.getGrossPay());
        return employee;
    }
}