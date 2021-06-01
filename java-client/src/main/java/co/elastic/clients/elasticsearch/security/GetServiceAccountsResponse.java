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

//----------------------------------------------------
// THIS CODE IS GENERATED. MANUAL EDITS WILL BE LOST.
//----------------------------------------------------

package co.elastic.clients.elasticsearch.security;

import co.elastic.clients.base.AdditionalProperties;
import co.elastic.clients.elasticsearch.security.get_service_accounts.RoleDescriptorWrapper;
import co.elastic.clients.json.DelegatingJsonpValueParser;
import co.elastic.clients.json.JsonpObjectBuilderParser;
import co.elastic.clients.json.JsonpObjectParser;
import co.elastic.clients.json.JsonpValueParser;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.String;

// typedef: security.get_service_accounts.Response
public final class GetServiceAccountsResponse extends AdditionalProperties<String, RoleDescriptorWrapper> {
	// ---------------------------------------------------------------------------------------------

	protected GetServiceAccountsResponse(Builder builder) {
		super(builder);

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link GetServiceAccountsResponse}.
	 */
	public static class Builder extends AdditionalProperties.AbstractBuilder<String, RoleDescriptorWrapper, Builder>
			implements
				ObjectBuilder<GetServiceAccountsResponse> {
		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link GetServiceAccountsResponse}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public GetServiceAccountsResponse build() {
			super.tKeySerializer(null);
			super.tValueSerializer(null);

			return new GetServiceAccountsResponse(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Json parser for GetServiceAccountsResponse
	 */
	public static final JsonpValueParser<GetServiceAccountsResponse> JSONP_PARSER = JsonpObjectBuilderParser
			.createForObject(Builder::new, GetServiceAccountsResponse::setupGetServiceAccountsResponseParser);

	protected static void setupGetServiceAccountsResponseParser(
			DelegatingJsonpValueParser<GetServiceAccountsResponse.Builder> op) {
		AdditionalProperties.setupAdditionalPropertiesParser(op, JsonpValueParser.stringParser(),
				RoleDescriptorWrapper.JSONP_PARSER);

	}

}