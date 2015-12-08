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

	public SimpleTrainStation(String stationName, List<Route> routes) {
		this.stationName = stationName;
		this.routes = routes;
	}

	@Override
	public String getStationName() {
		return this.stationName;
	}

	@Override
	public List<Route> getRoutes() {
		return this.routes;
	}

	@Override
	public void addRoute(Route route) {
		if (null != route) {
			routes.add(route);
		}
	}

}
