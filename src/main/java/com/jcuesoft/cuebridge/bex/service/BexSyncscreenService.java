package com.jcuesoft.cuebridge.bex.service;

import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.supercsv.cellprocessor.Optional;
import org.supercsv.cellprocessor.ParseBigDecimal;
import org.supercsv.cellprocessor.constraint.NotNull;
import org.supercsv.cellprocessor.constraint.StrRegEx;
import org.supercsv.cellprocessor.ift.CellProcessor;
import org.supercsv.io.CsvMapReader;
import org.supercsv.io.ICsvMapReader;
import org.supercsv.prefs.CsvPreference;

import com.jcuesoft.cuebridge.bex.vo.BexMasterRequestVO;
import com.jcuesoft.cuebridge.common.service.BaseService;
import com.jcuesoft.cuebridge.common.service.CommonBizService;

@Service
public class BexSyncscreenService extends BaseService {
    @Autowired
    private CommonBizService commonBizService;    
    @Autowired
    private BexMasterService bexMasterService;
    
    public String excuteByCsv(BexMasterRequestVO bexMasterRequestVO, MultipartFile file) throws Exception{
        logger.debug("Call BexSyncscreenService excute");
        String resultCode = ""; //resultCode        
        resultCode = "Success";        
        
        ICsvMapReader mapReader = null;
        try {            
            mapReader  = new CsvMapReader(new InputStreamReader(file.getInputStream(), "KSC5601"),
                    CsvPreference.STANDARD_PREFERENCE);
            final String[] header = mapReader.getHeader(true);
            List<String> expectedHeaders = Arrays.asList("NO_REQ","NO_EX","NM_SCREEN","DM_COOPERATE","AM_COOPERATE","DS_COOPERATE");            
            for (String x: header ){
                logger.debug("header debug:"+x);
            }
            final CellProcessor[] processors = getProcessors();
            

            if (!Arrays.asList(header).containsAll(expectedHeaders)){
                logger.debug("BexSyncscreenService throw:헤더값이 일치하지 않습니다");
                throw new Exception("헤더값이 일치하지 않습니다."
                                            +System.getProperty("line.separator")
                                            +"정의된 헤더:NO_REQ/NO_EX/NM_SCREEN/DM_COOPERATE/AM_COOPERATE/DS_COOPERATE");
            }
            
            Map<String, Object> customerMap;
            int i = 1;
            while( (customerMap = mapReader.read(header, processors)) != null ) {
                if(customerMap.get("NO_REQ") == null || customerMap.get("NO_REQ").toString().trim().equals("")){
                    throw new Exception("NO_REQ 필수항목입니다.");
                }
                if(customerMap.get("NO_EX") == null || customerMap.get("NO_EX").toString().trim().equals("")){
                    throw new Exception("NO_EX 필수항목입니다.");
                }
                if(customerMap.get("NM_SCREEN") == null || customerMap.get("NM_SCREEN").toString().trim().equals("")){
                    throw new Exception("NM_SCREEN 필수항목입니다.");
                }
                
                logger.debug("loop cnt:"+i);
                logger.debug(String.format("lineNo=%s, rowNo=%s, customerMap=%s", mapReader.getLineNumber(),
                        mapReader.getRowNumber(), customerMap));
                logger.debug("NO_REQ:"+customerMap.get("NO_REQ"));
                logger.debug("NO_EX:"+String.format("%03d", Integer.parseInt((String) customerMap.get("NO_EX"))));
                logger.debug("NM_SCREEN:"+customerMap.get("NM_SCREEN"));
                logger.debug("DM_COOPERATE:"+customerMap.get("DM_COOPERATE"));
                logger.debug("AM_COOPERATE:"+customerMap.get("AM_COOPERATE"));
                logger.debug("DS_COOPERATE:"+customerMap.get("DS_COOPERATE"));
                
                bexMasterRequestVO.setNoReq((String) customerMap.get("NO_REQ"));                
                bexMasterRequestVO.setNoEx(String.format("%03d", Integer.parseInt((String) customerMap.get("NO_EX"))));
                bexMasterRequestVO.setNmScreen((String) customerMap.get("NM_SCREEN"));
                String tmpDm = (String) customerMap.get("DM_COOPERATE");
                tmpDm = tmpDm.replaceAll("-","");
                tmpDm = tmpDm.replaceAll(":","");
                tmpDm = tmpDm.replaceAll("/","");
                tmpDm = tmpDm.replaceAll(" ","");
                tmpDm = tmpDm.replaceAll("AM","");
                tmpDm = tmpDm.replaceAll("PM","");
                bexMasterRequestVO.setDmCooperate(tmpDm);
                BigDecimal tmpAm = (BigDecimal) customerMap.get("AM_COOPERATE");
                tmpAm = tmpAm.multiply(new BigDecimal(10000));
                bexMasterRequestVO.setAmCooperate(tmpAm);
                bexMasterRequestVO.setDsCooperate((String) customerMap.get("DS_COOPERATE"));
                i++;
                
                logger.debug("Call BexSyncscreenService excute updateBexMaster");
                bexMasterService.updateBexMaster(bexMasterRequestVO);
                logger.debug("Call BexSyncscreenService excute insertBexContact");
                bexMasterService.insertBexContact(bexMasterRequestVO);
            }
        }
        finally {
                if( mapReader != null ) {
                    mapReader.close();
                }
        }        
        return resultCode;
    }
    
    private static CellProcessor[] getProcessors() {
        
        final String emailRegex = "[a-z0-9\\._]+@[a-z0-9\\.]+"; // just an example, not very robust!
        StrRegEx.registerMessage(emailRegex, "must be a valid email address");
        
        final CellProcessor[] processors = new CellProcessor[] { 
                new NotNull(), // noReq 접수번호
                new NotNull(), // noEx 실행번호
                new NotNull(), // nmScreen 심사상태코드명
                new Optional(), // dmCooperate 거래처승인일시
                new Optional(new ParseBigDecimal()), // amCooperate 거래처승인금액
                new Optional() // dsCooperate 거래처메세지
        };
        
        return processors;
}

    public void excuteByView(BexMasterRequestVO bexMasterRequestVO) throws Exception {
        
        if(bexMasterRequestVO.getDmCooperate() != null && bexMasterRequestVO.getDmCooperate().getBytes().length > 1){
            String tmpDm = bexMasterRequestVO.getDmCooperate();
            tmpDm = tmpDm.replaceAll("-","");
            tmpDm = tmpDm.replaceAll(":","");
            tmpDm = tmpDm.replaceAll("/","");
            tmpDm = tmpDm.replaceAll(" ","");
            tmpDm = tmpDm.replaceAll("AM","");
            tmpDm = tmpDm.replaceAll("PM","");
            bexMasterRequestVO.setDmCooperate(tmpDm);                  
        }
        
        BigDecimal tmpAm = bexMasterRequestVO.getAmCooperate();
        tmpAm = tmpAm.multiply(new BigDecimal(10000));
        bexMasterRequestVO.setAmCooperate(tmpAm);
        bexMasterService.updateBexMaster(bexMasterRequestVO);

    }    

}