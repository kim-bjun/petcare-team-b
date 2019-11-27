package com.petcare.web.utills;

import java.util.HashMap;
 
public class RequestMethodUtil {

	public static HashMap<String, Object> bbsMethod(Integer bbs, Integer page,
			String condition, String words) {
		if (bbs == null)
			bbs = 1;
		if (page == null)
			page = 1;
		if (condition == null)
			condition = "";
		if (words == null)
			words = "";

		HashMap<String, Object> queryMap = new HashMap<String, Object>();

		queryMap.put("page", page);
		queryMap.put("words", words);
		queryMap.put("condition", condition);

		UrlUtil urlHelper = new UrlUtil();
		urlHelper.urlEncodeUTF8(queryMap);

		queryMap.put("bbs", bbs);
		queryMap.put("queryString", urlHelper.getQueryString());

		return queryMap;
	}

	public static HashMap<String, Object> bbsNoneMethod(Integer page,
			String condition, String words) {
		if (page == null)
			page = 1;
		if (condition == null)
			condition = "";
		if (words == null)
			words = "";

		HashMap<String, Object> queryMap = new HashMap<String, Object>();

		queryMap.put("page", page);
		queryMap.put("words", words);
		queryMap.put("condition", condition);

		UrlUtil urlHelper = new UrlUtil();
		urlHelper.urlEncodeUTF8(queryMap);

		queryMap.put("queryString", urlHelper.getQueryString());

		return queryMap;
	}

}
