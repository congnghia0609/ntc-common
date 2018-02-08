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

import java.util.HashMap;
import java.util.Map;

import org.eclipse.jetty.client.HttpClient;
import org.eclipse.jetty.client.api.ContentResponse;
import org.eclipse.jetty.client.api.Request;
import org.eclipse.jetty.client.util.StringContentProvider;
import org.eclipse.jetty.util.ssl.SslContextFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HttpsRequest {
	private final Logger _logger = LoggerFactory.getLogger(HttpsRequest.class);
	HttpClient _httpClient;
	private final String _userAgent = "Mozilla/5.0 (X11; Linux x86_64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/36.0.1985.125 Safari/537.36";

	public static HttpsRequest Instance = new HttpsRequest();

	private HttpsRequest() {
		SslContextFactory ssl = new SslContextFactory(true);
		_httpClient = new HttpClient(ssl);

		try {
			_httpClient.start();
		} catch (Exception e) {
			_logger.error("error start httpClient ", e);
		}
	}

	public ContentResponse doGet(String url) {
		ContentResponse response = null;
		try {
			response = _httpClient.GET(url);
		} catch (Exception e) {
			_logger.error("doGet ", e);
			e.printStackTrace();
		}

		return response;
	}

	public ContentResponse doPost(String url, Map<String, String> header, String params) {
		ContentResponse response = null;
		try {
			Request request = _httpClient.POST(url);
			if(header != null) {
				for(String key : header.keySet()) {
					request = request.header(key, header.get(key));
				}
			}

			request.content(new StringContentProvider(params));
			response = request.send();
		} catch (Exception e) {
			_logger.error("doPost ", e);
			e.printStackTrace();
		}

		return response;
	}

	public ContentResponse doPostJsonContent( String url, Map<String,String> params) {
		Map<String, String> header = new HashMap<String, String>();
		header.put("Content-Type", "application/x-www-form-urlencoded");
		return doPost(url, header, params);
	}

	public ContentResponse doPost(String url, Map<String, String> header, Map<String, String> params) {
		ContentResponse response = null;
		try {
			Request request = _httpClient.POST(url);
			if(header != null) {
				for(String key : header.keySet()) {
					request = request.header(key, header.get(key));
				}
			}

			if(params != null) {
				for(String key : params.keySet()) {
					request = request.param(key, params.get(key));
				}
			}

			response = request.send();
		} catch (Exception e) {
			_logger.error("doPost ", e);
			e.printStackTrace();
		}

		return response;
	}

	public static void main(String[] args) {
		HttpsRequest req = new HttpsRequest();
		ContentResponse resp = req.doGet("https://api.foursquare.com/v2/venues/explore?ll=40.708379485154886,-74.03071002283066&query=Nightclub&sortByDistance=1&client_id=DWSFUFIL4KCVA0PUJJGRG5YMAWW5MCN0B0AU1WUSVL1OSRPT&client_secret=5CTOW4OP1JTE0VCUAVW4CRJ3S4OHEGFRJQSPE0WXY5JZ1Z5P&v=1343434343");
		System.out.println(resp.getContentAsString());
		System.exit(1);
	}
}
