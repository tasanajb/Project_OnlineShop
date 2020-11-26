<%-- 
    Document   : showShoppingCart
    Created on : Nov 24, 2020, 8:59:08 PM
    Author     : tasanajb
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.DvdTable"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Dvd"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Shopping Cart</title>
    </head
    <body>
    <center>
        <jsp:include page="showdvdcatalog.jsp" flush="true" />
        <br/>
        <jsp:include page="showCart.jsp" flush="true" />
</body>
</html>

