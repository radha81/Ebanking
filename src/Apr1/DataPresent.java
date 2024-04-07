package Apr1;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataPresent {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
		FileInputStream fi=new FileInputStream("C:\\Users\\DELL\\Desktop\\sample data.xlsx");
		XSSFWorkbook wb=new XSSFWorkbook(fi);
		XSSFSheet ws=wb.getSheet("emp");
		XSSFRow row=ws.getRow(4);
		XSSFCell c1=row.getCell(0);
		XSSFCell c2=row.getCell(1);
		XSSFCell c3=row.getCell(2);
		XSSFCell c4=row.getCell(3);
String fname=c1.getStringCellValue();
String mname=c2.getStringCellValue();
String lname=c3.getStringCellValue();
int eid=(int) c4.getNumericCellValue();
System.out.println(fname+"  "+mname+" "+lname+" "+ eid);



	}

}
