package com.fred.weather.entity;

/** 
 * ����Ԥ���࣬����Ԥ���Ļ������ԡ� 
 * @author siqi 
 * 
 */  
public class WeatherReport {  
  
    /** 
     * ���У����أ� 
     */  
    private String city;  
    /** 
     * ���� 
     */  
    private String date;  
    /** 
     * ���ڼ� 
     */  
    private String weekDay;  
    /** 
     * ���� 
     */  
    private String weather;  
    /** 
     * �¶� 
     */  
    private String temperature;  
    /** 
     * ���� 
     */  
    private String windDir;  
    /** 
     * ���� 
     */  
    private String wind;  
      
    /** 
     * ���컹������ 
     */  
    private String dayOrNight;  
  
    /** 
     * ��ȡ����Ԥ���ĳ��С� 
     * @return 
     */  
    public String getCity() {  
        return city;  
    }  
  
    /** 
     * ��������Ԥ���ĳ��С� 
     * @param city 
     */  
    public void setCity(String city) {  
        this.city = city;  
    }  
  
    /** 
     * ��ȡ����Ԥ�������ڣ���ʽΪ"1��28��" 
     * @return 
     */  
    public String getDate() {  
        return date;  
    }  
  
    /** 
     * ��������Ԥ�������ڣ���ʽΪ"1��28��" 
     * @param date 
     */  
    public void setDate(String date) {  
        this.date = date;  
    }  
  
    /** 
     * ��ȡ����Ԥ�������� 
     * @return 
     */  
    public String getWeekDay() {  
        return weekDay;  
    }  
  
    /** 
     * ��������Ԥ�������� 
     * @param weekDay 
     */  
    public void setWeekDay(String weekDay) {  
        this.weekDay = weekDay;  
    }  
  
    /** 
     * ��ȡ���� 
     * @return 
     */  
    public String getWeather() {  
        return weather;  
    }  
  
    /** 
     * �������� 
     * @param weather 
     */  
    public void setWeather(String weather) {  
        this.weather = weather;  
    }  
  
    /** 
     * ��ȡ�¶� 
     * @return 
     */  
    public String getTemperature() {  
        return temperature;  
    }  
  
    /** 
     * �����¶� 
     * @param temperature 
     */  
    public void setTemperature(String temperature) {  
        this.temperature = temperature;  
    }  
  
    /** 
     * ��ȡ���� 
     * @return 
     */  
    public String getWindDir() {  
        return windDir;  
    }  
  
    /** 
     * ���÷��� 
     * @param windDir 
     */  
    public void setWindDir(String windDir) {  
        this.windDir = windDir;  
    }  
  
    /** 
     * ��ȡ���� 
     * @return 
     */  
    public String getWind() {  
        return wind;  
    }  
  
    /** 
     * ���÷��� 
     * @param wind 
     */  
    public void setWind(String wind) {  
        this.wind = wind;  
    }  
  
    /** 
     * ��ȡ����Ԥ���ǰ��컹������ 
     * @return 
     */  
    public String getDayOrNight() {  
        return dayOrNight;  
    }  
  
    /** 
     * ��������Ԥ���ǰ��컹������ 
     * @param dayOrNight 
     */  
    public void setDayOrNight(String dayOrNight) {  
        this.dayOrNight = dayOrNight;  
    }  
  
    /** 
     * ����Ԥ�����ַ��� 
     */  
    public String toString() {  
        return "WeatherReport [city=" + city + ", date=" + date + ", weekDay="  
                + weekDay + ", weather=" + weather + ", temperature="  
                + temperature + ", windDir=" + windDir + ", wind=" + wind  
                + ", dayOrNight=" + dayOrNight + "]";  
    }  
  
}