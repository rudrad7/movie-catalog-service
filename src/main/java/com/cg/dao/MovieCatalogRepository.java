package com.cg.dao;
import java.util.Set;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.cg.entity.MovieCatalog;

import jakarta.transaction.Transactional;
@Repository
public interface MovieCatalogRepository
extends JpaRepository<MovieCatalog, Integer>
{	
	@Query("SELECT movcat FROM MovieCatalog movcat where movcat.movieName = :mnm") 
	public MovieCatalog getMovieInfoByName(@Param("mnm")String movName);
	
	@Transactional
	@Modifying
	@Query("delete from MovieCatalog mc where mc.movieName = :mnm")
	void deleteMovie(@Param("mnm") String movName);

}

