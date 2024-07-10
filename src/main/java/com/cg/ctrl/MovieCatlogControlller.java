package com.cg.ctrl;
import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
//http://localhost:9909/rating/list
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.HttpClientErrorException;

import com.cg.entity.MovieCatalog;
import com.cg.exception.MovieNotFoundException;
import com.cg.service.MovieCatalogService;

@RestController
@RequestMapping("/movCatCtrl")
public class MovieCatlogControlller 
{	
	@Autowired
	MovieCatalogService movieCatSer;
	
	@Value("${fname}")
	String fn;
	
	//http://localhost:8082/movCatCtrl/fetchMovieCatById/1003
	@GetMapping("/fetchMovieCatById/{movId}")
	public MovieCatalog getMovieById(@PathVariable("movId")int mId)
			throws MovieNotFoundException
	{	
		System.out.println(" In Controller  before get");
		MovieCatalog movCat=movieCatSer.getMovieCatalogById(mId);
		System.out.println(" In Controller   after  get"+movCat);
		if(movCat==null)			
		{
			 throw new MovieNotFoundException
			("Movie with movie id :"+mId + " Not Present");
		}	
		else 
		{
			return movCat;
			
		}
		
	}
	//--------------------------------------
	//http://localhost:8082/movCatCtrl/fetchMovieCatByName/Dangle
	@GetMapping("/fetchMovieCatByName/{movName}")
		public MovieCatalog getMovieByName(@PathVariable
				("movName")String mName)
		{
			return movieCatSer.getMovieInfoByName(mName);
		}
	
	//http://localhost:8082/movCatCtrl/fetchMovieCatByName?movName=Dangale
		@GetMapping("/fetchMovieCatByName")
			public MovieCatalog getMovieByNamee(@RequestParam
					("movName")String mName)
			{
				return movieCatSer.getMovieInfoByName(mName);
			}
		
	
	//--------------------------------
	//http://localhost:8082/movCatCtrl/fetchAllMovieCat
		@GetMapping("/fetchAllMovieCat")
		public HashSet<MovieCatalog> getAllMovieCat()
		{
			return (HashSet)movieCatSer.getAllMovieCatalog();
		}
		//----------------------------------------
	
	/* http://localhost:8082/movCatCtrl/addmoviefrmpostman/
		  {
		    "movieId":1007,
		   "movieName":"xyz"
		}*/
	@PostMapping(value ="/addmoviefrmpostman/")			
	public HashSet<MovieCatalog> addMovie(@RequestBody MovieCatalog mov) 
	{		
		System.out.println(mov +" in  addMovieFromPostMan ctrl..........................");
		movieCatSer.addMovie(mov);		
		System.out.println(mov +" mov  Added..........");
		return (HashSet)movieCatSer.getAllMovieCatalog()	;

	}
	//--------//http://localhost:8082/movCatCtrl-----------------
	@GetMapping
	public String greetMe()
	{
		return fn;
	}

}
