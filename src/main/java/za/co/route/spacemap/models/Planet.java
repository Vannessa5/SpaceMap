package za.co.route.spacemap.models;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Planet {
	
	@Id
	private String planetSymbol;
	private String planetName;
	
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Planet[planetSymbol=");
		buffer.append(planetSymbol);
		buffer.append("planetName=");
		buffer.append(planetName);
		buffer.append("]");
		return buffer.toString();
		
			}
	
	public Planet() {}
	
	public Planet(String planetSymnol, String planetName) {
		this.planetName=planetName;
		this.planetSymbol=planetSymbol;
		
	}

	public String getPlanetSymbol() {
		return planetSymbol;
	}

	public void setPlanetSymbol(String planetSymbol) {
		this.planetSymbol = planetSymbol;
	}

	public String getPlanetName() {
		return planetName;
	}

	public void setPlanetName(String planetName) {
		this.planetName = planetName;
	}
	
	

}
