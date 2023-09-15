package com.services;

import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Dao.DaoImp;
import com.entities.CustomerDetails;
import com.entities.EMISchedule;
import com.entities.LoanApplicants;
import com.entities.LoanNominee;
import com.entities.LoginClass;
import com.entities.LoginTable;
import com.entities.SessionTable;
import com.entities.schedule;

@Service
public class ServiceClass {
	DaoImp serv;

	@Autowired
	public ServiceClass(DaoImp serv) {
		this.serv = serv;

	}

	CustomerDetails cdet;
	LoanApplicants lapp;
	LoanNominee lnom;

	public void storeObj(CustomerDetails cust, LoanApplicants lap, LoanNominee nom, SessionTable st) {
		cust.setLuuser(st.getUser_id());
		cdet = cust;
		lapp = lap;
		lnom = nom;
	}

	public void applyLoan() {
		serv.persist(cdet, lapp, lnom);
	}

	public List<LoanApplicants> getAllApps() {
		return serv.getAllLoanApplicants();
	}

	public LoanApplicants getLoan(int loanid) {
		return serv.getLoanApplicant(loanid);

	}

	public void update(LoanApplicants lap) {
		serv.updateApp(lap);

	}

	public List<LoanApplicants> selOption(String sel) {
		return serv.selOption(sel);

	}

	public SessionTable checkCredentials(LoginClass log, SessionTable st) {
		LoginTable ret = serv.checkCredentials(log);

		if (ret == null)
			return null;
		String has = "" + log.getPassWord().hashCode();
		// System.out.println(has);
		System.out.println(ret.getUser_pwd() + "table");
		if (ret.getUser_pwd().equals(has)) {
			SessionTable key = serv.createKey(ret, st);
			return key;
		}
		return null;
	}

	public boolean checkAccess(SessionTable x) {
		// System.out.println(x);
		if (x == null)
			return false;
		SessionTable y = serv.getKeybyId(x.getUssn_id());
		System.out.println(y.getUssn_user_type());
		if (y != null && x.getUssn_key() == y.getUssn_key() && x.getUssn_exptime().isAfter(LocalDateTime.now())
				&& y.getUssn_status().equals("active")) {
			// && y.getUssn_user_type().equals(x.getUssn_user_type())
			System.out.println("session key and database keys are same");
			return true;
		}
		return false;
	}

	public SessionTable logout(SessionTable x) {
		return serv.logout(x.getUssn_id());
	}

	public static List<EMISchedule> schedule(LoanApplicants lapp2) {
		// TODO Auto-generated method stub
		List<schedule> ls = new ArrayList<>();
		List<EMISchedule> es = new ArrayList<>();
		double from = lapp2.getLapp_emirange_from();
		double to = lapp2.getLapp_emirange_to();
		int tenure = lapp2.getLapp_months_req();
		double principal = lapp2.getLapp_amount();
		double annualAmount = lapp2.getLapp_annual_income();
		double rateOfInterest = 0;
		double EMI = 0;
		double dispose = 0;
		double total = 0;

		if (tenure <= 60) {
			rateOfInterest = 15;
		} else if (tenure >= 61 && tenure >= 120) {
			rateOfInterest = 18;
		} else if (tenure >= 121 && tenure >= 180) {
			rateOfInterest = 18;
		} else {
			rateOfInterest = 15;
		}
		System.out.println("roi:" + rateOfInterest);
		System.out.println("principal" + principal);
		System.out.println("tenure" + tenure);

		double monthlyInterestRate = (rateOfInterest / 12) / 100;
		System.out.println("months" + monthlyInterestRate);

		EMI = (principal * monthlyInterestRate * Math.pow(1 + monthlyInterestRate, tenure))
				/ (Math.pow(1 + monthlyInterestRate, tenure) - 1);
		dispose = (annualAmount * 30) / 100;
		System.out.println(dispose + "dispose");
		total = tenure * EMI;

		DecimalFormat decimalFormat = new DecimalFormat("#.##");
		EMI = Double.parseDouble(decimalFormat.format(EMI));
		dispose = Double.parseDouble(decimalFormat.format(dispose));
		total = Double.parseDouble(decimalFormat.format(total));

		System.out.println(EMI + "emi");
		ls.add(new schedule(1, tenure, EMI, rateOfInterest, total));
		System.out.println("total" + ls);

		LocalDate currentDate = LocalDate.now();
		
		for (int i = 1; i <= tenure; i++) {
			LocalDate firstDayOfNextMonth = currentDate.plusMonths(i).withDayOfMonth(1);
			String dateAsString = firstDayOfNextMonth.toString();
			double rAmount = (EMI * i);
			System.out.println("mohan"+lapp2.getLapp_id());
			es.add(new EMISchedule(dateAsString, EMI, rAmount,lapp2.getLapp_id()));
		}

		return es;
	}

	public List<LoanApplicants> getApps(int id) {

		return serv.getLoanApplicants(id);
	}

	@Transactional
	public void EMISchedule(LoanApplicants lap) {
		// TODO Auto-generated method stub
		List<EMISchedule> ls = schedule(lap);
		
			System.out.println("**********"+ls);
		
		
		serv.EMISchedule(ls);
	}

	

	public List<com.entities.EMISchedule> EMITable(LoanApplicants lap) {
		// TODO Auto-generated method stub
		return serv.EMITable(lap);
	}

	public boolean findId(int user_id, String url, String method) {
		// TODO Auto-generated method stub
		
		
		return serv.findId(user_id,url,method);
	}
}
