package za.co.route.spacemap.services;

import java.util.List;

import org.springframework.stereotype.Service;

import za.co.route.spacemap.models.PlanetRoute;


/**
 * @author Vannessa
 *
 */

@Service
public interface RouteService  {
	void saveRoutes(List<PlanetRoute> routeList);

	//List<PlanetRoute> getAll();
	
		
	

}
