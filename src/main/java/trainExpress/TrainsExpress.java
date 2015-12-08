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

	public List<Route> getFastestRroute(TrainStation origin, TrainStation destination) {
		fastestRoute.clear();
		findQuickestRoute(origin, destination, new ArrayList<>(), new ArrayList<>());
		return this.fastestRoute;
	}

	private void findQuickestRoute(TrainStation origin, TrainStation destination, List<TrainStation> visitedStations,
			List<Route> calculatedRoute) {

		List<Route> stationRoutes = origin.getRoutes();
		visitedStations.add(origin);

		TrainStation routeDestination;
		for (Route route : stationRoutes) {

			routeDestination = route.getDestination();

			if (visitedStations.contains(routeDestination)) {
				continue;
			}

			calculatedRoute.add(route);

			if (routeDestination == destination) {
				if (calculateRouteDuration(fastestRoute) > calculateRouteDuration(calculatedRoute)
						|| fastestRoute.isEmpty()) {
					fastestRoute = new ArrayList<>(calculatedRoute);
				}
				calculatedRoute.remove(route);
			} else {
				findQuickestRoute(routeDestination, destination, visitedStations, calculatedRoute);
			}
			calculatedRoute.remove(route);

		}

		visitedStations.remove(origin);
		calculatedRoute.removeAll(stationRoutes);

	}

	public static int calculateRouteDuration(List<Route> routes) {

		int total = 0;
		for (Route route : routes) {
			total += route.getDuration();
		}
		return total;
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
