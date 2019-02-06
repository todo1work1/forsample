<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<html>
    <head>
        <title>Welcome</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css">
    </head>
    <body>
        <div class="container">
            <h2 id="article_header" class="text-warning" align="center">Employee List Example</h2>
            <div> </div>
             
            <!-- Div to add a new user to the mongo database -->
            <div id="add_new_user">
                    <a id="add" href="add" class="btn btn-success">Add Employee</a>
            </div>
            <div> </div>
             
            <!-- Table to display the user list from the mongo database -->
            <table id="users_table" class="table">
                <thead>
                    <tr align="center">
                        <th>Id</th>
                        <th>First Name</th>
                        <th>Last Name</th>
                        <th>Company Name</th>
                        
                    </tr>
                </thead>
                <tbody>
                    <c:forEach items="${employeeList}" var="employee">
                        <tr align="center">
                            <td><c:out value="${employee.id}" /></td>
                            <td><c:out value="${employee.firstName}" /></td>
                            <td><c:out value="${employee.lastName}" /></td>
                            <td><c:out value="${employee.companyName}" /></td>
                            <td>
                                <a id="update" href="/employee/edit?id=${employee.id}" class="btn btn-warning">Update</a>
                            </td>
                            <td>
                                <a id="delete" href="/employee/delete?id=${employee.id}" class="btn btn-danger">Delete</a>
                            </td>
                        </tr>
                    </c:forEach>
                </tbody>
            </table>
        </div>        
    </body>
</html>
