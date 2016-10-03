/*
 * Copyright 2015 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.social.fitbit.connect;

import org.springframework.social.connect.support.OAuth2ConnectionFactory;
import org.springframework.social.fitbit.api.Fitbit;

/**
 * Facebook ConnectionFactory implementation.
 * @author Keith Donald
 * @author Craig Walls
 */
public class FitbitConnectionFactory extends OAuth2ConnectionFactory<Fitbit> {

/*	@Override
	protected String extractProviderUserId(AccessGrant accessGrant) {
		Google api = ((GoogleServiceProvider)getServiceProvider()).getApi(accessGrant.getAccessToken());
	    UserProfile userProfile = getApiAdapter().fetchUserProfile(api);
	    return userProfile.getUsername();
	}
*/	/**
	 * Creates a FacebookConnectionFactory for the given application ID and secret.
	 * Using this constructor, no application namespace is set (and therefore Facebook's Open Graph operations cannot be used).
	 * @param appId The application's App ID as assigned by Facebook 
	 * @param appSecret The application's App Secret as assigned by Facebook
	 */
	public FitbitConnectionFactory(String appId, String appSecret) {
		super("fitbit", new FitbitServiceProvider(appId, appSecret), new FitbitAdapter());
	}

}
