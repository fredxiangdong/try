package com.fred.stock.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.springframework.stereotype.Component;

import com.fred.stock.entity.StockData;
import com.fred.stock.entity.StockType;
import com.fred.stock.service.RetriveStockDataService;
import com.fred.system.HibernateSessionFactory;

@Component("retriveStockDataService")
public class RetriveStockDataServiceImpl implements RetriveStockDataService{

    public List<StockData> retriveNamedStock(String stockCode,String stockName){
    	System.out.println(stockName);
    	 GetDataFromYahooUtil stockUtil = new GetDataFromYahooUtil();
    	 List<StockData> sdLs = stockUtil.getStockCsvData("600395.ss", "2014-01-01", "2015-04-08");
    	 for(StockData sd : sdLs){
    		 sd.setName(stockName);
    		 System.out.println("���ڣ�\t"+sd.getDate());
    		 System.out.println("��Ʊ���ƣ�\t"+sd.getName());
    		 System.out.println("��Ʊ���룺\t"+sd.getCode());
    		 System.out.println("���̼ۣ�\t"+sd.getOpen());
    		 System.out.println("��߼ۣ�\t"+sd.getHigh());
    		 System.out.println("��ͼۣ�\t"+sd.getLow());
    		 System.out.println("���̼ۣ�\t"+sd.getClose());
    	 }
    	 return sdLs;
    }

    @SuppressWarnings("unchecked") 
	public void retriveData() {
		 Session session = HibernateSessionFactory.getSessionFactory().openSession();
	        session.beginTransaction();
	        List<StockType> stockLs = session.createQuery("from StockType stock where stock.editFlag = 'Y' ").list();
	        int i = 1;
	        List<StockData> stockData = new ArrayList<StockData>();
	        for(StockType stockType:stockLs){
	        	System.out.println("��"+ i + "֧��Ʊ��Ϣ���£�");
	        	stockData.addAll(retriveNamedStock(stockType.getStockCode(),stockType.getStockName()));
	        	retriveNamedStock(stockType.getStockCode(),stockType.getStockName());
	        	i++;
	        }
	        session.getTransaction().commit();
	}

}
