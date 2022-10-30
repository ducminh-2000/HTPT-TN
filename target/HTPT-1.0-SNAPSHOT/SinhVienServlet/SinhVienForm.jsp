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
        <c:if test="${sinhVien != null}">
            <form action="update" method="post">
            </c:if>
            <c:if test="${sinhVien == null}">
                <form action="insert" method="post">
                </c:if>
                <table border="1" cellpadding="5">
                    <caption>
                        <h2>
                            <c:if test="${sinhVien != null}">
                                Edit
                            </c:if>
                            <c:if test="${sinhVien == null}">
                                Add New 
                            </c:if>
                        </h2>
                    </caption>

                    <tr>
                        <th>Ma SV:</th>
                        <td>
                            <c:if test="${sinhVien != null}">
                                <input type="text" readonly="true" name="maSV" value="<c:out value='${sinhVien.maSV}' />" />
                            </c:if> 
                            <c:if test="${sinhVien == null}">
                                <input type="text"  name="maSV" value="<c:out value='${sinhVien.maSV}' />" />
                            </c:if> 
                        </td>
                       
                    </tr>
                    <tr>
                         <th>Ten: </th>
                        <td>
                            <input type="text" name="ten" size="45"
                                   value="<c:out value='${sinhVien.ten}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Ngay Sinh: </th>
                        <td>
                            <input type="date" name="ngaySinh" size="45"
                                   value="<c:out value='${sinhVien.ngaySinh}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Dia Chi: </th>
                        <td>
                            <input type="text" name="diaChi" size="5"
                                   value="<c:out value='${sinhVien.diaChi}' />"
                                   />
                        </td>
                    </tr>
                    <tr>
                        <th>Khoa: </th>
                        <td>
                            <select id="khoa" name="khoa">

                                <c:forEach var="khoa" items="${listKhoa}">
                                    <c:if test="${sinhVien.maK == khoa.ma}">
                                        <option value="<c:out value='${khoa.ma}' />" selected="">${khoa.ten}</option>
                                    </c:if> 
                                    <c:if test="${sinhVien.maK != khoa.ma}"> 
                                        <option value="<c:out value='${khoa.ma}' />">${khoa.ten}</option> </c:if> 
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <th>Chi Nhanh: </th>
                        <td>
                            <select id="cn" name="cn">
                                <c:forEach var="cn" items="${listCn}">
                                    <c:if test="${sinhVien.maCn == cn.ma}">
                                        <option value="<c:out value='${cn.ma}' />" selected="">${cn.ten}</option>

                                    </c:if> 
                                    <c:if test="${sinhVien.maCn != cn.ma}">
                                        <option value="<c:out value='${cn.ma}' />">${cn.ten}</option>
                                    </c:if>
                                </c:forEach>
                            </select>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="2" align="center">
                            <input type="submit" value="Save" />
                        </td>
                    </tr>
                </table>
            </form>
    </div>   
</body>
</html>