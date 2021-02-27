package com.wyu;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@SpringBootApplication
@EnableAsync
@EnableTransactionManagement
public class TestInstitutionBeApplication {

	@PostConstruct
	void setDefaultTimezone() {
		TimeZone.setDefault(TimeZone.getTimeZone("Asia/Shanghai"));
	}

	public static void main(String[] args) {
		SpringApplication.run(TestInstitutionBeApplication.class, args);
	}

}
