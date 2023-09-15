<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
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

</style>
    <title>Button Event Example</title>
</head>
<body>
<center>
<h1>Select Your Login</h1>
    <button class="button" id="userLoginButton">User Login</button><br><br>
    <button class="button" id="adminButton">Admin Login</button>

</center>
    <script>
        // Function to handle the click event for the User Login button
        document.getElementById("userLoginButton").addEventListener("click", function () {
           window.location.href="userLogin";
            // You can add your login logic here
        });

        // Function to handle the click event for the Password button
        document.getElementById("adminButton").addEventListener("click", function () {
        	 window.location.href="adminLogin";
            // You can add your password logic here
        });
    </script>
</body>
</html>
