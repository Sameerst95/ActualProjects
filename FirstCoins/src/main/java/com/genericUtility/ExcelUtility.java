package com.genericUtility;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import net.bytebuddy.asm.Advice.Enter;

/**
 * 
 * @author Gokul
 */
public class ExcelUtility {

	/**
	 * @author Gokul
	 * @param sheetName
	 * @param rowNum
	 * @param cellNum
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String readDataFromExcelFile(String sheetName, int rowNum, int cellNum)
			throws IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook workBook = WorkbookFactory.create(fis);
		return workBook.getSheet(sheetName).getRow(rowNum).getCell(cellNum).getStringCellValue();
	}

	public void writeDataInExcelFile(String sheetName, int rowNum, int cellNum, String value,boolean t)
			throws EncryptedDocumentException, IOException {

		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook workBook = WorkbookFactory.create(fis);
		
        if(t) {
        	workBook.getSheet(sheetName).createRow(rowNum).createCell(cellNum).setCellValue(value);
        }else {
        	workBook.getSheet(sheetName).getRow(rowNum).createCell(cellNum).setCellValue(value);

        }
		
		FileOutputStream fOut = new FileOutputStream(IPathConstant.excelPath);
		workBook.write(fOut);
		workBook.close();
	}

	public Map<String, String> fetchDatafromExcelInMap(String sheetName,int cellNo) throws EncryptedDocumentException, IOException {
		FileInputStream fis = new FileInputStream(IPathConstant.excelPath);
		Workbook workBook = WorkbookFactory.create(fis);
		Sheet sheet = workBook.getSheet(sheetName);
		int rowCount=sheet.getLastRowNum();
	      Map<String , String> map= new HashMap<String, String>();
		for(int i=0;i<=rowCount;i++) {
			String key=sheet.getRow(i).getCell(cellNo).getStringCellValue();
			String value=sheet.getRow(i).getCell(cellNo+1).getStringCellValue();
			map.put(key, value);
		}
		return map;
		
	}
	
	

}
