<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<header>
    <div><strong>Pahana Edu</strong></div>
    <nav>
        <a href="dashboard.jsp">Dashboard</a>
        <a href="customers.jsp">Customers</a>
        <a href="invoices.jsp">Invoices</a>
        <a href="payments.jsp">Payments</a>
        <a href="settings.jsp">Settings</a>
        <a href="logout.jsp">Logout</a>
    </nav>
</header>

<style>
    header {
        background: #1a1a1a;
        color: white;
        padding: 15px 30px;
        display: flex;
        justify-content: space-between;
        align-items: center;
    }
    nav a {
        color: white;
        margin: 0 10px;
        text-decoration: none;
        font-weight: bold;
    }
    nav a:hover {
        text-decoration: underline;
    }
</style>
