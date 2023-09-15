package com.controllers;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.entities.LoanApplicants;
import com.entities.LoginClass;
import com.entities.SessionTable;
import com.execl.ExcelGenerator;
import com.services.ServiceClass;

@Controller
public class Control2 {
	ServiceClass ctrl;

	@Autowired
	public Control2(ServiceClass ctrl) {
		this.ctrl = ctrl;
	}

	@RequestMapping(value = "/adminLogin", method = RequestMethod.GET)
	public String adminLogin(Model model) {
		System.out.println("123".hashCode());
		return "adminLogin";
	}

	@RequestMapping(value = "/adminstartpage", method = RequestMethod.GET)
	public String userStartPage(LoginClass log, SessionTable st, HttpServletRequest hsq, Model model) {
		SessionTable b = ctrl.checkCredentials(log, st);
		if (b == null) {
			model.addAttribute("false", "incorrect crediatials");
			return "adminLogin";
		} else {
			HttpSession session = hsq.getSession();
			session.setAttribute("key", b);
			System.out.println(b);
			return "adminhomepage";
		}
	}

	public boolean checkValid(HttpServletRequest request,String url,String method) {
		HttpSession session = request.getSession();
		SessionTable x = (SessionTable) session.getAttribute("key");
		boolean a=ctrl.findId(x.getUser_id(),url,method);
		if (a) {
			return ctrl.checkAccess(x);
		}
			else {
			return false;
			}
	}

	@RequestMapping(value = "/admin", method = RequestMethod.GET)
	public String adminApplicationPage(HttpServletRequest req, Model model) {
		String url=req.getRequestURI();
		String method=req.getMethod();
		if (checkValid(req,"admin",method)) {
			List<LoanApplicants> lapp = ctrl.getAllApps();
			model.addAttribute("lapp", lapp);
			return "adminpage";
		} else
			return "adminLogin";
	}

	@RequestMapping(value = "/editdetails", method = RequestMethod.GET)
	public String editdetails(HttpServletRequest req, LoanApplicants lap, Model model) {
		String url=req.getRequestURI();
		String method=req.getMethod();
		if (checkValid(req,"editdetails",method)) {
			LoanApplicants lapp = ctrl.getLoan(lap.getLapp_id());
			model.addAttribute("editdetails", lapp);
			return "editdetails";
		}
		return "adminLogin";
	}

	@RequestMapping(value = "/save", method = RequestMethod.GET)
	public String save(HttpServletRequest req, LoanApplicants lap, Model model) {
		String url=req.getRequestURI();
		String method=req.getMethod();
		if (checkValid(req,"save",method)) {
			ctrl.update(lap);
			List<LoanApplicants> lapp = ctrl.getAllApps();
			System.out.println("level" + lap);
			LoanApplicants las = ctrl.getLoan(lap.getLapp_id());
			if (lap.getLapp_status().equals("approved")) {
				ctrl.EMISchedule(las);
			}

			model.addAttribute("lapp", lapp);
			return "adminpage";
		}
		return "adminLogin";
	}

	@RequestMapping(value = "/downloadExcel", method = RequestMethod.GET)
	public void downloadExcel(@RequestParam String sel, HttpServletRequest req, HttpServletResponse response)
			throws IOException {
		String url=req.getRequestURI();
		String method=req.getMethod();
		if (checkValid(req,"downloadExcel",method)) {
			
			List<LoanApplicants> lapp = ctrl.selOption(sel);
			Workbook workbook = ExcelGenerator.generateExcel(lapp);

			// Set the response headers for Excel download
			response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
			response.setHeader("Content-Disposition", "attachment; filename=loan_applicants.xlsx");

			// Write the workbook to the response output stream
			workbook.write(response.getOutputStream());
			workbook.close();
		}
	}

	@RequestMapping(value = "/filter", method = RequestMethod.GET)
	public String filter(@RequestParam String sel, HttpServletRequest req, Model model) {
		String url=req.getRequestURI();
		String method=req.getMethod();
		if (checkValid(req,"filter",method)) {
			
			
			model.addAttribute("sel", sel);
			List<LoanApplicants> al = ctrl.selOption(sel);
			model.addAttribute("lapp", al);
			return "adminpage";
		}
		return "adminLogin";
	}
}
