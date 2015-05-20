package com.fred.weather;


import java.io.InputStream;
import java.net.Socket;
import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
  
/** 
 * һ���򵥵��࣬������ȡ��ҳ���� 
 * @author siqi 
 * 
 */  
public class WebPageUtil {  
  
    /** 
     * ���� 
     */  
    private static boolean debug = true;  
      
    /** 
     * ��Ϣͷ������http��Դ����http��������һЩ���ԣ�����:<BR/> 
     * HTTP/1.1 200 OK<BR/> 
     * Server: nginx/0.7.68<BR/> 
     * Date: Tue, 22 Jan 2013 10:55:21 GMT<BR/> 
     * Content-Type: image/jpeg<BR/> 
     * Content-Length: 6372<BR/> 
     * Last-Modified: Sun, 29 Apr 2012 07:29:01 GMT<BR/> 
     * Connection: close<BR/> 
     * Expires: Mon, 18 Nov 2013 10:55:21 GMT<BR/> 
     * Cache-Control: max-age=25920000<BR/> 
     */  
    private String msgHeader;  
    /** 
     * ��Ϣͷ���ַ����� 
     */  
    private StringBuffer msgHeaderBuffer = new StringBuffer();  
  
    /** 
     * ��ҳ���ݱ��� 
     */  
    private Charset charset;  
  
    /** 
     * �����С(��λ���ֽ�) 
     */  
    private int buffer_size = 4096;  
      
    /** 
     * ��ҳ���� 
     */  
    private byte[] bytes = new byte[0];  
      
