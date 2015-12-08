package main.java.trainExpress;

import java.util.ArrayList;
import java.util.List;

import main.java.trainExpress.data.Route;
import main.java.trainExpress.data.trainStation.TrainStation;
import main.java.trainExpress.data.trainStation.impl.SimpleTrainStation;

public class TrainsExpress {

	private List<Route> fastestRoute;

	// public static void main(String[] args) {
	// List<TrainStation> trainStations = initialiseStationsAndRoutes();
	//
	// List<Route> quickestRoute = findQuickestRoute(trainStations.get(1),
	// trainStations.get(3),
	// new ArrayList<TrainStation>());
	// System.out.println("----");
	// for (Route route : fastestRoute) {
	// System.out.println(route.getDestination().getStationName() + " " +
	// route.getDuration());
	// }
	// System.out.println(calculateRouteDuration(fastestRoute));
	// System.out.println("----");
	// for (Route route : quickestRoute) {
	// System.out.println(route.getDestination().getStationName() + " " +
	// route.getDuration());
	// }
	// }

	/**
	 * 
	 * @param origin
	 * @param destination
	 * @return
	 */
	public List<Route> getFastestRroute(TrainStation origin, TrainStation destination) {
		fastestRoute.clear();
		findQuickestRoute(origin, destination, new ArrayList<>(), new ArrayList<>());
		return this.fastestRoute;
	}

	/**
	 * Method to find the fastest route from origin to destination. Takes in
	 * visited stations and already calculated routes to not back track over
	 * already calculated routes. Will set the class variable to the fastest
	 * route calculated.
	 * 
	 * @param origin
	 * @param destination
	 * @param visitedStations
	 * @param calculatedRoute
	 */
	private void findQuickestRoute(TrainStation origin, TrainStation destination, List<TrainStation> visitedStations,
			List<Route> calculatedRoute) {

		// Get the routes from this station and add the origin to the list of
		// visited stations.
		List<Route> stationRoutes = origin.getRoutes();
		visitedStations.add(origin);

		TrainStation routeDestination;

		// Loop through each route for this origin train station.
		for (Route route : stationRoutes) {

			// get the destination of the route.
			routeDestination = route.getDestination();

			// If the destination of this route is already in the visited
			// stations then we do not want to calculate any more routes from it
			// as we have already been there. Carry onto the next route.
			if (visitedStations.contains(routeDestination)) {
				continue;
			}

			// If we haven't been to the destination of the route then add the
			// route to list of calculate routes.
			calculatedRoute.add(route);

			// Check to see if the destination of this route is the final
			// destination we are looking for for this journey.
			if (routeDestination == destination) {

				// If it is then calculate whether it is faster than the already
				// calculated fastest route.
				if (calculateRouteDuration(fastestRoute) > calculateRouteDuration(calculatedRoute)
						|| fastestRoute.isEmpty()) {

					// Since the calculated route to this destination is faster
					// than the already saved fastest route, then make a new
					// copy of the calculated route and save it as the fastest
					// route.
					fastestRoute = new ArrayList<>(calculatedRoute);
				}
			} else {

				// As the station destination of this route is not the one we
				// want, check all of the routes from this station as well.
				findQuickestRoute(routeDestination, destination, visitedStations, calculatedRoute);
			}

			// Once we have checked the route from the origin and calculated
			// whether it is one of the fastest routes to the destination,
			// remove it from the calculated routes.
			calculatedRoute.remove(route);

		}

		// Once we have worked out all possible routes from this origin then
		// remove this station from the visited stations and the all it's routes
		// from the calculated routes.
		visitedStations.remove(origin);
		calculatedRoute.removeAll(stationRoutes);

	}

	/**
	 * Method returns the total duration of the routes in the list of routes
	 * provided.
	 * 
	 * @param routes
	 * @return Total duration of all routes
	 */
	public static int calculateRouteDuration(List<Route> routes) {

		int totalDuration = 0;

		// If the list of routes is not null then loop through it.
		if (null != routes) {
			for (Route route : routes) {

				// if the route is not null then add it's duration to the total.
				if (null != route) {
					totalDuration += route.getDuration();
				}
			}
		}
		return totalDuration;
	}

	public List<TrainStation> initialiseStationsAndRoutes() {

		List<TrainStation> trainStations = new ArrayList<>();
		fastestRoute = new ArrayList<Route>();

		TrainStation a = new SimpleTrainStation("A", new ArrayList<Route>());
		TrainStation b = new SimpleTrainStation("B", new ArrayList<Route>());
		TrainStation c = new SimpleTrainStation("C", new ArrayList<Route>());
		TrainStation d = new SimpleTrainStation("D", new ArrayList<Route>());
		TrainStation e = new SimpleTrainStation("E", new ArrayList<Route>());

		trainStations.add(a);
		trainStations.add(b);
		trainStations.add(c);
		trainStations.add(d);
		trainStations.add(e);

		a.addRoute(new Route(b, 3));
		a.addRoute(new Route(d, 6));
		b.addRoute(new Route(a, 3));
		b.addRoute(new Route(c, 7));
		c.addRoute(new Route(d, 8));
		c.addRoute(new Route(e, 3));
		d.addRoute(new Route(e, 9));
		d.addRoute(new Route(c, 9));
		d.addRoute(new Route(b, 5));
		e.addRoute(new Route(d, 9));

		return trainStations;

	}

}
