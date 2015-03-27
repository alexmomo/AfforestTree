package com.afforesttree.config;

public class DBConfig {

	/*
	 * en(www.taketours.com/www.gotobus.com/mobile.gotobus.com) 
	 * cn(cn.taketours.com/big5.taketours.com/www.zijiqu.com)
	 */
	public static final String language = "en"; 
	/*
	 * End
	 */
	public static boolean local_is_traditional = false;	//big5.taketours.com is true
	public static final String website_filter_key = "gotobus";//gotobus,taketours,cntaketours,zijiqu
	
	/*
	 * table name need to define
	 */
	public static final String TourSearchDataTableName = "ivy_tour_search_data_" + "en"; //cn big5 en zijiqu			
	public static final String embedWebsiteData="ivy_embed_website_data_"+"gotobus";//taketours => "taketours", gotobus => "gotobus", big5 => "big5", zijiqu => "zijiqu", cntaketours => "cntaketours"
	public static final String cacheDataLog = "ivy_cache_data_log_"+"taketours";//taketours => "taketours", gotobus => "gotobus", big5 => "big5", zijiqu => "zijiqu", cntaketours => "cntaketours"	
	public static final String ProductGroupToPidsTableName = "ivy_product_group_to_pids" + "_cntaketours"; //taketours => "", cn => "_cntaketours", big5 => "_cntaketours", zijiqu => "_zijiqu", gotobus => "_gotobus"
	public static final String destinationAliasTableName = "ivy_destination_alias_en";
	
	
	/*
	 * End
	 */
	/*
	 * sessionFactory config special for NameToId 
	 * sessionFactory1 => gm
	 * sessionFactory2 => gsearchtour
	 * sessionFactory3 => gsearchbusandhotel
	 */
	public static final String NameToIdSessionFactory = "sessionFactory3"; // taketours zijiqu cn => sessionFactory2   gotobus => sessionFactory3
	public static String getLanguage(){
		return language;
	}
}
