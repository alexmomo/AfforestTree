package com.afforesttree.config;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;

import com.afforesttree.util.DateProcessor;


public class AppInitConstants {

	/**
	 * System configuration JVars Map - Start loading
	 */
	public static String language = DBConfig.getLanguage(); 
	public static String local_db_plus = "db_plus/" + DBConfig.getLanguage() + "/";
	
	public static HashMap<String,String> CONFIG_MAP = new HashMap<String,String>();
	public static HashMap<String, String> CODE_ENGotoBus_MAP = new HashMap<String, String>();
	public static HashMap<String, String> CODE_ENTakeTours_MAP = new HashMap<String, String>();
	public static HashMap<String, String> CODE_CN_MAP = new HashMap<String, String>();
	public static HashMap<String, String> CODE_BIG5_MAP = new HashMap<String, String>();
	public static HashMap<String, String> CODE_ZIJIQU_MAP = new HashMap<String, String>();
	private static LinkedHashMap<String, Integer> websiteFilter = websiteFilter();
	private static Integer page_width = 960;
	private static Integer content_space = 6;
	private static Integer cookieMaxAge = 60 * 60 * 24 * 7;
	private static int disable_tour_of_the_day = 0;
	
	public static Boolean is_tours_site(){
		return getPropertiesValue("local_is_tour_site").equals("1") ? true : false;
	}
	
	public static Boolean is_bus_site(){
		return getPropertiesValue("local_is_bus_site").equals("1") ? true : false;
	}
	
	public static Boolean is_traditional(){
		return DBConfig.local_is_traditional;
	}
	
	public static String website_filter_key(){
		return DBConfig.website_filter_key;
	}
	
	public static boolean isHotelDiscount(){
		return getPropertiesValue("isHotelDiscount").equals("1") ? true : false;
	}
	
	public static String DBEncoding(){
		return getPropertiesValue("DBEncoding");
	}
	
	public static String proxyDomain() {
		return getPropertiesValue("proxyDomain");
	}
	
	public static String getLanguage()
	{
	 return DBConfig.language;
	}
	
	public static String getEncoding() {
		if (website_filter_key().equals("cntaketours") || website_filter_key().equals("zijiqu")) {
			if(is_traditional()){
				return "big5";
			} else {
				return "gbk";
			}
		} else {
			return "iso8859-1";
		}
	}

	private static List<Integer> defaultAmenities = Arrays
			.asList(new Integer[] { 4, 7, 9, 13, 19, 38, 67, 1004555 });
	private static final List<Integer> defaultBoards = Arrays
			.asList(new Integer[] { 1, 4, 1000360 });

	public static Integer getWebsitFilter() {
		return websiteFilter.get(website_filter_key());
	}

	public static LinkedHashMap<String, Integer> websiteFilter() {
		LinkedHashMap<String, Integer> map = new LinkedHashMap<String, Integer>();
		map.put("gotobus", 1);
		map.put("taketours", 2);
		map.put("cntaketours", 3);
		map.put("zijiqu", 4);
		map.put("big5", 5);
		return map;
	}

	public static String getPropertiesValue(String key) {
		return CONFIG_MAP.get(key);
	}

	public static String getI18nValue(String key) {//internationalization by key
		if (website_filter_key().equals("gotobus")) {
			return CODE_ENGotoBus_MAP.get(key);
		} 
		else if (website_filter_key().equals("taketours")) {
			return CODE_ENTakeTours_MAP.get(key);
		}else if ("cn".equals(language)) {
			if(is_traditional()){
				return CODE_BIG5_MAP.get(key);
			} else if(website_filter_key().equals("zijiqu")){
				return CODE_ZIJIQU_MAP.get(key);
			} else{
				return CODE_CN_MAP.get(key);
			}
		}  else {
			return key;
		}
	}

	public static String ico(){
		return getPropertiesValue("ico");
	}
	
	public static String domain() {
		return getPropertiesValue("local_main_domain");
	}
	
	public static String testDomain() {
		return getPropertiesValue("local_test_domain");
	}
	
	public static String secureDomain() {
		return getPropertiesValue("local_secure_main_domain");
	}
	
	public static String bussinessName(){
		return getPropertiesValue("local_business_name");
	}
	
	public static String imgDomain() {
		String imgDomain = getPropertiesValue("local_img_domain");
		return imgDomain == null ? "" : imgDomain;
	
	}
	public static String mDomain() {
		return getPropertiesValue("m_main_domain");
	}
	
	public static String select_xsl(String flag) {
		if (flag.equals("list")) {
			return local_db_plus + getPropertiesValue("xsllisttour");
		} else {
			return local_db_plus + getPropertiesValue("xsltour");
		}
	}

	public static String get_select_xsl(String flag) {
		if (flag.equals("list")) {
			return local_db_plus + getPropertiesValue("dbxsllisttour");
		} else {
			return local_db_plus + getPropertiesValue("dbxsltour");
		}
	}

