package za.co.route.spacemap.controller;

import java.util.LinkedList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import za.co.route.spacemap.models.CalculatePage;
import za.co.route.spacemap.models.Planet;
import za.co.route.spacemap.services.DistanceCal;


/**
 * @author Vannessa
 *
 */

@Controller
public class DistanceController {
	

	@Autowired
	private DistanceCal distanceCal;
	
//	public DistanceController(DistanceCal distanceCal) {
//		this.distanceCal = distanceCal;
//	}
	
	private LinkedList<Planet> shortDistance= null;
	
	@RequestMapping(value="/calculateDistance", method=RequestMethod.GET)
	public String showCalculatePage(ModelMap model) {
		model.addAttribute("calculatePage", new CalculatePage("A","B"));
		return "calculate";
		
	}
	
	
	
	@RequestMapping(value="/calculateDistance", method=RequestMethod.POST)
	public String calculatePage(ModelMap map, CalculatePage page, BindingResult result) {
		if(result.hasErrors()) {
			return "calculate";
		}
		
		this.shortDistance=distanceCal.calculateDistance(page.getPlanetOrigin(), 
				page.getPlanetDestination());
			
				map.put("symbols" , shortDistance);
				
				return "calculate";
		
	}		

}
