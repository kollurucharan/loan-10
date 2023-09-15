<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="com.entities.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<%
	CustomerDetails cd=(CustomerDetails)request.getAttribute("cust");
LoanApplicants lapp=(LoanApplicants)request.getAttribute("app");
LoanNominee lnom=(LoanNominee)request.getAttribute("nom");
%>

<center><h2>your applying details</h2></center>
<h3>your personal details</h3>
<b>first name:</b>
<p><%=cd.getCust_fname() %></p>
<b>Last Name:</b>
<p><%=cd.getCust_lname() %></p>
<b>Date of Birth:</b>
<p><%=cd.getCust_dob() %></p>
<b>PAN Number:</b>
<p><%=cd.getCust_panno() %></p> 
<b>Mobile Number:</b>
<p><%=cd.getCust_mobile() %></p>
<b>Address:</b>
<p><%=cd.getCust_address() %></p>
 <b>Guardian Name:</b>
<p><%=cd.getCust_gaurd_name() %></p>

<br>

<h3>your loan details</h3>
<b>Application Date:</b>
<p><%=lapp.getLapp_date() %></p>
<b>Loan Amount:</b>
<p><%=lapp.getLapp_amount() %></p>
<b>EMI Range (From):</b>
<p><%=lapp.getLapp_emirange_from() %></p>
<b>EMI Range (To):</b>
<p><%=lapp.getLapp_emirange_to()%></p>
<b>No Of Months Required:</b>
<p><%=lapp.getLapp_months_req() %></p>
<b>CIBIL Score:</b>
<p><%=lapp.getLapp_cibil_score()%></p>
<b>ANNUAL Amount:</b>
<p><%=lapp.getLapp_annual_income() %></p>




<h3>your nominee details</h3>

<b>Nominee Name:</b>
<p><%=lnom.getLnom_name() %></p>
<b>Relation:</b>
<p><%=lnom.getLnom_relation() %></p>

<form action="submit" method="get"><input type="submit" value="Submit"></form>
 

</body>
</html>