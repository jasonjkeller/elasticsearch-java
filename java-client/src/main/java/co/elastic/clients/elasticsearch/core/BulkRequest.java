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

package co.elastic.clients.elasticsearch.core;

import co.elastic.clients.elasticsearch._types.ErrorResponse;
import co.elastic.clients.elasticsearch._types.Refresh;
import co.elastic.clients.elasticsearch._types.RequestBase;
import co.elastic.clients.elasticsearch._types.Time;
import co.elastic.clients.elasticsearch._types.WaitForActiveShards;
import co.elastic.clients.elasticsearch.core.bulk.BulkOperation;
import co.elastic.clients.elasticsearch.core.search.SourceConfigParam;
import co.elastic.clients.json.JsonpDeserializable;
import co.elastic.clients.json.JsonpDeserializer;
import co.elastic.clients.json.JsonpMapper;
import co.elastic.clients.json.JsonpSerializable;
import co.elastic.clients.json.NdJsonpSerializable;
import co.elastic.clients.json.ObjectBuilderDeserializer;
import co.elastic.clients.json.ObjectDeserializer;
import co.elastic.clients.transport.Endpoint;
import co.elastic.clients.transport.endpoints.SimpleEndpoint;
import co.elastic.clients.util.ApiTypeHelper;
import co.elastic.clients.util.ObjectBuilder;
import jakarta.json.stream.JsonGenerator;
import java.lang.Boolean;
import java.lang.String;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;
import javax.annotation.Nullable;

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

// typedef: _global.bulk.Request

/**
 * Bulk index or delete documents. Performs multiple indexing or delete
 * operations in a single API call. This reduces overhead and can greatly
 * increase indexing speed.
 * 
 * @see <a href="../doc-files/api-spec.html#_global.bulk.Request">API
 *      specification</a>
 */

public class BulkRequest extends RequestBase implements NdJsonpSerializable, JsonpSerializable {
	@Nullable
	private final SourceConfigParam source;

	private final List<String> sourceExcludes;

	private final List<String> sourceIncludes;

	@Nullable
	private final String index;

	@Nullable
	private final Boolean listExecutedPipelines;

	@Nullable
	private final String pipeline;

	@Nullable
	private final Refresh refresh;

	@Nullable
	private final Boolean requireAlias;

	@Nullable
	private final Boolean requireDataStream;

	@Nullable
	private final String routing;

	@Nullable
	private final Time timeout;

	@Nullable
	private final WaitForActiveShards waitForActiveShards;

	private final List<BulkOperation> operations;

	// ---------------------------------------------------------------------------------------------

	private BulkRequest(Builder builder) {

		this.source = builder.source;
		this.sourceExcludes = ApiTypeHelper.unmodifiable(builder.sourceExcludes);
		this.sourceIncludes = ApiTypeHelper.unmodifiable(builder.sourceIncludes);
		this.index = builder.index;
		this.listExecutedPipelines = builder.listExecutedPipelines;
		this.pipeline = builder.pipeline;
		this.refresh = builder.refresh;
		this.requireAlias = builder.requireAlias;
		this.requireDataStream = builder.requireDataStream;
		this.routing = builder.routing;
		this.timeout = builder.timeout;
		this.waitForActiveShards = builder.waitForActiveShards;
		this.operations = ApiTypeHelper.unmodifiableRequired(builder.operations, this, "operations");

	}

	public static BulkRequest of(Function<Builder, ObjectBuilder<BulkRequest>> fn) {
		return fn.apply(new Builder()).build();
	}

	@Override
	public Iterator<?> _serializables() {
		return this.operations.iterator();
	}
	/**
	 * <code>true</code> or <code>false</code> to return the <code>_source</code>
	 * field or not, or a list of fields to return.
	 * <p>
	 * API name: {@code _source}
	 */
	@Nullable
	public final SourceConfigParam source() {
		return this.source;
	}

	/**
	 * A comma-separated list of source fields to exclude from the response.
	 * <p>
	 * API name: {@code _source_excludes}
	 */
	public final List<String> sourceExcludes() {
		return this.sourceExcludes;
	}

	/**
	 * A comma-separated list of source fields to include in the response.
	 * <p>
	 * API name: {@code _source_includes}
	 */
	public final List<String> sourceIncludes() {
		return this.sourceIncludes;
	}

	/**
	 * Name of the data stream, index, or index alias to perform bulk actions on.
	 * <p>
	 * API name: {@code index}
	 */
	@Nullable
	public final String index() {
		return this.index;
	}

