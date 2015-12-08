package main.java.trainExpress.data.trainStation;

import java.util.List;

import main.java.trainExpress.data.Route;

/**
 * Interface for common Train Station functionality.
 * 
 * @author Ilya
 *
 */
public interface TrainStation {

	/**
	 * Will return the name of the station.
	 * 
	 * @return Station Name
	 */
	public String getStationName();

	/**
	 * Gets the all routes from this station
	 * 
	 * @return List of Routes
	 */
	public List<Route> getRoutes();

	/**
	 * Add route to the station
	 * 
	 * @param route
	 */
	public void addRoute(Route route);

}
