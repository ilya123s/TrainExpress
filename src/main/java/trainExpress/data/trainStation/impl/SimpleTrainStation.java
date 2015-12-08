package main.java.trainExpress.data.trainStation.impl;

import java.util.List;

import main.java.trainExpress.data.Route;
import main.java.trainExpress.data.trainStation.TrainStation;

/**
 * Simple train station implementation. Contains the station name and all the
 * routes from this station.
 * 
 * @author Ilya
 *
 */
public class SimpleTrainStation implements TrainStation {

	private String stationName;

	private List<Route> routes;

	/**
	 * Creates a simple train station with the station name and list of routes
	 * from this station.
	 * 
	 * @param stationName
	 * @param routes
	 */
	public SimpleTrainStation(String stationName, List<Route> routes) {
		this.stationName = stationName;
		this.routes = routes;
	}

	/**
	 * Returns the station name
	 */
	@Override
	public String getStationName() {
		return this.stationName;
	}

	/**
	 * Returns the list of routes from this station
	 */
	@Override
	public List<Route> getRoutes() {
		return this.routes;
	}

	/**
	 * Adds a route from this station. If route is null then it will not be
	 * added.
	 */
	@Override
	public void addRoute(Route route) {
		if (null != route) {
			routes.add(route);
		}
	}

}
