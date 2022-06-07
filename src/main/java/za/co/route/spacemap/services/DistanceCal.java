package za.co.route.spacemap.services;

import java.util.ArrayList;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
//import org.springframework.stereotype.Service;

import za.co.route.spacemap.models.Maps;
import za.co.route.spacemap.models.Planet;
import za.co.route.spacemap.models.Route;


/**
 * @author Vannessa
 *
 */

@Component
public class DistanceCal {

	@Autowired
	PlanetServiceImplementation planetService;
	@Autowired
	RouteServiceImplementation routeService;

	private List<Planet> symbols;
	private List<Route> routes;

	private Map<String, Planet> planetMap;

	public LinkedList<Planet> calculateDistance(String origin, String destination) {
		symbols = this.setPlanetSymbols();
		routes = this.setRouteSymbols(symbols);
		planetMap = new HashMap<>();
		symbols.forEach(symbol -> {
			planetMap.put(symbol.getPlanetSymbol(), symbol);
		});

		Maps map = new Maps (symbols, routes);
		
		DijkstraAlgorithm dijkstra = new DijkstraAlgorithm(map);
		dijkstra.execute(planetMap.get(origin));
		LinkedList<Planet> path = dijkstra.getPath(planetMap.get(destination));
		for (Planet planet : path) {
			System.out.println(planet);
		}

		return path;
	}

	private List<Planet> setPlanetSymbols() {
		return this.planetService.getAll();
	}



	private List<Route> setRouteSymbols(List<Planet> planetlist) {
		List<Route> routeList = new ArrayList<Route>();

		Route route1 = new Route(1, planetlist.get(0), planetlist.get(1), 0.44d);
		Route route2 = new Route(2, planetlist.get(0), planetlist.get(2), 1.89d);
		Route route3 = new Route(3, planetlist.get(0), planetlist.get(3), 0.10d);
		Route route4 = new Route(4, planetlist.get(1), planetlist.get(7), 2.44d);
		Route route5 = new Route(5, planetlist.get(1), planetlist.get(4), 3.45d);
		Route route6 = new Route(6, planetlist.get(2), planetlist.get(5), 0.49d);
		Route route7 = new Route(7, planetlist.get(3), planetlist.get(11), 2.34d);
		Route route8 = new Route(8, planetlist.get(3), planetlist.get(12), 2.61d);
		Route route9 = new Route(9, planetlist.get(7), planetlist.get(6), 3.71d);
		
		Route route10 = new Route(10, planetlist.get(4), planetlist.get(8), 8.090d);
		Route route11 = new Route(11, planetlist.get(5), planetlist.get(9), 5.460d);
		Route route12 = new Route(12, planetlist.get(5), planetlist.get(10), 3.670d);
		Route route13 = new Route(13, planetlist.get(6), planetlist.get(25), 5.250d);
		Route route14 = new Route(14, planetlist.get(8), planetlist.get(25), 13.97d);
		Route route15 = new Route(15, planetlist.get(8), planetlist.get(9), 14.78d);
		
		Route route16 = new Route(16, planetlist.get(11), planetlist.get(19), 15.23d);
		Route route17 = new Route(17, planetlist.get(19), planetlist.get(13), 10.43d);
		Route route18 = new Route(18, planetlist.get(19), planetlist.get(18), 14.22d);
		Route route19 = new Route(19, planetlist.get(18), planetlist.get(14), 6.02d);
		Route route20 = new Route(20, planetlist.get(14), planetlist.get(20), 5.26d);
		Route route21 = new Route(21, planetlist.get(9), planetlist.get(19), 12.34d);
		Route route22 = new Route(22, planetlist.get(19), planetlist.get(15), 10.10d);
		Route route23 = new Route(23, planetlist.get(19), planetlist.get(36), 9.95d);
		
		Route route24 = new Route(24, planetlist.get(25), planetlist.get(24), 18.91d);
		Route route25 = new Route(25, planetlist.get(24), planetlist.get(16), 22.04d);
		Route route26 = new Route(26, planetlist.get(16), planetlist.get(23), 10.51d);
		Route route27 = new Route(27, planetlist.get(36), planetlist.get(23), 23.61d);
		Route route28 = new Route(28, planetlist.get(23), planetlist.get(36), 19.94d);
		Route route29 = new Route(29, planetlist.get(15), planetlist.get(20), 9.31d);
		Route route30 = new Route(30, planetlist.get(20), planetlist.get(36), 21.23d);
		Route route31 = new Route(31, planetlist.get(20), planetlist.get(35), 25.96d);
		Route route32 = new Route(32, planetlist.get(35), planetlist.get(21), 3.16d);
		
		Route route33 = new Route(33, planetlist.get(36), planetlist.get(21), 20.42d);
		Route route34 = new Route(34, planetlist.get(35), planetlist.get(35), 17.10d);
		Route route35 = new Route(35, planetlist.get(24), planetlist.get(26), 19.52d);
		Route route36 = new Route(36, planetlist.get(26), planetlist.get(27), 31.56d);
		Route route37 = new Route(37, planetlist.get(27), planetlist.get(28), 23.13d);
		Route route38 = new Route(38, planetlist.get(36), planetlist.get(22), 28.89d);
		Route route39 = new Route(39, planetlist.get(22), planetlist.get(28), 10.64d);
		Route route40 = new Route(40, planetlist.get(22), planetlist.get(30), 36.19d);
		
		Route route41 = new Route(41, planetlist.get(28), planetlist.get(29), 36.48d);
		Route route42 = new Route(42, planetlist.get(30), planetlist.get(30), 41.26d);
		Route route43 = new Route(43, planetlist.get(30), planetlist.get(31), 42.07d);
		Route route44 = new Route(44, planetlist.get(31), planetlist.get(32), 17.63d);
		Route route45 = new Route(45, planetlist.get(32), planetlist.get(33), 40.48d);
		
		routeList.add(route1);
		routeList.add(route2);
		routeList.add(route3);
		routeList.add(route4);
		routeList.add(route5);
		routeList.add(route6);
		routeList.add(route7);
		routeList.add(route8);
		routeList.add(route9);
		
		routeList.add(route10);
		routeList.add(route11);
		routeList.add(route12);
		routeList.add(route13);
		routeList.add(route14);
		routeList.add(route15);
		routeList.add(route16);
		
		routeList.add(route17);
		routeList.add(route18);
		routeList.add(route19);
		routeList.add(route20);
		routeList.add(route21);
		routeList.add(route22);
		routeList.add(route23);
		routeList.add(route24);
		
		routeList.add(route25);
		routeList.add(route26);
		routeList.add(route27);
		routeList.add(route28);
		routeList.add(route29);
		routeList.add(route30);
		routeList.add(route31);
		routeList.add(route32);
		routeList.add(route33);
		
		routeList.add(route34);
		routeList.add(route35);
		routeList.add(route36);
		routeList.add(route37);
		routeList.add(route38);
		routeList.add(route39);
		routeList.add(route40);
		
		routeList.add(route41);
		routeList.add(route42);
		routeList.add(route43);
		routeList.add(route44);
		routeList.add(route45);

		return routeList;
	}

}
