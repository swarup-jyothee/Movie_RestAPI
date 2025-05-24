package org.restapi.movie.MovieService;

import java.util.ArrayList;
import java.util.List;

import org.restapi.movie.Exception.DataisPresentException;
import org.restapi.movie.Exception.NoDataFoundException;
import org.restapi.movie.MovieDTO.MovieDTO;
import org.restapi.movie.MovieEntity.Movie;
import org.restapi.movie.MovieRepository.Movierepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class Movieservice {
	@Autowired
	Movierepo repository;
	public Movie saveMovie(MovieDTO dto) {
		if(!repository.existsByName(dto.getName())) {
		Movie movie=new Movie(dto);
		repository.save(movie);
		return movie;
	} else {
		//created exception
		throw new DataisPresentException("Name is  Already Exists:"+ dto.getName());
	}
	}
	public List<Movie> saveMovies(List<MovieDTO> dtos){
		List<Movie>movies=new ArrayList<Movie>();
		for(MovieDTO dto :dtos) {
			if(repository.existsByName(dto.getName()))
				throw new DataisPresentException("Movie name is already exist"+dto.getName());
			else 
				movies.add(new Movie(dto)); 		
			}
		return repository.saveAll(movies); 
	}
	
	public List<Movie> fetchAll(String sort,boolean desc,int page,int data){
		Sort sortBasedOn=Sort.by(sort);
		if(desc)
			sortBasedOn=sortBasedOn.descending();
		 PageRequest pageable = PageRequest.of(page-1, data,sortBasedOn);
		Page <Movie>records=repository.findAll(pageable);
		if(!records.isEmpty())
			return records.getContent();
		else
			throw new NoDataFoundException();
	}
	public String DeleteRecordById(Integer id) {
		repository.deleteById(id);
		return "Data Removed Success";
	}
	public Movie UpdateStudent(Movie movie) {
		return repository.save(movie);
	}
}
