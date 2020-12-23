package com.entelgy.prueba.configuration.constant;

public class AppConstant {
	
	private static final String LOG_DEFAULT="[ENTELGY-PRUEBA]:%s => {}";
	
	private AppConstant() {}
	
	public static String getLogFormat(String methodName) {
		return String.format(AppConstant.LOG_DEFAULT,methodName);
	}
}
