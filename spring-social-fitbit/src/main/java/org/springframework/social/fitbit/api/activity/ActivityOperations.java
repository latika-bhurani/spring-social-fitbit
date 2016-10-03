package org.springframework.social.fitbit.api.activity;

import java.util.Date;

public interface ActivityOperations {

	public static final String DEVICE_URL = "device.json";
	
	String getIntradaySteps(Granularity detailLevel, Date baseDate);
	String getIntradaySteps(Granularity detailLevel, String baseDate);
	String getIntradaySteps(Granularity detailLevel, Date baseDate, Date startTime, Date endTime);
	String getIntradaySteps(Granularity detailLevel, String baseDate,String startTime, String endTime);
	
	/*String getIntradayCalories();
	String getIntradayCaloriesBMR();
	String getDistance();
	String getIntradayFloors();
	String getIntradayElevation();
	String getIntradayMinutesSedentary();
	String getIntradayMinutesLightlyActive();
	String getIntradayMinutesFairlyActive();
	String getIntradayMinutesVeryActive();
	String getIntradayActivityCalories();
	String getIntradayHeart();*/
		
}
