package com.processing;

import java.io.FileInputStream;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

class Reprocessing {

	public static void main(String[] args) throws Exception {
		String file_one = "C:\\Users\\jayan\\Desktop\\Processed\\The Project Gutenberg eBook of A Christmas Carol.txt";
		String file_one_out = "C:\\Users\\jayan\\Desktop\\Reprocessed\\The Project Gutenberg eBook of A Christmas Carol.txt";
		process(file_one, file_one_out);

		String file_two = "C:\\Users\\jayan\\Desktop\\Processed\\The Project Gutenberg EBook of A Study In Scarlet.txt";
		String file_two_out = "C:\\Users\\jayan\\Desktop\\Reprocessed\\The Project Gutenberg EBook of A Study In Scarlet.txt";
		process(file_two, file_two_out);

		String file_three = "C:\\Users\\jayan\\Desktop\\Processed\\The Project Gutenberg eBook of Adventures of Huckleberry Finn.txt";
		String file_three_out = "C:\\Users\\jayan\\Desktop\\Reprocessed\\The Project Gutenberg eBook of Adventures of Huckleberry Finn.txt";
		process(file_three, file_three_out);

		String file_four = "C:\\Users\\jayan\\Desktop\\Processed\\The Project Gutenberg eBook of Frankenstein.txt";
		String file_four_out = "C:\\Users\\jayan\\Desktop\\Reprocessed\\The Project Gutenberg eBook of Frankenstein.txt";
		process(file_four, file_four_out);

		String file_five = "C:\\Users\\jayan\\Desktop\\Processed\\The Project Gutenberg eBook of Pride and Prejudice.txt";
		String file_five_out = "C:\\Users\\jayan\\Desktop\\Reprocessed\\The Project Gutenberg eBook of Pride and Prejudice.txt";
		process(file_five, file_five_out);

		String file_six = "C:\\Users\\jayan\\Desktop\\Processed\\The Project Gutenberg eBook of Siddhartha.txt";
		String file_six_out = "C:\\Users\\jayan\\Desktop\\Reprocessed\\The Project Gutenberg eBook of Siddhartha.txt";
		process(file_six, file_six_out);

		String file_seven = "C:\\Users\\jayan\\Desktop\\Processed\\The Project Gutenberg eBook of The Life and Adventures of Robinson Crusoe.txt";
		String file_seven_out = "C:\\Users\\jayan\\Desktop\\Reprocessed\\The Project Gutenberg eBook of The Life and Adventures of Robinson Crusoe.txt";
		process(file_seven, file_seven_out);

		String file_eight = "C:\\Users\\jayan\\Desktop\\Processed\\The Project Gutenberg eBook of The Republic.txt";
		String file_eight_out = "C:\\Users\\jayan\\Desktop\\Reprocessed\\The Project Gutenberg eBook of The Republic.txt";
		process(file_eight, file_eight_out);

		String file_nine = "C:\\Users\\jayan\\Desktop\\Processed\\The Project Gutenberg eBook of The Wonderful Wizard of Oz.txt";
		String file_nine_out = "C:\\Users\\jayan\\Desktop\\Reprocessed\\The Project Gutenberg eBook of The Wonderful Wizard of Oz.txt";
		process(file_nine, file_nine_out);

		String file_ten = "C:\\Users\\jayan\\Desktop\\Processed\\The Project Gutenberg eBook of Wuthering Heights.txt";
		String file_ten_out = "C:\\Users\\jayan\\Desktop\\Reprocessed\\The Project Gutenberg eBook of Wuthering Heights.txt";
		process(file_ten, file_ten_out);
	}

	public static void process(String infile, String outfile) {
		Map<String, String> variableMap = fillMap();
		Path inpath = Paths.get(infile);
		Path outpath = Paths.get(outfile);

		Stream<String> lines;

		try {

			lines = Files.lines(inpath);

			List<String> replacedLines = lines.map(line -> replaceTag(line, variableMap)).collect(Collectors.toList());

			Files.write(outpath, replacedLines);
			lines.close();
			
			System.out.println("replace done.");

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	public static Map<String, String> fillMap() {
		Map<String, String> map = new HashMap<String, String>();
		String excelfile = ".\\files\\Word Substitutions.xlsx";
		String[][] s = new String[101][2];
		int a = 0, b = 0;

		try {

			FileInputStream inputstream = new FileInputStream(excelfile);

			try (XSSFWorkbook workbook = new XSSFWorkbook(inputstream)) {
				XSSFSheet sheet = workbook.getSheetAt(0);

				int rows = sheet.getLastRowNum();
				int cols = sheet.getRow(1).getLastCellNum();

				a = rows;
				b = cols;

				for (int r = 0; r <= rows; r++) {
					XSSFRow row = sheet.getRow(r);
					for (int c = 0; c < cols; c++) {
						XSSFCell cell = row.getCell(c);
						s[r][c] = " " + cell.getStringCellValue() + " ";
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		for (int i = 1; i <= a; i++) {
			map.put(s[i][1], s[i][0]);
		}

		return map;
	}

	private static String replaceTag(String str, Map<String, String> map) {
		for (Map.Entry<String, String> entry : map.entrySet()) {
			if (str.contains(entry.getKey())) {

				str = str.replace(entry.getKey(), entry.getValue());
			}

		}
		return str;
	}
}