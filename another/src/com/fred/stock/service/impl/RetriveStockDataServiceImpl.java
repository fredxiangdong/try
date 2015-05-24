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
    		 System.out.println("日期：\t"+sd.getDate());
    		 System.out.println("股票名称：\t"+sd.getName());
    		 System.out.println("股票代码：\t"+sd.getCode());
    		 System.out.println("开盘价：\t"+sd.getOpen());
    		 System.out.println("最高价：\t"+sd.getHigh());
    		 System.out.println("最低价：\t"+sd.getLow());
    		 System.out.println("收盘价：\t"+sd.getClose());
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
	        	System.out.println("第"+ i + "支股票信息如下：");
	        	stockData.addAll(retriveNamedStock(stockType.getStockCode(),stockType.getStockName()));
	        	retriveNamedStock(stockType.getStockCode(),stockType.getStockName());
	        	i++;
	        }
	        session.getTransaction().commit();
	}

}
