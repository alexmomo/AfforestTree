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
	public static HashMap<String,String> CONFIG_MAP = new HashMap<String,String>();
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

	public static String getPropertiesValue(String key) {
		return CONFIG_MAP.get(key);
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
