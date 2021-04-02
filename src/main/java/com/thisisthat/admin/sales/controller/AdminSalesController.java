package com.thisisthat.admin.sales.controller;

import java.io.IOException;
import java.net.URLEncoder;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFDataFormat;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.thisisthat.admin.sales.service.AdminSalesService;
import com.thisisthat.admin.sales.vo.AdminSalesDataVO;

@Controller
@RequestMapping("/admin")
public class AdminSalesController {

	@Autowired
	private AdminSalesService salesService;

	/**
	 * 월별 매출현황
	 * @param sDate
	 * @param eDate
	 * @param model
	 * @return
	 */
	@GetMapping("/montlySales.mdo")
	public String montlySales(@RequestParam(value = "sDate", required = false) String sDate,
			@RequestParam(value = "eDate", required = false) String eDate, Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM");
		if (sDate != null && eDate != null) {
			try {
				Date startMonth = sdf.parse(sDate);
				Date endMonth = sdf.parse(eDate);
				List<AdminSalesDataVO> monthList = salesService.getMontlySales(startMonth, endMonth);
				for (AdminSalesDataVO month : monthList) {
					month.setGroupString(sdf.format(month.getGrouping()));
				}
				model.addAttribute("monthly", monthList);
				model.addAttribute("startMonth", sdf.format(startMonth));
				model.addAttribute("endMonth", sdf.format(endMonth));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		}
		return "admin/sales/montlySales";
	}

	/**
	 * 일별 매출현황
	 * @param sDate
	 * @param eDate
	 * @param model
	 * @return
	 */
	@GetMapping("/dailySales.mdo")
	public String dailySales(@RequestParam(value = "sDate", required = false) String sDate,
			@RequestParam(value = "eDate", required = false) String eDate, Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (sDate != null && eDate != null) {
			try {
				Date startDay = sdf.parse(sDate);
				Date endDay = sdf.parse(eDate);
				List<AdminSalesDataVO> dailyList = salesService.getDailySales(startDay, endDay);
				for (AdminSalesDataVO daily : dailyList) {
					daily.setGroupString(sdf.format(daily.getGrouping()));
				}
				model.addAttribute("daily", dailyList);
				model.addAttribute("startDay", sdf.format(startDay));
				model.addAttribute("endDay", sdf.format(endDay));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "admin/sales/dailySales";
	}

	/**
	 * 카테고리별 매출현황 
	 * @param sDate
	 * @param eDate
	 * @param model
	 * @return
	 */
	@GetMapping("/categorySales.mdo")
	public String categorySales(@RequestParam(value = "sDate", required = false) String sDate,
			@RequestParam(value = "eDate", required = false) String eDate, Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (sDate != null && eDate != null) {
			try {
				Date startDay = sdf.parse(sDate);
				Date endDay = sdf.parse(eDate);
				List<AdminSalesDataVO> cateList = salesService.getCategorySales(startDay, endDay);
				model.addAttribute("categorySales", cateList);
				model.addAttribute("startDay", sdf.format(startDay));
				model.addAttribute("endDay", sdf.format(endDay));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "admin/sales/categorySales";
	}

	/**
	 * 요일별 매출현황 
	 * @param sDate
	 * @param eDate
	 * @param model
	 * @return
	 */
	@GetMapping("/datelySales.mdo")
	public String datelySales(
			@RequestParam(value = "sDate", required = false) String sDate,
			@RequestParam(value = "eDate", required = false) String eDate, Model model) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		if (sDate != null && eDate != null) {
			try {
				Date startDay = sdf.parse(sDate);
				Date endDay = sdf.parse(eDate);
				List<AdminSalesDataVO> datelyList = salesService.getDatelySales(startDay, endDay);
				ArrayList<AdminSalesDataVO> dateSort = new ArrayList<AdminSalesDataVO>();
				dateSort.addAll(datelyList);
				for(AdminSalesDataVO date : datelyList) {
					switch (date.getGroupString().trim()) {
					case "Monday":date.setGroupString("월요일");dateSort.set(0, date);break;
					case "Tuesday":date.setGroupString("화요일");dateSort.set(1, date);break;
					case "Wednesday":date.setGroupString("수요일");dateSort.set(2, date);break;
					case "Thursday":date.setGroupString("목요일");dateSort.set(3, date);break;
					case "Friday":date.setGroupString("금요일");dateSort.set(4, date);break;
					case "Saturday":date.setGroupString("토요일");dateSort.set(5, date);break;
					case "Sunday":date.setGroupString("일요일");dateSort.set(6, date);break;
					}
				}
				model.addAttribute("datelySales", dateSort);
				model.addAttribute("startDay", sdf.format(startDay));
				model.addAttribute("endDay", sdf.format(endDay));
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return "admin/sales/datelySales";
	}
	
	/**
	 * 액셀 다운로드
	 * @param sDate
	 * @param eDate
	 * @param type
	 * @throws IOException
	 * @throws ParseException 
	 */
	@GetMapping("/excelDownload.mdo")
	public void excelDownload(@RequestParam(value = "sDate", required = false) String sDate,
			@RequestParam(value = "eDate", required = false) String eDate,
			@RequestParam(value = "type", required = false) String type, HttpServletResponse response)
			throws IOException, ParseException {
		SimpleDateFormat sdf = null;
		List<AdminSalesDataVO> salesList = new ArrayList<AdminSalesDataVO>();
		if (type.equals("monthly")) {
			sdf = new SimpleDateFormat("yyyy-MM");
			Date startMonth = sdf.parse(sDate);
			Date endMonth = sdf.parse(eDate);
			salesList = salesService.getMontlySales(startMonth, endMonth);
			for (AdminSalesDataVO month : salesList) {
				month.setGroupString(sdf.format(month.getGrouping()));
			}
		}else if(type.equals("daily")) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDay = sdf.parse(sDate);
			Date endDay = sdf.parse(eDate);
			salesList = salesService.getDailySales(startDay, endDay);
			for (AdminSalesDataVO daily : salesList) {
				daily.setGroupString(sdf.format(daily.getGrouping()));
			}
		}else if(type.equals("category")) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDay = sdf.parse(sDate);
			Date endDay = sdf.parse(eDate);
			salesList = salesService.getCategorySales(startDay, endDay);
		}else if(type.equals("dately")) {
			sdf = new SimpleDateFormat("yyyy-MM-dd");
			Date startDay = sdf.parse(sDate);
			Date endDay = sdf.parse(eDate);
			List<AdminSalesDataVO> datelyList = salesService.getDatelySales(startDay, endDay);
			salesList.addAll(datelyList);
			for(AdminSalesDataVO date : datelyList) {
				switch (date.getGroupString().trim()) {
				case "Monday":date.setGroupString("월요일");salesList.set(0, date);break;
				case "Tuesday":date.setGroupString("화요일");salesList.set(1, date);break;
				case "Wednesday":date.setGroupString("수요일");salesList.set(2, date);break;
				case "Thursday":date.setGroupString("목요일");salesList.set(3, date);break;
				case "Friday":date.setGroupString("금요일");salesList.set(4, date);break;
				case "Saturday":date.setGroupString("토요일");salesList.set(5, date);break;
				case "Sunday":date.setGroupString("일요일");salesList.set(6, date);break;
				}
			}
		}
		response.setCharacterEncoding("utf-8");
		excelMake(response, type, salesList, sDate, eDate);
	}

	/**
	 * 다운로드할 액셀파일 설정
	 * @param response
	 * @param type
	 * @param salesList
	 * @param sDate
	 * @param eDate
	 * @throws IOException
	 */
	public void excelMake(HttpServletResponse response, String type, List<AdminSalesDataVO> salesList, String sDate,String eDate) throws IOException {
		Workbook wb = new XSSFWorkbook();
		Sheet sheet = wb.createSheet("첫번째 시트");
		
		XSSFDataFormat df = (XSSFDataFormat) wb.createDataFormat();
		XSSFCellStyle cs = (XSSFCellStyle) wb.createCellStyle();
	    cs.setDataFormat(df.getFormat("#,###"));
	    Row row = null;
		Cell cell = null;
		int rowNum = 0;
		String typeString = null;
		String subTotalString = null;
		String fileName = sDate + "~" + eDate;
		// Header
		if (type.equals("monthly")) {
			fileName+=" 월별 ";
			typeString = "매출 월";
			subTotalString = "금액(단위 : 원)";
		}else if(type.equals("daily")) {
			fileName+=" 일별 ";
			typeString = "매출 일자";
			subTotalString = "금액(단위 : 원)";
		}else if(type.equals("category")) {
			fileName+=" 카테고리별 ";
			typeString = "카테고리";
			subTotalString = "수량(단위 : 개)";
		}else if(type.equals("dately")) {
			fileName+=" 요일별 ";
			typeString = "요일구분";
			subTotalString = "금액(단위 : 원)";
		}
		fileName+="매출현황";
		row = sheet.createRow(rowNum++);
		cell = row.createCell(0);
		cell.setCellValue(typeString);
		cell = row.createCell(1);
		cell.setCellValue(subTotalString);
		// Body
		for (int i = 0; i < salesList.size(); i++) {
			row = sheet.createRow(rowNum++);
			cell = row.createCell(0);
			cell.setCellValue(salesList.get(i).getGroupString());
			cell = row.createCell(1);
			cell.setCellStyle(cs);
			cell.setCellValue(salesList.get(i).getSubtotal());
		}
		for (int i=0; i<=12; i++){
		    sheet.autoSizeColumn(i);
		    sheet.setColumnWidth(i, (sheet.getColumnWidth(i))+(short)1024);
		}

		// 컨텐츠 타입과 파일명 지정
		response.setContentType("ms-vnd/excel");
		response.setHeader("Content-Disposition","attachment;filename=" + URLEncoder.encode(fileName, "UTF-8") + ".xlsx");
		
		// Excel File Output
		wb.write(response.getOutputStream());
		wb.close();
	}

}