    /**  
     * һ������WebUtil������  
     *   
     * @param args  
     */  
    public static void main(String[] args) {  
        try {  
            String url = "http://m.weathercn.com/common/province.jsp";  
            WebPageUtil webPageUtil = new WebPageUtil().processUrl(url);  
            System.out.println("=======Header :=======\r\n"+webPageUtil.getMsgHeader());  
            System.out.println("=======Content:=======\r\n"+webPageUtil.getWebContent());  
              
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
  
    /** 
     * ʹ��Socket���󣨻�ȡ��һ����ҳ��<br/> 
     * ����:<br/> 
     * processUrl("http://www.baidu.com/")���ȡ�ٶ���ҳ��<br/> 
     *  
     * @param url 
     *            �����ҳ������ҳ���ݵĵ�ַ 
     * @throws Exception 
     */  
    public WebPageUtil processUrl(String url) throws Exception {  
        url = formatUrl(url);  
  
        // ����Ҫ���ӵķ�������ַ  
        Socket socket = new Socket(getHost(url), getPort(url));  
        socket.setSoTimeout(5000);	//���ӳ�ʱʱ��
  
        // ��������������ο�HTTPЭ��(RFC2616)  
        String request = String.format("GET %s HTTP/1.0\r\n", getSubUrl(url));  
        request += String.format("HOST: %s \r\n\r\n", getHost(url));  
  
        if(debug) {  
            System.out.println("request:\r\n"+request);  
        }  
  
        // ��������  
        socket.getOutputStream().write(request.getBytes());  
  
        // ���û��棬��ø�ϵͳ��socket���ջ���һ��  
        this.buffer_size = socket.getReceiveBufferSize();  
        byte[] bytesBuffer = new byte[buffer_size];// ����InputStream��ԭʼ����  
        char[] charsBuffer = new char[buffer_size];// ����InputStream���ַ�����  
  
        // ���Է�������Ӧ(InputStream)  
        InputStream is = socket.getInputStream();  
  
        // �ֲ���������ȡ�������ݳ��ȣ��ֽڣ�  
        int bytesLength = 0;  
        // �ֲ��������ж���Ϣͷ�Ƿ��ȡ���  
        boolean headerComplete = false;  
  
        // ��InputStream�ж�ȡ��ҳ�����ݣ������ȡ��������  
        // ����Ϊ-1�����ȡ���  
        while ((bytesLength = is.read(bytesBuffer, 0, buffer_size)) != -1) {  
            if (headerComplete) {  
                SaveBytes(bytesBuffer, 0, bytesLength);  
            } else {  
                int bufferLength = msgHeaderBuffer.length();  
                msgHeaderBuffer.append(  
                        bytes2chars(bytesBuffer, charsBuffer, bytesLength), 0,  
                        bytesLength);  
                int msgEndIndex = msgHeaderBuffer.indexOf("\r\n\r\n");  
                if (msgEndIndex != -1) {  
                    headerComplete = true;  
                    msgHeader = "Url: " + url + "\r\n"  
                            + msgHeaderBuffer.substring(0, msgEndIndex);  
                    int temp = msgEndIndex - bufferLength + 4;  
                    SaveBytes(bytesBuffer, temp, bytesLength - temp);  
                }  
            }  
        }  
          
        socket.close();  
  
        //��ȡ��ҳ����   
        this.getCharset();  
          
        return this;  
    }  
  
    /** 
     * ������ַ��ȡ�������˿ڡ�<br/> 
     * http �˿�Ϊ80<br/> 
     * https�˿�Ϊ443 
     * @param url 
     * @return 
     */  
    public static int getPort(String url) {  
        int port = 0;  
        if (url.startsWith("https://")) {  
            port = 443;  
        } else if (url.startsWith("http://")) {  
            port = 80;  
        }  
          
        if(debug) {  
            System.out.println("port: "+port);  
        }  
          
        return port;  
    }  
  
    /** 
     * ������ַ����ȡ��������ַ<br/> 
     * ���磺<br/> 
     * http://m.weathercn.com/common/province.jsp<p> 
     * ���أ�<br/> 
     * m.weathercn.com 
     * @param url ��ַ 
     * @return 
     */  
    public static String getHost(String url) {  
        String host = "";  
        Matcher mat = Pattern.compile("(?<=https?://).+?(?=/)").matcher(url);  
        if(mat.find()) {  
            host = mat.group();  
        }  
          
        if(debug) {  
            System.out.println("host: "+host);  
        }  
          
        return host;  
    }  
      
    /** 
     * ������ַ����ȡ��ҳ·�� 
     * ���磺<br/> 
     * http://m.weathercn.com/common/province.jsp<p> 
     * ���أ�<br/> 
     * /common/province.jsp 
     * @param url 
     * @return ���û�л�ȡ����ҳ·��������""; 
     */  
    public static String getSubUrl(String url) {  
        String subUrl = "";  
        Matcher mat = Pattern.compile("https?://.+?(?=/)").matcher(url);  
        if(mat.find()) {  
            subUrl = url.substring(mat.group().length());  
        }  
          
        if(debug) {  
            System.out.println("subUrl: "+subUrl);  
        }  
          
        return subUrl;  
    }  
  
    /** 
     * ��ĳЩ��ַ�ϼӸ�"/"<br/> 
     * ���磺<br/> 
     * http://www.baidu.com<br/> 
     * ���أ�<br/> 
     * http://www.baidu.com/<p> 
     * ���磺<br/> 
     * http://www.baidu.com/xxxx<br/> 
     * ���أ�(û�м�"/")<br/> 
     * http://www.baidu.com/xxxx<br/> 
     * @param url 
     * @return 
     */  
    public static String formatUrl(String url) {  
        Matcher mat = Pattern.compile("https?://[^/]+").matcher(url);  
        if (mat.find() && mat.group().equals(url)) {  
            return url + "/";  
        } else {  
            return url;  
        }  
    }  
      
    /** 
     * �Ѵ��������ж�ȡ�������ݱ��浽bytes�����У� 
     * ÿ�ζ�����һ���µ�byte[]���洢ԭ��bytes[]�����е����ݺ� 
     * �¶�ȡ����b�е����ݡ� 
     * @param b �洢���ݵ�byte[] 
     * @param start ���ݵ���ʼλ�ã���0��ʼ 
     * @param length ���ݵĳ��� 
     * @throws Exception 
     */  
    private void SaveBytes(byte[] b, int start, int length) throws Exception {  
        //do some check  
        if(start<0 || length<0) {  
            throw new Exception("start/length is incorrect.");  
        }  
        //�½�һ��byte����  
        byte[] newBytes = new byte[bytes.length+length];  
        System.arraycopy(bytes, 0, newBytes, 0, bytes.length);  
        System.arraycopy(b, start, newBytes, bytes.length, length);  
          
        bytes = newBytes;  
  
    }  
  
    /** 
     * ���ֽ�����ת�����ַ����� 
     * @param srcBytes 
     * @param dstChars 
     * @param length 
     * @return 
     */  
    private char[] bytes2chars(byte[] srcBytes, char[] dstChars, int length) {  
        for (int i = 0; i < length; i++) {  
            dstChars[i] = (char) srcBytes[i];  
        }  
  
        return dstChars;  
    }  
  
    /** 
     * ��ȡ��ҳ��Դ���ļ�������Ϣͷ����������˷���������Դ��һЩ���� 
     */  
    public String getMsgHeader() {  
        return msgHeader;  
    }  
  
    /** 
     * ��ȡ��ҳ����ҳ��Դ�ı��룬�������Ϣͷ����û���ҵ����룬��ô�� 
     * ����ϵͳĬ�ϱ��롣 
     * @return 
     */  
    public Charset getCharset() {  
        String header = this.msgHeader.toUpperCase();  
        Matcher mat = Pattern.compile("CHARSET=.+").matcher(header);  
        if(mat.find()) {  
            this.charset = Charset.forName(mat.group().split("=")[1]);  
        }else{  
            this.charset = Charset.defaultCharset();  
        }  
        return charset;  
    }  
      
    /** 
     * ��ȡ��ҳ���� 
     * @return 
     */  
    public String getWebContent() {  
        return new String(bytes, charset);  
    }  
}