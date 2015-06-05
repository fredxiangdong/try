package com.fred.common;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
  
  
public class CSVUtil {  
  
    public static File createCSVFile(List<Map<String,String>> exportData, Map<String,String> rowMapper,  
            String outPutPath, String filename) {  
  
        File csvFile = null;  
        BufferedWriter csvFileOutputStream = null;  
        try {  
            csvFile = new File(outPutPath + filename + ".csv");  
            File parent = csvFile.getParentFile();  
            if (parent != null && !parent.exists()) {  
                parent.mkdirs();  
            }  
            csvFile.createNewFile();  
  
            // GB2312使正确读取分隔符","  
            csvFileOutputStream = new BufferedWriter(new OutputStreamWriter(  
                    new FileOutputStream(csvFile), "GB2312"), 1024);  
            // 写入文件头部  
            for (Iterator<Map.Entry<String,String>> propertyIterator = rowMapper.entrySet().iterator(); propertyIterator.hasNext();) {  
                Entry<String,String> propertyEntry = (Entry<String,String>) propertyIterator.next();  
                csvFileOutputStream.write("\""  
                        + propertyEntry.getValue().toString() + "\"");  
                if (propertyIterator.hasNext()) {  
                    csvFileOutputStream.write(",");  
                }  
            }  
            csvFileOutputStream.newLine();  
  
             
  
  
            // 写入文件内容  
            for (Iterator<Map<String,String>> iterator = exportData.iterator(); iterator.hasNext();) {    
               // Object row = (Object) iterator.next();    
                Map<String,String> row = (LinkedHashMap<String,String>) iterator.next();  
                System.out.println(row);  
               
                for (Iterator<Map.Entry<String,String>> propertyIterator = row.entrySet().iterator(); propertyIterator.hasNext();) {    
                	Entry<String,String> propertyEntry = (Entry<String,String>) propertyIterator.next();    
                   // System.out.println( BeanUtils.getProperty(row, propertyEntry.getKey().toString()));  
                    csvFileOutputStream.write("\""    
                            +  propertyEntry.getValue().toString() + "\"");    
                   if (propertyIterator.hasNext()) {    
                       csvFileOutputStream.write(",");    
                    }    
               }    
                if (iterator.hasNext()) {    
                   csvFileOutputStream.newLine();    
                }    
           }    
            csvFileOutputStream.flush();    
        } catch (Exception e) {    
           e.printStackTrace();    
        } finally {    
           try {    
                csvFileOutputStream.close();    
            } catch (IOException e) {    
               e.printStackTrace();  
           }    
       }    
        return csvFile;  
    }  
  
    public static void main(String[] args) {  
    	List<Map<String,String>> exportData = new ArrayList<Map<String,String>>();  
        Map<String, String> row1 = new LinkedHashMap<String, String>();  
        row1.put("1", "11");  
        row1.put("2", "12");  
        row1.put("3", "13");  
        row1.put("4", "14");  
        exportData.add(row1);  
        row1 = new LinkedHashMap<String, String>();  
        row1.put("1", "21");  
        row1.put("2", "22");  
        row1.put("3", "23");  
        row1.put("4", "24");  
        exportData.add(row1);  
        Map<String, String> map = new LinkedHashMap<String, String>();
        map.put("1", "第一列");  
        map.put("2", "第二列");  
        map.put("3", "第三列");  
        map.put("4", "第四列");  
        CSVUtil.createCSVFile(exportData, map, "E:/", "csvtest");  
    }  
}