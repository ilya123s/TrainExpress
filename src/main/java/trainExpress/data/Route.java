package main.java.trainExpress.data;

import main.java.trainExpress.data.trainStation.TrainStation;

public class Route implements Comparable<Route>{
	
	private TrainStation destination;

	private int duration;
	
	public Route(TrainStation destination, int duration){
		this.destination = destination;
		this.duration = duration;
		
	}
	
	public TrainStation getDestination(){
		return this.destination;
	}
	
	public int getDuration(){
		return this.duration;
	}
	

	@Override
	public int compareTo(Route route) {
		int compareValue = 0;;
		
		if(this.duration > route.getDuration()){
			compareValue = 1;
		} else if (this.duration < route.getDuration()){
			compareValue = -1;
		}
		return compareValue;
	}

}
