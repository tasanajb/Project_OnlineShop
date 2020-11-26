<%-- 
    Document   : chackOut
    Created on : Nov 25, 2020, 6:22:41 PM
    Author     : tasanajb
--%>

<%@page import="java.util.Vector"%>
<%@page import="model.ShopcartTable"%>
<%@page import="java.util.Iterator"%>
<%@page import="model.Shopcart"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title></title>
    </head>
    <jsp:useBean id="sc" class="model.Shopcart" scope="request"/>
    <%  
        EntityManager em = (EntityManager) session.getAttribute("entitymanager");
        Vector<Shopcart> scList = ShopcartTable.findAllShopcart(em);
        Iterator<Shopcart> itr = scList.iterator();
    %>
     <center>
    <body>
        <%
                double price = 0;
                int qty = 0;
                while (itr.hasNext()) {
                    sc = itr.next();
                    qty = sc.getQuantity();
                    double p = sc.getPrice()*qty;
                    price += p;
                }
            %>
        <br/>
        <h1>Your Order is confirmed!</h1>
        <h1>The total amount is <% out.println(price);%></h1>
    </body>
</html>
