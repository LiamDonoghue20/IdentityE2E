import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.logging.Logger;


public class DatabaseReader {


    final static Logger logger = (Logger) Logger.getLogger(String.valueOf(DatabaseReader.class));
    private ArrayList<Vehicle> vehicleRecords;


    public void PopulateData() {

        FileInputStream fis = null;
        try {
            fis = new FileInputStream(new File("VehicleDetails.xlsx"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(fis);
        } catch (IOException e) {
            e.printStackTrace();
        }

        HSSFSheet sheet = wb.getSheetAt(0);

        FormulaEvaluator forlulaEvaluator = wb.getCreationHelper().createFormulaEvaluator();

        for(Row row : sheet){
            for(Cell cell: row){
                switch(forlulaEvaluator.evaluateInCell(cell).getCellType())
                {
                    case Cell.CELL_TYPE_STRING:
                        System.out.print(cell.getStringCellValue() + "\t\t");
                        break;

                }
                System.out.println();
            }
        }


    }
}