	/**
	 * If <code>true</code>, the response will include the ingest pipelines that
	 * were executed for each index or create.
	 * <p>
	 * API name: {@code list_executed_pipelines}
	 */
	@Nullable
	public final Boolean listExecutedPipelines() {
		return this.listExecutedPipelines;
	}

	/**
	 * ID of the pipeline to use to preprocess incoming documents. If the index has
	 * a default ingest pipeline specified, then setting the value to
	 * <code>_none</code> disables the default ingest pipeline for this request. If
	 * a final pipeline is configured it will always run, regardless of the value of
	 * this parameter.
	 * <p>
	 * API name: {@code pipeline}
	 */
	@Nullable
	public final String pipeline() {
		return this.pipeline;
	}

	/**
	 * If <code>true</code>, Elasticsearch refreshes the affected shards to make
	 * this operation visible to search, if <code>wait_for</code> then wait for a
	 * refresh to make this operation visible to search, if <code>false</code> do
	 * nothing with refreshes. Valid values: <code>true</code>, <code>false</code>,
	 * <code>wait_for</code>.
	 * <p>
	 * API name: {@code refresh}
	 */
	@Nullable
	public final Refresh refresh() {
		return this.refresh;
	}

	/**
	 * If <code>true</code>, the request’s actions must target an index alias.
	 * <p>
	 * API name: {@code require_alias}
	 */
	@Nullable
	public final Boolean requireAlias() {
		return this.requireAlias;
	}

	/**
	 * If <code>true</code>, the request's actions must target a data stream
	 * (existing or to-be-created).
	 * <p>
	 * API name: {@code require_data_stream}
	 */
	@Nullable
	public final Boolean requireDataStream() {
		return this.requireDataStream;
	}

	/**
	 * Custom value used to route operations to a specific shard.
	 * <p>
	 * API name: {@code routing}
	 */
	@Nullable
	public final String routing() {
		return this.routing;
	}

	/**
	 * Period each action waits for the following operations: automatic index
	 * creation, dynamic mapping updates, waiting for active shards.
	 * <p>
	 * API name: {@code timeout}
	 */
	@Nullable
	public final Time timeout() {
		return this.timeout;
	}

	/**
	 * The number of shard copies that must be active before proceeding with the
	 * operation. Set to all or any positive integer up to the total number of
	 * shards in the index (<code>number_of_replicas+1</code>).
	 * <p>
	 * API name: {@code wait_for_active_shards}
	 */
	@Nullable
	public final WaitForActiveShards waitForActiveShards() {
		return this.waitForActiveShards;
	}

	/**
	 * Required - Request body.
	 */
	public final List<BulkOperation> operations() {
		return this.operations;
	}

