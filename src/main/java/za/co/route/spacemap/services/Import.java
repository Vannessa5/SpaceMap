package za.co.route.spacemap.services;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.PostConstruct;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.ResourceUtils;

import com.fasterxml.jackson.databind.exc.InvalidFormatException;

import za.co.route.spacemap.models.Planet;
import za.co.route.spacemap.models.PlanetRoute;

/**
 * @author Vannessa
 *
 */
@Component
public class Import {
	
	@Autowired
	private PlanetServiceImplementation planetServiceImpl;
	 
	@Autowired
	private RouteServiceImplementation routeServiceImpl;
	
	Map<String, Planet> planetMap;
	
	@PostConstruct
	public void importAndPersist() throws IOException, EncryptedDocumentException, InvalidFormatException, org.apache.poi.openxml4j.exceptions.InvalidFormatException {
		Workbook workbook = WorkbookFactory.create((ResourceUtils.getFile("classpath:data.xlsx")));
		List<Planet> planetList = this.extractSheetOne(workbook);
		List<PlanetRoute> routeList = this.extractSheetTwo(workbook);
		this.saveToDatabase(planetList, routeList);
	}
	

	private void saveToDatabase(List<Planet> planetList, List<PlanetRoute> routeList) {
		this.planetServiceImpl.savePlanets(planetList);
		this.routeServiceImpl.saveRoutes(routeList);
	}

	private List<Planet> extractSheetOne(Workbook workbook){
		Sheet sheet = workbook.getSheetAt(0);
		planetMap = new HashMap<>();
		List<Planet> planetList = new ArrayList<>();
		sheet.forEach(row -> {
			if(!(row.getRowNum() == 0)) {
				Planet planet = new Planet();
				row.forEach(cell -> {
					switch(cell.getColumnIndex()) {
					case 0:
						planet.setPlanetSymbol(cell.getRichStringCellValue().getString());
						break;
					case 1:
						planet.setPlanetName(cell.getRichStringCellValue().getString());
						break;
					default:
						System.out.println("");
					}
					planetMap.put(planet.getPlanetSymbol(), planet);
				});
				planetList.add(planet);
			}
		});
		return planetList;
	}
	
	private List<PlanetRoute> extractSheetTwo(Workbook workbook){
		Sheet sheet = workbook.getSheetAt(1);
		List<PlanetRoute> routeList = new ArrayList<>();
		sheet.forEach(row -> {
			if(!(row.getRowNum() == 0)) {
				PlanetRoute route = new PlanetRoute();
				row.forEach(cell -> {
					switch (cell.getColumnIndex()) {
					case 0:
						route.setRouteId((int) cell.getNumericCellValue());
						break;
					case 1:
						route.setPlanetOrigin(cell.getRichStringCellValue().getString());
						break;
					case 2:
						route.setPlanetDestination(cell.getRichStringCellValue().getString());
						break;
					case 3:
						route.setDistance(cell.getNumericCellValue());
						break;

					default:
						System.out.println(" ");
						break;
					}
				});
				routeList.add(route);
			}
		});
		
		
		return routeList;
	}
	
		
		

}
