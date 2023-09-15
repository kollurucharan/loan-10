<%@ page language="java" contentType="text/html; charset=ISO-8859-1" import="java.util.*,com.entities.*"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

    <style>
        /* Custom CSS */
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            padding: 20px;
        }

        h2 {
            color: #0077cc;
        }

        select {
            width: 150px;
            padding: 5px;
            border: 1px solid #ccc;
            border-radius: 5px;
        }

        table {
            width: 100%;
            border-collapse: collapse;
            margin-top: 20px;
        }

        th, td {
            padding: 10px;
            text-align: center;
        }

        th {
            background-color: #0077cc;
            color: #fff;
        }

        tr:nth-child(even) {
            background-color: #f2f2f2;
        }

        tr:hover {
            background-color: #e0e0e0;
        }

        input[type="submit"] {
            background-color: #0077cc;
            color: #fff;
            border: none;
            cursor: pointer;
            padding: 5px 10px;
        }

        a {
            display: inline-block;
            margin-top: 20px;
            background-color: #0077cc;
            color: #fff;
            padding: 10px 20px;
            text-decoration: none;
        }

        a:hover {
            background-color: #ff5500;
        }
    </style>
</head>
<body>
<%
	ArrayList<LoanApplicants> lapp=(ArrayList<LoanApplicants>)request.getAttribute("app");
    String selec=(String)request.getAttribute("sel");
%>
<center><h2>Customer Page</h2><br><br></center>
<table border=1>
<tr>

<th>customer id</th>

<th>applied date</th>
<th>loan type id</th>
<th>loan amount</th>
<th>emi range from</th>
<th>emi range to</th>
<th>emi months</th>
<th>cibil score</th>
<th>annual income</th>
<th>dispose income</th>
<th>status</th>
<th>conclusion remarks</th>
<th>EMI</th>
</tr>
<%
	for(LoanApplicants lp:lapp){
%>
<form action="schedule" method="get">
<tr>

<td><%=lp.getLapp_cust_id() %></td>

<td><%=lp.getLapp_date() %></td>
<td><%=lp.getLapp_ltype_id() %></td>
<td><%=lp.getLapp_amount() %></td>
<td><%=lp.getLapp_emirange_from() %></td>
<td><%=lp.getLapp_emirange_to() %></td>
<td><%=lp.getLapp_months_req() %></td>
<td><%=lp.getLapp_cibil_score() %></td>
<td><%=lp.getLapp_annual_income() %></td>
<td><%=lp.getLapp_dispos_income() %></td>
<td><%=lp.getLapp_status() %></td>
<td><%=lp.getLapp_conclusion_remarks() %></td>
<input type="hidden" name="lapp_id" value="<%=lp.getLapp_id()%>">
<td>
                <% if ("approved".equals(lp.getLapp_status())) { %>
                    <input type="submit" value="Schedule">
                <% } else { %>
                    <button disabled>EMI</button>
                <% } %>
            </td>
</tr>
</form>
<%} %>
</table>
<button onclick="download()">Downlaod Excel</button>

<script>
function download(){
	var x=document.getElementById("sel").value;
	console.log(x);
	window.location.href="downloadExcel?sel="+x;
}
</script>
</body>
</html>