package Apr1;

import java.awt.image.IndexColorModel;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class AlternateMethod {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		
		FileInputStream fi=new FileInputStream("C:\\Users\\DELL\\Desktop\\sample data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("emp");
		int rc=ws.getLastRowNum();
		System.out.println(rc);
		for(int i=1;i<=rc;i++)
		//XSSFRow row=ws.getRow(i);
		{
		/*	String fname=ws.getRow(i).getCell(0).getStringCellValue();
		String mname=ws.getRow(i).getCell(1).getStringCellValue();
		String lname=ws.getRow(i).getCell(2).getStringCellValue();
		int eid=(int) ws.getRow(i).getCell(3).getNumericCellValue();
System.out.println(fname+" "+mname+" "+lname+"  "+eid);*/
			ws.getRow(i).createCell(4).setCellValue("blocked");
XSSFCellStyle style=wb.createCellStyle();
XSSFFont font=wb.createFont();
font.setBold(true);
font.setColor(IndexedColors.GREEN.getIndex());
style.setFont(font);
ws.getRow(i).getCell(4).setCellStyle(style);
		}
fi.close();

FileOutputStream fo=new FileOutputStream("C:\\Users\\DELL\\Desktop\\Result2data.xlsx");
wb.write(fo);
fo.close();
wb.close();
		
	}

}
