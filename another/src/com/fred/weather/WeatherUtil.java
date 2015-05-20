package com.fred.weather;

import java.io.File;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Hashtable;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import com.fred.weather.entity.WeatherReport;
  
/** 
 * �й�����Ƶ���ֻ���("http://m.weathercn.com")��ȡ������Ϣ�� ��Ϊ�ֻ�����ҳ����С�������ٶȿ졣 
 *  
 * @author siqi 
 *  
 */  
public class WeatherUtil {  
  
    /** 
     * ʡ��ҳ�棨ʡ�� 
     */  
    public static final String PROVINCE_URL = "http://m.weathercn.com/common/province.jsp";  
    /** 
     * ����ҳ�棨�У�<br/> 
     * pid=%s��%s��ʾ���б�� ����http://m.weathercn.com/common/dis.do?pid=010101 
     */  
    public static final String DISTRICT_URL = "http://m.weathercn.com/common/dis.do?pid=%s";  
    /** 
     * ����ҳ�棨����<br/> 
     * did=%s��%s��ʾ�������<br/> 
     * pid=%s��%s��ʾ���б��<br/> 
     * ����http://m.weathercn.com/common/cout.do?did=01010101&pid=010101 
     */  
    public static final String COUNTY_URL = "http://m.weathercn.com/common/cout.do?did=%s&pid=%s";  
    /** 
     * 7������Ԥ��ҳ��<br/> 
     * cid=%s��%s��ʾ�����<br/> 
     * ����http://m.weathercn.com/common/7d.do?cid=0101010110 
     */  
    public static final String REPORT7_URL = "http://m.weathercn.com/common/7d.do?cid=%s";  
    /** 
     * ����ָ��ҳ��<br/> 
     * cid=%s��%s��ʾ����� 
     */  
    public static final String REPORT_MORE_URL = "http://m.weathercn.com/common/zslb.do?cid=%s";  
  
    /** 
     * ������б�����Ϣ��xml�ĵ�<br/> 
     * �����˾�������غ���������Ӧ�ı��룬����<br/> 
     * <county><br/> 
     * <name>����</name><br/> 
     * <code>0101010110</code><br/> 
     * </county> 
     */  
    public static final String XML_FILE = "./weathercn.xml";  
  
    private List<WeatherReport> weatherReportList = new ArrayList<WeatherReport>();  
  
