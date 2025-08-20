<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Pahana Edu - Customer Registration</title>
    <link rel="stylesheet" type="text/css" href="style.css">
</head>
<body>

<div class="register-container">
    <h2>Customer Registration</h2>
    <form action="RegisterServlet" method="post">
       
        <label for="name">Full Name</label>
        <input type="text" id="name" name="name" placeholder="Enter full name" required>

 <label for="username"> Username</label>
        <input type="text" id="username" name="username" placeholder="Create username" required>
        
        <label for="address">Address</label>
        <input type="text" id="address" name="address" placeholder="Enter address" required>

        <label for="telephone">Telephone Number</label>
        <input type="tel" id="telephone" name="telephone" placeholder="Enter telephone number" required>

      <label for="email Address">E-mail </label>
        <input type="text" id="email" name="email" placeholder="Enter E-mail Address" required>
      
       

        <label for="password"> Password</label>
        <input type="password" id="password" name="password" placeholder="Create password" required>

        <input type="submit" value="Register">
    </form>
    <div class="login-link">
        Already registered? <a href="login.jsp">Login here</a>
    </div>
</div>

</body>
</html>
