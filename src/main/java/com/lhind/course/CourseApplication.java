package com.lhind.course;

import com.lhind.course.model.entity.User;
import com.lhind.course.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {

	private static UserService userService;
//	private static CourseService courseService;
//	private static RegistrationService registrationService;

	public CourseApplication(UserService uService) {
		userService = uService;
	}
	public static void main(String[] args) {
		SpringApplication.run(CourseApplication.class, args);

//		User user = new User();
//		user.setFirstName("Eugen");
//		user.setLastName("Mirce");
//		user.setAge(22);
//		user = userService.createUser(user);
//		System.out.println(user);
//
//		Registration registration = new Registration();
//		registration.setName("Reg 1");
//		registration = registrationService.createRegistration(registration);
//		System.out.println(registration);
//
//		Course course = new Course();
//		course.setName("C1");
//		course.setDescription("Desc");
//		course.setRegistration(registration);
//		course = courseService.createCourse(course);
//		System.out.println(course);
	}
}
