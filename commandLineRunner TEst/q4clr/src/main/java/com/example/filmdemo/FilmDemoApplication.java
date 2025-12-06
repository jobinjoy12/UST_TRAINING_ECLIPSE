package com.example.filmdemo;

import java.util.List;
import java.util.Optional;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.filmdemo.model.Movie;
import com.example.filmdemo.repository.MovieRepository;

@SpringBootApplication
public class FilmDemoApplication implements CommandLineRunner {

	private final MovieRepository movieRepository;

	// Constructor-based dependency injection for MovieRepository
	public FilmDemoApplication(MovieRepository movieRepository) {
		this.movieRepository = movieRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(FilmDemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Application started! Performing film management operations...");

		// TODO: Implement the film management logic here.

		Movie m1 = new Movie("Kalam","Jobin",2000,"901");
		Movie m2 = new Movie("Kayal","Mamooty",2005,"0991");
		System.out.println("Created movies");

		List<Movie> LMovie = movieRepository.findAll();
		System.out.println("movies: "+LMovie);

		Long id = m2.getId();
		Optional<Movie> opt = movieRepository.findById(id);
		System.out.println("Movie with id: "+id+" is "+opt.get());

		if(opt.isPresent())
		{
			Movie movie = opt.get();
			movie.setDirector("Niranj");
			movieRepository.save(movie);
		}

		Long id2 = m1.getId();
		movieRepository.deleteById(id2);

	}
}