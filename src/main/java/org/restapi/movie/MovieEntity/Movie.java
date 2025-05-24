package org.restapi.movie.MovieEntity;

import org.restapi.movie.MovieDTO.MovieDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@Entity			
@NoArgsConstructor
@AllArgsConstructor
public class Movie {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@SequenceGenerator(initialValue=100,allocationSize=1,name="id")
	private Integer id;
	private String name;
	private String description;
	private String actor;
	private String actress;
	private String img;
	private String trailer;
	private Integer rating;
	
	public Movie(MovieDTO dto) {
		this.name=dto.getName();
		this.description=dto.getDescription();
		this.actor=dto.getActor();
		this.actress=dto.getActress();
		this.img=dto.getImg();
		this.trailer=dto.getTrailer();
		this.rating=dto.getRating();
	}

}
