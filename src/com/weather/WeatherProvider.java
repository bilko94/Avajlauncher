package com.weather;

public class WeatherProvider {
	
	private static WeatherProvider weatherProvider;
	private static String[] weather;

	private WeatherProvider(){
		super();
	}

	public static WeatherProvider getProvider(){
		return WeatherProvider.weatherProvider;
	}

	public String getCurrentWeather(Coordinates coordinates){
		String[] weather = {"Rain","Fog","Sun","Snow"};

        return weather[1];
	}

}
