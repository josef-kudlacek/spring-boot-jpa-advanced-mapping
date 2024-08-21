package eu.kudljo.cruddemo;

import eu.kudljo.cruddemo.dao.AppDAO;
import eu.kudljo.cruddemo.entity.Instructor;
import eu.kudljo.cruddemo.entity.InstructorDetail;
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
//			createInstructor(appDAO);
			findInstructor(appDAO);
		};
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
