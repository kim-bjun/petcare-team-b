package com.petcare.web.utills;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import com.petcare.web.domains.HospitalVo;

@Lazy
@Component
public class HospitalCrawlingProxy {

	
	public ArrayList<HospitalVo> animal() {
		ArrayList<String> tempArrayforOnePageHosCodeList = new ArrayList<String>();
		HospitalVo tempBean = new HospitalVo();
		ArrayList<HospitalVo> proxyList = new ArrayList<HospitalVo>();
		String[] list = {"0","15","30","45","60","75","105"};
		
		try {
			for (String pageStrNum : list) {
				tempArrayforOnePageHosCodeList = getCategoty(pageStrNum);
				for (String tempHosCode : tempArrayforOnePageHosCodeList) {
					tempBean = getHospitalDetail(tempHosCode);
					proxyList.add(tempBean);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		

		
		return proxyList;
	}
	
	public ArrayList<String> getCategoty(String startRow) throws Exception {
		
		ArrayList<String> tempCateList = new ArrayList<String>();
		final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36"; 
		String targetURL = "http://www.animaldoctor.co.kr/category.php?start="+startRow ;

		Connection.Response homePage = Jsoup.connect(targetURL)  
		     .method(Connection.Method.GET)  
		     .userAgent(USER_AGENT)  
		     .execute();		
		 
		Document tempDoc = homePage.parse();
		Elements temp1 = tempDoc.select("div#contents").select("td[class=font_20]").select("a");
		for (int i = 0; i < 3; i++) {
			temp1.remove(0);
		} 
		for (Element element : temp1) {
			tempCateList.add(element.attr("href").substring(18));
		}
		
		return tempCateList;
	}
	
	
	public HospitalVo getHospitalDetail(String hosNo) throws IOException{
		HospitalVo tempHosVo = new HospitalVo(); // 병원 별 상세 정보
		ArrayList<String> tempdump = new ArrayList<String>();  // 병원 상세 > 진료정보
		String tempHosService="",tempHosFeature="",tempHosOptime="";
		
		
		final String USER_AGENT = "Mozilla/5.0 (Windows NT 10.0; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/51.0.2704.103 Safari/537.36"; 
		String targetURL = "http://www.animaldoctor.co.kr/detail.php?number="+hosNo ;
		System.out.println(targetURL);
		Connection.Response homePage = Jsoup.connect(targetURL)  
		     .method(Connection.Method.GET)  
		     .userAgent(USER_AGENT)  
		     .execute();	
		
		Document tempDoc = homePage.parse();
		Elements table_11 = tempDoc.select("div#contents").select("table").get(11).select("td");
		Elements table_14 = tempDoc.select("div#contents").select("table").get(14).select("table");
		Elements photo_table = tempDoc.select("div#contents");
		
		tempHosVo.setHosPhoto("http://animaldoctor.co.kr/"+photo_table.select("div#image_preview_main").select("img#image_large_0").attr("src").substring(2)); ;
		
		for (int i = 3; i < table_14.size(); i++) {
				Elements temp = table_14.get(i).select("td");
				if (temp.size() <3) {
					tempdump.add(table_14.get(i).text()
							.replaceAll("주간진료", "주간진료:")
							.replaceAll("야간응급진료", "야간응급진료:")
							.replaceAll("미용", "미용:")); // 병원상세 > 진료정보
					
				}
		}//for
		
		
		int cnt =0;
/*
		if(tempdump.contains("진료과목")) {
			int endcnt=0;
			if (!tempdump.contains("진료동물") && !tempdump.contains("편의시설") && !tempdump.contains("진료시간") && tempdump.contains("기타")) {
				endcnt = tempdump.indexOf("기타");
			}else if(!tempdump.contains("진료동물") && !tempdump.contains("편의시설") && !tempdump.contains("진료시간") && !tempdump.contains("기타")) {
				endcnt = tempdump.size();
			}else if(!tempdump.contains("진료동물") && !tempdump.contains("편의시설") && tempdump.contains("진료시간")) {
				endcnt = tempdump.indexOf("진료시간");
			}else if(!tempdump.contains("진료동물") && tempdump.contains("편의시설")) {
				endcnt = tempdump.indexOf("편의시설");
			}else if(tempdump.contains("진료동물")) {
				endcnt = tempdump.indexOf("진료동물");
			}
			
			for (int i = tempdump.indexOf("진료과목")+1 ; i < endcnt; i++) {
				tempHosCourseOfTreatment +=tempdump.get(i).toString()+"|"; // 진료과목
			}
			tempMap.put("HosCourseOfTreatment", tempHosCourseOfTreatment);
			
		}*/
		
/*		
		if(tempdump.contains("진료동물")) {
			int endcnt=0;
			if ( !tempdump.contains("편의시설") && !tempdump.contains("진료시간") && tempdump.contains("기타")) {
				endcnt = tempdump.indexOf("기타");
			}else if(!tempdump.contains("편의시설") && !tempdump.contains("진료시간") && !tempdump.contains("기타")) {
				endcnt = tempdump.size();
			}else if( !tempdump.contains("편의시설") && tempdump.contains("진료시간")) {
				endcnt = tempdump.indexOf("진료시간");
			}else if( tempdump.contains("편의시설")) {
				endcnt = tempdump.indexOf("편의시설");
			}
			
			for (int i = tempdump.indexOf("진료동물")+1 ; i < endcnt; i++) {
				tempHosMajorTreatmentTarget +=tempdump.get(i).toString()+"|"; // 진료동물
			}
			tempMap.put("tempHosMajorTreatmentTarget", tempHosMajorTreatmentTarget);
		}
		*/
		
		if(tempdump.contains("편의시설")) {
			int endcnt=0;
			if ( !tempdump.contains("진료시간") && tempdump.contains("기타")) {
				endcnt = tempdump.indexOf("기타");
			}else if(!tempdump.contains("진료시간") && !tempdump.contains("기타")) {
				endcnt = tempdump.size();
			}else {
				endcnt = tempdump.indexOf("진료시간");
			}
			
			for (int i = tempdump.indexOf("편의시설")+1 ; i < endcnt; i++) {
				if(tempdump.get(i).toString().contains("미용") || tempdump.get(i).toString().contains("호텔") || tempdump.get(i).toString().contains("주차") ) {
					tempHosService +=tempdump.get(i).toString()+"\t"; 
				}else {
					tempHosService +=tempdump.get(i).toString(); // 편의시설
				}
			}
			tempHosVo.setHosService(tempHosService);
		}
		
		/*
		 * if(tempdump.contains("진료시간")) { int endcnt=0; if (!tempdump.contains("기타")) {
		 * endcnt = tempdump.size(); }else if( !tempdump.contains("기타")) { endcnt =
		 * tempdump.indexOf("기타"); }
		 * 
		 * for (int i = tempdump.indexOf("진료시간")+1 ; i < endcnt; i++) {
		 * if(tempdump.get(i).toString().contains("주간진료")) { tempHosOptime
		 * +=tempdump.get(i).toString()+" : "; }else
		 * if(tempdump.get(i).toString().contains("야간응급진료")) { tempHosOptime
		 * +=tempdump.get(i).toString()+" : "; }else { tempHosOptime
		 * +=tempdump.get(i).toString()+"|"; // 편의시설 }
		 * tempHosVo.setHosOptime(tempHosOptime); }
		 * 
		 * }
		 */
		if(tempdump.contains("기타")) {
			for (int i = tempdump.indexOf("기타")+1 ; i < tempdump.size(); i++) {
				if(i == tempdump.indexOf("기타")+1 ) {
					tempHosFeature +=tempdump.get(i).toString()+" "; // 편의시설
				}else {
					tempHosFeature +=", "+tempdump.get(i).toString(); // 편의시설
				}
			}
			tempHosVo.setHosFeature(tempHosFeature.replace(" .", ""));
		}
		
		tempHosVo.setHosNo(Integer.parseInt(hosNo));
		tempHosVo.setHosId("hosNo"+hosNo);
		tempHosVo.setHosPass("hosNo"+hosNo);		
		tempHosVo.setHosName(table_11.get(1).text());
		tempHosVo.setHosAddress(table_11.get(3).text());
		tempHosVo.setHosPhone(table_11.get(5).text());
		tempHosVo.setHosSite(table_11.get(7).text());
		tempHosVo.setHosMajorTreatmentTarget(table_11.get(9).text());
		tempHosVo.setHosCourseOfTreatment(table_11.get(11).text());
		tempHosVo.setHosIntro("안녕하세요    " +table_11.get(1).text()+ "입니다");
		
		System.out.println(tempHosVo.toString() + "<< hosNo");
		
		return tempHosVo;
		
	}
	
}
