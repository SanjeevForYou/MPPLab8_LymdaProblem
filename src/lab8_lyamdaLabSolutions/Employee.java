package lab8_lyamdaLabSolutions;

import java.util.function.BiFunction;
import java.util.function.Predicate;

public class Employee{

	private String name;
	
	public Employee(String nam)
	{
		this.name = nam;
	}
	
	public String getName()
	{
		return name;
	}
	
	public boolean myMethod(Employee emp)
	{
//	   this.equals(obj);  this::equals
		Predicate<Employee> p = this::equals;
		return p.test(emp);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub 
		Employee emp1 = new Employee("San");
		Employee emp2 = new Employee("bjd");	
		System.out.println(emp1.myMethod(emp2));
	}
	
	@Override
	public boolean equals(Object obj)
	{
		if(obj== null) return false;
		if(obj.getClass() != this.getClass()) return false;
		Employee emp = (Employee) obj;
		return this.getName() == emp.getName();
	}
}
