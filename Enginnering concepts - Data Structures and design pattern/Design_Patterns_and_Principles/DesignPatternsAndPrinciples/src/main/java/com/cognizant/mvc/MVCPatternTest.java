package com.cognizant.mvc;

public class MVCPatternTest {

    public static void main(String[] args) {

        Student student =
                new Student("101",
                        "Krishna",
                        "A");

        StudentView view = new StudentView();

        StudentController controller =
                new StudentController(student, view);

        System.out.println("Initial Student");

        controller.updateView();

        System.out.println();

        controller.setStudentName("Krishna Garg");
        controller.setStudentGrade("A+");

        System.out.println("Updated Student");
        System.out.println();

        controller.updateView();

    }

}