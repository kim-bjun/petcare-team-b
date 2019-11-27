package com.petcare.web.utills;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

public class UrlUtil {

	private String baseURL;
	private String queryString;

	public String getBaseURL() {
		return baseURL;
	}

	public void setBaseURL(HttpServletRequest request) {
		/*this.baseURL = String.format("%s://%s:%d/web/", request.getScheme(),
				request.getServerName(), request.getServerPort());*/
		
		this.baseURL = String.format("%s://%s:%d/", request.getScheme(),
				request.getServerName(), request.getServerPort());
	}

	public String urlEncodeUTF8(String s) {
		try {
			return URLEncoder.encode(s, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public void urlEncodeUTF8(Map<?, ?> map) {
		StringBuilder sb = new StringBuilder();

		for (Map.Entry<?, ?> entry : map.entrySet()) {
			
			if (ComparatorUtil.isNotEmpty(entry.getValue().toString())) {
				if (sb.length() > 0) {
					sb.append("&");
				}

				sb.append(String.format("%s=%s",
						this.urlEncodeUTF8(entry.getKey().toString()),
						this.urlEncodeUTF8(entry.getValue().toString())));
			}
		}

		this.setQueryString(sb.toString());
	}

	public String getQueryString() {
		return queryString;
	}

	public void setQueryString(String queryString) {
		this.queryString = queryString;
	}
}