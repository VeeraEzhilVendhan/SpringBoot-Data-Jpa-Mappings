package com.veera.SpringBootDataJpaMappings;

import com.veera.SpringBootDataJpaMappings.onetoone.bi.DB_Operation_OnetoOne_Bi;
import com.veera.SpringBootDataJpaMappings.onetoone.uni.DB_Operation_OnetoOne_Uni;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SpringBootDataJpaMappingsApplication
{

	public static void main(String[] args)
	{
		SpringApplication.run(SpringBootDataJpaMappingsApplication.class, args);
	}


	@Bean
	public CommandLineRunner commandLineRunner(DB_Operation_OnetoOne_Bi dbOperation)
	{
		return runner -> {
			//dbOperation.save();
			dbOperation.read();
		};
	}

}
