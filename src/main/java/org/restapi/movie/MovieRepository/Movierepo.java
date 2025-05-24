package org.restapi.movie.MovieRepository;

import org.restapi.movie.MovieEntity.Movie;
																																																																																									
import org.springframework.data.jpa.repository.JpaRepository;

public interface Movierepo extends JpaRepository<Movie,Integer>{

	boolean existsByName(String name);

}
