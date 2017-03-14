
public class ThingThatCallsService {

	private int multiplier;

	public ThingThatItReturns callThatCallsService(int multiplier) {
		
		this.multiplier = multiplier;
		
		// Maybe service has to be initialized (not shown) and takes a long time:
		Service service = new Service();
		
		//Maybe this like a long time:
		ThingYouGetFromTheService thingYouGetFromTheService = service.getTheThing();

		return performCalculation(thingYouGetFromTheService);
	}

	public ThingThatItReturns performCalculation(ThingYouGetFromTheService thingYouGetFromTheService) {

		return new ThingThatItReturns(thingYouGetFromTheService.getValue() * multiplier);
	}

}
