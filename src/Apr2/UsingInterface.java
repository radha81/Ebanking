package Apr2;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class UsingInterface {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
FileInputStream fi=new FileInputStream("C:\\Users\\DELL\\Desktop\\data.xls.xlsx");

Workbook wb=WorkbookFactory.create(fi);
Sheet ws=wb.getSheet("emp");
int rc=ws.getLastRowNum();
for(int i=1;i<=rc;i++)	
{
	String fname=ws.getRow(i).getCell(0).getStringCellValue();
	
	String mname=ws.getRow(i).getCell(1).getStringCellValue();
	String lname=ws.getRow(i).getCell(2).getStringCellValue();
int eid=(int) ws.getRow(i).getCell(3).getNumericCellValue();
System.out.println(fname+"  "+mname+"    "+lname+"  "+eid);
	
	
}
fi.close();
FileOutputStream fo=new FileOutputStream("C:\\Users\\DELL\\Downloads\\results.xls.xlsx");
wb.write(fo);
fo.close();
wb.close();

	}

}
