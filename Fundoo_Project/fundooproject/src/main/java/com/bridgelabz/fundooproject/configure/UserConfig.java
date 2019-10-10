package com.bridgelabz.fundooproject.configure;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class UserConfig 
{     
	@Bean
	public ModelMapper modelMapper() 
	{
	    return new ModelMapper();
	}
	
	@Bean
	public BCryptPasswordEncoder getBcrypt()
	{
		return new BCryptPasswordEncoder();
	}
	
	/*
	 * @Bean public Docket productApi() { return new
	 * Docket(DocumentationType.SWAGGER_2).select()
	 * .apis(RequestHandlerSelectors.basePackage("com.bridgelabz.fundooproject")).
	 * build(); }
	 */

}
