package com.fred.poi.service.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.fred.common.ExcelUtil;
import com.fred.poi.service.ImportExcelService;

@Component("importExcelService")
public class ImportExcelServiceImpl implements ImportExcelService{

	public void importExcel(String filePath){
		ExcelUtil e = new ExcelUtil(filePath);
		int sheetNum = e.getSheetNum();
		for(int i=0 ; i < sheetNum; i++){
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
		
	
	private String getStrings(String[] args){
		String rtn = "";
		for (String str : args){
			rtn += "," + str;
		}
		if (rtn.length() >= 1){
			return rtn.substring(1);
		}
		return rtn;
	}
}
