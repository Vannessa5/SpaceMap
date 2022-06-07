package za.co.route.spacemap.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import za.co.route.spacemap.models.PlanetRoute;
import za.co.route.spacemap.services.RouteService;
import za.co.route.spacemap.services.RouteServiceImplementation;

/**
 * @author Vannessa
 *
 */


@RestController

public class RouteController {
	
	@Autowired
	private RouteServiceImplementation routeServiceImpl;
	
	
	@RequestMapping(value="/routes", method =RequestMethod.GET)
	public List<PlanetRoute> getAllRoutes(){
		return this.routeServiceImpl.getAll();
		
		
	}
	

	
}
