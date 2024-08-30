package eu.kudljo.cruddemo;

import eu.kudljo.cruddemo.dao.AppDAO;
import eu.kudljo.cruddemo.entity.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AppDAO appDAO) {
		return runner -> {
//			createCourseAndStudents(appDAO);
//			findCourseAndStudents(appDAO);
//			findStudentAndCourses(appDAO);
//			addMoreCoursesForStudent(appDAO);
//			deleteCourse(appDAO);
			deleteStudent(appDAO);
		};
	}

	private void deleteStudent(AppDAO appDAO) {
		int id = 2;

		System.out.println("Deleting student with id " + id);

		appDAO.deleteStudentById(id);

		System.out.println("Done!");
	}

	private void addMoreCoursesForStudent(AppDAO appDAO) {
		int id = 2;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		Course course1 = new Course("Rubik's Cube - How to Speed Cube");
		Course course2 = new Course("Atari 2600 - Game Development");

		student.addCourse(course1);
		student.addCourse(course2);

		System.out.println("Updating student: " + student);
		System.out.println("Associated courses: " + student.getCourses());

		appDAO.update(student);

		System.out.println("Done!");
	}

	private void findStudentAndCourses(AppDAO appDAO) {
		int id = 2;

		Student student = appDAO.findStudentAndCoursesByStudentId(id);

		System.out.println("Loaded student: " + student);
		System.out.println("Courses: " + student.getCourses());

		System.out.println("Done!");
	}

	private void findCourseAndStudents(AppDAO appDAO) {
		int id = 10;

		Course course = appDAO.findCourseAndStudentsByCourseId(id);

		System.out.println("Loaded course: " + course);
		System.out.println("Students: " + course.getStudents());

		System.out.println("Done!");
	}

	private void createCourseAndStudents(AppDAO appDAO) {
		Course course = new Course("Pacman - How To Score One Million Points");

		Student student1 = new Student("John", "Doe", "john@luv2code.com");
		Student student2 = new Student("Mary", "Public", "mary@luv2code.com");

		course.addStudent(student1);
		course.addStudent(student2);

		System.out.println("Saving the course: " + course);
		System.out.println("Associated students: " + course.getStudents());

		appDAO.save(course);

		System.out.println("Done!");
	}

	private void deleteCourseAndReviews(AppDAO appDAO) {
		int id = 10;

		System.out.println("Deleting course id: " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Done!");
	}

	private void retrieveCourseAndReviews(AppDAO appDAO) {
		int id = 10;

		Course course = appDAO.findCourseAndReviewsByCourseId(id);

		System.out.println(course);

		System.out.println(course.getReviews());

		System.out.println("Done!");
	}

	private void createCourseAndReviews(AppDAO appDAO) {
		Course course = new Course("Pacman - How to Score One Million Points");

		course.addReview(new Review("Great course... loved it!"));
		course.addReview(new Review("Cool course, job well done."));
		course.addReview(new Review("What a dump course, you are an idiot!"));

		System.out.println("Saving the course: " + course);
		System.out.println(course.getReviews());

		appDAO.save(course);
		System.out.println("Done!");
	}

	private void deleteCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println("Deleting course with id " + id);

		appDAO.deleteCourseById(id);

		System.out.println("Done!");
	}

	private void updateCourse(AppDAO appDAO) {
		int id = 10;

		System.out.println("Finding course id: " + id);
		Course course = appDAO.findCourseById(id);

		System.out.println("Updating course id: " + id);
		course.setTitle("Enjoy the Simple Things");

		appDAO.update(course);

		System.out.println("Done!");
	}

	private void updateInstructor(AppDAO appDAO) {
		int id = 1;

		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Updating instructor with id: " + id);
		instructor.setLastName("TESTER");

		appDAO.update(instructor);

		System.out.println("Done!");
	}

	private void findInstructorWithCoursesJoinFetch(AppDAO appDAO) {
		int id = 1;
		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findInstructorByInstructorIdJoinFetch(id);

		System.out.println("Found instructor: " + instructor);
		System.out.println("Associated courses: " + instructor.getCourses());

		System.out.println("Done!");
	}

	private void findInstructorWithCourses(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor with id: " + id);
		Instructor instructor = appDAO.findInstructorById(id);

		System.out.println("Found instructor: " + instructor);
		System.out.println("Associated courses: " + appDAO.findCoursesByInstructorId(instructor.getId()));

		System.out.println("Done!");
	}

	private void createInstructorWithCourses(AppDAO appDAO) {
		Instructor instructor =
				new Instructor("Susan", "Public", "susan.public@luv2code.com");

		InstructorDetail instructorDetail =
				new InstructorDetail(
						"http://www.youtube.com",
						"Video Games"
				);

		instructor.setInstructorDetail(instructorDetail);

		Course course1 = new Course("Air Guitar - The Ultimate Guide");
		Course course2 = new Course("The Pinball Masterclass");

		instructor.add(course1);
		instructor.add(course2);

		System.out.println("Saving instructor:" + instructor);
		System.out.println("The courses: " + instructor.getCourses());

		// thanks to CascadeType.PERSIST are courses save also
		appDAO.save(instructor);
	}

	private void deleteInstructorDetail(AppDAO appDAO) {
		int id = 3;
		System.out.println("Deleting instructor detail with id: " + id);

		appDAO.deleteInstructorDetailById(id);

		System.out.println("Done!");
	}

	private void findInstructorDetail(AppDAO appDAO) {
		int id = 2;
		InstructorDetail instructorDetail = appDAO.findInstructorDetailById(id);

		System.out.println("Instructor Detail: " + instructorDetail);

		System.out.println("Associated instructor: " + instructorDetail.getInstructor());
	}

	private void deleteInstructor(AppDAO appDAO) {
		int id = 1;
		System.out.println("Deleting instructor id: " + id);

		appDAO.deleteInstructorById(id);

		System.out.println("Done!");
	}

	private void findInstructor(AppDAO appDAO) {
		int id = 2;
		System.out.println("Finding instructor with id: " + id);

		Instructor instructor = appDAO.findInstructorById(id);
		System.out.println("Found instructor: " + instructor);
		System.out.println("The associate instructor details: " + instructor.getInstructorDetail());
	}

	private void createInstructor(AppDAO appDAO) {
//		Instructor instructor =
//				new Instructor("Chad", "Darby", "darby@luv2code.com");
//
//		InstructorDetail instructorDetail =
//				new InstructorDetail(
//						"http://www.luv2code.com/youtube",
//						"Luv 2 code!!!"
//				);

		Instructor instructor =
						new Instructor("Madhu", "Patel", "madhu@luv2code.com");

				InstructorDetail instructorDetail =
						new InstructorDetail(
								"http://www.luv2code.com/youtube",
								"Guitar"
						);

		instructor.setInstructorDetail(instructorDetail);

		System.out.println("Saving instructor: " + instructor);
		appDAO.save(instructor);

		System.out.println("Done!");
	}
}
