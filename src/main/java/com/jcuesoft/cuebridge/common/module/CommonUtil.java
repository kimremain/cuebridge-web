package com.jcuesoft.cuebridge.common.module;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.nio.file.attribute.GroupPrincipal;
import java.nio.file.attribute.UserPrincipal;
import java.nio.file.attribute.UserPrincipalLookupService;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;

import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

public class CommonUtil  extends BaseModule{

    private final static Pattern LTRIM = Pattern.compile("^\\s+");
    
    public CommonUtil(){
        logger.debug("CommonUtil.logger:" + logger.getName());
    }
    
    public static String ltrim(String s) {
        return LTRIM.matcher(s).replaceAll("");
    }    
    
    /**
     * OS 명령어 실행
     * 
     * @param command
     * @return  void
     * @throws Exception
     */
    public static void shellCmd(String command) throws Exception {
        Runtime runtime = Runtime.getRuntime();
        Process process = runtime.exec(command);
        InputStream is = process.getInputStream();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader br = new BufferedReader(isr);
        String line;
        while ((line = br.readLine()) != null) {
            System.out.println(line);
        }
    }
    
    /**
     * 현재시각 unixtime 으로 반환
     */
    public long getUnixTime() throws Exception {
        long L = System.currentTimeMillis() / 1000;
        
        return L;
    }
    
    /**
     * 파일복사
     */    
    public void copyFile(String fileFrom, String fileTo) throws Exception {
        logger.debug("copyFile");
        if(fileFrom.equals(null) || fileTo.equals(null)){
            logger.debug("copyFile param null");
            return;
        }
        
        UserPrincipalLookupService lookupservice = FileSystems.getDefault().getUserPrincipalLookupService();
        UserPrincipal daemonUser = lookupservice.lookupPrincipalByName("daemon");
        GroupPrincipal daemonuGroup = lookupservice.lookupPrincipalByGroupName("daemon");
        FileOwnerAttributeView foav = null;
        
        File sourceFile = new File( fileFrom );
        FileInputStream inputStream = null;
        FileOutputStream outputStream = null;
        FileChannel fcin = null;
        FileChannel fcout = null;
        
        inputStream = new FileInputStream(sourceFile);
        outputStream = new FileOutputStream(fileTo);
        
        fcin = inputStream.getChannel();
        fcout = outputStream.getChannel();
        long size = fcin.size();
        fcin.transferTo(0, size, fcout);
        
        fcout.close();
        fcin.close();
        outputStream.close();
        inputStream.close();
        
/*        foav = Files.getFileAttributeView(Paths.get(fileTo), FileOwnerAttributeView.class, LinkOption.NOFOLLOW_LINKS);
        foav.setOwner(daemonUser);
        Files.getFileAttributeView(Paths.get(fileTo), PosixFileAttributeView.class).setGroup(daemonuGroup);      */  
        
/*        if (fileTo.matches("(?i).*ups.*")){
            String cmd = "chown daemon:daemon " + fileTo;
            shellCmd(cmd);
        }*/
    }
    
    /**
     * 파일삭제
     */    
    public boolean deleteFile(String filePath) throws Exception {
        File file = new File(filePath);
        if(file.exists() == true){            
            return file.delete();
        }else{
            return false;
        }
    }
    
    /**
     * 거래처코드에 따라 UPS 디비링크 반환
     */    
    public String getUpsDbLink(String cdCooperate) throws Exception{
        String dbLink = null;
        
        if(cdCooperate.equals("70301")){
            dbLink = "@UPS_Y";
        }else if (cdCooperate.equals("70302")) {
            dbLink = "@UPS_S";
        }else if (cdCooperate.equals("70303")) {
            dbLink = "@UPS_M";
        }else if (cdCooperate.equals("70314")) {
            dbLink = "@UPS_T";            
        }else{
            
        }
        return dbLink;
    }
    
    /**
     * 거래처코드에 따라 HSJ 디비링크 반환
     */    
    public String getHsjDbLink(String cdCooperate) throws Exception{
        String dbLink = null;
        
        if(cdCooperate.equals("70301")){
            dbLink = "@HSJ_Y";
        }else if (cdCooperate.equals("70302")) {
            dbLink = "@HSJ_S";
        }else if (cdCooperate.equals("70303")) {
            dbLink = "@HSJ_M";
        }else{
            
        }
        return dbLink;
    }    
    
