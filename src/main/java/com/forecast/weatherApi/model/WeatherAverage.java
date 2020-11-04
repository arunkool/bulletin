package com.forecast.weatherApi.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.io.Serializable;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;

public class WeatherAverage implements Serializable {

	private static final long serialVersionUID = 5763148931413501367L;

	@JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate date;

	private BigDecimal dayTemperature;

	private BigDecimal nightTemperature;

	private BigDecimal humidity;

	@JsonIgnore
	private BigDecimal totalDayTemp;

	@JsonIgnore
	private Integer dayCount;

	@JsonIgnore
	private BigDecimal totalNightTemp;

	@JsonIgnore
	private Integer nightCount;

	@JsonIgnore
	private BigDecimal totalHumidity;

	@JsonIgnore
	private Integer humidityCount;

	public WeatherAverage() {
		this.totalDayTemp = BigDecimal.ZERO;
		this.totalNightTemp = BigDecimal.ZERO;
		this.totalHumidity = BigDecimal.ZERO;
		this.dayCount = 0;
		this.nightCount = 0;
		this.humidityCount = 0;
	}

	public WeatherAverage(LocalDate date, BigDecimal daily, BigDecimal nightly, BigDecimal humidity,
                             BigDecimal totalDaily, Integer quantDaily, BigDecimal totalNightly, Integer quantNightly,
                             BigDecimal totalHumidity, Integer quantHumidity) {
		this.date = date;
		this.dayTemperature = daily;
		this.nightTemperature = nightly;
		this.humidity = humidity;
		this.totalDayTemp = totalDaily;
		this.dayCount = quantDaily;
		this.totalNightTemp = totalNightly;
		this.nightCount = quantNightly;
		this.totalHumidity = totalHumidity;
		this.humidityCount = quantHumidity;
	}

	public void addMap(WeatherMapTime map) {
		if (map.isDaily()) {
			this.totalDayTemp = this.totalDayTemp.add(map.getMain().getTemp());
			this.dayCount++;
		} else {
			this.totalNightTemp = this.totalNightTemp.add(map.getMain().getTemp());
			this.nightCount++;
		}
		this.totalHumidity = this.totalHumidity.add(map.getMain().getHumidity());
		this.humidityCount++;
	}

	public void totalizer() {
		this.dayTemperature = (this.dayCount > 0)
				? this.totalDayTemp.divide(new BigDecimal(this.dayCount.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.nightTemperature = (this.nightCount > 0)
				? this.totalNightTemp.divide(new BigDecimal(this.nightCount.toString()), 2, RoundingMode.HALF_UP)
				: null;
		this.humidity = (this.humidityCount > 0)
				? this.totalHumidity.divide(new BigDecimal(this.humidityCount.toString()), 2, RoundingMode.HALF_UP)
				: null;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public BigDecimal getDayTemperature() {
		return dayTemperature;
	}

	public void setDayTemperature(BigDecimal dayTemperature) {
		this.dayTemperature = dayTemperature;
	}

	public BigDecimal getNightTemperature() {
		return nightTemperature;
	}

	public void setNightTemperature(BigDecimal nightTemperature) {
		this.nightTemperature = nightTemperature;
	}

	public BigDecimal getHumidity() {
		return humidity;
	}

	public void setHumidity(BigDecimal humidity) {
		this.humidity = humidity;
	}

	public BigDecimal getTotalDayTemp() {
		return totalDayTemp;
	}

	public void setTotalDayTemp(BigDecimal totalDayTemp) {
		this.totalDayTemp = totalDayTemp;
	}

	public Integer getDayCount() {
		return dayCount;
	}

	public void setDayCount(Integer dayCount) {
		this.dayCount = dayCount;
	}

	public BigDecimal getTotalNightTemp() {
		return totalNightTemp;
	}

	public void setTotalNightTemp(BigDecimal totalNightTemp) {
		this.totalNightTemp = totalNightTemp;
	}

	public Integer getNightCount() {
		return nightCount;
	}

	public void setNightCount(Integer nightCount) {
		this.nightCount = nightCount;
	}

	public BigDecimal getTotalHumidity() {
		return totalHumidity;
	}

	public void setTotalHumidity(BigDecimal totalHumidity) {
		this.totalHumidity = totalHumidity;
	}

	public Integer getHumidityCount() {
		return humidityCount;
	}

	public void setHumidityCount(Integer humidityCount) {
		this.humidityCount = humidityCount;
	}

}
