package com.cg.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="mov_cat")
public class MovieCatalog  implements Serializable
{	
	@Override
	public String toString() {
		return "MovieCatalog [movieId=" + movieId + ", movieName=" + movieName + "]";
	}
	@Id
	@Column(name="mov_id",length=10)
	private int movieId;
	
	@Column(name="mov_name",length=50)
	private String movieName;
	public MovieCatalog() 
	{
		// TODO Auto-generated constructor stub
	}

	public MovieCatalog(int movieId) {
		super();
		this.movieId = movieId;
	}

	public MovieCatalog(int movieId, String movieName) {
		super();
		this.movieId = movieId;
		this.movieName = movieName;
	}

	public int getMovieId() {
		return movieId;
	}
	public void setMovieId(int movieId) {
		this.movieId = movieId;
	}
	public String getMovieName() {
		return movieName;
	}
	public void setMovieName(String movieName) {
		System.out.println("set moviename called....");
		this.movieName = movieName;
	}
	
	
}
