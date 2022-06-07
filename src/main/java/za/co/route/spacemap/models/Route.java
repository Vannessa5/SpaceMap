package za.co.route.spacemap.models;

public class Route {
	private int routeId;
	private Planet planetOrigin;
	private Planet planetDestination;
	private double distance;
	
	public Route() {}
	
	public Route(int routeId, Planet planetOrigin, Planet planetDestination, double distance) {
		super();
		this.routeId = routeId;
		this.planetOrigin = planetOrigin;
		this.planetDestination = planetDestination;
		this.distance = distance;
	}

	public int getRouteId() {
		return routeId;
	}

	public void setRouteId(int routeId) {
		this.routeId = routeId;
	}

	public Planet getPlanetOrigin() {
		return planetOrigin;
	}

	public void setPlanetOrigin(Planet planetOrigin) {
		this.planetOrigin = planetOrigin;
	}

	public Planet getPlanetDestination() {
		return planetDestination;
	}

	public void setPlanetDestination(Planet planetDestination) {
		this.planetDestination = planetDestination;
	}

	public double getDistance() {
		return distance;
	}

	public void setDistance(double distance) {
		this.distance = distance;
	}

	@Override
	public String toString() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("Route [routeId=");
		buffer.append(", planetOrigin=");
		buffer.append(planetOrigin);
		buffer.append(", planetDestination=");
		buffer.append(planetDestination);
		buffer.append(", distance=");
		buffer.append(distance);
		buffer.append("]");
		return buffer.toString();
	}
	
	

}
