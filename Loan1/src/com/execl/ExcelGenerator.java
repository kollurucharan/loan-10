package com.execl;

import java.io.IOException;
import java.util.List;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.entities.LoanApplicants;

public class ExcelGenerator {

	public static Workbook generateExcel(List<LoanApplicants> loanApplicants) throws IOException {
		Workbook workbook = new XSSFWorkbook();
		Sheet sheet = workbook.createSheet("Loan Applicants");

		// Create header row
		Row headerRow = sheet.createRow(0);
		headerRow.createCell(0).setCellValue("Loan Applicant ID");
		headerRow.createCell(1).setCellValue("Customer ID");
		headerRow.createCell(2).setCellValue("nominee id");
		headerRow.createCell(3).setCellValue("applied date");
		headerRow.createCell(4).setCellValue("loan type id");
		headerRow.createCell(5).setCellValue("loan amount");
		headerRow.createCell(6).setCellValue("emi range from");
		headerRow.createCell(7).setCellValue("emi range to");
		headerRow.createCell(8).setCellValue("emi months");
		headerRow.createCell(9).setCellValue("cibil score");
		headerRow.createCell(10).setCellValue("annual income");
		headerRow.createCell(11).setCellValue("disposed income");
		headerRow.createCell(12).setCellValue("status");
		headerRow.createCell(13).setCellValue("remarks");

		int rowNum = 1;
		for (LoanApplicants applicant : loanApplicants) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(applicant.getLapp_id());
			row.createCell(1).setCellValue(applicant.getLapp_cust_id());
			row.createCell(2).setCellValue(applicant.getLapp_lnom_id());
			row.createCell(3).setCellValue(applicant.getLapp_date());
			row.createCell(4).setCellValue(applicant.getLapp_ltype_id());
			row.createCell(5).setCellValue(applicant.getLapp_amount());
			row.createCell(6).setCellValue(applicant.getLapp_emirange_from());
			row.createCell(7).setCellValue(applicant.getLapp_emirange_to());
			row.createCell(8).setCellValue(applicant.getLapp_months_req());
			row.createCell(9).setCellValue(applicant.getLapp_cibil_score());
			row.createCell(10).setCellValue(applicant.getLapp_annual_income());
			row.createCell(11).setCellValue(applicant.getLapp_dispos_income());
			row.createCell(12).setCellValue(applicant.getLapp_status());
			row.createCell(13).setCellValue(applicant.getLapp_conclusion_remarks());
			// Add other data fields as needed
		}

		return workbook;
	}
}
