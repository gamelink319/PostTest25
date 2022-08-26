package com.juaracoding.ujian.DriverStrategies;

import Utils.Constants;

public class DriverStrategyImplementer {
	
	public static DriverStrategy chooseStategy(String strategy) {
		switch (strategy) {
		case Constants.CHROME:		
			return new Chrome();
		
		case Constants.FIREFOX:		
			return new Firefox();
		default:
			return null;
		}
	}

}