	/**
	 * Serialize this value to JSON.
	 */
	public void serialize(JsonGenerator generator, JsonpMapper mapper) {
		generator.writeStartArray();
		for (BulkOperation item0 : this.operations) {
			item0.serialize(generator, mapper);

		}
		generator.writeEnd();

	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Builder for {@link BulkRequest}.
	 */

	public static class Builder extends RequestBase.AbstractBuilder<Builder> implements ObjectBuilder<BulkRequest> {
		@Nullable
		private SourceConfigParam source;

		@Nullable
		private List<String> sourceExcludes;

		@Nullable
		private List<String> sourceIncludes;

		@Nullable
		private String index;

		@Nullable
		private Boolean listExecutedPipelines;

		@Nullable
		private String pipeline;

		@Nullable
		private Refresh refresh;

		@Nullable
		private Boolean requireAlias;

		@Nullable
		private Boolean requireDataStream;

		@Nullable
		private String routing;

		@Nullable
		private Time timeout;

		@Nullable
		private WaitForActiveShards waitForActiveShards;

		private List<BulkOperation> operations;

		/**
		 * <code>true</code> or <code>false</code> to return the <code>_source</code>
		 * field or not, or a list of fields to return.
		 * <p>
		 * API name: {@code _source}
		 */
		public final Builder source(@Nullable SourceConfigParam value) {
			this.source = value;
			return this;
		}

		/**
		 * <code>true</code> or <code>false</code> to return the <code>_source</code>
		 * field or not, or a list of fields to return.
		 * <p>
		 * API name: {@code _source}
		 */
		public final Builder source(Function<SourceConfigParam.Builder, ObjectBuilder<SourceConfigParam>> fn) {
			return this.source(fn.apply(new SourceConfigParam.Builder()).build());
		}

		/**
		 * A comma-separated list of source fields to exclude from the response.
		 * <p>
		 * API name: {@code _source_excludes}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>sourceExcludes</code>.
		 */
		public final Builder sourceExcludes(List<String> list) {
			this.sourceExcludes = _listAddAll(this.sourceExcludes, list);
			return this;
		}

		/**
		 * A comma-separated list of source fields to exclude from the response.
		 * <p>
		 * API name: {@code _source_excludes}
		 * <p>
		 * Adds one or more values to <code>sourceExcludes</code>.
		 */
		public final Builder sourceExcludes(String value, String... values) {
			this.sourceExcludes = _listAdd(this.sourceExcludes, value, values);
			return this;
		}

		/**
		 * A comma-separated list of source fields to include in the response.
		 * <p>
		 * API name: {@code _source_includes}
		 * <p>
		 * Adds all elements of <code>list</code> to <code>sourceIncludes</code>.
		 */
		public final Builder sourceIncludes(List<String> list) {
			this.sourceIncludes = _listAddAll(this.sourceIncludes, list);
			return this;
		}

		/**
		 * A comma-separated list of source fields to include in the response.
		 * <p>
		 * API name: {@code _source_includes}
		 * <p>
		 * Adds one or more values to <code>sourceIncludes</code>.
		 */
		public final Builder sourceIncludes(String value, String... values) {
			this.sourceIncludes = _listAdd(this.sourceIncludes, value, values);
			return this;
		}

		/**
		 * Name of the data stream, index, or index alias to perform bulk actions on.
		 * <p>
		 * API name: {@code index}
		 */
		public final Builder index(@Nullable String value) {
			this.index = value;
			return this;
		}

		/**
		 * If <code>true</code>, the response will include the ingest pipelines that
		 * were executed for each index or create.
		 * <p>
		 * API name: {@code list_executed_pipelines}
		 */
		public final Builder listExecutedPipelines(@Nullable Boolean value) {
			this.listExecutedPipelines = value;
			return this;
		}

		/**
		 * ID of the pipeline to use to preprocess incoming documents. If the index has
		 * a default ingest pipeline specified, then setting the value to
		 * <code>_none</code> disables the default ingest pipeline for this request. If
		 * a final pipeline is configured it will always run, regardless of the value of
		 * this parameter.
		 * <p>
		 * API name: {@code pipeline}
		 */
		public final Builder pipeline(@Nullable String value) {
			this.pipeline = value;
			return this;
		}

		/**
		 * If <code>true</code>, Elasticsearch refreshes the affected shards to make
		 * this operation visible to search, if <code>wait_for</code> then wait for a
		 * refresh to make this operation visible to search, if <code>false</code> do
		 * nothing with refreshes. Valid values: <code>true</code>, <code>false</code>,
		 * <code>wait_for</code>.
		 * <p>
		 * API name: {@code refresh}
		 */
		public final Builder refresh(@Nullable Refresh value) {
			this.refresh = value;
			return this;
		}

		/**
		 * If <code>true</code>, the request’s actions must target an index alias.
		 * <p>
		 * API name: {@code require_alias}
		 */
		public final Builder requireAlias(@Nullable Boolean value) {
			this.requireAlias = value;
			return this;
		}

		/**
		 * If <code>true</code>, the request's actions must target a data stream
		 * (existing or to-be-created).
		 * <p>
		 * API name: {@code require_data_stream}
		 */
		public final Builder requireDataStream(@Nullable Boolean value) {
			this.requireDataStream = value;
			return this;
		}

		/**
		 * Custom value used to route operations to a specific shard.
		 * <p>
		 * API name: {@code routing}
		 */
		public final Builder routing(@Nullable String value) {
			this.routing = value;
			return this;
		}

		/**
		 * Period each action waits for the following operations: automatic index
		 * creation, dynamic mapping updates, waiting for active shards.
		 * <p>
		 * API name: {@code timeout}
		 */
		public final Builder timeout(@Nullable Time value) {
			this.timeout = value;
			return this;
		}

		/**
		 * Period each action waits for the following operations: automatic index
		 * creation, dynamic mapping updates, waiting for active shards.
		 * <p>
		 * API name: {@code timeout}
		 */
		public final Builder timeout(Function<Time.Builder, ObjectBuilder<Time>> fn) {
			return this.timeout(fn.apply(new Time.Builder()).build());
		}

		/**
		 * The number of shard copies that must be active before proceeding with the
		 * operation. Set to all or any positive integer up to the total number of
		 * shards in the index (<code>number_of_replicas+1</code>).
		 * <p>
		 * API name: {@code wait_for_active_shards}
		 */
		public final Builder waitForActiveShards(@Nullable WaitForActiveShards value) {
			this.waitForActiveShards = value;
			return this;
		}

		/**
		 * The number of shard copies that must be active before proceeding with the
		 * operation. Set to all or any positive integer up to the total number of
		 * shards in the index (<code>number_of_replicas+1</code>).
		 * <p>
		 * API name: {@code wait_for_active_shards}
		 */
		public final Builder waitForActiveShards(
				Function<WaitForActiveShards.Builder, ObjectBuilder<WaitForActiveShards>> fn) {
			return this.waitForActiveShards(fn.apply(new WaitForActiveShards.Builder()).build());
		}

		/**
		 * Required - Request body.
		 * <p>
		 * Adds all elements of <code>list</code> to <code>operations</code>.
		 */
		public final Builder operations(List<BulkOperation> list) {
			this.operations = _listAddAll(this.operations, list);
			return this;
		}

		/**
		 * Required - Request body.
		 * <p>
		 * Adds one or more values to <code>operations</code>.
		 */
		public final Builder operations(BulkOperation value, BulkOperation... values) {
			this.operations = _listAdd(this.operations, value, values);
			return this;
		}

		/**
		 * Required - Request body.
		 * <p>
		 * Adds a value to <code>operations</code> using a builder lambda.
		 */
		public final Builder operations(Function<BulkOperation.Builder, ObjectBuilder<BulkOperation>> fn) {
			return operations(fn.apply(new BulkOperation.Builder()).build());
		}

		@Override
		protected Builder self() {
			return this;
		}

		/**
		 * Builds a {@link BulkRequest}.
		 *
		 * @throws NullPointerException
		 *             if some of the required fields are null.
		 */
		public BulkRequest build() {
			_checkSingleUse();

			return new BulkRequest(this);
		}
	}

	// ---------------------------------------------------------------------------------------------

	/**
	 * Endpoint "{@code bulk}".
	 */
	public static final Endpoint<BulkRequest, BulkResponse, ErrorResponse> _ENDPOINT = new SimpleEndpoint<>("es/bulk",

			// Request method
			request -> {
				return "POST";

			},

			// Request path
			request -> {
				final int _index = 1 << 0;

				int propsSet = 0;

				if (request.index() != null)
					propsSet |= _index;

				if (propsSet == 0) {
					StringBuilder buf = new StringBuilder();
					buf.append("/_bulk");
					return buf.toString();
				}
				if (propsSet == (_index)) {
					StringBuilder buf = new StringBuilder();
					buf.append("/");
					SimpleEndpoint.pathEncode(request.index, buf);
					buf.append("/_bulk");
					return buf.toString();
				}
				throw SimpleEndpoint.noPathTemplateFound("path");

			},

			// Path parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				final int _index = 1 << 0;

				int propsSet = 0;

				if (request.index() != null)
					propsSet |= _index;

				if (propsSet == 0) {
				}
				if (propsSet == (_index)) {
					params.put("index", request.index);
				}
				return params;
			},

			// Request parameters
			request -> {
				Map<String, String> params = new HashMap<>();
				if (request.pipeline != null) {
					params.put("pipeline", request.pipeline);
				}
				if (request.routing != null) {
					params.put("routing", request.routing);
				}
				if (request.requireAlias != null) {
					params.put("require_alias", String.valueOf(request.requireAlias));
				}
				if (request.refresh != null) {
					params.put("refresh", request.refresh.jsonValue());
				}
				if (request.waitForActiveShards != null) {
					params.put("wait_for_active_shards", request.waitForActiveShards._toJsonString());
				}
				if (request.source != null) {
					params.put("_source", request.source._toJsonString());
				}
				if (ApiTypeHelper.isDefined(request.sourceExcludes)) {
					params.put("_source_excludes",
							request.sourceExcludes.stream().map(v -> v).collect(Collectors.joining(",")));
				}
				if (ApiTypeHelper.isDefined(request.sourceIncludes)) {
					params.put("_source_includes",
							request.sourceIncludes.stream().map(v -> v).collect(Collectors.joining(",")));
				}
				if (request.requireDataStream != null) {
					params.put("require_data_stream", String.valueOf(request.requireDataStream));
				}
				if (request.listExecutedPipelines != null) {
					params.put("list_executed_pipelines", String.valueOf(request.listExecutedPipelines));
				}
				if (request.timeout != null) {
					params.put("timeout", request.timeout._toJsonString());
				}
				return params;

			}, SimpleEndpoint.emptyMap(), true, BulkResponse._DESERIALIZER);
}