	public static String getXslbusembed() {
		return local_db_plus + getPropertiesValue("xslbusembed");
	}

	public static String getXslBusMobile() {
		return local_db_plus + getPropertiesValue("xslBusMobile");
	}

	public static String getXslbus() {
		return local_db_plus + getPropertiesValue("xslbus");
	}
	
	public static String getNewXslbus() {
		return local_db_plus + getPropertiesValue("newxslbus");
	}
	
	public static String getXslBusForApi() {
		return local_db_plus + getPropertiesValue("xslbusforapi");
	}

	public static String getStyleFileName() {
		return getPropertiesValue("localStyleFileName");
	}
	
	public static String getHomePageCss(){
		return getPropertiesValue("local_home_page_css");
	}

	public static String getCss() {
		return getPropertiesValue("css");
	}

	public static String getHotel_do() {
		return getPropertiesValue("hotel_do");
	}

	public static String getJs_dir() {
		return domain() + "/js/" + language + "/";
	}

	public static Integer getContent_space() {
		return content_space;
	}

	public static Integer getPage_width() {
		return page_width;
	}

	public static String getBus_do() {
		return getPropertiesValue("bus_do");
	}

	public static List<Integer> getDefaultAmenities() {
		return defaultAmenities;
	}

	public static List<Integer> getDefaultBoards() {
		return defaultBoards;
	}

	public static String getDesWs() {
		return local_db_plus + getPropertiesValue("desWs");
	}

	public static String getHotelXsl(String xsl_flag) {
		return local_db_plus + "hotel/" + xsl_flag + ".xsl";
	}
	
	public static String getMobileHotelXsl()
	{
		return local_db_plus + "hotel/detail_gotobus_for_mobile.xsl";
	}

	public static String getBusHotelXsl() {
		return local_db_plus + getPropertiesValue("busHotelXsl");
	}
	
	public static String getMobileBusHotelXsl()
	{
		return local_db_plus + "hotel/bus_and_hotel_for_mobile.xsl";
	}

	public static int getDisable_tour_of_the_day() {
		return disable_tour_of_the_day;
	}

	public static String getCookieDomain() {
		return getPropertiesValue("cookieDomain");
	}
	
	public static String ajaxUrl()
	{
		return getPropertiesValue("ajax_do");
	}

	public static Integer getCookieMaxAge() {
		return cookieMaxAge;
	}

	public static String getLocal_google_key_link() {
		return getPropertiesValue("local_google_key_link");
	}

	public static String getHotelsProApi() {
		return getPropertiesValue("hotelsProApi");
	}

	public static String getJsVersion() {
		return getPropertiesValue("jsVersion");
	}

	public static LinkedHashMap<String, String> day_to_value() {
		LinkedHashMap<String, String> map = new LinkedHashMap<String, String>();
		map.put("1-1", "1 " + getI18nValue("day"));
		map.put("2-2", "2 " + getI18nValue("days"));
		map.put("3-3", "3 " + getI18nValue("days"));
		map.put("4-4", "4 " + getI18nValue("days"));
		map.put("5-5", "5 " + getI18nValue("days"));
		map.put("6-6", "6 " + getI18nValue("days"));
		map.put("7-7", "7 " + getI18nValue("days"));
		map.put("8-8", "8 " + getI18nValue("days"));
		map.put("9-9", "9 " + getI18nValue("days"));
		map.put("10-", "10 " + getI18nValue("orMoreDays"));
		map.put("2-3", "2-3 " + getI18nValue("days"));
		map.put("3-4", "3-4 " + getI18nValue("days"));
		map.put("4-5", "4-5 " + getI18nValue("days"));
		map.put("5-6", "5-6 " + getI18nValue("days"));
		map.put("6-7", "6-7 " + getI18nValue("days"));
		map.put("7-8", "7-8 " + getI18nValue("days"));
		map.put("8-9", "8-9 " + getI18nValue("days"));
		return map;
	}

	public static String getLocalLaborDayMessage() {
		try {
			if (DateProcessor.compareToCurrentTime(getPropertiesValue("localLaborDay")) < 0 || !isHotelDiscount()) {
				return "";
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			return "";
		}
		return getI18nValue("localLaborDayMessage");
	}

	public static String getXslBusWSXsl() {
		return "WEB-INF/db_plus/en/bus/bus_search_ws.xsl";
	}
	
	public static String  getSearchTour(){
		return getPropertiesValue("tour_search_do");
	}
	
	public static String getSearchTourAlias()
	{
	 return getPropertiesValue("tour_search_secure_do_alias");
	}
	
	public static String getlocalWsRestfulUrl(){
		return getPropertiesValue("localWsRestfulUrl");
	}
	
	public static String apiUid()
	{
		return getPropertiesValue("apiUid");
	}
	public static String apiPassword()
	{
		return getPropertiesValue("apiPassword");
	}
	
	
	
	
}
