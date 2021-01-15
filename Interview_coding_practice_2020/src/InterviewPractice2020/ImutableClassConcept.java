package InterviewPractice2020;
	//      In order to create an immutable class, you should follow the below steps:
	//		Make your class final, so that no other classes can extend it.
	//		Make all your fields final, so that they’re initialized only once inside the constructor and never modified afterward.
	//		Don’t expose setter methods.
	//		When exposing methods which modify the state of the class, you must always return a new instance of the class.
	//		If the class holds a mutable object:
	//		Inside the constructor, make sure to use a clone copy of the passed argument and never set your mutable field to the real instance passed through constructor, this is to prevent the clients who pass the object from modifying it afterwards.
	//		Make sure to always return a clone copy of the field and never return the real object instance.

class Age {
	private int day;
	private int month;
	private int year;

	public int getDay() {
		return day;
	}

	public void setDay(int day) {
		this.day = day;
	}

	public int getMonth() {
		return month;
	}

	public void setMonth(int month) {
		this.month = month;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}
}

final class ImmutableStudent {
	private final int id;
	private final String name;
	private final Age age;

	// #5 from the steps that we mention above for creating an immutable class. So we modify the constructor in order to clone the
	// passed argument of Age and use a clone instance of it.
	public ImmutableStudent(int id, String name, Age age) {
		this.name = name;
		this.id = id;
		Age cloneAge = new Age();
		cloneAge.setDay(age.getDay());
		cloneAge.setMonth(age.getMonth());
		cloneAge.setYear(age.getYear());
		this.age = cloneAge;
	}

	public int getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	// #4, when returning mutable fields from immutable object, you should return a clone instance of
	// them and not the real instance of the field.
	public Age getAge() {
		Age cloneAge = new Age();
		cloneAge.setDay(this.age.getDay());
		cloneAge.setMonth(this.age.getMonth());
		cloneAge.setYear(this.age.getYear());
		return cloneAge;
	}
}


public class ImutableClassConcept {


	public static void main(String[] args) {
		Age age = new Age();
		// those fileds will not be populated since both class become immutable
		age.setDay(1);
		age.setMonth(1);
		age.setYear(1992);
		ImmutableStudent student = new ImmutableStudent(1, "Alex", age);
		System.out.println("Alex age year before modification = " + student.getAge().getYear());
		student.getAge().setYear(1993);
		System.out.println("Alex age year after modification = " + student.getAge().getYear());
	}


}

