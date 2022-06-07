package za.co.route.spacemap.models;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class PlanetRoute {
	
	@Id
	private int routeId;
	private String planetOrigin;
	private String planetDestination;
	private double distance;
	
	
	public PlanetRoute() {}
	
	public PlanetRoute(int routeId, String planetOrigin, String planetDestination) {
		this.routeId=routeId;
		this.planetOrigin=planetOrigin;
		this.planetDestination=planetDestination;
			
	}
	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Route[routeId=");
		buffer.append(routeId);
		buffer.append(",planetOrigin=");
		buffer.append(planetOrigin);
		buffer.append(", planetDestination");
		buffer.append(planetDestination);
		buffer.append(",distane");
		buffer.append(distance);
		buffer.append("]");
		return buffer.toString();
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public String getPlanetOrigin() {
		return planetOrigin;
	}

	public void setPlanetOrigin(String planetOrigin) {
		this.planetOrigin = planetOrigin;
	}

	public String getPlanetDestination() {
		return planetDestination;
	}

	public void setPlanetDestination(String planetDestination) {
		this.planetDestination = planetDestination;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double d) {
		this.distance = d;
	}
	

}
