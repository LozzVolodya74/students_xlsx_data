package students_xlsx_data.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import students_xlsx_data.entity.Student;

public class XSSFconvert {
	private static final Logger LOGGER = LoggerFactory.getLogger(XSSFconvert.class);

	private static XSSFCellStyle createStyleForTitle(XSSFWorkbook workbook) {
		XSSFFont font = workbook.createFont();
		font.setBold(true);
		XSSFCellStyle style = workbook.createCellStyle();
		style.setFont(font);
		return style;
	}

	public static void writeData(List<Student> list) throws IOException {
		XSSFWorkbook workbook = new XSSFWorkbook();
		XSSFSheet sheet = workbook.createSheet("Students sheet");

		int rownum = 0;
		Cell cell;
		Row row;

		XSSFCellStyle style = createStyleForTitle(workbook);
		row = sheet.createRow(rownum);

		cell = row.createCell(0);
		cell.setCellValue("firstName");
		cell.setCellStyle(style);

		cell = row.createCell(1);
		cell.setCellValue("lastName");
		cell.setCellStyle(style);

		cell = row.createCell(2);
		cell.setCellValue("age");
		cell.setCellStyle(style);

		cell = row.createCell(3);
		cell.setCellValue("birthday");
		cell.setCellStyle(style);

		cell = row.createCell(4);
		cell.setCellValue("faculty");
		cell.setCellStyle(style);

		for (Student emp : list) {
			rownum++;
			row = sheet.createRow(rownum);

			cell = row.createCell(0);
			cell.setCellValue(emp.getFirstName());

			cell = row.createCell(1);
			cell.setCellValue(emp.getLastName());

			cell = row.createCell(2);
			cell.setCellValue(emp.getAge());

			cell = row.createCell(3);
			cell.setCellValue(emp.getBirthday());

			cell = row.createCell(4);
			cell.setCellValue(emp.getFaculty());
		}

		File file = new File("C:/Students/students.xlsx");
		file.getParentFile().mkdirs();

		LOGGER.warn("FILE PREPARDE " + file.getAbsolutePath());
		FileOutputStream outFile = new FileOutputStream(file);
		workbook.write(outFile);

	}

}
