/*
 * Copyright 2015 nghiatc.
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

package com.ntc.http;

import java.util.Map;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpRequest {
	private final Logger _logger = LoggerFactory.getLogger(HttpRequest.class);
	HttpClient _httpClient;

	public static HttpRequest Instance = new HttpRequest();

	private HttpRequest() {
		_httpClient = new HttpClient();
		try {
			_httpClient.setRequestBufferSize(10240);
			_httpClient.start();
		} catch (Exception e) {
			_logger.error("error start httpClient ", e);
		}
	}

	public ContentResponse doGetResponse(String url) {
		ContentResponse response = null;
		try {
			response = _httpClient.GET(url);
		} catch (Exception e) {
			_logger.error("doGet ", e);
			e.printStackTrace();
		}

		return response;
	}

	public ContentResponse doPost(String url, Map<String, String> params) {
		ContentResponse response = null;
		try {
			Request request = _httpClient.POST(url);
			for(String key : params.keySet()) {
				request = request.param(key, params.get(key));
			}
			response = request.send();
		} catch (Exception e) {
			_logger.error("doPost ", e);
			e.printStackTrace();
		}

		return response;
	}
}
