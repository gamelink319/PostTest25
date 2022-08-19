package com.juaracoding.ujian.DriverStrategies;

public class DriverStrategyImplementer {
	
	public static DriverStrategy chooseStategy(String strategy) {
		switch (strategy) {
		case "Chrome":		
			return new Chrome();
		
		case "Firefox":		
			return new Firefox();
		default:
			return null;
		}
	}

}
