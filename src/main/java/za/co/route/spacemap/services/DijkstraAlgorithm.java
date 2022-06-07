package za.co.route.spacemap.services;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;
import java.util.Map;
import za.co.route.spacemap.models.*;




public class DijkstraAlgorithm {

	private final List<Planet> symbols;
	private final List<Route> route1;

	private Set<Planet> settledSymbols;
	private Set<Planet> unsettledSymbols;

	private Map<Planet, Planet> predecessors;
	private Map<Planet, Double> distance;

	public DijkstraAlgorithm(Maps map) {
		this.symbols = new ArrayList<Planet>(map.getPlanets());
		this.route1 = new ArrayList<Route>(map.getRoutes());
	}

	public void execute(Planet source) {
		settledSymbols = new HashSet<Planet>();
		unsettledSymbols = new HashSet<Planet>();

		distance = new HashMap<Planet, Double>();
		predecessors = new HashMap<Planet, Planet>();
		distance.put(source, 0.0);
		unsettledSymbols.add(source);

		while (unsettledSymbols.size() > 0) {
			Planet symbol = getMinimun(unsettledSymbols);
			settledSymbols.add(symbol);
			unsettledSymbols.remove(symbol);
			findMinimalDistance(symbol);

		}
	}

	private Planet getMinimun(Set<Planet> vertexes) {
		Planet minimum = null;
		for (Planet vertex : vertexes) {
			if (minimum == null) {
				minimum = vertex;

			} else {
				if (getShortDistance(vertex) < getShortDistance(minimum)) {
					minimum = vertex;
				}
			}
		}
		return minimum;
	}

	LinkedList<Planet> getPath(Planet planet) {
		LinkedList<Planet> path = new LinkedList<Planet>();
		Planet step = planet;
		if (predecessors.get(step) == null) {
			return null;
		}
		path.add(step);
		while (predecessors.get(step) != null) {
			step = predecessors.get(step);
			path.add(step);
		}
		Collections.reverse(path);
		return path;
	}

	private boolean isSettled(Planet vertex) {
		return settledSymbols.contains(vertex);

	}

	private void findMinimalDistance(Planet symbol) {
		List<Planet> adjacentSymbols = getNearBy(symbol);
		for (Planet target : adjacentSymbols) {
			if (getShortDistance(target) > getShortDistance(symbol) + getDistance(symbol, target)) {
				distance.put(target, getShortDistance(symbol) + getDistance(symbol, target));
				predecessors.put(target, symbol);
				unsettledSymbols.add(target);

			}

		}

	}

	private List<Planet> getNearBy(Planet symbol) {
		List<Planet> nearBy = new ArrayList<>();
		for (Route route : route1) {
			if (route.getPlanetOrigin().equals(symbol) && !isSettled(route.getPlanetDestination())) {
				nearBy.add(route.getPlanetDestination());
			}

		}
		return nearBy;
	}

	private double getDistance(Planet symbol, Planet target) {
		double distance = 0.0;
		for (Route route : route1) {
			if (route.getPlanetOrigin().equals(symbol) && route.getPlanetDestination().equals(target)) {
				distance = route.getDistance();
			}
		}
		return distance;

	}

	private double getShortDistance(Planet destination) {
		Double distance1 = distance.get(destination);
		return distance1 == null ? Double.MAX_VALUE : distance1;

	}
}
