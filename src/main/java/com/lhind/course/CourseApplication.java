package com.lhind.course;

import com.lhind.course.model.Course;
import com.lhind.course.model.Registration;
import com.lhind.course.model.User;
import com.lhind.course.service.CourseService;
import com.lhind.course.service.RegistrationService;
import com.lhind.course.service.UserService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CourseApplication {

//	private static UserService userService;
//	private static CourseService courseService;
//	private static RegistrationService registrationService;
//
//	public CourseApplication(UserService uService, CourseService cService, RegistrationService rService) {
//		userService = uService;
//		courseService = cService;
//		registrationService = rService;
//	}

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
