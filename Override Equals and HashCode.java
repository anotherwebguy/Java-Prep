import java.util.*;
import java.io.*;

class Student {
	private Integer age;

	public void setAge(Integer age){
		this.age = age;
	}

	public Integer getAge(){
		return this.age;
	}

	@Override
	public final boolean equals(Object obj){
		if(this==obj) return true;
		if(!(obj instanceof Student)) return false;
		Student s = (Student)obj;
		return this.age==s.age;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 17;
		result = prime * result + age.hashCode();
		return result;
	}
}

class logger {
	public static void main(String[] args) {
		Student s = new Student();
		s.setAge(15);
		Student s1 = s;
		Student s2 = new Student();
		s2.setAge(15);
		System.out.println(s.equals(s1));
		System.out.println(s.equals(s2));
		System.out.println(s.hashCode());
	}
}
