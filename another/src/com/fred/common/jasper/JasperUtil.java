package com.fred.common.jasper;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRAbstractExporter;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.opensymphony.xwork2.ActionContext;

public class JasperUtil {
	/**
	 * Instantiates a new jasper helper.
	 */
	private JasperUtil() {
	}
	
	/** The Constant PRINT_TYPE. */
	public static final String PRINT_TYPE = "print";

	/** The Constant PDF_TYPE. */
	public static final String PDF_TYPE = "pdf";

	
	/**
	 * ����pdf��ע��˴��������⣬
	 * 
	 * ����Ӧ����ϸ˵����Ҫ��ireport����¾����ˡ���ͼ
	 * 
	 * 1����ireport��classpath�м���iTextAsian.jar 2����ireport��jrxmlʱ����ireport������и���������
	 * 
	 * �±ߵ����þ��ڵ��ֶε����Ժ���֡� pdf font name ��STSong-Light ��pdf encoding ��UniGB-UCS2-H
	 * 
	 * @param jasperPrint
	 *            the jasper print
	 * @param defaultFilename
	 *            the default filename
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 * @throws JRException
	 *             the jR exception
	 */
	private static Integer exportPdf(JasperPrint jasperPrint,String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException {

		ApplicationContext context = new ClassPathXmlApplicationContext("applicationPath.xml");
		String fileDir = ((Map <String,String>)context.getBean("appExtConfig")).get("filePath");
		String filePath = fileDir + defaultFilename + ".pdf";		
//		Document document = new Document();
		FileOutputStream ouputStream = new FileOutputStream(filePath);
		JasperExportManager.exportReportToPdfStream(jasperPrint, ouputStream);
		ouputStream.flush();
		ouputStream.close();
		try {
//			document.setFile(filePath);
		} catch (Exception ex) {
		}

//		return document.getNumberOfPages();
		return null;
	}



	

	/**
	 * ��ӡ.
	 * 
	 * @param jasperPrint
	 *            the jasper print
	 * @param response
	 *            the response
	 * @param request
	 *            the request
	 * @throws IOException
	 *             Signals that an I/O exception has occurred.
	 */
	private static void exportPrint(JasperPrint jasperPrint,
			HttpServletResponse response, HttpServletRequest request)
			throws IOException {
		response.setContentType("application/octet-stream");
		ServletOutputStream ouputStream = response.getOutputStream();
		ObjectOutputStream oos = new ObjectOutputStream(ouputStream);
		oos.writeObject(jasperPrint);
		oos.flush();
		oos.close();
		ouputStream.flush();
		ouputStream.close();
	}

	
	/**
	 * �������͵�����ͬ��ʽ�ļ�.
	 * 
	 * @param datas
	 *            ����
	 * @param maps
	 *            the maps
	 * @param type
	 *            �ļ�����
	 * @param defaultFilename
	 *            the default filename
	 * @param is
	 *            jasper�ļ�����Դ
	 * @param request
	 *            the request
	 * @param response
	 *            the response
	 */
	private static String export(Collection<?> datas, Map<String, Object> maps,
			String type, String defaultFilename, InputStream is,
			HttpServletRequest request, HttpServletResponse response) {
		try {
			JRDataSource ds = new JRBeanCollectionDataSource(datas, false);
			JasperPrint jasperPrint = JasperFillManager.fillReport(is, maps, ds);
				if (PDF_TYPE.equals(type)) {
				return exportPdf(jasperPrint, defaultFilename, request,
						response) + "";
			} else {
				exportPrint(jasperPrint, response, request);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * �������(���ӱ���ʹ��).
	 * 
	 * @param exportType
	 *            �����ļ�������(PDF_TYPE,EXCEL_TYPE,HTML_TYPE,WORD_TYPE)
	 * @param jaspername
	 *            jasper�ļ���·������ �磺 xxx/xx.jasper
	 * @param list
	 *            ����������
	 * @param maps
	 *            the maps
	 * @param defaultFilename
	 *            the default filename
	 */
	public static String exportmain(String exportType, String jaspername,
			List<?> list, Map<String, Object> maps, String defaultFilename) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationPath.xml");
		String fileDir = ((Map <String,String>)context.getBean("appExtConfig")).get("filePath");
		ActionContext ct = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ct
									.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = ServletActionContext.getResponse();
		File file = new File("E://"+jaspername);
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			return export(list, maps, exportType, defaultFilename, is, request,
					response);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}



	public static InputStream exportPdfDir(String fileName,
			Map<String, Object> maps) {// wxl9.11 ������
		try {
			JRDataSource ds = new JRBeanCollectionDataSource(null, false);

			ApplicationContext context = new ClassPathXmlApplicationContext("applicationPath.xml");
			String fileDir = ((Map <String,String>)context.getBean("appExtConfig")).get("filePath");
			String filerul = fileDir + fileName;
			InputStream file;

			file = new FileInputStream(filerul);

			JasperPrint jasperPrint = JasperFillManager.fillReport(file, maps,
					ds);
			ByteArrayOutputStream out = new ByteArrayOutputStream();
			JasperExportManager.exportReportToPdfStream(jasperPrint, out);
			return new ByteArrayInputStream(out.toByteArray());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	//wxl15.3.1��δ�ҵ�@deper�������,��ҪΪ��gbk
		public static InputStream exportWordDir(String fileName, Map<String, Object> maps, List<?> ls) {// wxl9.11 ������

			try {
				JRDataSource ds = new JRBeanCollectionDataSource(ls, false);
				ApplicationContext context = new ClassPathXmlApplicationContext("applicationPath.xml");
				String fileDir = ((Map <String,String>)context.getBean("appExtConfig")).get("filePath");
				String filenurl = fileDir + fileName;
				InputStream file = new FileInputStream(filenurl);

				JasperPrint jasperPrint = JasperFillManager.fillReport(file, maps, ds);
				ByteArrayOutputStream out = new ByteArrayOutputStream();
				
				JRAbstractExporter exporter = new JRDocxExporter();
				exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
				exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, out);
				exporter.setParameter(JRExporterParameter.CHARACTER_ENCODING, "gbk");
				exporter.exportReport();

				return new ByteArrayInputStream(out.toByteArray());
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		}
}
