import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ThingThatCallsServiceTest {

	@Test
	public void impracticalTestCallingRealService() {
		ThingThatCallsService thingThatCallsService = new ThingThatCallsService();

		ThingThatItReturns actualResultOfCalculation = thingThatCallsService.callThatCallsService(3);
		
		Integer expectedResultOfCalculation = 15;
		assertEquals(expectedResultOfCalculation, actualResultOfCalculation.getValue());
	}

	@Mock
	Service mockService;

	@InjectMocks
	ThingThatCallsService autowiredThingThatCallsService;

	@Test
	public void testWithMock() {
		ThingThatCallsService autowiredThingThatCallsService;
		ThingYouGetFromTheService mockItemThatServiceWouldReturn = new ThingYouGetFromTheService(7);
		when(mockService.getTheThing()).thenReturn(mockItemThatServiceWouldReturn);

		ThingThatItReturns actualResultOfCalculation = autowiredThingThatCallsService.callThatCallsService(3);
		
		Integer expectedResultOfCalculation = 21;
		assertEquals(expectedResultOfCalculation, actualResultOfCalculation.getValue());
	}
}
