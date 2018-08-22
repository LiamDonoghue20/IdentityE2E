import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class VehicleAssigner {


    FileInputStream file = null;
    XSSFWorkbook workbook = null;
    XSSFCell registration;
    XSSFCell vehicleMake;
    XSSFCell vehicleColour;
    Vehicle vehicle = new Vehicle();

    public List<Vehicle> assignVehicles() throws IOException {

        file = new FileInputStream(DatabaseReader.Path_TestData + DatabaseReader.File_TestData);
        workbook = new XSSFWorkbook(file);
        XSSFSheet sheet = workbook.getSheetAt(0);
        int rowCount = 0;
        int cellCount = 0;
        List<Vehicle> vehicleList = new ArrayList<>();

        registration = sheet.getRow(rowCount).getCell(cellCount);
        vehicleMake = sheet.getRow(rowCount).getCell(1);
        vehicleColour = sheet.getRow(rowCount).getCell(2);


        while (!registration.getStringCellValue().equals("")) {

            switch (cellCount) {
                case 0:
                    vehicle.setVehicleRegNumber(registration.getStringCellValue());
                    break;
                case 1:
                    vehicle.setVehicleMake(vehicleMake.getStringCellValue());
                    break;
                case 2:
                    vehicle.setVehicleColour(vehicleColour.getStringCellValue());
                    break;
            }
            vehicleList.add(vehicle);
            rowCount++;
        }
        return vehicleList;
    }

}
