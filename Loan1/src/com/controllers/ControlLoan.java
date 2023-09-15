package com.controllers;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.entities.CustomerDetails;
import com.entities.EMISchedule;
import com.entities.LoanApplicants;
import com.entities.LoanNominee;
import com.entities.LoginClass;
import com.entities.SessionTable;
import com.entities.schedule;
import com.services.ServiceClass;

@Controller
public class ControlLoan {
	ServiceClass ctrl;

	@Autowired
	public ControlLoan(ServiceClass ctrl) {
		this.ctrl = ctrl;
	}

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String login(Model model) {
		return "login";
	}

	@RequestMapping(value = "/userLogin", method = RequestMethod.GET)
	public String userLogin(Model model) {
		// System.out.println("rj123".hashCode());
		return "userLogin";
	}

	@RequestMapping(value = "/startpage", method = RequestMethod.GET)
	public String userStartPage(LoginClass log, SessionTable st, HttpServletRequest hsq, Model model) {
		// System.out.println(log.getUserType());
		SessionTable b = ctrl.checkCredentials(log, st);
		if (b == null) {
			model.addAttribute("false", "incorrect crediatials");
			return "userLogin";
		} else {
			HttpSession session = hsq.getSession();
			session.setAttribute("key", b);
			// System.out.println(b + " key");
			return "userstartpage";
		}
	}

	public boolean checkValid(HttpServletRequest request, String type) {
		HttpSession session = request.getSession();
		SessionTable x = (SessionTable) session.getAttribute("key");
		// System.out.println(x.getUssn_user_type() + " checking");
		if (x.getUssn_user_type().equals(type))
			return ctrl.checkAccess(x);
		else
			return false;
	}

	@RequestMapping(value = "/home", method = RequestMethod.GET)
	public String customerApplication(HttpServletRequest req, Model model) {
		if (checkValid(req, "customer"))
			return "customerApplication";
		else
			return "userLogin";
	}

	@RequestMapping(value = "/customer", method = RequestMethod.GET)
	public String applicationPreview(CustomerDetails customerdetails, LoanNominee nominee,
			LoanApplicants loanApplicants, HttpServletRequest req, Model model) {
		if (checkValid(req, "customer")) {
			HttpSession session = req.getSession();
			SessionTable sessionTable = (SessionTable) session.getAttribute("key");
			ctrl.storeObj(customerdetails, loanApplicants, nominee, sessionTable);
			model.addAttribute("nom", nominee);
			model.addAttribute("cust", customerdetails);
			model.addAttribute("app", loanApplicants);

			return "applicationPreview";
		}
		return "userLogin";
	}

	@RequestMapping(value = "/submit", method = RequestMethod.GET)
	public String ttt(HttpServletRequest req, Model model) {
		if (checkValid(req, "customer")) {
			ctrl.applyLoan();
			return "userstartpage";
		}
		return "userLogin";
	}

	@RequestMapping(value = "/backtouserpage", method = RequestMethod.GET)
	public String backToUserStartPage(HttpServletRequest req, Model model) {
		if (checkValid(req, "customer")) {
			return "userstartpage";
		}
		return "userLogin";
	}

	@RequestMapping(value = "/checkloan", method = RequestMethod.GET)
	public String check(HttpServletRequest req, Model model) {
		if (checkValid(req, "customer")) {
			return "checkloan";
		}
		return "userLogin";
	}

	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logout(HttpServletRequest req, Model model) {
		HttpSession session = req.getSession();
		SessionTable x = (SessionTable) session.getAttribute("key");
		session.setAttribute("key", ctrl.logout(x));
		return "userLogin";
	}

	@RequestMapping(value = "/status", method = RequestMethod.GET)
	public String status(HttpServletRequest request, Model model) {
		if (checkValid(request, "customer")) {
			HttpSession session = request.getSession();
			SessionTable x = (SessionTable) session.getAttribute("key");
			List<LoanApplicants> lapp = ctrl.getApps(x.getUser_id());
			model.addAttribute("app", lapp);
			return "status";
		} else
			return "userLogin";
	}

	@RequestMapping(value = "/schedule", method = RequestMethod.GET)
	public String schedule(HttpServletRequest request, LoanApplicants lap, Model model) {
		if (checkValid(request, "customer")) {
			List<EMISchedule> les=ctrl.EMITable(lap);
			System.out.println("tableee"+les);
			model.addAttribute("schedule", les);
			return "schedule";
		} else
			return "userLogin";
	}
}
