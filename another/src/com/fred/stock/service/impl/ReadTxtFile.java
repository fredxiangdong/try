package com.fred.stock.service.impl;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;

import com.fred.common.UUIDGenerator;
import com.fred.stock.entity.StockType;
import com.fred.system.HibernateSessionFactory;

public class ReadTxtFile {
	
    public static List<StockType> readTxtFile(String filePath) {
    	List<StockType> stockList = new ArrayList<StockType>();
        try {
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                	InputStreamReader read = new InputStreamReader(new FileInputStream(file),"GBK");
                	BufferedReader bufferedReader  = new BufferedReader(read);
                	String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	if(lineTxt.indexOf("\" target=\"_blank\" title=\"")!= -1){
                    		String text = lineTxt.substring(lineTxt.indexOf("\">")+2,lineTxt.indexOf("</a></li>"));
                    		StockType stock = new StockType();
                    		String[] msg = text.split(" ");
                    		StringBuffer name = new StringBuffer();
                    		for(int i = 0; i<msg.length-1 ;i++){
                    			name.append(msg[i]);
                    		}
                    		stock.setStockName(name.toString());
                    		stock.setStockCode(msg[msg.length-1]+".ss");
                    		stockList.add(stock);
                    	}
                       	if(lineTxt.indexOf("深市>深市")!= -1){
                    		break;
                    	}
                    }
                    read.close();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockList;
    }
    
    public static List<StockType> readSZTxtFile(String filePath) {
    	List<StockType> stockList = new ArrayList<StockType>();
        try {
                File file=new File(filePath);
                if(file.isFile() && file.exists()){ //判断文件是否存在
                	InputStreamReader read = new InputStreamReader(new FileInputStream(file),"GBK");
                	BufferedReader bufferedReader  = new BufferedReader(read);
                	String lineTxt = null;
                    while((lineTxt = bufferedReader.readLine()) != null){
                    	if(lineTxt.indexOf("\" target=\"_blank\" title=\"")!= -1){
                    		String text = lineTxt.substring(lineTxt.indexOf("\">")+2,lineTxt.indexOf("</a></li>"));
                    		StockType stock = new StockType();
                    		String[] msg = text.split(" ");
                    		StringBuffer name = new StringBuffer();
                    		for(int i = 0; i<msg.length-1 ;i++){
                    			name.append(msg[i]);
                    		}
                    		stock.setStockName(name.toString());
                    		stock.setStockCode(msg[msg.length-1]+".sz");
                    		stockList.add(stock);
                    	}
                       	if(lineTxt.indexOf("深市>深市")!= -1){
                    		break;
                    	}
                    }
                    read.close();
                }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return stockList;
    }
    
    
    public static void main(String[] args){
    	List<StockType> shStockList = readTxtFile("D:/stock.txt");
//    	List<StockType> shStockList = readSZTxtFile("D:/stock.txt");
    	Session session=null;
    	UUIDGenerator uuid = new UUIDGenerator();
    	 try{
    		  session = HibernateSessionFactory.getSessionFactory().openSession();
    		  session.beginTransaction();
    		  for(StockType stock:shStockList){
    			  stock.setStockId(uuid.generate().toString());
    			  System.out.println(stock.getStockId()+":"+stock.getStockName()+":"+stock.getStockCode());
    			  session.saveOrUpdate(stock);
    		  }
    		  session.getTransaction().commit();
    	}catch(Exception e){
    		e.printStackTrace();
    	}finally{
    		HibernateSessionFactory.closeSession();
    	}
    }
    
}
