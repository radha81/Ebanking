import java.io.FileInputStream;
import java.io.FileNotFoundException;

import org.apache.poi.xssf.eventusermodel.XSSFSheetXMLHandler;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class RowCellCount {

	public static void main(String[] args) throws Throwable {
		// TODO Auto-generated method stub
FileInputStream fi=new FileInputStream("C:\\Users\\DELL\\Desktop\\sample data.xlsx");
XSSFWorkbook wb=new XSSFWorkbook(fi);
XSSFSheet ws=wb.getSheet("emp");
XSSFRow row=ws.getRow(0);
int rc=ws.getLastRowNum();
int cc=row.getLastCellNum();
System.out.println("  "+rc+ "   "+cc);
fi.close();
wb.close();
	}

}
