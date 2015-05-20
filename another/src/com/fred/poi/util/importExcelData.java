package com.fred.poi.util;

import java.util.List;

import com.fred.common.ExcelUtil;

public class importExcelData {
	
	public static void importExcel(String filePath){
		ExcelUtil e = new ExcelUtil(filePath);
		int sheetNum = e.getSheetNum();
		for(int i=0 ; i < sheetNum; i++){
			System.out.println(i);
			List<String[]> dataList = e.getAllData(i);
			int rowNum = 0;
			for (String[] row : dataList){
				rowNum++;
				if(rowNum == 1){
					continue;
				}
				else {
					System.out.println(getStrings(row));
				}
			}
		}
	}
	
	private static String getStrings(String[] args){
		String rtn = "";
		for (String str : args){
			rtn += "," + str;
		}
		if (rtn.length() >= 1){
			return rtn.substring(1);
		}
		return rtn;
	}
	
	public static void main(String[] args){
		importExcel("D:/1.xlsx");
	}
}
