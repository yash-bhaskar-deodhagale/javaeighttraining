package com.assigment.practice;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

import org.omg.PortableInterceptor.SYSTEM_EXCEPTION;

public class EmployeeTest {

	public static void main(String[] args) {
        Employee employee1 = new Employee(
                "Yash",
                20,
                new Address("1234"),
                Arrays.asList(new MobileNumber("1233"), new MobileNumber("1234")));
     
            Employee employee2 = new Employee(
                "Ram",
                20,
                new Address("1235"),
                Arrays.asList(new MobileNumber("1111"), new MobileNumber("3333"), new MobileNumber("1233")));
     
            Employee employee3 = new Employee(
                "Sita",
                20,
                new Address("1236"),
                Arrays.asList(new MobileNumber("3333"), new MobileNumber("4444")));
            
            List<Employee> employees = Arrays.asList(employee1, employee2, employee3);
            
            // Get employee with exact match name "Yash", if not found print "Not found".
            
            Optional getExact=employees.stream().filter(emp->emp.getName().equals("Yash")).findAny();
            System.out.println("1.employee with exact match name Yash:"+ (getExact.isPresent()?getExact.get():getExact.orElse("Not Found")));
            
            
            // Get employee with matching address "1235"
            Optional<Employee> empAddMatch=employees.stream().filter(emp->emp.getAddress().getZipcode().equals("1235")).findFirst();
            System.out.println("2.Employee with matching address 1235: "+empAddMatch.get());
            
            // Get all employee having mobile numbers 3333.
            List<Employee> empAddMatchMobile=employees.stream().filter(emp->emp.getMobileNumbers().contains(new MobileNumber("3333"))).collect(Collectors.toList());
            System.out.println("3.All employee having mobile numbers 3333: "+empAddMatchMobile);
            
           // List<Employee> empAddMatchM=employees.stream().filter(emp->emp.getMobileNumbers().stream().findAny().filter(x->x.getNumber().equals("3333"))).collect(Collectors.toList());

            //employees.stream().forEach(e->System.out.println(e.getMobileNumbers()));
           
            
            // Convert List<Employee> to List<String> of employee name
            List<String> employeeString=employees.stream().map(e->e.getName()).collect(Collectors.toList());
            System.out.println("4.EmployeeString: "+employeeString);
            
            // Collect all the names of employees in a string separated by ||
            String employeeNameSeperated=employeeString.stream().map(m->m).collect(Collectors.joining("||"));
            System.out.println("5.Names of employees in a string separated by ||:"+employeeNameSeperated);
            
            // Change the case of List<String>
            List<String> caseList=employeeString.stream().map(m->m.toLowerCase()).collect(Collectors.toList());
            System.out.println("6.Change the case of List<String>:"+caseList);
            
            // Sort List<String>
            List<String> sortedStringList=employeeString.stream().sorted((e1,e2)->e1.compareTo(e2)).collect(Collectors.toList());
            System.out.println("7.Sortedlist of Employee String:"+sortedStringList);
            
            // sort List<Employee> based on name
            Comparator<Employee> comparator=(emp1,emp2)->emp1.getName().compareTo(emp2.getName());
            List<Employee> sortedList=employees.stream().sorted(comparator).collect(Collectors.toList());
            System.out.println("8.SortedList of Employee based on name: "+sortedList);
            // 
            
            
	}
}
