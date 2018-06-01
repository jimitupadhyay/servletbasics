package test;

public class User {

	private String name;
	private int age;
	
	public User(String name,int  age) {
		this.name = name;
		this.age = age;
	}
	
	public void setName(String nameTemp) {
		this.name = nameTemp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public void setAge(int ageTemp) {
		this.age = ageTemp;
	}
	
	public int getAge() {
		return this.age;
	}
}
