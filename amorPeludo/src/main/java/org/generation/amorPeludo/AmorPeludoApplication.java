package org.generation.amorPeludo;

import org.generation.amorPeludo.config.JwtFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class AmorPeludoApplication {

	public static void main(String[] args) {
		SpringApplication.run(AmorPeludoApplication.class, args);
	}
	
	
	//@Bean public FilterRegistrationBean<JwtFilter> jwtFilter(){
	//FilterRegistrationBean<JwtFilter> registrationBean = new
	//FilterRegistrationBean<>(); registrationBean.setFilter(new JwtFilter());
	//registrationBean.addUrlPatterns("/api/productos/*");
	//registrationBean.addUrlPatterns("/api/usuarios/*"); return registrationBean;
	//} // jwtFilter
	 	
}//class AmorPeludoApplication
