package com.cg.service;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.web.bind.annotation.RequestBody;

import com.cg.dao.MovieCatalogRepository;
import com.cg.entity.MovieCatalog;


@Service
public class MovieCatalogService 
{
	@Autowired
	MovieCatalogRepository movieCatDao;
		
	public Set<MovieCatalog> getAllMovieCatalog()
	{
		ArrayList<MovieCatalog> movList=(ArrayList)movieCatDao.findAll();
		HashSet<MovieCatalog> movSet=new  HashSet<MovieCatalog>();
		for(MovieCatalog mc:movList)
		{
			movSet.add(mc);
		}		
		return movSet;
	}
	public MovieCatalog getMovieCatalogById(int movId)
	{	
		System.out.println("  in service ....");
		Optional<MovieCatalog>  opCat=movieCatDao.findById(movId);	
		if(opCat.isPresent())
		{
			return opCat.get();
		}
		else
		{
			return null;
		}
		
	}
	public MovieCatalog getMovieInfoByName(String movName)
	{
		return movieCatDao.getMovieInfoByName(movName);
	}
	public void addMovie(MovieCatalog movie)
	{
		movieCatDao.saveAndFlush(movie);
		
	}
		
	
	
}
