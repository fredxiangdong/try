package com.fred.poi.service;

import java.util.ArrayList;

import com.fred.poi.entity.RoadSign;

public interface ImportDocService {

	public ArrayList<RoadSign> readSignFromDoc(String filePath);
	
	public void writeRoadSignToExcl(String dir, String fileName,
			ArrayList<RoadSign> list, String sheetName);
}