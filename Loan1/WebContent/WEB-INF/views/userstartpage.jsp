<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<style>
/* styles.css */
body {
    font-family: Arial, sans-serif;
    background-color: #f0f0f0;
    text-align: center; /* Center align the content horizontally */
    padding-top: 20px; /* Add some top padding for vertical centering */
}
h1 {
    font-size: 36px; /* Adjust the font size as needed */
    color: "black";
    margin-bottom: 20px; /* Add margin below the <h1> element */
}

.button {
    display: inline-block;
    padding: 10px 20px;
    background-color: #0077cc;
    color: #ffffff;
    text-decoration: none;
    margin: 10px; /* Add some margin to separate the buttons */
    border-radius: 5px;
    transition: background-color 0.3s;
}

.button:hover {
    background-color: #ff5500;
}
#logout{
    position: fixed;     /* Fix the button position */
    top: 10px;           /* Distance from the top of the viewport */
    right: 10px;         /* Distance from the right of the viewport */
    padding: 10px 20px;  /* Button padding for better visibility */
    background-color: #007bff; /* Button background color */
    color: white;        /* Text color */
    border: none;        /* Remove button border */
    cursor: pointer;     /* Show pointer cursor on hover */
}
</style>
</head>
<body>

<h1>LRC LOANS</h1>
<form action="logout" method="get">
<input type="submit" id="logout" value="logout">
</form>
<center>
<a class="button" href="home">customer page</a><br><br>
<a  class="button" href="checkloan">check your luck</a><br><br>
<a  class="button" href="status">status</a>
</center>
</body>

</html>