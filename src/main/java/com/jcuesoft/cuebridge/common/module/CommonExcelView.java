package com.jcuesoft.cuebridge.common.module;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.web.servlet.view.document.AbstractExcelView;

public class CommonExcelView extends AbstractExcelView  {
    /**
     * Excel File 생성 <BR/>
     * SpringFramework AbstractExcelView 이용 <BR/>
     * buildExcelDocument method override
     */
    @SuppressWarnings("unchecked")
    @Override
    protected void buildExcelDocument(Map<String, Object> modelMap, HSSFWorkbook workbook, HttpServletRequest request, HttpServletResponse response) throws Exception {
        //modelMap
        String excelName = (String) modelMap.get("excelName"); //excel name
        List<String> colName = (List<String>) modelMap.get("colName"); //excel header
        List<List<String>> colValue = (List<List<String>>) modelMap.get("colValue"); //excel content

        //set response
        response.setContentType("application/vnd.ms-excel");
        response.setHeader("Content-Disposition", "attachment; filename="+ excelName + ".xls");

        //excel sheet
        HSSFSheet sheet = workbook.createSheet(excelName);

        //excel header
        HSSFRow headerRow = sheet.createRow(0);
        for (int i=0; i<colName.size(); i++) {
            HSSFCell cell = headerRow.createCell(i);
            cell.setCellValue(new HSSFRichTextString(colName.get(i)));
        }

        //excel content
        HSSFRow row;
        HSSFCell cell;
        
        HSSFCellStyle dateStyle = workbook.createCellStyle();
        dateStyle.setAlignment(HSSFCellStyle.ALIGN_CENTER);
        dateStyle.setVerticalAlignment(HSSFCellStyle.ALIGN_CENTER_SELECTION);
        dateStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("m/d/yy h:mm"));
        String datePattern = "\\d{4}-\\d{2}-\\d{2} \\d{2}:\\d{2}:\\d{2}";
                
        for (int i=0; i<colValue.size(); i++) {
            row = sheet.createRow(i+1); //header row가 있기때문에 + 1

            for (int j=0; j<colValue.get(i).size(); j++) {
                cell = row.createCell(j);

                String data = colValue.get(i).get(j);

                if ( data != null  && data.matches(datePattern)) {
                    cell.setCellStyle(dateStyle); 
                    logger.debug("@@@ mached dateStyle changed"+  data);  
                }
                cell.setCellValue(new HSSFRichTextString(data));
            }
        }
    }
}
