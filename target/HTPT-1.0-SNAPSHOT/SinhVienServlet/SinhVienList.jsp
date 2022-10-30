<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <title>Application</title>
    </head>
    <body>
    <center>
        <h1>SinhVien Management</h1>
        <h2>
            <a href="/HTPT/SinhVienServlet/new">Add New </a>
            &nbsp;&nbsp;&nbsp;
            <a href="/HTPT/SinhVienServlet/list">List All</a>

        </h2>
    </center>
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List</h2></caption>
            <tr>
                <th>Ma SV</th>
                <th>Ten</th>
                <th>Ngay Sinh</th>
                <th>Dia Chi</th>
                <th>Ten Khoa</th>
                <th>Ten CN</th>

            </tr>
            <c:forEach var="sinhVien" items="${listSinhVien}">
                <tr>
                    <td><c:out value="${sinhVien.maSV}" /></td>
                    <td><c:out value="${sinhVien.ten}" /></td>
                    <td><c:out value="${sinhVien.ngaySinh}" /></td>
                    <td><c:out value="${sinhVien.diaChi}" /></td>
                    <td><c:out value="${sinhVien.tenK}" /></td>
                    <td><c:out value="${sinhVien.tenCn}" /></td>
                    <td>
                        <a href="/HTPT/SinhVienServlet/edit?maSV=<c:out value='${sinhVien.maSV}' />">Edit</a>
                        &nbsp;&nbsp;&nbsp;&nbsp;
                        <a href="/HTPT/SinhVienServlet/delete?maSV=<c:out value='${sinhVien.maSV}' />">Delete</a>                     
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>   
</body>
</html>