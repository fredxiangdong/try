package com.fred.poi.entity;


public class RoadSign {

	private String msAdress;
	private String location;
	private String number;
	private String signType;
	private String signTypeCode;
	private String signShape;
	private String signSize;
	private String signMaterial;
	private String signHoudu;
	private String signFGCL;
	private String lz_ZCFS;
	private String lz_CL;
	private String lz_size;
	private String lz_high;
	private String lz_zb;
	private String lz_ffcl;
	private String jc_xs;
	private String jc_size;
	private String jc_tongbj;
	private String yongtu;
	private String sy_width;
	private String photo_name;
	private String file_name;
	private String file_nameB;
	
	
	//浠ヤ笅涓轰綅缃俊鎭細
	private String busiCode;
	private String roadShotName;
	private String sectionGrade;
	private String beginMilestone;
	private String upDown;
	private String offSetType;
	private String offSetValue;
	private String remark;

	private String fileNameB_index;

	public String[] getTrueArray(){
		String [] roadSignArray=new String[29];
		roadSignArray[0]=this.roadShotName;
		roadSignArray[1]=this.upDown;
		roadSignArray[2]=this.beginMilestone;
		roadSignArray[3]=this.offSetType;
		roadSignArray[4]=this.offSetValue;
		roadSignArray[5]=this.number;
		roadSignArray[6]=this.signType;
		roadSignArray[7]=this.location;
		roadSignArray[8]=this.busiCode;
		roadSignArray[9]="公路局";
		roadSignArray[10]=this.sy_width;
		roadSignArray[11]=this.yongtu;
		roadSignArray[12]=this.signShape;
		roadSignArray[13]=this.signSize;
		roadSignArray[14]=this.signMaterial;
		roadSignArray[15]=this.signHoudu;
		roadSignArray[16]=this.signFGCL;
		roadSignArray[17]=this.lz_ZCFS;
		roadSignArray[18]=this.lz_CL;
		roadSignArray[19]=this.lz_size;
		roadSignArray[20]=this.lz_ffcl;
		roadSignArray[21]=this.lz_high;
		roadSignArray[22]=this.jc_xs;
		roadSignArray[23]=this.jc_size;
		roadSignArray[24]=this.jc_tongbj;
		roadSignArray[25]=this.busiCode;
		roadSignArray[26]=photo_name;
		roadSignArray[27]=this.signTypeCode;
		roadSignArray[28]=this.lz_zb;
		return roadSignArray;
		
	}
	
