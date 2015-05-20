package com.fred.poi.service.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFHyperlink;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hwpf.HWPFDocument;
import org.apache.poi.hwpf.usermodel.Picture;
import org.apache.poi.hwpf.usermodel.Range;
import org.apache.poi.hwpf.usermodel.Table;
import org.apache.poi.hwpf.usermodel.TableIterator;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.springframework.stereotype.Component;

import com.fred.common.HyCommonUtil;
import com.fred.poi.entity.RoadSign;
import com.fred.poi.service.ImportDocService;

@Component("importDocService")
public class ImportDocServiceImpl implements ImportDocService{

	public ArrayList<RoadSign> readSignFromDoc(String filePath) {
		ArrayList<RoadSign> list = new ArrayList<RoadSign>();
		FileInputStream in = null;
		POIFSFileSystem pfs = null;
		HWPFDocument hwpf = null;
		FileOutputStream os = null;
		String rtnPath = "E:/";
		String fileName = "1.doc";
		try {
			File filedir = new File(rtnPath);
			if (!filedir.exists() && !filedir.isDirectory()) {
				filedir.mkdir();
			}
			String picDir = rtnPath + "ͼƬ/";
			File file = new File(picDir);
			if (!file.exists() && !file.isDirectory()) {
				file.mkdir();
			}
			in = new FileInputStream(rtnPath + fileName);
			pfs = new POIFSFileSystem(in);
			hwpf = new HWPFDocument(pfs);
			Range range = hwpf.getRange();// �õ��ĵ��Ķ�ȡ��Χ
			TableIterator it = new TableIterator(range); // �����ĵ��еı��
			int numPic = 0;
			int count = 1;

			while (it.hasNext()) {
				// ����������Ϣ��
				Table tb = it.next();// ������Ϣ
				String temp = "";
				char[] chars = tb.text().toCharArray();
				for (int i = 0; i < chars.length; i++) {
					if ((int) chars[i] == 7) {
						temp += "|";
					} else {
						temp += chars[i];
					}
				}
				if (temp.indexOf("��Ͻ��λ") != -1) {
					temp = temp.substring(temp.indexOf("��Ͻ��λ"));
					System.out.println(count + "---------------" + temp);
					String[] table = temp.split("\\|");
					if (table.length < 18)
						continue;
					RoadSign roadSign = new RoadSign();
					roadSign.setSignTypeCode(table[3]);
					roadSign.setSignType("��ʾ��־");
					roadSign.setBusiCode(table[1]);
					ArrayList<Picture> alist = (ArrayList<Picture>) hwpf
							.getPicturesTable().getAllPictures();
					if (alist.size() <= numPic) {
						continue;
					}
					Picture picture = alist.get(numPic);
					if (picture != null) {
						String jpgName = numPic + "-"
								+ System.currentTimeMillis() + ".jpg";

						os = new FileOutputStream(picDir + jpgName);
						picture.writeImageContent(os);
						roadSign.setPhoto_name(jpgName);
						picture = null;
					} else
						System.out.println("����Ƭ��" + roadSign.getFile_name());
					numPic++;
					ArrayList<RoadSign> rslist = this.addRoadSignList(roadSign,
							table);
					if (rslist != null)
						list.addAll(rslist);

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				if (os != null)
					os.close();
				if (in != null)
					in.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return list;
	}

	
	public ArrayList<RoadSign> addRoadSignList(RoadSign roadSign, String[] table) {
		ArrayList<RoadSign> rsList = new ArrayList<RoadSign>();
		String bmStr = table[11].replaceAll("\\/", ",").replaceAll("\\\\", ",").replaceAll("��", ",");
		String udStr = table[13].replaceAll("\\/", ",").replaceAll("\\\\", ",").replaceAll("��", ",");
		if (bmStr.indexOf(",") != -1) {// && upDown.indexOf("\\") != -1
			String[] bm = bmStr.split(",");
			String[] ud = udStr.split(",");
			for (int i = 0; i < bm.length; i++) {
				RoadSign rs = new RoadSign();
				rs.setNumber(roadSign.getNumber());
				rs.setSignType(roadSign.getSignType());
				rs.setSignTypeCode(roadSign.getSignTypeCode());
				rs.setSignShape(roadSign.getSignShape());
				rs.setSignSize(roadSign.getSignSize());
				rs.setSignMaterial(roadSign.getSignMaterial());
				rs.setSignHoudu(roadSign.getSignHoudu());
				rs.setSignFGCL(roadSign.getSignFGCL());
				rs.setLz_ZCFS(roadSign.getLz_ZCFS());
				rs.setLz_CL(roadSign.getLz_CL());
				rs.setLz_size(roadSign.getLz_size());
				rs.setLz_high(roadSign.getLz_high());
				rs.setLz_zb(roadSign.getLz_zb());
				rs.setLz_ffcl(roadSign.getLz_ffcl());
				rs.setJc_xs(roadSign.getJc_xs());
				rs.setJc_size(roadSign.getJc_size());
				rs.setJc_tongbj(roadSign.getJc_tongbj());
				rs.setYongtu(roadSign.getYongtu());
				rs.setSy_width(roadSign.getSy_width());
				rs.setBusiCode(table[1]);
				rs.setRoadShotName(table[6]);
				rs.setSectionGrade(table[8]);
				rs.setBeginMilestone(bm[i]);
				rs.setPhoto_name(roadSign.getPhoto_name());
				rs.setFile_name(rs.getFile_name());
				if (ud.length <= i) {
					this.getUpDown(rs, ud[ud.length - 1]);
				} else {
					this.getUpDown(rs, ud[i]);
				}
				rsList.add(rs);
			}
		} else {
			roadSign.setBusiCode(table[1]);
			roadSign.setRoadShotName(table[6]);
			roadSign.setSectionGrade(table[8]);
			roadSign.setBeginMilestone(table[11]);
			this.getUpDown(roadSign, table[13]);
			rsList.add(roadSign);
		}
		return rsList;
	}
	
	private void getUpDown(RoadSign roadSign, String upDown) {
		if (upDown.indexOf("��") != -1) {
			upDown = "����";
		} else if (upDown.indexOf("��") != -1) {
			upDown = "����";
		}
		if ("����".equals(upDown) || "����".equals(upDown)) {
			roadSign.setUpDown(upDown);
			roadSign.setOffSetType("��·����");
			roadSign.setOffSetValue("0.5");
		} else {
			roadSign.setUpDown("����");
			roadSign.setOffSetType("������");
			roadSign.setOffSetValue("0");
		}
	}
	
	
	public void writeRoadSignToExcl(String dir, String fileName,
			ArrayList<RoadSign> list, String sheetName) {
		FileOutputStream out = null;
		try {
			FileInputStream in = null;
			HSSFWorkbook wb = null;
			File excel = new File(fileName); // ��ȡ�ļ�
			if (!excel.exists()) {
				wb = new HSSFWorkbook(); // ����excel�ļ�����
			} else {
				in = new FileInputStream(excel); // ת��Ϊ��
				wb = new HSSFWorkbook(in); // ����excel�ļ�����
			}
//			HSSFSheet sheet = wb.createSheet(sheetName); // ����һ���ű�
			HSSFSheet sheet = wb.createSheet(Long.toString(System.currentTimeMillis())); // ����һ���ű�
			HSSFRow rowTitle0 = sheet.createRow(0);// �����ж���
			rowTitle0.createCell(0).setCellValue("��·��־");
			rowTitle0.createCell(28).setCellValue(" ");
			HSSFRow rowTitle1 = sheet.createRow(1);// �����ж���
			rowTitle1.createCell(0).setCellValue(
					"SZGL_DA_ROAD_SIGN_TEMP.LINE_CODE");
			rowTitle1.createCell(1).setCellValue("UP_DOWN");
			rowTitle1.createCell(2).setCellValue("MIDDLE_MILESTONE");
			rowTitle1.createCell(3).setCellValue("OFF_SET_TYPE");
			rowTitle1.createCell(4).setCellValue("OFF_SET_VALUE");
			rowTitle1.createCell(5).setCellValue("SIGN_NO");
			rowTitle1.createCell(6).setCellValue("SIGN_CATEGORIES");
			rowTitle1.createCell(7).setCellValue("LACATION");
			rowTitle1.createCell(8).setCellValue("RULE_CODE");
			rowTitle1.createCell(9).setCellValue("PROPERTY_RIGHT");
			rowTitle1.createCell(10).setCellValue("SUITABLE_ROAD_WIDTH");
			rowTitle1.createCell(11).setCellValue("APPLICATION");
			rowTitle1.createCell(12).setCellValue("SHAPE");
			rowTitle1.createCell(13).setCellValue("BOARD_SIZE");
			rowTitle1.createCell(14).setCellValue("MATERIAL");
			rowTitle1.createCell(15).setCellValue("THICKNESS");
			rowTitle1.createCell(16).setCellValue("REFLECTING_MATERIAL");
			rowTitle1.createCell(17).setCellValue("SUPPORT_FOMR");
			rowTitle1.createCell(18).setCellValue("BRACE_MATERIAL");
			rowTitle1.createCell(19).setCellValue("BRACE_SIZE");
			rowTitle1.createCell(20).setCellValue("ANTISEPTIC_DEAL");
			rowTitle1.createCell(21).setCellValue("BRACE_HEIGHT");
			rowTitle1.createCell(22).setCellValue("FOUNDATION_FORM");
			rowTitle1.createCell(23).setCellValue("FOUNDATION__SIZE");
			rowTitle1.createCell(24).setCellValue("CONCRETE_NO");
			rowTitle1.createCell(25).setCellValue("BUSI_CODE");
			rowTitle1.createCell(26).setCellValue("PHOTO");
			rowTitle1.createCell(27).setCellValue("ROAD_SIGN_NAME");
			rowTitle1.createCell(28).setCellValue("BRACE_BRACKET");
			HSSFRow rowTitle2 = sheet.createRow(2);// �����ж���
			rowTitle2.createCell(0).setCellValue("����·��");
			rowTitle2.createCell(1).setCellValue("������");
			rowTitle2.createCell(2).setCellValue("���׮��");
			rowTitle2.createCell(3).setCellValue("ƫ��λ��");
			rowTitle2.createCell(4).setCellValue("ƫ�������ף�");
			rowTitle2.createCell(5).setCellValue("��־���");
			rowTitle2.createCell(6).setCellValue("��־����");
			rowTitle2.createCell(7).setCellValue("��־λ��");
			rowTitle2.createCell(8).setCellValue("��Ͻ��λ");
			rowTitle2.createCell(9).setCellValue("��Ȩ����");
			rowTitle2.createCell(10).setCellValue("����·���ȣ��ף�");
			rowTitle2.createCell(11).setCellValue("��;");
			rowTitle2.createCell(12).setCellValue("������״");
			rowTitle2.createCell(13).setCellValue("����ߴ磨mm��");
			rowTitle2.createCell(14).setCellValue("����");
			rowTitle2.createCell(15).setCellValue("��ȣ�mm��");
			rowTitle2.createCell(16).setCellValue("�������");
			rowTitle2.createCell(17).setCellValue("֧�ŷ�ʽ");
			rowTitle2.createCell(18).setCellValue("��������");
			rowTitle2.createCell(19).setCellValue("����ֱ����mm��");
			rowTitle2.createCell(20).setCellValue("��������");
			rowTitle2.createCell(21).setCellValue("�����߶ȣ�mm��");
			rowTitle2.createCell(22).setCellValue("������ʽ");
			rowTitle2.createCell(23).setCellValue("�ߴ磨mm��");
			rowTitle2.createCell(24).setCellValue("�ű��");
			rowTitle2.createCell(25).setCellValue("����λ");
			rowTitle2.createCell(26).setCellValue("����ͼƬ");
			rowTitle2.createCell(27).setCellValue("��־����");
			rowTitle2.createCell(28).setCellValue("����֧��");

			// ѭ����
			for (int i = 3; i < list.size() + 3; i++) {
				RoadSign roadSign = list.get(i - 3);
				HSSFRow row = sheet.createRow(i);// �����ж���
				// �и�ֵ
				String[] roadSignArray = roadSign.getTrueArray();
				for (int j = 0; j < roadSignArray.length; j++) {
					HSSFCell cell = row.createCell(j);// ������Ԫ��
					if (j == 2) {
						String temp = roadSignArray[j].replaceAll("\\+", ".");
						if (temp.indexOf("K") != -1) {
							cell.setCellValue(temp.replaceAll("K", ""));
						} else
							cell.setCellValue(temp);
					} else if (j == 26) { // ����������
						if (HyCommonUtil.strIsNull(roadSign.getPhoto_name())) {
							continue;
						}
						HSSFHyperlink link = new HSSFHyperlink(
								HSSFHyperlink.LINK_URL);
						link.setAddress("file:///" + dir + "ͼƬ\\"
								+ roadSign.getPhoto_name());
						cell.setHyperlink(link);// �趨��Ԫ�������
						cell.setCellValue(roadSignArray[j]);
					} else {
						cell.setCellValue(roadSignArray[j]);
					}
				}
			}
			out = new FileOutputStream(fileName);
			wb.write(out);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (out != null)
					out.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}
