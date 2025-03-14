package com.design.creational.builder;

public class Director {
	StudentBuilder studentBuilder;

	public Director(StudentBuilder studentBuilder) {
		this.studentBuilder = studentBuilder;
	}

	public Student createStudent() {
		if (studentBuilder instanceof EngineeringStudentBuilder) {
			return createEngineeringStudent();
		} else if (studentBuilder instanceof MBAStudentBuilder) {
			return createMBAStudent();
		}
		return null;

	}

	private Student createMBAStudent() {
		return studentBuilder.setRollNumber(2).setAge(24).setName("sj").setFatherName("MyFatherName")
				.setMotherName("MyMotherName").setSubjects().build();
	}

	private Student createEngineeringStudent() {
		return studentBuilder.setRollNumber(1).setAge(22).setName("SJ").setSubjects().build();
	}

}
