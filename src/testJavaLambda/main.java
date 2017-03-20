package testJavaLambda;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Person {
	private int age;
	private boolean gender;
	public Person() {
		
	}
	public boolean getGender() {
		return gender;
	}
	public void setGender(boolean gender) {
		this.gender = gender;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	public int fun1(int x, int y) {
		return y;
		
	}
}

public class main {
	public static void main(String[] args) {
		
		getTestLambda();
		getTestLambda2();

		
	}
	
	public static void getTestLambda2() {
		//Anonymous inner class
		Person p = new Person() {
			//Make a method
			@Override
			public int fun1(int x, int y) {
				return x * y;
			}
		};
		
		List<Person> persons = new ArrayList<>();
		p.setAge(10);
		p.setGender(true);
		persons.add(p);
		p = new Person();
		p.setAge(20);
		p.setGender(true);
		persons.add(p);
		p = new Person();
		p.setAge(30);
		p.setGender(true);
		persons.add(p);
		p = new Person();
		p.setAge(40);
		p.setGender(true);
		persons.add(p);
		
		//To use filter to find the value without FOR LOOP, IF...ELSE 
		int max = persons.stream()
				.filter(person -> person.getAge() == 30)
				.mapToInt(Person::getAge).sum();
		System.out.println(max);
		
	}
	
	public static void getTestLambda() {
		Map<String,Integer> items = new HashMap<>();
		
		items.put("a",	10);
		items.put("b",	20);
		items.put("c",	30);
		items.put("d",	40);
		
		items.forEach((k,v) -> System.out.println("item:" + k + " count:" + v));
		
		items.forEach((k,v) -> {
			System.out.println("item:" + k + " count:" + v);
			if("b".equals(k)) {
				System.out.println("hello");
			}
			
		});
		
		List<String> items2 = new ArrayList<>();
		items2.add("A");
		items2.add("B");
		items2.add("C");
		items2.add("D");
		
		items2.forEach(item->System.out.println(item));
		
		//For each + if else
		items2.forEach(item->{
			if("C".equals(item)) {
				System.out.println(item);
			}
		});
		//For each without arg
		items2.forEach(System.out::println);
		
		//Filter to instead of IF
		items2.stream()
			.filter(s->s.contains("B"))
			.forEach(System.out::println);

		if(items2.stream().isParallel()) {
			System.out.println("yes");
		}
	}
}
