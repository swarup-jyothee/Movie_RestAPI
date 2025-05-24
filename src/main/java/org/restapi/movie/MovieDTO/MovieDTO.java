package org.restapi.movie.MovieDTO;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDTO {
	private String name;
	private String description;
	private String actor;
	private String actress;
	private String img;
	private String trailer;
	private Integer rating;

}
