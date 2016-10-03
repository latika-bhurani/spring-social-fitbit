package org.springframework.social.fitbit.api.activity.impl;

import java.util.Date;

import org.springframework.social.fitbit.api.impl.AbstractFitbitApiOperations;
import org.springframework.social.fitbit.util.TimeUtils;
import org.springframework.web.client.RestTemplate;

public class ActivityTemplate extends AbstractFitbitApiOperations implements ActivityOperations {

	public ActivityTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	private String buildIntradayActivityEndpoint(ResourceType resourceType, Granularity detailLevel, 
    		String baseDate, String startTime, String endTime) {
    	StringBuilder url = new StringBuilder()
        .append(resourceType.getResourcePath())
        .append("/date/" + baseDate)
        .append("/1d/" + detailLevel.getDetailFormat())
        .append(endTime == null ? "" : "/time/" + startTime + "/" + endTime)
        .append(".json");
        return url.toString();
    }
	
	private String getData(ResourceType resourceType, Granularity detailLevel, 
    		String baseDate, String startTime, String endTime){
		String url = buildIntradayActivityEndpoint(resourceType, detailLevel, baseDate , startTime, endTime);
		return getEntity(url, String.class);
	}
	
	@Override
	public String getIntradaySteps(Granularity detailLevel, Date baseDate) {
		return getIntradaySteps(detailLevel, TimeUtils.LOCAL_DATE_FORMATTER.format(baseDate), 
				null, null);
	}

	@Override
	public String getIntradaySteps(Granularity detailLevel, String baseDate) {
		return getIntradaySteps(detailLevel, baseDate, null, null);
	}

	@Override
	public String getIntradaySteps(Granularity detailLevel, Date baseDate, Date startTime, Date endTime) {
		return getIntradaySteps(detailLevel, TimeUtils.LOCAL_DATE_FORMATTER.format(baseDate), 
				TimeUtils.LOCAL_TIME_HOURS_MINUTES_FORMATTER.format(startTime),
				TimeUtils.LOCAL_TIME_HOURS_MINUTES_FORMATTER.format(endTime));
	}

	@Override
	public String getIntradaySteps(Granularity detailLevel, String baseDate, String startTime, String endTime) {
		return getData(ResourceType.STEPS, detailLevel, baseDate , startTime, endTime);
	}
}