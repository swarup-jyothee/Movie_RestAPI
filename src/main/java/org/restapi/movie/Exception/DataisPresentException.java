package org.restapi.movie.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class DataisPresentException extends RuntimeException{
String message="movie name is already present";
}
