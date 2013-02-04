<%-- 
    Document   : footer
    Created on : Jan 7, 2013, 7:32:36 PM
    Author     : Owl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="/WEB-INF/struts-bean.tld" prefix="bean" %>
<%@ taglib uri="/WEB-INF/struts-html.tld" prefix="html" %>
<%@ taglib uri="/WEB-INF/struts-logic.tld" prefix="logic" %>
<%@taglib uri="/WEB-INF/struts-nested.tld" prefix="nested" %>

<div class="navbar navbar-inverse navbar-fixed-bottom">
    <div class="navbar-inner">
        <div class="container-fluid">
            <html:form action="/EmployeeList" styleClass="navbar-form pull-right">
                <html:hidden property="method" value="EmployeeList.do" />
                <span class="help-inline">
                    <bean:message key="header.size"/>
                </span>
                <nested:text name="EmployeesForm" property="pageSize" styleClass="span2"/>
                <span class="help-inline">
                    <nested:message key="header.page"/>
                </span>
                <nested:text name="EmployeesForm" property="pageNumber" styleClass="span2"/>
                <span class="help-inline">
                    <bean:message key="header.of"/>
                    ${EmployeesForm.totalPages}
                </span>
                <input type="submit" value="GO!" class="btn" />
            </html:form>
            <footer>
                <p>&copy; <bean:message key="footer.company.text"/></p>
            </footer>
        </div>
    </div>
</div>