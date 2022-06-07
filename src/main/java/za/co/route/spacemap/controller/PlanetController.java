package za.co.route.spacemap.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import za.co.route.spacemap.services.PlanetServiceImplementation;

/**
 * @author Vannessa
 *
 */


@Controller
public class PlanetController {
	
	@Autowired
	private PlanetServiceImplementation planetServiceImplementation;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String showHomePage(ModelMap map) {
		map.put("planets", planetServiceImplementation.getAll());
		return "index";
	}
		
		@RequestMapping(value ="/listPlanets", method =RequestMethod.GET)
			public String showAllPlanets(ModelMap map) {
				map.put("planets", planetServiceImplementation.getAll());
				return "list-planets";
		
	
		
	}
}
