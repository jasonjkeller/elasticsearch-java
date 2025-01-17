/*
 * Licensed to Elasticsearch B.V. under one or more contributor
 * license agreements. See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Elasticsearch B.V. licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */

package co.elastic.clients.elasticsearch.features;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.util.Collections;
import java.util.Objects;

//----------------------------------------------------------------
//       THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------------------
//
// This code is generated from the Elasticsearch API specification
// at https://github.com/elastic/elasticsearch-specification
//
// Manual updates to this file will be lost when the code is
// re-generated.
//
// If you find a property that is missing or wrongly typed, please
// open an issue or a PR on the API specification repository.
//
//----------------------------------------------------------------

// typedef: features.reset_features.Request

/**
 * Reset the features. Clear all of the state information stored in system
 * indices by Elasticsearch features, including the security and machine
 * learning indices.
 * <p>
 * WARNING: Intended for development and testing use only. Do not reset features
 * on a production cluster.
 * <p>
 * Return a cluster to the same state as a new installation by resetting the
 * feature state for all Elasticsearch features. This deletes all state
 * information stored in system indices.
 * <p>
 * The response code is HTTP 200 if the state is successfully reset for all
 * features. It is HTTP 500 if the reset operation failed for any feature.
 * <p>
 * Note that select features might provide a way to reset particular system
 * indices. Using this API resets all features, both those that are built-in and
 * implemented as plugins.
 * <p>
 * To list the features that will be affected, use the get features API.
 * <p>
 * IMPORTANT: The features installed on the node you submit this request to are
 * the features that will be reset. Run on the master node if you have any
 * doubts about which plugins are installed on individual nodes.
 * 
 * @see <a href="../doc-files/api-spec.html#features.reset_features.Request">API
 *      specification</a>
 */

public class ResetFeaturesRequest extends RequestBase {
	public ResetFeaturesRequest() {
	}

	/**
	 * Singleton instance for {@link ResetFeaturesRequest}.
	 */
	public static final ResetFeaturesRequest _INSTANCE = new ResetFeaturesRequest();

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code features.reset_features}".
	 */
	public static final Endpoint<ResetFeaturesRequest, ResetFeaturesResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>(
			"es/features.reset_features",

			// Request method
			request -> {
				return "POST";

			},

			// Request path
			request -> {
				return "/_features/_reset";

			},

			// Path parameters
			request -> {
				return Collections.emptyMap();
			},

			// Request parameters
			request -> {
				return Collections.emptyMap();

			}, SimpleEndpoint.emptyMap(), false, ResetFeaturesResponse._DESERIALIZER);
}
