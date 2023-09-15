<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
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
<center>
<h1>Admin Page</h1>
<a class="button" href="admin"> Loans</a><br><br>
</center>
</body>
</html>