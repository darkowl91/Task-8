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
            <ul class="nav">
                <li class="active">
                    <html:link href="EmployeeList.do" styleClass="brand">
                        <bean:message key="header.title"/>
                    </html:link>
                </li>
            </ul>
                
            <html:form action="EmployeeList.do" styleClass="navbar-form pull-right">
                <span class="help-inline ">
                    <bean:message key="header.size"/>
                </span>
                <html:text name="EmployeesForm" property="pageRequest.pageSize" styleClass="span2"/>
                <span class="help-inline ">
                    <bean:message key="header.page"/>
                </span>
                <html:text name="EmployeesForm" property="pageRequest.pageNumber" styleClass="span2"/>
                <span class="help-inline ">
                    <bean:message key="header.of"/>
                </span>
                <html:submit styleClass="btn">
                    <bean:message key="header.go"/>
                </html:submit>
            </html:form>            
        </div>
    </div>
</div>