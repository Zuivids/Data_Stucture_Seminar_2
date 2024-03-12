package service;

import java.util.Arrays;

import datastr.MyLinkedList;
import model.Student;

public class MainService {

	public static void main(String[] args) {

		MyLinkedList<Integer> myLinkedList = new MyLinkedList<Integer>();

		myLinkedList.add(2);
		myLinkedList.add(10);
		myLinkedList.add(50);
		myLinkedList.print(); // 2 10 50

		try {
			myLinkedList.add(1, 1000);
			myLinkedList.print(); // 2 1000 10 50
			myLinkedList.add(0, -1000);
			myLinkedList.print(); // -1000 2 1000 10 50

			myLinkedList.remove(2);
			myLinkedList.print(); // -1000 2 10 50
			myLinkedList.remove(0);
			myLinkedList.print(); // 2 10 50
			myLinkedList.remove(2);
			myLinkedList.print(); // 2 10
			myLinkedList.add(10);
			myLinkedList.add(20);
			myLinkedList.add(30);
			myLinkedList.print(); // 2 10 10 20 30
			// System.out.println(Arrays.toString(myLinkedList.search(10)));

			System.out.println(myLinkedList.get(3)); // 10

			myLinkedList.makeEmpty();
			System.out.println("===");
			myLinkedList.add(1);
			myLinkedList.add(2);
			myLinkedList.add(3);
			myLinkedList.print();
			System.out.println("===");

		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("--------------------------");
		MyLinkedList<Student> myStudentLinkedList = new MyLinkedList<Student>();
		Student s1 = new Student("Martins", "Raimis", 230006, (short) 1995, (byte) 11, (byte) 3, "111111-10735", 'm',
				"martinsraimisgmail.com", 26433303);
		Student s2 = new Student("Markuss", "Taimis", 2322006, (short) 1990, (byte) 1, (byte) 4, "123456-10735", 'm',
				"martinstaimisgmail.com", 26433555);
		Student s3 = new Student("Maris", "Vaimis", 2329006, (short) 1999, (byte) 12, (byte) 3, "199999-10735", 'm',
				"martinsvaimisgmail.com", 23433555);
		try {
			myStudentLinkedList.add(s1);
			myStudentLinkedList.add(0, s2);
			myStudentLinkedList.add(1, s3);
			myStudentLinkedList.print();// Anna Liga Janis
			System.out.println(myStudentLinkedList.get(1));// Liga
			myStudentLinkedList.remove(1);
			myStudentLinkedList.print();// Anna Janis
			myStudentLinkedList.makeEmpty();
			myStudentLinkedList.print();
		}

		catch (Exception e) {
			System.out.println(e);
		}

	}

}
