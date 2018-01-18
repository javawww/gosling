package com.gosling.util.freemarkerutil;

public class DomainUrlUtil {
	protected static org.apache.log4j.Logger log = org.apache.log4j.LogManager.getLogger(DomainUrlUtil.class);

	public static String URL_RESOURCES; // 主站的URL
	public static String STATIC_RESOURCES; // 静态资源的URL
	public static String IMAGE_RESOURCES; // 图片资源的URL

	public static String getURL_RESOURCES() {
		return URL_RESOURCES;
	}

	public static void setURL_RESOURCES(String eJS_URL_RESOURCES) {
		URL_RESOURCES = eJS_URL_RESOURCES;
	}

	public static String getSTATIC_RESOURCES() {
		return STATIC_RESOURCES;
	}

	public static void setSTATIC_RESOURCES(String eJS_STATIC_RESOURCES) {
		STATIC_RESOURCES = eJS_STATIC_RESOURCES;
	}

	public static String getIMAGE_RESOURCES() {
		return IMAGE_RESOURCES;
	}

	public static void setIMAGE_RESOURCES(String eJS_IMAGE_RESOURCES) {
		IMAGE_RESOURCES = eJS_IMAGE_RESOURCES;
	}
}
