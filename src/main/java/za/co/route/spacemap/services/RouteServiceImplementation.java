package za.co.route.spacemap.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import za.co.route.spacemap.models.PlanetRoute;
import za.co.route.spacemap.repository.RouteRepository;

/**
 * @author Vannessa
 *
 */

@Service
public class RouteServiceImplementation implements RouteService {

	@Autowired
	private RouteRepository routeRepository;

	@Override
	public void saveRoutes(List<PlanetRoute> routeList) {
		// TODO Auto-generated method stub
		routeList.stream().forEach(route -> {
			this.routeRepository.save(route);
		});
	}

	public PlanetRoute findById(int id) {
		return this.routeRepository.getById(id);

	}

	public List<PlanetRoute> getAll() {
		return this.routeRepository.findAll();
	}

	public RouteServiceImplementation(final RouteRepository repository) {
		this.routeRepository = repository;
	}
}
