package za.co.route.spacemap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.route.spacemap.models.Planet;
import za.co.route.spacemap.repository.PlanetRepository;

/**
 * @author Vannessa
 *
 */


@Service
public class PlanetServiceImplementation implements PlanetServices{

	@Override
	public void savePlanets(List<Planet> planetList) {
		// TODO Auto-generated method stub
		planetList.stream().forEach(planet -> {
			this.planetRepository.save(planet);
		});
		
	}
	@Autowired
	public PlanetRepository planetRepository;
	
	public Planet getById(String id) {
		return this.planetRepository.getById(id);
		
	}
	public List<Planet> getAll(){
		return this.planetRepository.findAll();
		
	}
	public PlanetServiceImplementation(final PlanetRepository repository) {
		this.planetRepository=repository;
	}
}
