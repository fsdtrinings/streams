package day4.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import day2.Employee;
import day2.Project;

public class StreamDemo {

	public static void main(String[] args) {
		
		//streamCreation();
		//minOrMax();
		//minOfEmployee();
		//doFilterOperation();
		
		mapDemo();
	}
	
	public static void streamCreation()
	{
		
		   List<Integer> list = new ArrayList();
		   
		   list.add(1);
		   list.add(2);
		   list.add(133);


		   // approach 1 
		   Stream<Integer> stream = list.stream();
		   terminalOperationForEach(list);
		   
		   // approach 2 
		   Stream<Integer> stream2 = Stream.of(1,33,5,344);
		  

		   // approach 3
		   list = Arrays.asList(1,33,5,344);
		   list.stream();

	}
	
	
	public static void terminalOperationForEach(List<Integer> list)
	{
	
		System.out.println(" ==============  Normal Iteration ==========");
		// ---- Non - stream approach ---
		for (Integer data : list) {
			System.out.println(data);
		}
		
		
		System.out.println(" ============== Anymou... Class Iteration  ==========");
		list.stream().forEach(new Consumer<Integer>() {

		

			@Override
			public void accept(Integer t) {
				System.out.println(t);
				
			}

			@Override
			public Consumer<Integer> andThen(Consumer<? super Integer> after) {
				// TODO Auto-generated method stub
				return Consumer.super.andThen(after);
			}
			
			
		});
		
		
		System.out.println(" ============== Stream Based Iteration  ==========");
		
		// ----- Stream Apporach --
		list.stream().forEach((data)->{
			data = data + 2;  // business operation over iteration
			System.out.println(""+data);
		});
		
		// =============  Count terminal operation 
		
		long count = list.stream().count();
		System.out.println(" Count "+count);
		
	}
	
	public static void minOrMax()
	{
		List<Integer> list = Arrays.asList(45,4,8,19,95,65,3,2,10);
		
					
		Optional<Integer> optional =  list.stream().min((a,b)->a.compareTo(b));
		System.out.println(optional.get());
		
	}
	
	public static void minOfEmployee()
	{
		Project p = new Project("p1","java");
		Employee e1 = new Employee("Rakesh", 101, 2000, p);
		Employee e2 = new Employee("Amit", 102, 2300, p);
		Employee e3 = new Employee("Varun", 103, 3300, new Project("B","SFDC"));
		Employee e4 = new Employee("Ashish", 104, 1500, new Project("C","React"));
		
		
		List<Employee> empList = Arrays.asList(e1,e2,e3,e4);
		
		Comparator<Employee> salaryComparator = (emp1,emp2)->
		{
			return emp1.getEmployeeSalary() - emp2.getEmployeeSalary();
			
		};
		
		
		Optional<Employee> optional = empList.stream().min(salaryComparator);
		Employee e = optional.get();
		e.annualIncrement(10);
		
		
		
	}
	
	
	
	public static void doFilterOperation()
	{
		Project p = new Project("p1","java");
		Employee e1 = new Employee("Rakesh", 101, 2000, p);
		Employee e2 = new Employee("Amit", 102, 2300, p);
		Employee e3 = new Employee("Varun", 103, 3300, new Project("B","SFDC"));
		Employee e4 = new Employee("Ashish", 104, 1500, new Project("C","React"));
		Employee e5 = new Employee("Ramesh", 105, 1800, new Project("C","React"));
		Employee e6 = new Employee("Rakesh", 106, 2500, new Project("C","React"));
		
		
		List<Employee> empList = Arrays.asList(e1,e2,e3,e4,e5,e6);
		
		
		// ---new stream approach
		Comparator<Employee> salaryComparator = (emp1,emp2)->
		{
			return emp1.getEmployeeSalary() - emp2.getEmployeeSalary();
			
		};
		
		Employee e = empList.stream().
			    filter(emp1->{
			    			Project project = emp1.getProject();
			    			String projectName = project.getProjectName();
			    	
			    			return projectName.equals("React");
			    			 }).
			    min(salaryComparator).
			    get();
			   

		List<Employee> empBasedOnSalaryList = 
				empList.stream().
			    filter(emp1->{
			    			Project project = emp1.getProject();
			    			String projectName = project.getProjectName();
			    	
			    			return projectName.equals("React");
			    			 }).
			    collect(Collectors.toList());
			    
		
	}
	
	
	
	public static void mapDemo()
	{
		
		Stream.of("bjkbhjk","fdv","erfer").map(x->x.toUpperCase()).
				forEach(x->System.out.println(x));
	
	
	
		Project p = new Project("p1","java");
		Employee e1 = new Employee("Rakesh", 101, 2000, p);
		Employee e2 = new Employee("Amit", 102, 2300, p);
		Employee e3 = new Employee("Varun", 103, 3300, new Project("B","SFDC"));
		Employee e4 = new Employee("Ashish", 104, 1500, new Project("C","React"));
		Employee e5 = new Employee("Ramesh", 105, 1800, new Project("C","React"));
		Employee e6 = new Employee("Rakesh", 106, 2500, new Project("C","React"));
		
		
		List<Employee> empList = Arrays.asList(e1,e2,e3,e4,e5,e6);
		
		
		empList = empList.stream().map(emp->{
			int oldSalary = emp.getEmployeeSalary();
			int newSalary = oldSalary+1000;
			emp.setEmployeeSalary(newSalary);
			return emp;
		}).collect(Collectors.toList());
	
		System.out.println(empList);
	
	}
	
	
	
	
	
	
	
	public static List<Employee> oldAppraochOfFilter(List<Employee> list)
	{
		// filter employees based on Salary 1500 - 3000
		
		List<Employee> salaryBasedEmployeeList = new ArrayList<>();
		
		for (Employee employee : list) {
			
			int currentEmployeeSalary = employee.getEmployeeSalary();
			if(currentEmployeeSalary>1500 && employee.getEmployeeSalary()<3000)
			{
				salaryBasedEmployeeList.add(employee);
			}
		}
		
		return salaryBasedEmployeeList;
	}
	
}//end class






