<%-- 
    Document   : header
    Created on : Jan 7, 2013, 7:32:47 PM
    Author     : Owl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>

<div class="navbar navbar-inverse navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <html:link href="EmployeeList.do" styleClass="brand">
                <bean:message key="header.title"/>
            </html:link>
            <p class="text-success">
                <bean:message key="header.time"/>
                ${EmployeesForm.time}
                <bean:message key="header.time.ms"/>
            </p>
        </div>
    </div>
</div>