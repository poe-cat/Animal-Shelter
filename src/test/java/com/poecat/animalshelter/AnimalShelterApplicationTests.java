package com.poecat.animalshelter;

import com.poecat.animalshelter.controller.HomeController;
import com.poecat.animalshelter.controller.RegistrationController;
import com.poecat.animalshelter.files.DownloadController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class AnimalShelterApplicationTests {

	@Autowired
	private HomeController homeController;
	@Autowired
	private RegistrationController registrationController;
	@Autowired
	private DownloadController downloadController;

	@Test
	public void contextLoads() throws Exception {
		assertThat(homeController).isNotNull();
		assertThat(registrationController).isNotNull();
		assertThat(downloadController).isNotNull();
	}
}
