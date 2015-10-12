package developer.gibranpolonsky.util;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Cell;
public class ExcelReader{

	
	public static void read(){
		boolean first = true;
		String insert ="insert into &&&&(???) VALUES (¡¡¡)";
		Runtime.getRuntime().maxMemory();
		
		try{
			FileInputStream file = new FileInputStream(new File("base de datos.xlsx"));
		
			XSSFWorkbook workbook = new XSSFWorkbook(file);
			
			
			XSSFSheet sheet = workbook.getSheetAt(10);
			insert = insert.replace("&&&&", sheet.getSheetName());
			
			
			System.out.println(insert);
			
			System.exit(1);
			Iterator<Row> rowIterator = sheet.iterator();
			
			while(rowIterator.hasNext()){
				Row row = rowIterator.next();
				Iterator<Cell> cellIterator = row.cellIterator();
				
				while(cellIterator.hasNext()){
					Cell cell = cellIterator.next();
					switch (cell.getCellType()){
						case Cell.CELL_TYPE_NUMERIC:
								
								
						
								System.out.print((int) Math.floor(cell.getNumericCellValue())+ "\t");
								
						break;
						case Cell.CELL_TYPE_STRING:
								System.out.print(cell.getStringCellValue() + "\t");
								
						break;
					}
				}
				System.out.println("");
			}
			file.close();
			
		}catch(IOException ioe){
			ioe.printStackTrace();
		}	
	}
}