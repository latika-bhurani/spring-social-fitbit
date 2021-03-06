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
package org.springframework.social.fitbit.api;

import org.springframework.util.MultiValueMap;

/**
 * Defines low-level operations against Facebook's Graph API
 * @author Craig Walls
 */
public interface FitbitApi {
	
	/**
	 * Fetches an object, extracting it into the given Java type
	 * Requires appropriate permission to fetch the object.
	 * @param objectId the Facebook object's ID
	 * @param type the Java type to fetch
	 * @param <T> The Java type to bind the Facebook object to
	 * @return an Java object representing the requested Facebook object.
	 */
	<T> T fetchObject(String objectId, Class<T> type);

	/**
	 * Fetches an object, extracting it into the given Java type
	 * Requires appropriate permission to fetch the object.
	 * @param objectId the Facebook object's ID
	 * @param type the Java type to fetch
	 * @param fields the fields to include in the response.
	 * @param <T> The Java type to bind the Facebook object to
	 * @return an Java object representing the requested Facebook object.
	 */
	<T> T fetchObject(String objectId, Class<T> type, String... fields);

	/**
	 * Fetches an object, extracting it into the given Java type
	 * Requires appropriate permission to fetch the object.
	 * @param objectId the Facebook object's ID
	 * @param type the Java type to fetch
	 * @param queryParameters query parameters to include in the request
	 * @param <T> The Java type to bind the Facebook object to
	 * @return an Java object representing the requested Facebook object.
	 */
	<T> T fetchObject(String objectId, Class<T> type, MultiValueMap<String, String> queryParameters);

	/**
	 * Deletes an object connection.
	 * Requires appropriate permission to delete the object connection.
	 * @param objectId the object ID
	 * @param connectionName the connection name
	 */
	void delete(String objectId, String connectionName);

	/**
	 * Deletes an object connection.
	 * Requires appropriate permission to delete the object connection.
	 * @param objectId the object ID
	 * @param connectionName the connection name
	 * @param data parameters for the delete request
	 */
	void delete(String objectId, String connectionName, MultiValueMap<String, String> data);

	/**
	 * @return The application namespace associated with this GraphApi instance. Useful for interacting with Facebook's OpenGraph actions.
	 * 			May be null if no namespace was specified.
	 */
	String getApplicationNamespace();
	
	/**
	 * @return The base URL for the Graph API.
	 */
	String getBaseGraphApiUrl();
	
	/**
	 * @deprecated Use getBaseGraphApiUrl() instead.
	 */
	@Deprecated
	static final String GRAPH_API_URL = "https://graph.facebook.com/v2.5/";

}
