<%@ page language="java" contentType="text/html; charset=UTF-8" import="java.util.List" import="com.entities.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>EMI Schedule</title>

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
<h1>EMI Schedule</h1>
<% List<schedule> ls = (List<schedule>) request.getAttribute("schedule"); %>
<table border="1">
<tr>
    <th>No Of Months</th>
    <th>EMI Per Month</th>
    <th>Rate Of Interest</th>
    <th>Total</th>
    <th>Schedule</th>
</tr>
<% for (schedule item : ls) { %>
<form action="emiDates" method="get">
<tr>
    <td><%= item.getMonths()%></td>
    <td><%= item.getEmiPerMonth() %></td>
    <td><%= item.getRateOfInterest() %></td>
    <td><%= item.getTotal() %></td>
   
    <td>  <input type="submit" value="Schedule"> </td>
</tr>
</form>
<% } %>
</table>
</body>
</html>