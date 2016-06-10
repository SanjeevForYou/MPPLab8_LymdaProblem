package lab8_MethodReference;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class MethodRef {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
        //A
		Employee emp1 = new Employee("San",23334);
		Function<Employee, String> fe = (Employee e) -> e.getName();
		System.out.println(fe.apply(emp1));
		
		Employee emp2 = new Employee("Sanjeev Kumar",23334);
		Function<Employee, String> fe2 = Employee::getName;  ////Class::instanceMethod
		System.out.println(fe2.apply(emp2));
		
		//B
		BiConsumer<Employee, String> bc = (Employee e, String s) -> e.setName(s);
		bc.accept(emp1, "Bhusal Sanjeev");
		Function<Employee, String> fe3 = (Employee e) -> e.getName();
		System.out.println(fe3.apply(emp1));
		
		BiConsumer<Employee, String> bc2 = Employee::setName;  ////Class::instanceMethod
		bc2.accept(emp1, "setName() with method ref");
		Function<Employee, String> fe4 = (Employee e) -> e.getName();
		System.out.println(fe4.apply(emp1));
		
		//C
		BiFunction<String, String, Integer> bcStr = (String s1, String s2) -> s1.compareTo(s2);	
		System.out.println(bcStr.apply("san1", "san21"));
		
		BiFunction<String, String, Integer> bcStr2 = String::compareTo;  //Class::instanceMethod
		System.out.println(bcStr2.apply("san1", "san"));
		
		//D
		BiFunction<Integer, Integer, Double> bcPow  = (Integer x, Integer y) -> Math.pow(x, y); //Class :: staticMethod
		System.out.println("Math.pow(x,y) with lymda "+bcPow.apply(2, 2));
		
		BiFunction<Integer, Integer, Double> bcPow2  = Math::pow;
		System.out.println("Math.pow(x,y) with lymda "+bcPow2.apply(2, 2));
		
		//E
		Apple a = new Apple();
        Function<Apple,String> getWeight = (Apple a1) -> a1.getWeight();   // Class::instanceMethod
        System.out.println("getWeight() Apple Lyamda  "+getWeight.apply(a));
        
        Function<Apple,String> getWeight1 = Apple::getWeight;
        System.out.println("getWeight() Apple Method REf  "+getWeight1.apply(a));
      

        //F
        Function<String,Integer> parseInt = (String s) -> Integer.parseInt(s); ////Class :: staticMethod
        Function<String,Integer> parseInt1 = Integer::parseInt;

		//G
		EmployeeNameComparator comp = new EmployeeNameComparator();
		BiFunction<Employee, Employee, Integer> empCom = (Employee e1, Employee e2) -> comp.compare(e1,e2);
		System.out.println("EmployeeNameComparator with lymda "+empCom.apply(emp1, emp2));
		
		BiFunction<Employee, Employee, Integer> empCom2 = comp::compare;  // Object :: instanceMethod
		System.out.println("EmployeeNameComparator with method ref "+empCom2.apply(emp1, emp2));
		
	}


}
