import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;


public class PEPFinder {

    private FileInputStream stream;
    private Workbook wb;
    private Sheet dataSheet;
    private DataFormatter formatter;
    private String path;

    public PEPFinder(String filePath){
        this.path = filePath;
    }

    //Find the PEP file and convert it to a sheet
    public Sheet findFile(){
        try {
            //Init fileinputstream at find the file at the specific path defined in the constructor
            stream = new FileInputStream(new File(path));
            //Representation of a Excel workbook - Used for both reading and writing to a excel document
            //Used to create sheets
            wb = new XSSFWorkbook(stream);
            //Defining a sheet to be traversed to identify PEPs
            dataSheet = wb.getSheetAt(0);


        } catch (FileNotFoundException e) {
            System.err.println("File could not be found!");
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return dataSheet;
    }

    //Method to find a specific PEP defiend by first name and last name.
    public boolean findPerson(String firstName, String lastName){
        boolean found = false;
        //Used for formatting cell values - Extract, Read or modify cell data.
        DataFormatter formatter = new DataFormatter();
        //Defining the sheet to traversed
        Sheet sheet = findFile();
        for(Row row : sheet){
            for(Cell cell : row){
                //Checking if a person with specific first name exists in any cell
                if(firstName.equals(formatter.formatCellValue(cell))){
                    //Defining the adjacent cell to match the first and last name
                    Cell adjacent = row.getCell(cell.getColumnIndex()-1);
                    //Matching last name with cell value
                    if(lastName.equals(formatter.formatCellValue(adjacent))){
                        //Returns true if both cells matches input string
                        found = true;
                    }
                }
            }
        }
        return found;
    }
}
