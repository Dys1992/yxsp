package util;

import constants.FilePathConstants;
import org.apache.log4j.Logger;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;

import static org.apache.poi.ss.usermodel.Cell.*;

/**
 * @Author: fanyu
 * @Date: 2018/5/16 10:05
 */

public class ExcelDataUtils {
    public static final Logger log = Logger.getLogger(ExcelDataUtils.class);

    public static Object[][] getData(String fileName,String name){
        ArrayList<String> arrkey = new ArrayList<String>();
        Workbook workbook = getWorkbook(FilePathConstants.EXCEL_PATH+fileName);
        Sheet sheet = workbook.getSheet(name);
        int rowTotalNum = sheet.getLastRowNum()+1;
        int columns = sheet.getRow(0).getPhysicalNumberOfCells();

        HashMap<String,String>[][] map = new HashMap[rowTotalNum-1][1];

        if(rowTotalNum > 1){
            for (int i = 0; i< rowTotalNum -1;i++){
                map[i][0] = new HashMap();
            }
        }else {
            log.error("测试用例为空");
        }

        //获取首行列名
        for (int c = 0; c < columns ; c++){
            String cellValue = getCellValue(sheet,0,c);
            arrkey.add(cellValue);
        }

        //遍历单元格值
        for(int r = 1;r < rowTotalNum ; r++) {
            for (int c = 0; c <columns ; c ++){
                String cellValue = getCellValue(sheet,r,c);
                map[r-1][0].put(arrkey.get(c),cellValue);
            }
        }

        return map;

    }

    private static Workbook getWorkbook(String filePath){
        Workbook wb = null;
        try {
            if (filePath.endsWith(".xls")) {
                File file = new File(filePath);
                InputStream is = new FileInputStream(file);
                wb = new HSSFWorkbook(is);
            } else if (filePath.endsWith(".xlsx") || filePath.endsWith(".xlsm")) {
                wb = new XSSFWorkbook(filePath);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return wb;
    }

    private static String getCellValue(Sheet sheet, int rowNum, int cellNum) {
        HSSFCell cell = (HSSFCell) sheet.getRow(rowNum).getCell(cellNum);
        return getValue(cell);
    }


    /**
     * 把不同类型的单元格转换成字符串，并返回
     * @param cell cell
     * @return 当个单元格值
     */

    private static String getValue(Cell cell) {
        String value = "";
        switch (cell.getCellType()) {
            case CELL_TYPE_STRING:
                value = String.valueOf(cell.getRichStringCellValue());
                return value;
            case CELL_TYPE_NUMERIC:
                cell.setCellType(Cell.CELL_TYPE_NUMERIC);
                value = String.valueOf((int)cell.getNumericCellValue());
                return value;
            case CELL_TYPE_BOOLEAN:
                value = String.valueOf(cell.getBooleanCellValue());
                return value;

            case CELL_TYPE_FORMULA:
                value = String.valueOf(cell.getCellFormula());
                return value;

            case CELL_TYPE_ERROR:
                value = String.valueOf(cell.getErrorCellValue());
                return value;
            case CELL_TYPE_BLANK:
                return value;
            default:
                log.error("未知该单元格类型");
                return value;

        }
    }


}
