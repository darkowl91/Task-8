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
<%@ taglib uri="/WEB-INF/tlds/paging-tag.tld" prefix="pg" %>

<div class="navbar navbar-fixed-top">
    <div class="navbar-inner">
        <div class="container-fluid">
            <ul class="nav">
                <li class="active">
                    <html:link href="EmployeeList.do" styleClass="brand">
                        <bean:message key="header.title"/>
                    </html:link>
                </li>
            </ul>
            <pg:Paging-form pageNumber="${EmployeesForm.pageNumber}"
                            pageSize="${EmployeesForm.pageSize}" 
                            totalPages="${EmployeesForm.totalPages}"
                            totalItems="${EmployeesForm.totalItems}"
                            action="EmployeeList.do"/>
        </div>
    </div>
</div>