<%-- 
    Document   : content
    Created on : Jan 7, 2013, 7:33:01 PM
    Author     : Owl
--%>
<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>
<%@ taglib uri="http://struts.apache.org/tags-nested" prefix="nested" %>
<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <table class="table table-fixed-header" >   
        <thead class="header">
            <tr >
                <th><bean:message key="content.text.firstname"/></th>
                <th><bean:message key="content.text.lastname"/></th>
                <th><bean:message key="content.text.address"/></th>
                <th><bean:message key="content.text.companyname"/></th>
                <th><bean:message key="content.text.city"/></th>
                <th><bean:message key="content.text.country"/></th>
                <th><bean:message key="content.text.count"/></th>
                <th><bean:message key="content.text.position"/></th>
            <tr/>
        </thead>
        <!--make the header fixed on scroll-->
        <script language="javascript" type="text/javascript" >
            $(document).ready(function(){
                $('.table-fixed-header').fixedHeader();
            });
        </script>
        <!---->
        <tbody>
            <c:forEach var="employee" items="${EmployeesForm.employees}">
                <c:set var="hight" value="${fn:length(employee.works)}"/>
                <tr>
                    <td rowspan="${hight + 1}" ><c:out value="${employee.firstName}"/></td>
                    <td rowspan="${hight + 1}" ><c:out value="${employee.lastName}"/></td>
                    <c:set var="address" value="${employee.address}"/>
                    <td rowspan="${hight + 1}"><c:out value="${address.city.country.title}, ${address.city.title}, ${address.building}-${address.room}"/></td>
                </tr>
                <c:forEach var="work" items="${employee.works}">
                    <tr>
                        <td><c:out value="${work.office.company.title}"/></td>
                        <td><c:out value="${work.office.address.city.title}"/></td>
                        <td><c:out value="${work.office.address.city.country.title}"/></td>
                        <td><c:out value="${work.office.countOfEmployees}"/></td>
                        <td><c:out value="${work.position.title}"/></td>
                    </tr>
                </c:forEach>
            </c:forEach>
        </tbody>
    </table>    
