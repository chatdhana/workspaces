package sample.excel.compare;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ExcelComparer {

	private static String LINE_DEL = System.getProperty("line.separator");
	public static void main(String[] args) {
		if (args.length != 3) {
			System.out.println("Usage: ExcelComparer <SourceFilePath> <TargetFilePath> <MappingFilePath>");
			return;
		}
		StringBuilder erorReport = new ExcelComparer().compare(args[0], args[1], args[2]);
		if (erorReport.length() > 0) {
			System.out.println("Source and Target Files are not matching. Comparison Report:");
			System.out.println(erorReport.toString());
		} else {
			System.out.println("Source and Target Files are matching");
		}
	}

	private StringBuilder compare(String srcFilePath, String trgFilePath, String mappingFilePath) {
		Map<String, Integer> srcHeaderMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> trgHeaderMap = new LinkedHashMap<String, Integer>();
		Map<String, Integer> mappingHeaderMap = new LinkedHashMap<String, Integer>();
		Map<Integer, Row> srcRowMap = new LinkedHashMap<Integer, Row>();
		Map<Integer, Row> trgRowMap = new LinkedHashMap<Integer, Row>();
		Map<Integer, Row> mappingRowMap = new LinkedHashMap<Integer, Row>();
		List<String> sourceFieldsList = new ArrayList<String>();
		List<String> targetFieldsList = new ArrayList<String>();
		List<String> mappingFieldsList = new ArrayList<String>();
		
		StringBuilder erorReport = new StringBuilder();
		try {
			Workbook srcBook = loadExcel(srcFilePath);
			Workbook trgBook = loadExcel(trgFilePath);
			Workbook mappingBook = loadExcel(mappingFilePath);

			if (mappingBook.getNumberOfSheets() > 0) {
				Sheet sheet = mappingBook.getSheetAt(0);
				if (sheet.getPhysicalNumberOfRows() > 0) {
					for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
						Row row = sheet.getRow(i);
						if (i == 0) {
							for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
								Cell cell = row.getCell(j);
								if (cell != null)
									mappingHeaderMap.put(cell.getStringCellValue(), j);
							}
						} else {
							mappingRowMap.put(i, row);
						}
					}
				}
			}
	
			if (srcBook.getNumberOfSheets() > 0) {
				Sheet sheet = srcBook.getSheetAt(0);
				if (sheet.getPhysicalNumberOfRows() > 0) {
					for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
						Row row = sheet.getRow(i);
						if (i == 0) {
							for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
								Cell cell = row.getCell(j);
								if (cell != null)
									srcHeaderMap.put(cell.getStringCellValue(), j);
							}
						} else {
							srcRowMap.put(i, row);
						}
					}
				}
			}

			if (trgBook.getNumberOfSheets() > 0) {
				Sheet sheet = trgBook.getSheetAt(0);
				if (sheet.getPhysicalNumberOfRows() > 0) {
					for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++) {
						Row row = sheet.getRow(i);
						if (i == 0) {
							for (int j = 0; j < row.getPhysicalNumberOfCells(); j++) {
								Cell cell = row.getCell(j);
								if (cell != null)
									trgHeaderMap.put(cell.getStringCellValue(), j);
							}
						} else {
							trgRowMap.put(i, row);
						}
					}
				}
			}
	
			if (srcRowMap.size() != srcRowMap.size()) {
				erorReport.append("Mismatch in number of records in Source and Target files." + LINE_DEL);
				return erorReport;
			}
			
			if (mappingHeaderMap.size() == 3) {

				for (Iterator<Integer> iter = mappingRowMap.keySet().iterator(); iter.hasNext();) {
					Row row = mappingRowMap.get(iter.next());
					sourceFieldsList.add(row.getCell(mappingHeaderMap.get("Source")).getStringCellValue());
				}

				for (Iterator<Integer> iter = mappingRowMap.keySet().iterator(); iter.hasNext();) {
					Row row = mappingRowMap.get(iter.next());
					targetFieldsList.add(row.getCell(mappingHeaderMap.get("Target")).getStringCellValue());
				}

				for (Iterator<Integer> iter = mappingRowMap.keySet().iterator(); iter.hasNext();) {
					Row row = mappingRowMap.get(iter.next());
					mappingFieldsList.add(row.getCell(mappingHeaderMap.get("Mapping")).getStringCellValue());
				}
			}

			if (sourceFieldsList.size() != targetFieldsList.size()) {
				erorReport.append("Mismatch in number of Source and Target fields." + LINE_DEL);
				return erorReport;
			}
			String srcVal = null;
			String trgVal = null;
			for (Iterator<Integer> iter = srcRowMap.keySet().iterator(); iter.hasNext();) {
				int rowId = iter.next();
				Row srcRow = srcRowMap.get(rowId);
				Row trgRow = trgRowMap.get(rowId);
				for (int j = 0; j < sourceFieldsList.size() && srcRow != null && trgRow != null; j++) {
					if(srcHeaderMap.containsKey(sourceFieldsList.get(j))) {
						Cell cell = srcRow.getCell(srcHeaderMap.get(sourceFieldsList.get(j)));
						if(cell != null){
							 if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								 srcVal = String.valueOf(cell.getNumericCellValue());
							 } else {
								 srcVal = cell.getStringCellValue();
							 } 
						} else {
							srcVal = "";
						}
					} else {
						erorReport.append("Source Field <" + targetFieldsList.get(j) + "> Not Found." + LINE_DEL);
						continue;
					}
					
					if (trgHeaderMap.containsKey(targetFieldsList.get(j))) {
						Cell cell = trgRow.getCell(trgHeaderMap.get(targetFieldsList.get(j)));
						if(cell != null) {
							if(cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
								trgVal = String.valueOf(cell.getNumericCellValue());
							} else {
								trgVal = cell.getStringCellValue();
							} 
						} else {
							trgVal = "";
						}
					} else {
						erorReport.append("Target Field <" + targetFieldsList.get(j) + "> Not Found." + LINE_DEL);
						continue;
					}
					
					if (srcVal == null || trgVal == null || !srcVal.equals(trgVal)) {
						erorReport.append("Mismatch -> Row:" + rowId + "\tSrcField:" + sourceFieldsList.get(j)
								+ "\tTrgField:" + targetFieldsList.get(j) + "\tMappingField:"
								+ mappingFieldsList.get(j) + LINE_DEL);
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			erorReport.append("Error Occeured:" + e.getMessage() + LINE_DEL);
		}

		return erorReport;
	}

	private Workbook loadExcel(String filePath) {
		Workbook wb = null;
		try {
			System.out.println("Loading " + filePath);
			wb = WorkbookFactory.create(new File(filePath));
		} catch (InvalidFormatException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return wb;
	}
}