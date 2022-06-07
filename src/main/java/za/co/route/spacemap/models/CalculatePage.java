package za.co.route.spacemap.models;

public class CalculatePage {

	
	private String planetDestination;
	private String planetOrigin;
	
	public CalculatePage(String destination, String origin ){
		super();
		this.planetDestination= destination;
		this.planetOrigin=origin;
		
	}

	public String getPlanetDestination() {
		return planetDestination;
	}

	public void setPlanetDestination(String planetDestination) {
		this.planetDestination = planetDestination;
	}

	public String getPlanetOrigin() {
		return planetOrigin;
	}

	public void setPlanetOrigin(String planetOrigin) {
		this.planetOrigin = planetOrigin;
	}
	
	
}
