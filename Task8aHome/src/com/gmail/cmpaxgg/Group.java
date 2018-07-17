package com.gmail.cmpaxgg;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.io.Writer;
import java.util.Arrays;

import javax.swing.JOptionPane;

public class Group implements Serializable {
	private static final long serialVersionUID = 1L;
	private Student[] arrayStudent = new Student[10];

	public Group() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void interactiveAddStudent() throws MyException {
		String in = String.valueOf(JOptionPane.showInputDialog("If you want to add student -  Enter \"y or n?\""));
		if (in.equals("y")) {
			Student student = new Student();
			int studentNumber = Integer.valueOf(JOptionPane.showInputDialog("Enter number "));
			if (studentNumber > 10)
				throw new MyException();
			{
			}
			student.setLastname(String.valueOf(JOptionPane.showInputDialog("Enter string lastname")));
			student.setName(String.valueOf(JOptionPane.showInputDialog("Enter string name")));
			student.setAge(Integer.valueOf(JOptionPane.showInputDialog("Enter age")));
			boolean sex = getSex("Enter sex:true-man or false-woman");
			student.setFaculty(String.valueOf(JOptionPane.showInputDialog("Enter string faculty")));
			student.setCourse(Integer.valueOf(JOptionPane.showInputDialog("Enter int course")));

			if ((studentNumber - 1 >= 0) && (studentNumber - 1 < arrayStudent.length)
					&& (arrayStudent[studentNumber - 1] == null)) {
				arrayStudent[studentNumber - 1] = student;

			} else {
				JOptionPane.showMessageDialog(null, " Choose other number student");

			}

		} else {
			JOptionPane.showMessageDialog(null, " Ok");
		}

	}

	public void addStudent(Student student) throws MyException {
		if (student == null) {
			throw new IllegalArgumentException("Null student");
		}
		for (int j = 0; j < arrayStudent.length; j++) {
			if (arrayStudent[j] == null) {
				arrayStudent[j] = student;

				return;
			}
		}
		throw new MyException();
	}

	public String searchStudent(String lastname) {
		for (int j = 0; j < arrayStudent.length; j++) {
			if (arrayStudent[j] != null && arrayStudent[j].getLastname().equals(lastname)) {
				return arrayStudent[j].getLastname();
			}
		}
		return "Student is not found in this group";
	}

	public boolean deleteStudent(Student student) {
		for (int j = 0; j < arrayStudent.length; j++) {
			if (arrayStudent[j] == student) {
				arrayStudent[j] = null;
				return true;
			}
		}
		return false;
	}

	public void sortStudentLastname() {
		Arrays.sort(arrayStudent, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: a.getLastname().compareTo(b.getLastname()));
		for (Student student : arrayStudent) {
			return;
		}
	}

	public void sortStudentAge() {
		Arrays.sort(arrayStudent, (a, b) -> CheckNull.checkNull(a, b) != CheckNull.NOT_NULL ? CheckNull.checkNull(a, b)
				: a.getAge() - b.getAge());
		for (Student student : arrayStudent) {
			return;
		}
	}

	private boolean getSex(String message) throws NullPointerException {
		boolean done = false;
		boolean name = false;
		for (; !done;) {
			try {
				name = JOptionPane.showInputDialog(message).equals("man");
				done = true;
			} catch (NumberFormatException e) {
				JOptionPane.showInternalMessageDialog(null, "Invalid format");
			}
		}
		return name;
	}

	public void writeGroupFile(String name) {
		try (Writer wr = new FileWriter(new File(name))) {
			wr.write(toString());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		int i = 0;
		for (Student student : arrayStudent) {
			if (student != null) {
				sb.append((++i) + ": ").append(student);
				sb.append(System.lineSeparator());
			}
		}
		return sb.toString();
	}

}
