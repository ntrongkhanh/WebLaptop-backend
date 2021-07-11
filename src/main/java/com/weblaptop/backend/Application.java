package com.weblaptop.backend;

import com.weblaptop.backend.models.ENTITY.User;
import com.weblaptop.backend.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.crypto.password.PasswordEncoder;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

@SpringBootApplication
@EnableSwagger2
public class Application {
	@Autowired
	PasswordEncoder encoder;
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(Application.class);
		application.setAdditionalProfiles("ssl");
		application.run(args);
	}
	@Bean
	public CommandLineRunner demoData(UserRepository repo) {
		return args -> {
			Optional<User> user=repo.findByEmail("Admin");
			if (!user.isPresent()){
				repo.save(new User("Admin",encoder.encode("Admin"),"Admin",true,true));
			}
		};
	}
}
