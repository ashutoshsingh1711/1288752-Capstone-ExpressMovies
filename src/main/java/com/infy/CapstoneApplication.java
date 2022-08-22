package com.infy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.support.AbstractApplicationContext;

import com.infy.dto.DirectorDTO;
import com.infy.dto.MovieDTO;
import com.infy.service.MovieService;

@SpringBootApplication
public class CapstoneApplication {


	@SuppressWarnings("unused")
	public static void main(String[] args) {
		AbstractApplicationContext context = (AbstractApplicationContext)SpringApplication.run(CapstoneApplication.class, args);
	    
		
		MovieService service = (MovieService)context.getBean("movieservice");
		//Insert 
		MovieDTO dto = new MovieDTO("DDLJ",LocalDate.now(),LocalDateTime.now());
		List<DirectorDTO> directorList = Arrays.asList(
				new DirectorDTO("abcd", "dhfn", "LUCKNOW","sonu@infosys.com",7355367284L),
				new DirectorDTO("efhdu","djdn","PUNE","ashutosh@infy.com",9453500035L)
				);
	
		
		service.add(dto,directorList); 
		
		
        service.searchBasedOnTitle("DDLJ");
        
        
//        service.updateReleaseDate(LocalDate.of(2021, 14, 7), "ABC");
        
        
        service.getDirectorListFromTitle("DDLJ");

        service.getMovieListFromDirectorName("DDLJ");
        

        System.out.println(service.displayAll().toString());       
	}

}
