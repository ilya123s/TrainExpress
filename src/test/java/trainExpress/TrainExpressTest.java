package test.java.trainExpress; 

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Before;
import org.junit.Test;

import main.java.trainExpress.TrainsExpress;
import main.java.trainExpress.data.Route;
import main.java.trainExpress.data.trainStation.TrainStation;


public class TrainExpressTest {
	
	TrainsExpress classUnderTest;
	
	List<TrainStation> stations;
	
	@Before
	public void setup(){
		
		classUnderTest = new TrainsExpress();
		stations = classUnderTest.initialiseStationsAndRoutes();
	}

	
	@Test
	public void testAtoB(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(0), stations.get(1));
		assertEquals(3, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testAtoC(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(0), stations.get(2));
		assertEquals(10, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testAtoD(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(0), stations.get(3));
		assertEquals(6, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testAtoE(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(0), stations.get(4));
		assertEquals(13, TrainsExpress.calculateRouteDuration(result));
	}
	
	@Test
	public void testBtoA(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(1), stations.get(0));
		assertEquals(3, TrainsExpress.calculateRouteDuration(result));
	}
	
	@Test
	public void testBtoC(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(1), stations.get(2));
		assertEquals(7, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testBtoD(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(1), stations.get(3));
		assertEquals(9, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testBtoE(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(1), stations.get(4));
		assertEquals(10, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testCtoA(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(2), stations.get(0));
		assertEquals(16, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testCtoB(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(2), stations.get(1));
		assertEquals(13, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testCtoD(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(2), stations.get(3));
		assertEquals(8, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testCtoE(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(2), stations.get(4));
		assertEquals(3, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testDtoA(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(3), stations.get(0));
		assertEquals(8, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testDtoB(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(3), stations.get(1));
		assertEquals(5, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testDtoC(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(3), stations.get(2));
		assertEquals(9, TrainsExpress.calculateRouteDuration(result));
	}
	
	@Test
	public void testDtoE(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(3), stations.get(4));
		assertEquals(9, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testEtoA(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(4), stations.get(0));
		assertEquals(17, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testEtoB(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(4), stations.get(1));
		assertEquals(14, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testEtoC(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(4), stations.get(2));
		assertEquals(18, TrainsExpress.calculateRouteDuration(result));
	}

	@Test
	public void testEtoD(){
		List<Route> result = classUnderTest.getFastestRroute(stations.get(4), stations.get(3));
		assertEquals(9, TrainsExpress.calculateRouteDuration(result));
	}

}