    /**
     * 거래처코드에 따라 ERP 디비링크 반환
     */    
    public String getErpDbLink(String cdCooperate) throws Exception{
        String dbLink = null;
        
        if(cdCooperate.equals("70301")){
            dbLink = "@ERP_Y";
        }else if (cdCooperate.equals("70302")) {
            dbLink = "@ERP_S";
        }else if (cdCooperate.equals("70303")) {
            dbLink = "@ERP_M";
        }else if (cdCooperate.equals("70314")) {
            dbLink = "@ERP_T";            
        }else{
            
        }
        return dbLink;
    }    
    
    /**
     * 거래처코드에 따라 UPS NAS법인명 반환
     */    
    public String getdataImgNasComNm(String cdCooperate) throws Exception{
        String nasComNm = null;
        
        if(cdCooperate.equals("70301")){
            nasComNm = "youi";
        }else if (cdCooperate.equals("70302")) {
            nasComNm = "star";
        }else if (cdCooperate.equals("70303")) {
            nasComNm = "million";
        }else if (cdCooperate.equals("70314")) {
            nasComNm = "athlete";            
        }else{
            
        }
        return nasComNm;
    }    
    
    /**
     * 거래처코드에 따라 UPS NAS ROOT PATH 반환
     */    
    public String getdataImgNasRootPath(String cdCooperate) throws Exception{
        String nasRootPath = null;
        
        if(cdCooperate.equals("70301")){
            nasRootPath = "/ext_data/youi/img/ups";
        }else if (cdCooperate.equals("70302")) {
            nasRootPath = "/ext_data/star/img/ups";
        }else if (cdCooperate.equals("70303")) {
            nasRootPath = "/ext_data/million/img/ups";
        }else if (cdCooperate.equals("70314")) {
            nasRootPath = "/ext_data/athlete/img/ups";            
        }else{
            
        }
        return nasRootPath;
    }    
    
    /**
     * communication 목적테이블 반환
     */       
    public String getCommunicationNm(String memberListNo) throws Exception{
        String nm;
        if(memberListNo.length() == 1){
            nm = "COMMUNICATION_" + "0" + memberListNo;
        }else{
            nm = "COMMUNICATION_" + memberListNo.substring(memberListNo.length()-2); 
        }
        return nm;
    }
    
    
    /**
     * getEncryptMd5
     * 
     * @param decryptStr
     * @return  String
     * @throws NoSuchAlgorithmException
     */
    public String getEncryptMd5(String decryptStr) throws NoSuchAlgorithmException{
        
        // 비밀번호 MD5 변환 
        MessageDigest md = MessageDigest.getInstance("MD5");
        String eip = "";
        String encryptStr = "";
        byte[] bip =  md.digest(decryptStr.getBytes());
        
        for(int i=0; i < bip.length; i++) {
            eip = "" + Integer.toHexString((int)bip[i] & 0x000000ff);
            if(eip.length() < 2) eip = "0" + eip; 
            encryptStr = encryptStr + eip;
        }
        return encryptStr;
    }
    
    /**
     * getEncryptSHA512
     * 
     * @param decryptStr
     * @return  String
     * @throws NoSuchAlgorithmException
     */
    public String getEncryptSHA512(String decryptStr) throws NoSuchAlgorithmException{
        
        MessageDigest md = MessageDigest.getInstance("SHA-512");
        String eip = "";
        String encryptStr = "";
        byte[] bip =  md.digest(decryptStr.getBytes());
        
        for(int i=0; i < bip.length; i++) {
            eip = "" + Integer.toHexString((int)bip[i] & 0x000000ff);
            if(eip.length() < 2) eip = "0" + eip; 
            encryptStr = encryptStr + eip;
        }
        return encryptStr;
    }
    
    /**
     * getEncrypt
     * 
     * @param decryptStr
     * @return  String
     * @throws NoSuchAlgorithmException
     */
    public String getEncrypt(String decryptStr, String algorithm) throws NoSuchAlgorithmException{
        
        MessageDigest md = MessageDigest.getInstance(algorithm);
        String eip = "";
        String encryptStr = "";
        byte[] bip =  md.digest(decryptStr.getBytes());
        
        for(int i=0; i < bip.length; i++) {
            eip = "" + Integer.toHexString((int)bip[i] & 0x000000ff);
            if(eip.length() < 2) eip = "0" + eip; 
            encryptStr = encryptStr + eip;
        }
        return encryptStr;
    }    

    /**
     * urlEncode
     * 
     * @param url
     * @return  String
     * @throws UnsupportedEncodingException
     */
    public String urlEncode(String url) throws UnsupportedEncodingException {
        return URLEncoder.encode(url,"UTF-8");
    }
    
