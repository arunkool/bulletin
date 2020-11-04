package com.forecast.weatherApi.model;

import java.math.BigDecimal;

public class WeatherMapTimeMain {

	private BigDecimal temp;

	private BigDecimal temp_min;

	private BigDecimal temp_max;

	private BigDecimal humidity;

	private BigDecimal temp_kf;

	public BigDecimal getTemp() {
		return temp;
	}

	public void setTemp(BigDecimal temp) {
		this.temp = temp;
	}

	public BigDecimal getTemp_min() {
		return temp_min;
	}

	public void setTemp_min(BigDecimal temp_min) {
		this.temp_min = temp_min;
	}

	public BigDecimal getTemp_max() {
		return temp_max;
	}

	public void setTemp_max(BigDecimal temp_max) {
		this.temp_max = temp_max;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public BigDecimal getTemp_kf() {
		return temp_kf;
	}

	public void setTemp_kf(BigDecimal temp_kf) {
		this.temp_kf = temp_kf;
	}

}
