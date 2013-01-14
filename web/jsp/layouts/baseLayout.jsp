<%-- 
    Document   : baseLayout
    Created on : Jan 7, 2013, 7:31:00 PM
    Author     : Owl
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="/WEB-INF/struts-tiles.tld" prefix="tiles" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
        <title>Employees</title>
        <!-- STYLES -->
        <link rel="stylesheet" type="text/css" href="css/bootstrap.css"/>
        <link rel="stylesheet" type="text/css" href="css/table-fixed-header.css"/>
        <!-- CSS and JS for table fixed header -->
        <script src="js/jquery-1.7.2.min.js"></script>
        <link rel="css/stylesheet" href="table-fixed-header.css">
        <script src="js/table-fixed-header.js"></script>
    </head>
    <body>
        <tiles:insert attribute="header"/>
        <div class="container">
            <div class="hero-unit">
                    <tiles:insert attribute="content"/>
                </div>
            </div>
        <tiles:insert attribute="footer"/>
    </body>
</html>
