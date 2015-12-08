package main.java.trainExpress.data;

import main.java.trainExpress.data.trainStation.TrainStation;

/**
 * Route class contains information of a route from a station. Holds the train
 * station destination and the duration of the journey to that destination.
 * 
 * @author Ilya
 *
 */
public class Route {

	private TrainStation destination;

	private int duration;

	/**
	 * Creates a route with the destination and duration of the journey set.
	 * 
	 * @param destination
	 * @param duration
	 */
	public Route(TrainStation destination, int duration) {
		this.destination = destination;
		this.duration = duration;

	}

	public void setDestination(TrainStation destination) {
		this.destination = destination;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public TrainStation getDestination() {
		return this.destination;
	}

	public int getDuration() {
		return this.duration;
	}

}
