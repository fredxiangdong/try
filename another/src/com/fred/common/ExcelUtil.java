package com.fred.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;


public class ExcelUtil {

	Workbook wb = null;
	List<String[]> dataList = new ArrayList<String[]>(100);

	public ExcelUtil(String filePath) {
		try {
			InputStream inp = new FileInputStream(filePath);
			wb = WorkbookFactory.create(inp);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/** 
	  * 取Excel所有数据，包含header 
	  * @return  List<String[]> 
	  */
	public List<String[]> getAllData(int sheetIndex) {
		dataList = new ArrayList<String[]>(100);
		int columnNum = 0;
		Sheet sheet = wb.getSheetAt(sheetIndex);
		if (sheet.getRow(0) != null) {
			columnNum = sheet.getRow(0).getLastCellNum() - sheet.getRow(0).getFirstCellNum();
		}
		if (columnNum <= 0)
			return dataList;
		for (Row row : sheet) {
			String[] singleRow = new String[columnNum];
			int n = 0;
			for (int i = 0; i < columnNum; i++) {
				Cell cell = row.getCell(i, Row.CREATE_NULL_AS_BLANK);
				switch (cell.getCellType()) {
				case Cell.CELL_TYPE_BLANK:
					singleRow[n] = "";
					break;
				case Cell.CELL_TYPE_BOOLEAN:
					singleRow[n] = Boolean.toString(cell.getBooleanCellValue());
					break;
				// 数值
				case Cell.CELL_TYPE_NUMERIC:
					try {
						String format = cell.getCellStyle().getDataFormatString();
						format = format.replaceAll("[\"|\']", "").replaceAll("[年|月|日|时|分|秒|毫秒|微秒]", "");
						if (DateUtil.isADateFormat(cell.getCellStyle().getDataFormat(), format)||DateUtil.isCellDateFormatted(cell)) {
							Timestamp tt = new Timestamp(cell.getDateCellValue().getTime());
							singleRow[n] = tt.toString().substring(0, 10);
						} else {
							cell.setCellType(Cell.CELL_TYPE_STRING);
							String temp = cell.getStringCellValue();
							// 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
							if (temp.indexOf(".") > -1) {
								singleRow[n] = String.valueOf(new Double(temp)).trim();
							} else {
								singleRow[n] = temp.trim();
							}
						}
					} catch (NumberFormatException e) {
						cell.setCellType(Cell.CELL_TYPE_STRING);
						String temp = cell.getStringCellValue();
						// 判断是否包含小数点，如果不含小数点，则以字符串读取，如果含小数点，则转换为Double类型的字符串
						if (temp.indexOf(".") > -1) {
							singleRow[n] = String.valueOf(new Double(temp)).trim();
						} else {
							singleRow[n] = temp.trim();
						}
					}
					break;
				case Cell.CELL_TYPE_STRING:
					singleRow[n] = cell.getStringCellValue().trim();
					break;
				case Cell.CELL_TYPE_ERROR:
					singleRow[n] = "";
					break;
				case Cell.CELL_TYPE_FORMULA:
					cell.setCellType(Cell.CELL_TYPE_STRING);
					singleRow[n] = cell.getStringCellValue();
					if (singleRow[n] != null) {
						singleRow[n] = singleRow[n].replaceAll("#N/A", "").trim();
					}
					break;
				default:
					singleRow[n] = "";
					break;
				}
				n++;
			}
			if ("".equals(singleRow[0])) {
				continue;
			}// 如果第一行为空，跳过
			dataList.add(singleRow);
		}
		return dataList;
	}

	/** 
	 * 获取某一列数据 
	 * @param colIndex 
	 * @return 
	 */
	public String[] getColumnData(int sheetIndex, int colIndex) {
		String[] dataArray = null;
		if (colIndex > this.getColumnNum(sheetIndex)) {
			return dataArray;
		} else {
			if (this.dataList != null && this.dataList.size() > 0) {
				dataArray = new String[this.getRowNum(sheetIndex) + 1];
				int index = 0;
				for (String[] rowData : dataList) {
					if (rowData != null) {
						dataArray[index] = rowData[colIndex];
						index++;
					}
				}
			}
		}
		return dataArray;

	}

	/** 
	 * 返回数据的列数 
	 * @return  
	 */
	public int getColumnNum(int sheetIndex) {
		Sheet sheet = wb.getSheetAt(sheetIndex);
		Row row = sheet.getRow(0);
		if (row != null && row.getLastCellNum() > 0) {
			return row.getLastCellNum();
		}
		return 0;
	}

	/** 
	 * 返回Excel最大行index值，实际行数要加1 
	 * @return 
	 */
	public int getRowNum(int sheetIndex) {
		Sheet sheet = wb.getSheetAt(sheetIndex);
		return sheet.getLastRowNum();
	}

	public int getSheetNum() {
		return wb.getNumberOfSheets();
	}
}

