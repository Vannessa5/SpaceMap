package za.co.route.spacemap.services;

import java.util.List;

import org.springframework.stereotype.Service;

import za.co.route.spacemap.models.Planet;


/**
 * @author Vannessa
 *
 */

@Service
public interface PlanetServices {
	void savePlanets(List<Planet> planetList);
	

}
