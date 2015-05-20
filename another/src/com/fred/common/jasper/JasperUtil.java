package com.fred.common.jasper;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.imageio.ImageIO;
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
import net.sf.jasperreports.engine.export.JRHtmlExporter;
import net.sf.jasperreports.engine.export.JRPdfExporter;
import net.sf.jasperreports.engine.export.JRRtfExporter;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRDocxExporter;
import net.sf.jasperreports.export.Exporter;
import net.sf.jasperreports.export.ExporterInput;
import net.sf.jasperreports.export.HtmlExporterOutput;
import net.sf.jasperreports.export.RtfExporterConfiguration;
import net.sf.jasperreports.export.RtfReportConfiguration;
import net.sf.jasperreports.export.SimpleExporterInput;
import net.sf.jasperreports.export.SimpleHtmlExporterOutput;
import net.sf.jasperreports.export.SimpleOutputStreamExporterOutput;
import net.sf.jasperreports.export.SimpleWriterExporterOutput;
import net.sf.jasperreports.export.SimpleXlsReportConfiguration;
import net.sf.jasperreports.export.WriterExporterOutput;
import net.sf.jasperreports.export.XlsReportConfiguration;

import org.apache.struts2.ServletActionContext;
import org.icepdf.core.pobjects.Document;
import org.icepdf.core.pobjects.Page;
import org.icepdf.core.util.GraphicsRenderingHints;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.fred.common.HyCommonUtil;
import com.fred.common.UUIDGenerator;
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

	/** The Constant EXCEL_TYPE. */
	public static final String EXCEL_TYPE = "excel";

	public static final String HTML_TYPE = "html";
	public static final String WORD_TYPE = "word";
	public static final String IMAGE_TYPE = "image";
	
	public static ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
	public static final String fileDir = ((Map <String,String>)context.getBean("appExtConfig")).get("filePath");
	
	/**
	 * 导出excel.
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
	private static void exportExcel(JasperPrint jasperPrint,
			String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException {
		/*
		 * 设置头信息
		 */
		response.setContentType("application/vnd.ms-excel");
		String defaultname = null;
		if (HyCommonUtil.strIsNull(defaultFilename)) {
			defaultname = "export.xls";
			String fileName = new String(defaultname.getBytes("utf-8"),
					"ISO8859_1");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName);
		} else {
			defaultname = defaultFilename + ".xls";
			String fileName = new String(defaultname.getBytes("utf-8"),
					"ISO8859_1");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName);
		}
		ServletOutputStream ouputStream = response.getOutputStream();
		JRXlsExporter exporter = new JRXlsExporter();

		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
		jasperPrintList.add(jasperPrint);
		ExporterInput exporterInput = SimpleExporterInput
				.getInstance(jasperPrintList);
		exporter.setExporterInput(exporterInput);

		SimpleOutputStreamExporterOutput exporterOutput = new SimpleOutputStreamExporterOutput(
				ouputStream);
		exporter.setExporterOutput(exporterOutput);

		XlsReportConfiguration configuration = new SimpleXlsReportConfiguration();
		configuration.isRemoveEmptySpaceBetweenRows();
		configuration.isOnePagePerSheet();
		configuration.isWhitePageBackground();

		exporter.setConfiguration(configuration);
		exporter.exportReport();
		ouputStream.flush();
		ouputStream.close();
	}

	/**
	 * 导出pdf，注意此处中文问题，
	 * 
	 * 这里应该详细说：主要在ireport里变下就行了。看图
	 * 
	 * 1）在ireport的classpath中加入iTextAsian.jar 2）在ireport画jrxml时，看ireport最左边有个属性栏。
	 * 
	 * 下边的设置就在点字段的属性后出现。 pdf font name ：STSong-Light ，pdf encoding ：UniGB-UCS2-H
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

/*		String filePath = ApplicationUtil.getAppConfig().getAppExtProp()
				.get("fileTempPath")
				+ defaultFilename + ".pdf";*/
		
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

	private static String exportImage(JasperPrint jasperPrint,
			String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException {

		exportPdf(jasperPrint, defaultFilename, request, response);
/*		String p = ApplicationUtil.getAppConfig().getAppExtProp()
				.get("fileTempPath")
				+ defaultFilename + ".pdf";
		String filePath = p;*/

		String filePath = fileDir + defaultFilename + ".pdf";		
		
		Document document = new Document();
		try {
			document.setFile(filePath);
		} catch (Exception ex) {
		}

		// save page caputres to file.
		float scale = 3f;
		float rotation = 0f;
		// Paint each pages content to an image and write the image to file
		String imageFile = "";
		for (int i = 0; i < document.getNumberOfPages(); i++) {
			BufferedImage image = (BufferedImage) document.getPageImage(i,
					GraphicsRenderingHints.SCREEN, Page.BOUNDARY_CROPBOX,
					rotation, scale);
			RenderedImage rendImage = image;
			UUIDGenerator uuidgen = new UUIDGenerator();
			String imageName = uuidgen.generate() + ".png";
			// capture the page image to file
			try {
/*				File file = new File(ApplicationUtil.getAppConfig()
						.getAppExtProp().get("fileTempPath")
						+ imageName);*/
				
				File file = new File(fileDir + imageName);
				ImageIO.write(rendImage, "png", file);
			} catch (IOException e) {
				e.printStackTrace();
			}
			imageFile += imageName + ",";
			image.flush();
		}
		if (imageFile.endsWith(","))
			imageFile = imageFile.substring(0, imageFile.length() - 1);
		// clean up resources
		document.dispose();
		return imageFile;
	}

	/**
	 * 导出html
	 */
	private static void exportHtml(JasperPrint jasperPrint,
			String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws IOException, JRException {
		response.setContentType("text/html");
		ServletOutputStream ouputStream = response.getOutputStream();
		JRHtmlExporter exporter = new JRHtmlExporter();

		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();
		jasperPrintList.add(jasperPrint);
		ExporterInput exporterInput = SimpleExporterInput
				.getInstance(jasperPrintList);
		exporter.setExporterInput(exporterInput);

		HtmlExporterOutput exporterOutput = new SimpleHtmlExporterOutput(
				ouputStream, "UTF-8");
		exporter.setExporterOutput(exporterOutput);

		exporter.exportReport();
		ouputStream.flush();
		ouputStream.close();
	}

	/**
	 * 导出word
	 */
	private static void exportWord(JasperPrint jasperPrint,
			String defaultFilename, HttpServletRequest request,
			HttpServletResponse response) throws JRException, IOException {
		response.setContentType("application/msword;charset=utf-8");
		String defaultname = null;
		if ("".equals(defaultFilename) && defaultFilename == null) {
			response.setHeader("Content-disposition", "inline;");
		} else {
			defaultname = defaultFilename + ".doc";
			String fileName = new String(defaultname.getBytes("GBK"),
					"ISO8859_1");
			response.setHeader("Content-disposition", "attachment; filename="
					+ fileName);
		}
		Exporter<ExporterInput, RtfReportConfiguration, RtfExporterConfiguration, WriterExporterOutput> exporter = new JRRtfExporter();

		SimpleExporterInput exporterInput = new SimpleExporterInput(jasperPrint);
		exporter.setExporterInput(exporterInput);
		WriterExporterOutput exporterOutput = new SimpleWriterExporterOutput(
				response.getOutputStream());
		exporter.setExporterOutput(exporterOutput);
		exporter.exportReport();
	}

	/**
	 * 打印.
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
	 * 按照类型导出不同格式文件.
	 * 
	 * @param datas
	 *            数据
	 * @param maps
	 *            the maps
	 * @param type
	 *            文件类型
	 * @param defaultFilename
	 *            the default filename
	 * @param is
	 *            jasper文件的来源
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
			JasperPrint jasperPrint = JasperFillManager
					.fillReport(is, maps, ds);

			if (EXCEL_TYPE.equals(type)) {
				exportExcel(jasperPrint, defaultFilename, request, response);
			} else if (PDF_TYPE.equals(type)) {
				return exportPdf(jasperPrint, defaultFilename, request,
						response) + "";
			} else if (HTML_TYPE.equals(type)) {
				exportHtml(jasperPrint, defaultFilename, request, response);
			} else if (WORD_TYPE.equals(type)) {
				exportWord(jasperPrint, defaultFilename, request, response);
			} else if (IMAGE_TYPE.equals(type)) {
				return exportImage(jasperPrint, defaultFilename, request,
						response);
			} else {
				exportPrint(jasperPrint, response, request);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "";
	}

	/**
	 * 导出入口.
	 * 
	 * @param exportType
	 *            导出文件的类型(PDF_TYPE,EXCEL_TYPE,HTML_TYPE,WORD_TYPE)
	 * @param jaspername
	 *            jasper文件的路径名字 如： xxx/xx.jasper
	 * @param dataWrap
	 *            导出的数据
	 * @param defaultFilename
	 *            the default filename
	 */
	public static void exportmain(String exportType, String jaspername,
			DataWrap<?> dataWrap, String defaultFilename) {
		ActionContext ct = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ct
				.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = ServletActionContext.getResponse();
		String filenurl = new PathUtil().getWebInfPath() + "/szgl/ireport/"
				+ jaspername;// jasper文件放在WebRoot/xx
		File file = new File(filenurl);
		InputStream is = null;
		try {
			is = new FileInputStream(file);
			export(dataWrap.getDataList(),
					ReadClassAttr.readClassAttr(dataWrap.getData()),
					exportType, defaultFilename, is, request, response);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 导出入口(复杂报表使用).
	 * 
	 * @param exportType
	 *            导出文件的类型(PDF_TYPE,EXCEL_TYPE,HTML_TYPE,WORD_TYPE)
	 * @param jaspername
	 *            jasper文件的路径名字 如： xxx/xx.jasper
	 * @param list
	 *            导出的数据
	 * @param maps
	 *            the maps
	 * @param defaultFilename
	 *            the default filename
	 */
	public static String exportmain(String exportType, String jaspername,
			List<?> list, Map<String, Object> maps, String defaultFilename) {
		ActionContext ct = ActionContext.getContext();
		HttpServletRequest request = (HttpServletRequest) ct
				.get(ServletActionContext.HTTP_REQUEST);
		HttpServletResponse response = ServletActionContext.getResponse();
/*		String filenurl = new PathUtil().getWebInfPath() + "ireport/szgl/"
				+ jaspername;// jasper文件放在WebRoot/xx        	
		if (maps == null)
			maps = new HashMap<String, Object>();
		maps.put("SUBREPORT_DIR",
				filenurl.substring(0, filenurl.lastIndexOf("/") + 1));*/
		
//		String fileurl = "E://LzAcceptNotice.jasper";
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

	public static int exportmain(String exportType,
			List<String> jaspernameList, List<?> list,
			Map<String, Object> maps, String defaultFilename)
			throws FileNotFoundException, JRException {

		if (jaspernameList == null || jaspernameList.size() == 0) {
			throw new Exception("报表模板传入异常");
		}
		String[] filenurl = new String[jaspernameList.size()];
		PathUtil pathUtil = new PathUtil();
		for (int i = 0; i < jaspernameList.size(); i++) {
			filenurl[i] = pathUtil.getWebInfPath() + "ireport/szgl/"
					+ jaspernameList.get(i);
		}

		List<JasperPrint> jasperPrintList = new ArrayList<JasperPrint>();

		for (int i = 0; i < filenurl.length; i++) {
			File file = new File(filenurl[i]);
			InputStream is = new FileInputStream(file);
			JRDataSource ds = new JRBeanCollectionDataSource(list, false);
			JasperPrint jasperPrint = JasperFillManager
					.fillReport(is, maps, ds);
			jasperPrintList.add(jasperPrint);

		}
/*		String filePath = ApplicationUtil.getAppConfig().getAppExtProp()
				.get("fileTempPath")
				+ defaultFilename + ".pdf";*/
		String filePath = fileDir + defaultFilename + ".pdf";
		Document document = new Document();
		FileOutputStream ouputStream = new FileOutputStream(filePath);
		JRPdfExporter exporter = new JRPdfExporter();
		exporter.setParameter(JRExporterParameter.JASPER_PRINT_LIST,
				jasperPrintList);
		exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, ouputStream);
		exporter.exportReport();

		try {
			document.setFile(filePath);
		} catch (Exception ex) {
		}

		return document.getNumberOfPages();
	}

	public static InputStream exportPdfDir(String fileName,
			Map<String, Object> maps) {// wxl9.11 公文用
		try {
			JRDataSource ds = new JRBeanCollectionDataSource(null, false);

/*			String filenurl = new PathUtil().getWebInfPath() + "/ireport/szgl/"
					+ fileName;*/
			
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
	
	//wxl15.3.1暂未找到@deper替代方法,主要为了gbk
		public static InputStream exportWordDir(String fileName, Map<String, Object> maps, List<?> ls) {// wxl9.11 公文用

			try {
				JRDataSource ds = new JRBeanCollectionDataSource(ls, false);

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
