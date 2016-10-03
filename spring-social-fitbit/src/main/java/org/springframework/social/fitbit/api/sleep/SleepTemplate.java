package org.springframework.social.fitbit.api.sleep;

import java.util.Date;

import org.springframework.social.fitbit.api.impl.AbstractFitbitApiOperations;
import org.springframework.social.fitbit.util.TimeUtils;
import org.springframework.web.client.RestTemplate;

public class SleepTemplate extends AbstractFitbitApiOperations implements SleepOperations {

	public SleepTemplate(RestTemplate restTemplate, boolean isAuthorized) {
		super(restTemplate, isAuthorized);
	}

	@Override
	public void getMinutesAsleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getMinutesAwake() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getAwakeningsCount() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getTimeInBed() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getMinutesToFallAsleep() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getMinutesAfterWakeup() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getStartTime() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getEfficiency() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Sleep getSleep(Date date) {
		return getSleep(TimeUtils.LOCAL_DATE_FORMATTER.format(date));
	}

	@Override
	public Sleep getSleep(String baseDate) {
		Sleep sleep = getEntity(String.format(SLEEP, baseDate), Sleep.class);
		return sleep;
	}
}
