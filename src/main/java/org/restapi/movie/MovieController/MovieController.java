package org.restapi.movie.MovieController;

import java.util.List;

import org.restapi.movie.MovieDTO.MovieDTO;
import org.restapi.movie.MovieEntity.Movie;
import org.restapi.movie.MovieService.Movieservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
@RestController
@RequestMapping("/api/v1")
public class MovieController {
	@Autowired
	 Movieservice service;
	@PostMapping("/movie")                 
	public ResponseEntity<Movie> saveMovie(@RequestBody MovieDTO dto){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveMovie(dto));
	}
	@PostMapping("/movies")
	public ResponseEntity<List<Movie>> saveMultipleMovie(@RequestBody List<MovieDTO>dtos){
		return ResponseEntity.status(HttpStatus.CREATED).body(service.saveMovies(dtos));
	}
	@GetMapping("/movies")  //<list<students>--> inside it should be
	public ResponseEntity<List<Movie>> fetchMovies(@RequestParam(defaultValue="id")String sort,
			@RequestParam(defaultValue="false")boolean desc,
			@RequestParam(defaultValue="1")int page,
			@RequestParam(defaultValue="10")int data)
			{
		return ResponseEntity.status(HttpStatus.OK).body(service.fetchAll(sort,desc,page,data));
	}
	
	@DeleteMapping("/movie/{id}")
	public ResponseEntity<String>deleteRecord(@PathVariable Integer id){
		return ResponseEntity.status(HttpStatus.OK).body(service.DeleteRecordById(id));
	}
	@PutMapping("/movie")
	public ResponseEntity<Movie>updateStudent(@RequestBody Movie movie){
		return ResponseEntity.status(HttpStatus.OK).body(service.UpdateStudent(movie));
	}
}
