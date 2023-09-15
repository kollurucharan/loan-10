<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Loan Calculator</title>
<style>
/* General styles */
body {
	font-family: Arial, sans-serif;
	background-color: #f0f0f0;
	text-align: center;
	padding: 20px;
}

h1 {
	color: #0077cc;
}

label {
	font-weight: bold;
}

table {
	margin: 20px auto;
	border-collapse: collapse;
	width: 80%;
}

th, td {
	padding: 10px;
	border: 1px solid #ccc;
}

th {
	background-color: #0077cc; /* Updated background color */
	color: #fff;
}

.error {
	color: red;
}

button {
	background-color: #0077cc;
	color: #fff;
	border: none;
	padding: 10px 20px;
	cursor: pointer;
}

button:hover {
	background-color: #ff5500;
}

a {
	display: block;
	margin-top: 20px;
	background-color: #0077cc;
	color: #fff;
	padding: 10px 20px;
	text-decoration: none;
}

a:hover {
	background-color: #ff5500;
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
	<h1>Loan Calculator</h1>
	<label for="loanAmount">Loan Amount:</label>
	<input type="number" id="loanAmount" name="loanAmount" required>
	<br>
	<br>

	<table border="1">
		<h3>Rate of Interst</h3>
		<tr>
			<th>1-5 Years</th>
			<th>6-10 Years</th>
			<th>11-15 Years</th>
			<th>16-20 Years</th>
		</tr>
		<tr>
			<td>15%</td>
			<td>18%</td>
			<td>22%</td>
			<td>25%</td>
		</tr>
	</table>
	<br>
	<br>
	<label for="emiMonths">EMI Months:</label>
	<input type="number" id="emiMonths" name="emiMonths" required>
	<p id="emiMonthsError" class="error"></p>
	<br>
	<br>

	<label for="annualSalary">Annual Salary:</label>
	<input type="number" id="annualSalary" name="annualSalary" required>
	<br>
	<br>
	<button id="validateButton">Validate Months</button>
	<a href="backtouserpage">back to start page</a>
	<script>
        const emiMonthsInput = document.getElementById("emiMonths");
        const emiMonthsError = document.getElementById("emiMonthsError");
    

        emiMonthsInput.addEventListener("input", function () {
            const emiMonths = emiMonthsInput.value;

            if (emiMonths === "" || isNaN(emiMonths) || parseInt(emiMonths) >= 240) {
                emiMonthsError.textContent = "Please enter a valid number of months less than 240.";
            } else {
                emiMonthsError.textContent = ""; // Clear any previous error message
            }
        });
        document.getElementById("validateButton").addEventListener("click", function () {
        	var LoanAmount = parseInt(document.getElementById("loanAmount").value);
        	var salary = parseInt(document.getElementById("annualSalary").value);
        	var months = parseInt(document.getElementById("emiMonths").value);

            var roi=0.0;
        	console.log(LoanAmount);
        	console.log(salary);
        			console.log("months"+months);
        	
        	var dispo=((salary/12)*30)/(100);
        	console.log("dispo"+dispo);
        	
        	if(months>0 && months<=5)
        		{
        		roi=15;
        		}
        	else if(months>=6 && months<=10)
        		{
        		roi=18;
        		}
        	else if(months>=11 && months<=15)
        		{
        		roi=22;
        		}
        	else if(months>=16 && months<=20)
        		{
        		roi=25;
        		}
        	console.log(roi);
        	
        	var total=LoanAmount+(LoanAmount*roi*(months/12))/100;
			var emi=total/months;
        	if(emi<dispo)
        		{
        		alert("Eligible");
        		}
        	else
        		{
        		alert(" not Eligible");
        		}
        });
    </script>
</body>
</html>