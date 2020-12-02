package com.jcuesoft.cuebridge.common.module;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.nio.file.attribute.FileOwnerAttributeView;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.web.multipart.MultipartFile;

public class CommonFileUpload extends BaseModule{

    private Format formatter = null;
    private String sDate = null;
/*    private UserPrincipalLookupService lookupservice = null;
    private UserPrincipal daemonUser = null;
    private GroupPrincipal daemonuGroup = null;*/

    FileOwnerAttributeView foav = null;

    public CommonFileUpload() throws IOException {
/*        lookupservice = FileSystems.getDefault().getUserPrincipalLookupService();
        daemonUser = lookupservice.lookupPrincipalByName("daemon");
        daemonuGroup = lookupservice.lookupPrincipalByGroupName("daemon");*/
    }

    public String uploadFile(String path, String name, MultipartFile file) throws Exception {

        if (logger.isDebugEnabled()) {
            logger.debug("CommonModule uploadFile...");
        }

        if (!file.isEmpty()) {

            try {
                File tmpFile = new File(path + name);
                file.transferTo(tmpFile);

/*                foav = Files.getFileAttributeView(Paths.get(path, name), FileOwnerAttributeView.class, LinkOption.NOFOLLOW_LINKS);
                foav.setOwner(daemonUser);
                Files.getFileAttributeView(Paths.get(path, name), PosixFileAttributeView.class).setGroup(daemonuGroup);*/

                return "S:success";
            } catch (Exception e) {
                return "F:" + e.getMessage();
            }
        } else {
            if (logger.isDebugEnabled()) {
                logger.debug("###isEmpty...");
            }
            return "F:" + "유효하지 않은파일";
        }
    }

    public String getFileExtension(String name) throws Exception {
        return new CommonUtil().getFileExtension(name);
    }

    public String getImgSavePath(String nasPath) throws Exception {
        logger.debug("CommonModule getImgSavePath...");
        StringBuffer tmpPath = new StringBuffer();
        logger.debug(nasPath);
        tmpPath.append(nasPath);
        logger.debug("tmpPath:" + tmpPath.toString());

        formatter = new SimpleDateFormat("yyyy");
        sDate = formatter.format(new Date());
        tmpPath.append(sDate + "/"); // yyyy
        logger.debug("tmpPath:" + tmpPath.toString());
        formatter = new SimpleDateFormat("yyyyMMdd");
        sDate = formatter.format(new Date());
        tmpPath.append(sDate + "/"); // yyyymmdd
        logger.debug("tmpPath:" + tmpPath.toString());
        logger.debug("CommonModule-getSavePath:" + tmpPath.toString());
        return tmpPath.toString();
    }

    public String getImgFileName(String nmCompShort, String noReq, BigDecimal noSeq) throws Exception {
        logger.debug("CommonModule getImgFileName...");
        StringBuffer tmpFileName = new StringBuffer();

        tmpFileName.append(nmCompShort + "_"); // 법인약명
        logger.debug("tmpFileName:" + tmpFileName.toString());
        tmpFileName.append(noReq + "_"); // 접수번호
        logger.debug("tmpFileName:" + tmpFileName.toString());
        formatter = new SimpleDateFormat("yyyyMMddHHmmss");
        sDate = formatter.format(new Date());
        tmpFileName.append(sDate + "_"); // yyyymmddhh24miss
        logger.debug("tmpFileName:" + tmpFileName.toString());
        tmpFileName.append(noSeq); // 시퀀스
        logger.debug("tmpFileName:" + tmpFileName.toString());
        return tmpFileName.toString();
    }

}
