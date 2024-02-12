package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRangeCopier;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	
	public FileInputStream fi;
	public XSSFWorkbook workbook;
	public XSSFSheet sheet;
	public XSSFRow row;
	public XSSFCell cell;
	
	String path = System.getProperty("user.dir") + "//testData//dataOutput.xlsx";
	String read_path = System.getProperty("user.dir") + "//testData//dataInput.xlsx";
	
	public void tableWriting(List<List<String>> tableData) {
		try {
			FileOutputStream fileOutputStream = new FileOutputStream(path);
			workbook = new XSSFWorkbook();
			sheet = workbook.createSheet("Year-O-Year Data");
			
			for(int i=0; i<tableData.size(); i++) {
				XSSFRow row = sheet.createRow(i);
				for(int j=0; j<tableData.get(i).size(); j++){
					XSSFCell cell = row.createCell(j);
					cell.setCellValue(tableData.get(i).get(j));
				}
			}
			
			workbook.write(fileOutputStream);
			workbook.close();
			fileOutputStream.close();
			
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	
	public String getCellData(String sheetName,int rownum,int colnum) throws IOException
	{
		fi=new FileInputStream(read_path);
		workbook=new XSSFWorkbook(fi);
		sheet=workbook.getSheet(sheetName);
		row=sheet.getRow(rownum);
		cell=row.getCell(colnum);
		
		DataFormatter formatter = new DataFormatter();
		String data;
		try{
		data = formatter.formatCellValue(cell); //Returns the formatted value of a cell as a String regardless of the cell type.
		}
		catch(Exception e)
		{
			data="";
		}
		workbook.close();
		fi.close();
		return data;
	}
}
