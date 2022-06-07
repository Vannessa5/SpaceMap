package za.co.route.spacemap.models;

import java.util.List;

public class Maps {
	
	
	private final List<Route> route;

	private final List<Planet> planets;
	
	
	public Maps(List<Planet> planets,List<Route> route ) {
		this.planets=planets;
		this.route=route;
		
	}


	public List<Route> getRoutes() {
		return route;
	}


	public List<Planet> getPlanets() {
		return planets;
	}
	
	
}
