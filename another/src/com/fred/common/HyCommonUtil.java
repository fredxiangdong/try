package com.fred.common;

import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.OutputStream;
import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.math.BigDecimal;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.ejb.EntityBean;

import org.w3c.dom.Document;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;


public class HyCommonUtil {

	public static Timestamp strToTimeStamp(String dateStr) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		try {
			Date date = format.parse(dateStr);
			return new Timestamp(date.getTime());
		} catch (ParseException e) {
			return null;
		}
	}

	public static Timestamp getYearFirst() {
		return getYearFirst(getDate());
	}

	public static Timestamp getYearFirst(Timestamp whenDate) {
		Timestamp yearfirst = strToTimeStamp(whenDate.toString()
				.substring(0, 4) + "-01-01 00:00:00.0");
		return yearfirst;
	}

	public static Timestamp getMonFirst(Timestamp timestamp) {
		return strToTimeStamp(timestamp.toString().substring(0, 7)
				+ "-01 00:00:00.0");
	}

	public static Timestamp getMonLast(Timestamp timestamp) {
		Timestamp monLast = timestamp;
		monLast = strToTimeStamp(timestamp.toString().substring(0, 7)
				+ "-01 00:00:00.0");
		monLast = addDay(addMonth(monLast, 1), -1);
		return monLast;
	}

	/**
	 * 如果字符串逗号结尾,删掉逗号
	 * @param str
	 * @return
	 */
	public static String deleteLastStr(String str) {
		if (str != null && str.endsWith(",")) {
			str = str.substring(0, str.length() - 1);
		}
		str = str.trim().length() == 0 ? "" : str;
		return str;
	}

	/**
	 * 处理,;分割的数字wxl
	 * @param ids
	 * @return
	 */
	public static List<Long> paraseIds(String ids) {
		List<Long> resLs = new ArrayList<Long>();
		if (ids == null) {
			return resLs;
		}
		String[] strArr = ids.split("[,;]");
		for (String str : strArr) {
			if (str == null || "".equals(str.trim())) {
				continue;
			}
			resLs.add(Long.valueOf(str));
		}
		return resLs;
	}

	/**
	 * 处理,分割的strwxl
	 * @param ids
	 * @return
	 */
	public static List<String> paraseStrs(String strs) {
		List<String> resLs = new ArrayList<String>();
		if (strs == null) {
			return resLs;
		}
		String[] strArr = strs.split(",");
		for (String str : strArr) {
			if (str == null || "".equals(str.trim())) {
				continue;
			}
			resLs.add(str);
		}
		return resLs;
	}

	// 将集合解释成1,2,3,4这种
	public static String chLsToStr(List<?> ls) {
		StringBuilder result = new StringBuilder();
		for (int i = 0; i < ls.size(); i++) {
			result.append(ls.get(i) + "");
			if (i != ls.size() - 1) {
				result.append(",");
			}
		}
		return result.toString();
	}


	// 数字转中文
	public static String intToCnNum(int num) {
		StringBuilder sb = new StringBuilder();
		String cNNUM = "零一二三四五六七八九";
		String cNW = "十百千";
		int n = num;
		if (num == 0) {
			return "零";
		}
		for (int i = 0; n > 0; i++) {
			int g = n % 10;
			if ((i >= 1) && (i <= 3)) {
				if (g != 0) {
					sb.insert(0, cNW.charAt(i - 1));
				}
			} else if (i == 4) {
				sb.insert(0, "万");
			} else if ((i >= 5) && (i <= 7)) {
				if (g != 0) {
					sb.insert(0, cNW.charAt(i - 4 - 1));
				}
			} else if (i == 8) {
				sb.insert(0, "亿");
			} else if ((i >= 9) && (i <= 10)) {
				if (g != 0) {
					sb.insert(0, cNW.charAt(i - 8 - 1));
				}
			}
			if ((g != 0) || ((i > 0) && (sb.substring(0, 1)).equals("零"))) {
				sb.insert(0, cNNUM.charAt(g));
			}
			n = n / 10;
		}
		if ((sb.length() > 1) && (sb.substring(sb.length() - 1).equals("零"))) {
			sb.setLength(sb.length() - 1);
		}
		if (sb != null && sb.length() == 3 && "一十".equals(sb.substring(0, 2))) {// 去掉一十一开头的一
			return sb.substring(1);
		}
		return sb.toString();
	}


	/**
	 * 
	 * @param input
	 *            输入的时间字符串
	 * @param pattern
	 *            时间规则
	 * @return
	 * @throws ParseException
	 * @throws Exception
	 */
	public static Timestamp paraseTime(String input, String pattern)
			throws ParseException {
		SimpleDateFormat sim = new SimpleDateFormat(pattern);
		Date myDate = sim.parse(input);
		return new Timestamp(myDate.getTime());
	}

	/**
	 * 获取传入实体主键名 wxl
	 * @param entityClass
	 * @return
	 */
	public static String getPKFileName(Class<?> entityClass) {
		Field[] fields = entityClass.getDeclaredFields();
		for (Field f : fields) {
			Annotation[] annotations = f.getAnnotations();
			if (annotations.length <= 0) {
				continue;
			}
			for (Annotation anno : annotations) {
				if (anno.toString().contains("@javax.persistence.Id()")) {
					return f.getName();
				}
			}
		}
		return null;
	}

	/**
	 * 获取传入实体主键get方法名
	 * @param entityClass
	 * @return
	 */
	public static String getPKGetName(Class<?> entityClass) {
		String pkFileName = getPKFileName(entityClass);
		if (pkFileName == null) {
			return null;
		} else {
			return "get" + pkFileName.substring(0, 1).toUpperCase()
					+ pkFileName.substring(1);
		}
	}

	public static <T extends EntityBean> Serializable getEntityPKValue(T t)
			throws Exception {
		Method me = t.getClass().getMethod(getPKGetName(t.getClass()));
		return (Serializable) me.invoke(t);
	}

	/**
	 * 判断字符串是否为null。
	 * @param str
	 * @return
	 */
	public static boolean strIsNull(String str) {
		boolean flag = false;
		if (str == null || str.trim().length() <= 0) {
			return true;
		}
		return flag;
	}

	public static String genUUID() {
		return String.valueOf(UUID.randomUUID()).replaceAll("-", "");
	}

	public static Timestamp addMinute(Timestamp val, int num) {
		return calendarAdd(val, Calendar.MINUTE, num);
	}

	public static Timestamp addHour(Timestamp val, int num) {
		return calendarAdd(val, Calendar.HOUR_OF_DAY, num);
	}



	/**
	 * 给定日期的日的最早。
	 * @param whenDate
	 * @return
	 */
	public static Timestamp getDayFirst(Timestamp whenDate) {
		if (whenDate == null)
			return getDate();
		return strToTimeStamp(whenDate.toString().substring(0, 10)
				+ " 00:00:00.0");
	}

	/**
	 * 给定日期的日的最晚。
	 * @param whenDate
	 * @return
	 */
	public static Timestamp getDayLast(Timestamp whenDate) {
		return strToTimeStamp(getDayFirst(whenDate).toString().substring(0, 10)
				+ " 23:59:59.0");
	}

	/**
	 * Java文件操作 获取文件扩展名
	 * 
	 * @param filename
	 *            String 类型的 文件名称
	 */
	public static String getExtName(String filename) {
		if ((null != filename) && (filename.length() > 0)) {
			int dot = filename.lastIndexOf('.');
			if ((dot > -1) && (dot < (filename.length() - 1))) {
				return filename.substring(dot + 1);
			}
		}
		return filename;
	}

	/**
	 * 获取用(1231231)这样数字结尾的数字 w
	 * @param info
	 * @return
	 */
	public static Long extractLong(String info) {
		Pattern pattern = Pattern.compile("\\(\\d+\\)$");
		Matcher matcher = pattern.matcher(info);
		if (matcher.find()) {
			String str = matcher.group();
			return Long.valueOf(str.substring(1, str.lastIndexOf(")")));
		} else {
			return null;
		}
	}

	/**
	 * 获取用(Y/N)这样数字结尾的字符
	 * @param info
	 * @return
	 */
	public static String extractString(String info) {
		Pattern pattern = Pattern.compile("\\(\\w+\\)$");
		Matcher matcher = pattern.matcher(info);
		if (matcher.find()) {
			String str = matcher.group();
			return str.substring(1, str.lastIndexOf(")"));
		} else {
			return null;
		}
	}

	public static String md5hashEncrypt(String oriString) {
		if (oriString == null || oriString.equals("")) {
			return oriString;
		}
		String encriptString = "";
		MessageDigest md;
		try {
			md = MessageDigest.getInstance("MD5");
			encriptString = bytes2Hex(md.digest(oriString.getBytes()));
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return encriptString;
	}

	private static String bytes2Hex(byte[] byteArray) {
		StringBuffer strBuf = new StringBuffer();
		for (int i = 0; i < byteArray.length; i++) {
			if (byteArray[i] >= 0 && byteArray[i] < 16) {
				strBuf.append("0");
			}
			strBuf.append(Integer.toHexString(byteArray[i] & 0xFF));
		}
		return strBuf.toString();
	}

	/**
	 * 计算时间差。
	 * @param diffType  Y年  M月份   D天  H小时  MM分
	 * @param beginDate
	 * @param endDate
	 * @return
	 * @throws Exception
	 */
	public static Long getDateDiff(String diffType, Timestamp beginDate,
			Timestamp endDate) {
		Long diffValue = 0L;
		if (beginDate == null || endDate == null) {
			return diffValue;
		}
		if ("Y".equals(diffType)) {
			diffValue = Long.valueOf(endDate.toString().substring(0, 4))
					- Long.valueOf(beginDate.toString().substring(0, 4));
		} else if ("M".equals(diffType)) {
			diffValue = Long.valueOf(endDate.toString().substring(0, 4)) * 12
					- Long.valueOf(beginDate.toString().substring(0, 4)) * 12
					+ Long.valueOf(endDate.toString().substring(5, 7))
					- Long.valueOf(beginDate.toString().substring(5, 7));
		} else if ("D".equals(diffType)) {
			Long diffNanos = endDate.getTime() - beginDate.getTime();
			diffValue = diffNanos / 1000 / 60 / 60 / 24;
		} else if ("H".equals(diffType)) {
			Long diffNanos = endDate.getTime() - beginDate.getTime();
			diffValue = diffNanos / 1000 / 60 / 60;
		} else if ("MM".equals(diffType)) {
			Long diffNanos = endDate.getTime() - beginDate.getTime();
			diffValue = diffNanos / 1000 / 60;
		}
		return diffValue;
	}

	public static String getVarGetName(String var) {
		if (var == null || "".equals(var.trim())) {
			return null;
		}
		return "get" + var.substring(0, 1).toUpperCase() + var.substring(1);
	}


	/**
	 * 得到时间是周几。
	 * @param datetime
	 * @return 1 星期一  7星期天
	 */
	public static int getWeek(Timestamp datetime) {
		Calendar cal = Calendar.getInstance();
		cal.setTime(datetime);
		return cal.get(Calendar.DAY_OF_WEEK);
	}

	/**
	 * 比较时间,如果前者时间不小于后者,返回真,否则为false
	 * @param firstTime
	 * @param lastTime
	 * @return
	 */
	public static boolean compareTimeNoLess(Timestamp firstTime,
			Timestamp lastTime) {
		if (firstTime.getTime() - lastTime.getTime() >= 0) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * 得到当前月份的第一天
	 * 
	 * @return
	 */
	public static Timestamp getCurMonFirst() {
		Timestamp curMonFirst = getMonFirst(getDate());
		return curMonFirst;
	}

	/**
	 * 得到当前月份的最后一天
	 * 
	 * @return
	 */
	public static Timestamp getCurMonLast() {
		return getMonLast(getDate());
	}
	
	public static Timestamp getDate()
	  {
	    Date dt = new Date(System.currentTimeMillis());
	    return new Timestamp(dt.getTime());
	  }



	  public static Timestamp getDateTime()
	  {
	    long current = System.currentTimeMillis();
	    current -= current % 1000L;
	    return new Timestamp(current);
	  }

	  public static String getChineseDate()
	  {
	    return DateFormat.getDateInstance(1, 
	      Locale.CHINA).format
	      (
	      new Date(System.currentTimeMillis()));
	  }

	  public static String getChineseDate(Date date)
	  {
	    return DateFormat.getDateInstance(1, 
	      Locale.CHINA).format
	      (date);
	  }

	  public static String getChineseDateTime()
	  {
	    return DateFormat.getDateTimeInstance(1, 1, 
	      Locale.CHINA).format
	      (
	      new Date(System.currentTimeMillis()));
	  }

	  public static String getChineseDateTime(Date date)
	  {
	    return DateFormat.getDateTimeInstance(1, 1, 
	      Locale.CHINA).format
	      (date);
	  }

	  public static Timestamp addYear(Timestamp val, int num)
	  {
	    return calendarAdd(val, 1, num);
	  }

	  public static Timestamp addMonth(Timestamp val, int num)
	  {
	    return calendarAdd(val, 2, num);
	  }

	  public static Timestamp addDay(Timestamp val, int num)
	  {
	    return calendarAdd(val, 5, num);
	  }



	  private static Timestamp calendarAdd(Timestamp val, int field, int num)
	  {
	    if (val == null)
	      return val;

	    GregorianCalendar calendar = new GregorianCalendar();
	    calendar.setTime(val);
	    calendar.add(field, num);
	    return new Timestamp(calendar.getTime().getTime());
	  }

	  public static double add(double v1, double v2)
	  {
	    BigDecimal b1 = new BigDecimal(Double.toString(v1));
	    BigDecimal b2 = new BigDecimal(Double.toString(v2));
	    return b1.add(b2).doubleValue();
	  }

	  public static double sub(double v1, double v2)
	  {
	    BigDecimal b1 = new BigDecimal(Double.toString(v1));
	    BigDecimal b2 = new BigDecimal(Double.toString(v2));
	    return b1.subtract(b2).doubleValue();
	  }

	  public static double mul(double v1, double v2)
	  {
	    BigDecimal b1 = new BigDecimal(Double.toString(v1));
	    BigDecimal b2 = new BigDecimal(Double.toString(v2));
	    return b1.multiply(b2).doubleValue();
	  }

	  public static double div(double v1, double v2)
	  {
	    return div(v1, v2, 10);
	  }

	  public static double div(double v1, double v2, int scale)
	  {
	    if (scale < 0)
	      throw new IllegalArgumentException(
	        "The scale must be a positive integer or zero");

	    BigDecimal b1 = new BigDecimal(Double.toString(v1));
	    BigDecimal b2 = new BigDecimal(Double.toString(v2));
	    return b1.divide(b2, scale, 4).doubleValue();
	  }

	  public static double round(double v, int scale)
	  {
	    if (scale < 0)
	      throw new IllegalArgumentException(
	        "The scale must be a positive integer or zero");

	    BigDecimal b = new BigDecimal(Double.toString(v));
	    BigDecimal one = new BigDecimal("1");
	    return b.divide(one, scale, 4).doubleValue();
	  }

	  public static String ltrim(String val)
	  {
	    if (val == null) {
	      return val;
	    }

	    int len = val.length();
	    int start = 0;
	    while ((start < len) && (val.charAt(start) <= ' '))
	      ++start;

	    return ((start > 0) ? val.substring(start, len) : val);
	  }

	  public static String rtrim(String val)
	  {
	    if (val == null) {
	      return val;
	    }

	    int len = val.length();
	    int end = len;
	    while ((end > 0) && (val.charAt(end - 1) <= ' '))
	      --end;

	    return ((end < len) ? val.substring(0, end) : val);
	  }

	  public static String charFormat(String charValue, int len)
	  {
	    if (charValue == null)
	      return null;

	    charValue = rtrim(charValue);
	    StringBuffer buffer = new StringBuffer(charValue);
	    int charLen = charValue.length();
	    for (int i = 0; i < len - charLen; ++i)
	      buffer.append(" ");

	    return buffer.toString();
	  }

	  public static String charZeroFormat(String charValue, int len)
	  {
	    if (charValue == null)
	      return null;

	    StringBuffer buffer = new StringBuffer("");
	    int charLen = charValue.length();
	    for (int i = 0; i < len - charLen; ++i)
	      buffer.append("0");

	    buffer.append(charValue);
	    return buffer.toString();
	  }

	  public static String getStrFromXml(Document doc, String encode)
	  {
	    ByteArrayOutputStream baos = new ByteArrayOutputStream();
	    try {
	      OutputStream os = new BufferedOutputStream(baos);
	      OutputFormat of = new OutputFormat();

	      of.setEncoding(encode);

	      XMLSerializer serial = new XMLSerializer(os, of);
	      if (doc.getDocumentElement() == null)
	        return null;

	      serial.serialize(doc.getDocumentElement());
	    } catch (Exception e) {
	      e.printStackTrace();
	    }
	    try {
	      return new String(baos.toByteArray(), encode); } catch (UnsupportedEncodingException e) {
	    }
	    return new String(baos.toByteArray());
	  }

	  public static Timestamp getTimeMillis()
	  {
	    long current = System.currentTimeMillis();
	    return new Timestamp(current);
	  }

}
