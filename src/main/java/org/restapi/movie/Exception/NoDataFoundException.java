package org.restapi.movie.Exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class NoDataFoundException extends RuntimeException{
	String note="no data is there";

}
