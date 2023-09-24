package com.veera.SpringBootDataJpaMappings;

import com.veera.SpringBootDataJpaMappings.manytomany.DBOperation_ManyToMany;
import com.veera.SpringBootDataJpaMappings.onetomany.DBOperation_OnetoMany;
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
	public CommandLineRunner commandLineRunner(DBOperation_ManyToMany dbOperation)
	{
		return runner -> {
			dbOperation.save();
			//dbOperation.read();
		};
	}

}
