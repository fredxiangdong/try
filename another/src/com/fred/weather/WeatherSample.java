package com.fred.weather;

import java.util.List;

import com.fred.weather.entity.WeatherReport;

public class WeatherSample {  
	  
    /** 
     * һ���򵥵�Ӧ�� 
     *  
     * @param args 
     */  
    public static void main(String[] args) {  
        // ��ȡ�ɶ�������Ԥ����Ϣ��  
        String city = "��̨";  
        System.out.println(city + "δ��7������Ԥ����Ϣ��");  
        List<WeatherReport> listReport = new WeatherUtil()  
                .getWeatherReports(city);  
        if (listReport.size() < 1) {  
            System.out.println("û���ҵ� " + city + " ������Ԥ����");  
        } else {  
            for (WeatherReport report : listReport) {  
                System.out.println(report);  
            }  
        }  
    }  
  
}