    /** 
     * ������ʱ�����ȼ��weathercn.xml�Ƿ���ڣ���������ڵĻ������´�m.weathercn.com��ȡ�� 
     * ֻ�е�һ�ε�ʱ����ȡ�� 
     */  
    static {  
        try {  
            prepareXML();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * ����ָ�����У�ָ�����ڵ�����Ԥ����<br/> 
     *  
     * @param city 
     *            ���У���"����"�� 
     * @param cal 
     *            ���ڡ� 
     * @return ���������ȷ������������7�����ڣ���ô����������Ϣ�����򷵻�null�� 
     */  
    public WeatherReport getWeatherReport(String city, Calendar cal) {  
        String dateStr = cal.get(Calendar.MONTH) + "��"  
                + cal.get(Calendar.DAY_OF_MONTH) + "��";  
        return getWeatherReport(city, dateStr);  
    }  
  
    /** 
     * ����ָ�����У�ָ�����ڵ�����Ԥ����<br/> 
     *  
     * @param city 
     *            ���У���"����"�� 
     * @param date 
     *            ���ڣ���ʽΪ"1��20��"�� 
     * @return ���������ȷ������������7�����ڣ���ô����������Ϣ�����򷵻�null�� 
     */  
    public WeatherReport getWeatherReport(String city, String date) {  
        for (WeatherReport report : getWeatherReports(city)) {  
            if (report.getDate().equals(date)) {  
                return report;  
            }  
        }  
  
        return null;  
    }  
  
    /** 
     * ����ָ�����е�����Ԥ����7���ڣ� 
     *  
     * @param city 
     * @return ����ָ�����е�����Ԥ����7���ڣ������ָ���ĳ��д��󣬷��ؿյ�list��list.size()=0 
     */  
    public List<WeatherReport> getWeatherReports(String city) {  
        List<WeatherReport> list = new ArrayList<WeatherReport>();  
        try {  
  
            String weatherPage = getWeatherReportPage(city);  
  
            List<String> reportStrList = getAllMathers(weatherPage,  
                    "(?<=class=\"b\">)[\\s\\S]+?<br>[\\s\\S]+?(?=</)");  
            for (String reportStr : reportStrList) {  
                String weather = reportStr.trim().replaceAll(" ", "")  
                        .replaceAll("<br>\r\n\r\n", "\r\n")  
                        .replaceAll("<br>", "");  
  
                String[] str = weather.split("\r\n");  
                if (str.length > 5) {  
                    WeatherReport report = new WeatherReport();  
  
                    int i = 0;  
                    String dateStr = str[i++].trim();  
  
                    report.setCity(city);  
                    report.setDate(getMatcher(dateStr, ".+(?=\\()"));  
                    report.setWeekDay(getMatcher(dateStr, "(?<=\\().+?(?=\\))"));  
                    report.setDayOrNight(str[i++].trim());  
                    report.setWeather(str[i++].trim());  
                    report.setTemperature(str[i++].trim());  
                    report.setWindDir(str[i++].trim());  
                    report.setWind(str[i++].trim());  
  
                    list.add(report);  
                    if (str.length > 10) {  
                        report = new WeatherReport();  
                        report.setCity(city);  
                        report.setDate(getMatcher(dateStr, ".+(?=\\()"));  
                        report.setWeekDay(getMatcher(dateStr,  
                                "(?<=\\().+?(?=\\))"));  
                        report.setDayOrNight(str[i++].trim());  
                        report.setWeather(str[i++].trim());  
                        report.setTemperature(str[i++].trim());  
                        report.setWindDir(str[i++].trim());  
                        report.setWind(str[i++].trim());  
                        list.add(report);  
                    }  
                }  
            }  
  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
  
        this.weatherReportList = list;  
        return this.weatherReportList;  
  
    }  
  
    /** 
     * �����ַ����е�һ������regex���ַ��������û�з��ϵģ����ؿ��ַ��� 
     *  
     * @param str 
     *            �ַ��� 
     * @param regex 
     *            ������ʽ 
     * @return 
     */  
    public static String getMatcher(String str, String regex) {  
        Matcher mat = Pattern.compile(regex).matcher(str);  
        if (mat.find()) {  
            return mat.group();  
        } else {  
            return "";  
        }  
    }  
  
    /** 
     * �����ַ���str�����з���regex�����ַ����� 
     *  
     * @param str 
     * @param regex 
     * @return 
     */  
    public static List<String> getAllMathers(String str, String regex) {  
        List<String> strList = new ArrayList<String>();  
        Matcher mat = Pattern.compile(regex).matcher(str);  
        while (mat.find()) {  
            strList.add(mat.group());  
        }  
        return strList;  
    }  
  
    /** 
     * ��m.weathercn.com��ȡ����(����county)�ͳ�������Ӧ�ı��(������cid)��<br/> 
     * �����浽xml�ļ�"weathercn.xml"������Ѿ�����weathercn.xml�ļ�����ô�����ٴλ�ȡ�� 
     *  
     * @throws Exception 
     */  
    private static void prepareXML() throws Exception {  
        /** 
         * ���xml�ļ��Ѿ����ڣ������ٴλ�ȡ�� 
         */  
        File file = new File(XML_FILE);  
        if (file.exists()) {  
            // ��ʾxml�ļ�λ�ã�����Ҫ����ע�͵���  
            System.out.println("�������·�����ҵ�XML�ļ� " + file.getCanonicalPath());  
            return;  
        }  
  
        // ��DOM����XML�ĵ�  
        Document doc = DocumentBuilderFactory.newInstance()  
                .newDocumentBuilder().newDocument();  
        // ����XML�ĵ�root element  
        Element root = doc.createElement("root");  
        doc.appendChild(root);  
  
        // ʡprovince  
        //  
        WebPageUtil webPageUtil = new WebPageUtil().processUrl(PROVINCE_URL);  
  
        String provincePage = webPageUtil.getWebContent();  
        Hashtable<String, String> provinceTable = parseProvincePage(provincePage);  
        for (String province : provinceTable.keySet()) {  
            // ������ʾ������Ҫ����ע�͵�  
            System.out.println(String.format("���ڻ�ȡ%s�ĳ�����Ϣ...", province));  
            Element eleProvince = doc.createElement(province);  
            eleProvince.setAttribute("pid", provinceTable.get(province));  
            root.appendChild(eleProvince);  
  
            String districtPage = new WebPageUtil().processUrl(  
                    String.format(DISTRICT_URL, provinceTable.get(province)))  
                    .getWebContent();  
  
            Hashtable<String, String> districtTable = parseDistrictPage(districtPage);  
            for (String district : districtTable.keySet()) {  
                Element eleDistrict = doc.createElement(district);  
                eleDistrict.setAttribute("did", districtTable.get(district));  
                eleProvince.appendChild(eleDistrict);  
  
                 long time = System.currentTimeMillis();  
                String countyPage = new WebPageUtil().processUrl(  
                        String.format(COUNTY_URL, districtTable.get(district),  
                                provinceTable.get(province))).getWebContent();  
                Hashtable<String, String> countyTable = parseCountyPage(countyPage);  
                for (String county : countyTable.keySet()) {  
                    Element eleCounty = doc.createElement(county);  
                    eleCounty.setAttribute("cid", countyTable.get(county));  
                    eleDistrict.appendChild(eleCounty);  
                     System.out.println(String.format("%s->%s->%s %s",  
                     province, district, county,  
                     System.currentTimeMillis()-time));  
  
                }  
            }  
            // ������ʾ������Ҫ����ע�͵�  
            System.out.println(String.format("�ѳɹ���ȡ%s�ĳ�����Ϣ", province));  
        }  
  
        // ����ȡ������Ϣ���浽xml�ļ���  
        TransformerFactory tFactory = TransformerFactory.newInstance();  
        Transformer transformer = tFactory.newTransformer();  
        transformer.setOutputProperty(OutputKeys.INDENT, "yes");  
        transformer.setOutputProperty(  
                "{http://xml.apache.org/xslt}indent-amount", "2");  
        DOMSource source = new DOMSource(doc);  
        StreamResult result = new StreamResult(file);  
        transformer.transform(source, result);  
        System.out.println("XML�ļ��Ѿ����ɹ����� " + file.getCanonicalPath());  
  
    }  
  
    /** 
     * ��m.weathercn.com����ҳ���л�ȡ������Ϣ��<br/> 
     * ���磺�ӳɶ���ҳ���л�ȡ�½�˫�������صı�š� 
     *  
     * @param page 
     * @return 
     */  
    public static Hashtable<String, String> parseCountyPage(String page) {  
  
        return getKeyValues(page,  
                "<a href=\"index.do\\?cid=?.+?&pid=.+?class=\"c\">.+?</a>",  
                "(?<=>).+?(?=</a>)", "(?<=cid=)[0-9]+");  
    }  
  
    /** 
     * ��m.weathercn.com��ʡҳ���л�ȡʡ����Ϣ��<br/> 
     * ���磺���Ĵ�ʡ��ҳ���ȡ�ɶ���������еı�š� 
     *  
     * @param page 
     * @return 
     */  
    public static Hashtable<String, String> parseDistrictPage(String page) {  
  
        return getKeyValues(page, "<a href=\"cout.do\\?.+?class=\"c\">.+?</a>",  
                "(?<=>).+?(?=</a>)", "(?<=did=)[0-9]+");  
    }  
  
    /** 
     * ��m.weathercn.com�Ĺ���ҳ���л�ȡʡ����Ϣ��<br/> 
     * ���磺�ӹ���ҳ���ȡ�Ĵ�ʡ��ɽ��ʡ�������еȵı�š� 
     *  
     * @param page 
     * @return 
     */  
    public static Hashtable<String, String> parseProvincePage(String page) {  
  
        return getKeyValues(page, "<a href=\"dis.do?.+?class=\"c\">.+?</a>",  
                "(?<=>).+?(?=</a>)", "(?<=pid=)[0-9]+");  
    }  
  
    /** 
     * ��ҳ�������ȡ����Ҫ����Ϣ�� 
     *  
     * @param webPage 
     *            ��ҳ 
     * @param tagRegex 
     *            ������ʽ�����Ի�ȡ����key��value�����ݣ��������ַ���tag�� 
     * @param keyRegex 
     *            ������ʽ�����Դ�tag��ȡkey��ֵ 
     * @param valueRegex 
     *            ������ʽ�����Դ�tag��ȡvalue��ֵ 
     * @return ������ҳ������ƥ���key��value�����û�У�����һ���յ�table��table.size()=0 
     */  
    public static Hashtable<String, String> getKeyValues(String webPage,  
            String tagRegex, String keyRegex, String valueRegex) {  
        Hashtable<String, String> table = new Hashtable<String, String>();  
  
        for (String tag : getAllMathers(webPage, tagRegex)) {  
            table.put(getMatcher(tag, keyRegex), getMatcher(tag, valueRegex));  
        }  
  
        return table;  
    }  
  
    /** 
     * ��ȡָ�����л������������Ԥ��ҳ�档 
     *  
     * @param city 
     *            ���� 
     * @return ��������Ԥ��ҳ���Դ���롣������߳��в���ȷ���򷵻ؿ��ַ����� 
     * @throws Exception 
     */  
    public String getWeatherReportPage(String city) throws Exception {  
        Document doc = DocumentBuilderFactory.newInstance()  
                .newDocumentBuilder().parse(XML_FILE);  
        NodeList nodeList = doc.getElementsByTagName(city);  
        for (int i = 0; i < nodeList.getLength(); i++) {  
            Element ele = (Element) nodeList.item(i);  
            if (!ele.getAttribute("cid").equals("")) {  
                return new WebPageUtil().processUrl(  
                        String.format(REPORT7_URL, ele.getAttribute("cid")))  
                        .getWebContent();  
            }  
        }  
        return "";  
    }  
} 