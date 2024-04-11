package my.project.medicalsurveys;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Profile;

@Profile("!test")
@SpringBootApplication
public class MedicalSurveysApplication {

	public static void main(String[] args) {
		SpringApplication.run(MedicalSurveysApplication.class, args);
	}

}
