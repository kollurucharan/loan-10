<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login Page</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            background-color: #f0f0f0;
            text-align: center;
            padding: 20px;
        }

        h1 {
            font-size: 24px;
            color: red; /* Change the color for the error message */
        }

        .login-container {
            max-width: 400px;
            margin: 0 auto;
            background-color: #ffffff;
            padding: 20px;
            border-radius: 5px;
            box-shadow: 0px 0px 10px rgba(0, 0, 0, 0.1);
        }

        form {
            text-align: left;
        }

        label {
            display: block;
            margin-bottom: 10px;
        }

        input[type="text"],
        input[type="password"] {
            width: 90%; /* Full width inside the .login-container */
            padding: 10px;
            margin-bottom: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
        }

        input[type="submit"] {
            background-color: #0077cc;
            color: #ffffff;
            padding: 10px 20px;
            border: none;
            border-radius: 3px;
            cursor: pointer;
        }

        input[type="submit"]:hover {
            background-color: #ff5500;
        }
    </style>
</head>
<body>
<div class="login-container">
<%String incorrect=(String)request.getAttribute("false");%>
<h1><%if(incorrect!=null){%>incorrect crediantials<%} %></h1>
    <h1>User Login</h1>
    <form action="startpage" method="get">
    
    	<input type="hidden" name="userType" value="customer">
    
        <label for="id">ID:</label>
        <input type="text" id="id" name="userName" required><br><br>
        
        <label for="password">Password:</label>
        <input type="password" id="passWord" name="passWord" required><br><br>
		
        <input type="submit" value="Submit">
    </form>
    </div> 
</body>
</html>