    /**
     * urlDecode
     * 
     * @param url
     * @return  String
     * @throws UnsupportedEncodingException
     */
    public String urlDecode(String url) throws UnsupportedEncodingException {
        return URLDecoder.decode(url,"UTF-8");
    }
    
    public static HttpServletRequest getCurrentRequest() {

        ServletRequestAttributes sra = (ServletRequestAttributes) RequestContextHolder
                .currentRequestAttributes();

        HttpServletRequest hsr = sra.getRequest();
        return hsr;
    }
    
   public String getHangul(String str){
       StringBuffer hangul = new StringBuffer();   
       for(int i= 0;i < str.length();i++) 
       {
            if(checkHan(str.charAt(i)) ) 
            {
                hangul.append(str.charAt(i));
            }
       }
       return hangul.toString();
   }
   
   public boolean checkHan(char cValue) {
       if (cValue >= 0xAC00 && cValue <= 0xD743) 
       {
           return true;
       } 
       else 
       {
           return false;
       }       
   }
   
   public String getFileExtension(String name) throws Exception {
       logger.debug("CommonModule getExtension...");

       int pos = name.lastIndexOf(".");
       return name.substring(pos + 1);
   }   
   
   public String getLastIndexString(String source, String split) throws Exception {
       logger.debug("CommonModule getFileName...");

       int pos = source.lastIndexOf(split);
       return source.substring(pos + 1);
   }
   
   public String convertBase64Decode(String source) throws Exception {
       logger.debug("CommonModule convertBase64Decode...");
       byte[] asBytes = Base64.getDecoder().decode(source);
       return new String(asBytes, "utf-8");
   }
   
   public String maskNumberString(String source, String mask) throws Exception {
       logger.debug("CommonModule maskNumberString...");
       // format the number
       int index = 0;
       StringBuilder maskedNumber = new StringBuilder();
       for (int i = 0; i < mask.length(); i++) {
           char c = mask.charAt(i);
           if (c == '#') {
               maskedNumber.append(source.charAt(index));
               index++;
           } else if (c == 'x') {
               maskedNumber.append(c);
               index++;
           } else {
               maskedNumber.append(c);
           }
       }

       // return the masked number
       return maskedNumber.toString();
   }
   
   public String setPhoneNumberFormat(String source) throws Exception {
       logger.debug("CommonModule maskPhoneNumber...");
       String result = null;
       String regEx = null;
       
       if(source == null){
           logger.debug("<Notice> maskPhoneNumber parameter is null");
           result = null;
       }else if(source.length() == 8){ //XXXX-XXXX
           regEx = "(\\d{4})(\\d{4})";
           result = source.replaceAll(regEx, "$1-$2");
       }else if(source.length() == 11){ // XXX-XXXX-XXXX
           regEx = "(\\d{3})(\\d{4}(\\d{4}))";
           result = source.replaceAll(regEx, "$1-$2-$3");
       }else if(source.length() == 9 && source.startsWith("02")){ // 02-XXX-XXXX
           regEx = "(\\d{2})(\\d{3}(\\d{4}))";
           result = source.replaceAll(regEx, "$1-$2-$3");
       }else if(source.length() == 10 && source.startsWith("02")){ // 02-XXXX-XXXX
           regEx = "(\\d{2})(\\d{4}(\\d{4}))";
           result = source.replaceAll(regEx, "$1-$2-$3");
       }else if(source.length() == 10){ // XXX-XXX-XXXX
           regEx = "(\\d{3})(\\d{3}(\\d{4}))";
           result = source.replaceAll(regEx, "$1-$2-$3");
       }else{
           logger.debug("<Notice> maskPhoneNumber parameter unexpected value:"+source);
           result = source;
       }
       
       return result;
   }
   
   public static String getDomainCompany(String url) throws Exception {
       String companyCode = null;
       if (url.contains(CommonConstants.DOMAIN_YOUI)) {
           companyCode = "Y";            
       } else if (url.contains(CommonConstants.DOMAIN_MILL)) {
           companyCode = "M";
       } else if (url.contains(CommonConstants.DOMAIN_STAR)) {
           companyCode = "S";
       }
       
       return companyCode;
   }
   
   public static boolean checkMmsMessage(String msg) throws Exception {
     if(msg != null && msg.getBytes("euc-kr").length > 76){
         return true;
     }else{
         return false;
     }
       
   }
   
   public static void sleepSeconds(int second) throws Exception{
       Thread.sleep(second*1000);
   }
   
   
}