	public String[] getArray(){
		String [] roadSignArray=new String[30];
		roadSignArray[0]=msAdress;
		roadSignArray[1]=location;
		roadSignArray[2]=signType;
		roadSignArray[3]=signTypeCode;
		roadSignArray[4]=signShape;
		roadSignArray[5]=signSize;
		roadSignArray[6]=signMaterial;
		roadSignArray[7]=signHoudu;
		roadSignArray[8]=signFGCL;
		roadSignArray[9]=lz_ZCFS;
		roadSignArray[10]=lz_CL;
		roadSignArray[11]=lz_size;
		roadSignArray[12]=lz_high;
		roadSignArray[13]=lz_zb;
		roadSignArray[14]=lz_ffcl;
		roadSignArray[15]=jc_xs;
		roadSignArray[16]=jc_size;
		roadSignArray[17]=jc_tongbj;
		roadSignArray[18]=yongtu;
		roadSignArray[19]=sy_width;
		roadSignArray[20]=busiCode;
		roadSignArray[21]=roadShotName;
		roadSignArray[22]=sectionGrade;
		roadSignArray[23]=beginMilestone;
		roadSignArray[24]=upDown;
		roadSignArray[25]=remark;
		roadSignArray[26]=photo_name;
		roadSignArray[27]=file_name;
		roadSignArray[28]=file_nameB;
		roadSignArray[29]=fileNameB_index;
		return roadSignArray;
	}
	public String getBeginMilestone() {
		return beginMilestone;
	}
	public String getBusiCode() {
		return busiCode;
	}
	public String getFile_name() {
		return file_name;
	}
	public String getFile_nameB() {
		return file_nameB;
	}
	public String getFileNameB_index() {
		return fileNameB_index;
	}
	public String getJc_size() {
		return jc_size;
	}
	public String getJc_tongbj() {
		return jc_tongbj;
	}
	public String getJc_xs() {
		return jc_xs;
	}
	public String getLocation() {
		return location;
	}
	public String getLz_CL() {
		return lz_CL;
	}
	public String getLz_ffcl() {
		return lz_ffcl;
	}
	public String getLz_high() {
		return lz_high;
	}
	public String getLz_size() {
		return lz_size;
	}
	public String getLz_zb() {
		return lz_zb;
	}
	public String getLz_ZCFS() {
		return lz_ZCFS;
	}
	public String getMsAdress() {
		return msAdress;
	}
	public String getNumber() {
		return number;
	}
	public String getPhoto_name() {
		return photo_name;
	}
	public String getRemark() {
		return remark;
	}
	public String getRoadShotName() {
		return roadShotName;
	}
	public String getSectionGrade() {
		return sectionGrade;
	}
	public String getSignFGCL() {
		return signFGCL;
	}
	public String getSignHoudu() {
		return signHoudu;
	}
	public String getSignMaterial() {
		return signMaterial;
	}
	public String getSignShape() {
		return signShape;
	}
	public String getSignSize() {
		return signSize;
	}
	public String getSignType() {
		return signType;
	}
	public String getSy_width() {
		return sy_width;
	}
	public String getUpDown() {
		return upDown;
	}
	public String getYongtu() {
		return yongtu;
	}
	public void setBeginMilestone(String beginMilestone) {
		this.beginMilestone = beginMilestone;
	}
	public void setBusiCode(String busiCode) {
		this.busiCode = busiCode;
	}
	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}
	public void setFile_nameB(String file_nameB) {
		this.file_nameB = file_nameB;
	}
	public void setFileNameB_index(String fileNameB_index) {
		this.fileNameB_index = fileNameB_index;
	}
	public void setJc_size(String jc_size) {
		this.jc_size = jc_size;
	}
	public void setJc_tongbj(String jc_tongbj) {
		this.jc_tongbj = jc_tongbj;
	}
	public void setJc_xs(String jc_xs) {
		this.jc_xs = jc_xs;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public void setLz_CL(String lz_CL) {
		this.lz_CL = lz_CL;
	}
	public void setLz_ffcl(String lz_ffcl) {
		this.lz_ffcl = lz_ffcl;
	}
	public void setLz_high(String lz_high) {
		this.lz_high = lz_high;
	}
	public void setLz_size(String lz_size) {
		this.lz_size = lz_size;
	}
	public void setLz_zb(String lz_zb) {
		this.lz_zb = lz_zb;
	}
	public void setLz_ZCFS(String lz_ZCFS) {
		this.lz_ZCFS = lz_ZCFS;
	}
	public void setMsAdress(String msAdress) {
		this.msAdress = msAdress;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public void setPhoto_name(String photo_name) {
		this.photo_name = photo_name;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	public void setRoadShotName(String roadShotName) {
		this.roadShotName = roadShotName;
	}
	public void setSectionGrade(String sectionGrade) {
		this.sectionGrade = sectionGrade;
	}
	public void setSignFGCL(String signFGCL) {
		this.signFGCL = signFGCL;
	}
	public void setSignHoudu(String signHoudu) {
		this.signHoudu = signHoudu;
	}
	public void setSignMaterial(String signMaterial) {
		this.signMaterial = signMaterial;
	}
	public void setSignShape(String signShape) {
		this.signShape = signShape;
	}
	public void setSignSize(String signSize) {
		this.signSize = signSize;
	}
	public void setSignType(String signType) {
		this.signType = signType;
	}
	public void setSy_width(String sy_width) {
		this.sy_width = sy_width;
	}
	public void setUpDown(String upDown) {
		this.upDown = upDown;
	}
	public void setYongtu(String yongtu) {
		this.yongtu = yongtu;
	}
	public String getOffSetType() {
		return offSetType;
	}

	public void setOffSetType(String offSetType) {
		this.offSetType = offSetType;
	}

	public String getOffSetValue() {
		return offSetValue;
	}

	public void setOffSetValue(String offSetValue) {
		this.offSetValue = offSetValue;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "RoadSign [msAdress=" + msAdress + ", location=" + location
				+ ", signType=" + signType + ", signTypeCode=" + signTypeCode 
				+ ", number=" + number
				+ ", signShape=" + signShape + ", signSize=" + signSize
				+ ", signMaterial=" + signMaterial + ", signHoudu=" + signHoudu
				+ ", signFGCL=" + signFGCL + ", lz_ZCFS=" + lz_ZCFS
				+ ", lz_CL=" + lz_CL + ", lz_size=" + lz_size 
				+ ", lz_high="+ lz_high + ", lz_zb=" + lz_zb 
				+ ", lz_ffcl=" + lz_ffcl + ", jc_xs=" + jc_xs 
				+ ", jc_size=" + jc_size + ", jc_tongbj=" + jc_tongbj 
				+ ", yongtu=" + yongtu + ", sy_width=" + sy_width
				+ ", busiCode=" + busiCode
				+ ", roadShotName=" + roadShotName + ", sectionGrade=" + sectionGrade
				+ ",beginMilestone=" + beginMilestone + ", upDown=" + upDown 
				+ ", remark=" + remark
				+ ", photo_name=" + photo_name + ", file_name=" + file_name
				+ ", file_nameB=" + file_nameB + ", fileNameB_index=" + fileNameB_index
				+ "]";
	}

	public String getSignTypeCode() {
		return signTypeCode;
	}

	public void setSignTypeCode(String signTypeCode) {
		this.signTypeCode = signTypeCode;
	}

}
