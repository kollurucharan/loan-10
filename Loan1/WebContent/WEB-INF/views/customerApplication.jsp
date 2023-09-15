<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Loan Management</title>

<style>
/* General page styles */
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	text-align: center;
	padding: 20px;
	margin-top:50px;
}

/* Styles for the tabs */
#tabs {
	text-align: center;
	background-color: #0077cc; /* Blue background color for the buttons */
	padding: 10px; /* Add some padding for spacing */
}

.tab {
	display: none;
}

.activeTab {
	display: block;
}

/* Center align content within the tabs */
.center-content {
	text-align: center;
}

/* Style the labels */
label {
	display: block;
	margin-top: 10px;
}

/* Style the submit button */
input[type="submit"] {
	background-color: #0077cc;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
}

input[type="submit"]:hover {
	background-color: #ff5500;
}

/* Style the heading */
h2 {
	font-size: 24px;
	color: #0077cc;
}
/* Style the tabs */
.tab {
	display: none;
}

.activeTab {
	display: block;
}

#logout {
	position: fixed; /* Fix the button position */
	top: 10px; /* Distance from the top of the viewport */
	right: 10px; /* Distance from the right of the viewport */
	padding: 10px 20px; /* Button padding for better visibility */
	background-color: #007bff; /* Button background color */
	color: white; /* Text color */
	border: none; /* Remove button border */
	cursor: pointer; /* Show pointer cursor on hover */
}
</style>




</head>
<body>
	<form action="logout" method="get">
		<input type="submit" id="logout" value="logout">
	</form>
	<div id="tabs">
		<button class="tablink" onclick="openTab(event, 'customerTab')">Customer
			Registration</button>
		<button class="tablink" onclick="openTab(event, 'loanApplicationTab')">Loan
			Application</button>
		<button class="tablink" onclick="openTab(event, 'loanNomineeTab')">Loan
			Nominee</button>
	</div>
	<form action="customer" method="get">
		<div id="customerTab" class="tab activeTab">
			<center>
				<h2>Customer Registration Form</h2>
			</center>
			<center>
				<b> First Name:</b> <input type="text" id="cust_fname"
					name="cust_fname" required><br>
				<br> <b>Last Name:</b> <input type="text" id="cust_lname"
					name="cust_lname" required><br>
				<br> <b>Date of Birth:</b> <input type="date" id="cust_dob"
					name="cust_dob" required><br>
				<br> <b>PAN Number:</b> <input type="text" id="cust_panno"
					name="cust_panno" maxlength="10" required><br>
				<br> <b>Mobile Number:</b> <input type="text" id="cust_mobile"
					name="cust_mobile" pattern="\d{10}" required><br>
				<br> <b>Address:</b>
				<textarea id="cust_address" name="cust_address" rows="4" cols="50"
					required></textarea>
				<br>
				<br> <b>Guardian Name:</b> <input type="text" id="cust_gname"
					name="cust_gaurd_name" required><br>
				<br>

			</center>

			<!-- Include the content of your "Customer Registration" JSP page here -->
		</div>

		<div id="loanApplicationTab" class="tab">
			<center>
				<h2>Loan Application Form</h2>
			</center>
			<center>
				<b>Application Date:</b> <input type="date" id="la_date"
					name="lapp_date" required><br>
				<br> <b>Loan Type :</b> <select id="select"
					name="lapp_ltype_id"><option>--</option>
					<option value="1">personal loan</option></select><br>
				<br> <b>Loan Amount:</b> <input type="text" id="la_amount"
					name="lapp_amount" required><br>
				<br> <b>EMI Range (From):</b> <input type="text"
					id="la_emirange_from" name="lapp_emirange_from" required><br>
				<br> <b>EMI Range (To):</b> <input type="text"
					id="la_emirange_to" name="lapp_emirange_to" required><br>
				<br> <b>No Of Months Required:</b> <input type="text"
					id="la_nom_req" name="lapp_months_req" required><br>
				<br> <b>CIBIL Score:</b> <input type="text" id="la_cibil_score"
					name="lapp_cibil_score" required><br>
				<br> <b>ANNUAL Amount:</b> <input type="text"
					id="lapp_annual_income" name="lapp_annual_income" required><br>
				<br>

			</center>
			<!-- Include the content of your "Loan Application" JSP page here -->
		</div>

		<div id="loanNomineeTab" class="tab">
			<center>
				<h2>Loan Nominee Information</h2>
			</center>
			<center>
				<b>Nominee Name:</b> <input type="text" id="ln_nominee"
					name="lnom_name" required><br>
				<br> <b>Relation:</b> <input type="text" id="ln_relation"
					name="lnom_relation" required><br>
				<br> <input type="submit" value="Submit">
				<!-- Include the content of your "Loan Nominee Information" JSP page here -->
			</center>
		</div>


	</form>
	<script>
		// Function to open a tab
		function openTab(evt, tabName) {
			var i, tabcontent, tablinks;
			tabcontent = document.getElementsByClassName("tab");
			for (i = 0; i < tabcontent.length; i++) {
				tabcontent[i].className = "tab"; // Hide all tabs
			}
			document.getElementById(tabName).className = "tab activeTab"; // Show the selected tab
		}
	</script>
</body>
</html>