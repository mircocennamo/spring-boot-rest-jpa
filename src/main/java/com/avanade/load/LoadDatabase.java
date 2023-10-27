package com.avanade.load;

import com.avanade.model.Course;
import com.avanade.model.LevelStatus;
import com.avanade.model.Student;
import com.avanade.repository.CourseJpaRepository;
import com.avanade.repository.StudentJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Configuration
class LoadDatabase {

	private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);

	@Autowired
	CourseJpaRepository courseJpaRepository;

	@Autowired
	StudentJpaRepository studentJpaRepository;

	@Bean
	CommandLineRunner initDatabase() {

		Course courseJava = new Course("language java", LevelStatus.ADVANCED);
		Course courseC = new Course("language c",LevelStatus.ADVANCED);
		Course courseSql = new Course("language sql",LevelStatus.BASIC);
		Student pippo = new Student("Pippo","12345" );
		Student pluto = new Student("Pluto","8765" );

		Set<Course> setCourses_2 = Stream.of(courseJava, courseC)
				.collect(Collectors.toCollection(HashSet::new));
		pluto.setCourses(setCourses_2);

		Set<Course> setCourses_1 = Stream.of(courseJava, courseC, courseSql)
				.collect(Collectors.toCollection(HashSet::new));
		pippo.setCourses(setCourses_1);



		return args -> {
			log.info("Preloading " + courseJpaRepository.save(courseJava));
			log.info("Preloading " + courseJpaRepository.save(courseC));
			log.info("Preloading " + courseJpaRepository.save(courseSql));
			log.info("Preloading " + studentJpaRepository.save(pippo));
			log.info("Preloading " + studentJpaRepository.save(pluto));
		};
	}
}
