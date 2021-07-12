package day2;

public class Employee implements Comparable<Employee> 
{

	private String employeeName;
	private int employeeId;
	private int employeeSalary;
	
	private Project project;// has-a

	public Employee() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Employee(String employeeName, int employeeId, int employeeSalary, Project project) {
		super();
		this.employeeName = employeeName;
		this.employeeId = employeeId;
		this.employeeSalary = employeeSalary;
		this.project = project;
	}

	public String getEmployeeName() {
		return employeeName;
	}

	public void setEmployeeName(String employeeName) {
		this.employeeName = employeeName;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public int getEmployeeSalary() {
		return employeeSalary;
	}

	public void setEmployeeSalary(int employeeSalary) {
		this.employeeSalary = employeeSalary;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}
	
	public void annualIncrement(int per)
	{
		this.employeeSalary += ((this.employeeSalary*per)/100);
	}
	
	public void loginLogoff()
	{
		System.out.println("Login-logoff");
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + employeeId;
		result = prime * result + ((employeeName == null) ? 0 : employeeName.hashCode());
		result = prime * result + employeeSalary;
		result = prime * result + ((project == null) ? 0 : project.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (employeeId != other.employeeId)
			return false;
		if (employeeName == null) {
			if (other.employeeName != null)
				return false;
		} else if (!employeeName.equals(other.employeeName))
			return false;
		if (employeeSalary != other.employeeSalary)
			return false;
		if (project == null) {
			if (other.project != null)
				return false;
		} else if (!project.equals(other.project))
			return false;
		return true;
	}

	
	
	
	
	
	/*
	 * @Override public int hashCode() {
	 * 
	 * System.out.println("\n ==>> Hashcode for "+employeeName); // 1000 lines code
	 * int uniqueHashcode = 1;
	 * 
	 * uniqueHashcode = employeeName.length()+employeeId+3;
	 * 
	 * return uniqueHashcode; }
	 * 
	 * 
	 * @Override public boolean equals(Object obj) {
	 * System.out.println("\n ==>> Equals for "+employeeName); if(obj instanceof
	 * Employee) { // Business -> Employee e = (Employee)obj;
	 * 
	 * boolean a = (this.employeeName).equals(e.getEmployeeName()); boolean b =
	 * (this.employeeId) == e.getEmployeeId(); boolean c = (this.employeeSalary ==
	 * e.getEmployeeSalary());
	 * 
	 * //boolean b = (this.employeeId) == e.getEmployeeId(); compare project
	 * 
	 * return a&&b&&c;
	 * 
	 * 
	 * } else return false;
	 * 
	 * }
	 */ 
	 

	@Override
	public String toString() {
		return "=> "+employeeId+" - "+employeeName+" - "+employeeSalary+"\n";
	}

	@Override
	public int compareTo(Employee o) {
		
		return this.getEmployeeId() - o.getEmployeeId();
	}
	
	
	
	
	
	
}//end class




















