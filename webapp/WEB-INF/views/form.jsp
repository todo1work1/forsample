<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
    <head>
        <title>User form</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h3 id="form_header" class="text-warning" align="center">New Employee Form</h3>
            <div> </div>
     
            <!-- User input form to add a new user or update the existing user-->
            
            <form:form id="employee_form" modelAttribute="empAttr" method="POST" action="save">
                <form:hidden path="id" />
                <label for="emp_fname">Enter First Name: </label>
                <form:input id="emp_fname" cssClass="form-control" path="firstName" />
                <div> </div>
 				<label for="emp_lname">Enter Lirst Name: </label>
                <form:input id="emp_lname" cssClass="form-control" path="lastName" />
                <div> </div>
                <label for="emp_cname">Enter Company Name: </label>
                <form:input id="emp_cname" cssClass="form-control" path="companyName" />
                <div> </div>
                <button id="saveBtn" type="submit" class="btn btn-primary">Save</button>
            </form:form>
        </div>
    </body>
</html>