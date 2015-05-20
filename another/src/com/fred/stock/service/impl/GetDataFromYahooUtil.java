package com.fred.stock.service.impl;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fred.stock.entity.StockData;

public class GetDataFromYahooUtil {

	  public static final String YAHOO_FINANCE_URL = "http://table.finance.yahoo.com/table.csv?";
	    public static final String YAHOO_FINANCE_URL_TODAY = "http://download.finance.yahoo.com/d/quotes.csv?";

	    /**
	     * ���� ��Ʊ���롢��ʼ���ڡ��������� ��ȡ��Ʊ����
	     * @author �����
	     * @param stockName  ���У�000000.ss ���У�000000.sz
	     * @param fromDate    ��ʼ����
	     * @param toDate         ��������
	     * @return List<StockData>
	     */
	    public  List<StockData> getStockCsvData(String stockName, String fromDate,String toDate) {
	        List<StockData> list = new ArrayList<StockData>();
	        String[] datefromInfo= fromDate.split("-");
	        String[] toDateInfo = toDate.split("-");
	        String code = stockName.substring(0, 6);;
	        
	        String a = (Integer.valueOf(datefromInfo[1])-1)+"";// a �C ��ʼʱ�䣬��
	        String b = datefromInfo[2];// b �C ��ʼʱ�䣬��
	        String c =  datefromInfo[0];// c �C ��ʼʱ�䣬��
	        String d = (Integer.valueOf(toDateInfo[1])-1)+"";// d �C ����ʱ�䣬��
	        String e = toDateInfo[2];// e �C ����ʱ�䣬��
	        String f =  toDateInfo[0];// f �C ����ʱ�䣬��
	        
	        String params = "&a=" + a + "&b=" + b + "&c=" + c + "&d=" + d + "&e="
	                + e + "&f=" + f;
	        String url = YAHOO_FINANCE_URL + "s=" + stockName + params;
	        
	        URL MyURL = null;
	        URLConnection con = null;
	        InputStreamReader ins = null;
	        BufferedReader in = null;
	        try {
	            MyURL = new URL(url);
	            con = MyURL.openConnection();
	            ins = new InputStreamReader(con.getInputStream(), "UTF-8");
	            in = new BufferedReader(ins);

	            String newLine = in.readLine();// ������
	            
	            while ((newLine = in.readLine()) != null) {
	                String stockInfo[] = newLine.trim().split(",");
	                StockData sd = new StockData();
	                sd.setCode(code);
	                sd.setDate(stockInfo[0]);
	                sd.setOpen(Double.valueOf(stockInfo[1]));
	                sd.setHigh(Double.valueOf(stockInfo[2]));
	                sd.setLow(Double.valueOf(stockInfo[3]));
	                sd.setClose(Double.valueOf(stockInfo[4]));
	                sd.setVolume(Double.valueOf(stockInfo[5]));
	                list.add(sd);
	            }

	        } catch (Exception ex) {
	            return null; //�޽�������
	        } finally {
	            if (in != null)
	                try {
	                    in.close();
	                } catch (IOException ex) {
	                    ex.printStackTrace();
	                }
	        }
	        return list;
	
	    }
	    
	    /**
	     * ���� ��Ʊ���롢���� ��ȡ��Ʊ����
	     * @author �����
	     * @param stockName   ���У�000000.ss ���У�000000.sz
	     * @param date ����
	     * @return StockData
	     */
	    public StockData getStockCsvData(String stockName, String date){
	        List<StockData> list = getStockCsvData(stockName,date,date);
	        if(list == null){
	        	return null;
	        }
	        else{
	            return ((list.size()>0)?list.get(0):null);
	        }	
	    }
	    /**
	     * ���� ��Ʊ���� ��ȡ�����Ʊ����
	     * @author �����
	     * @param stockName   ���У�000000.ss ���У�000000.sz
	     * @return StockData
	     */
	    public StockData getStockCsvData(String stockName){
	        String date = String.format("%1$tF", new Date());
	        List<StockData> list = getStockCsvData(stockName,date,date);
	        return ((list!=null&&list.size()>0)?list.get(0):null);
	    }
	}
