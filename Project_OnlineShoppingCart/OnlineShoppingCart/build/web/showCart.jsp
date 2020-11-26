<%-- 
    Document   : showCart
    Created on : Nov 24, 2020, 8:59:08 PM
    Author     : tasanajb
--%>

<%@page import="model.ShopcartTable"%>
<%@page import="model.Shopcart"%>
<%@page import="java.util.Vector"%>
<%@page import="java.util.Iterator"%>
<%@page import="javax.persistence.EntityManager"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Show Cart</title>
    </head>
    <jsp:useBean id="sc" class="model.Shopcart" scope="request"/>
    <%  
        EntityManager em = (EntityManager) session.getAttribute("entitymanager");
        Vector<Shopcart> scList = ShopcartTable.findAllShopcart(em);
        Iterator<Shopcart> itr = scList.iterator();
    %>
    <body>
    <center>
        <h1>Shopping Cart</h1>
        <table border="1">
            <tr>
                <th>DVD Name</th>
                <th>Rate</th>
                <th>Year</th>
                <th>Price</th>
                <th>Quantity</th>
                <th>Remove</th>
            </tr>
            <%
                while (itr.hasNext()) {
                    sc = itr.next();
                    out.println("<tr>");
                    out.println("<td> " + sc.getDvdname() + "</td>");
                    out.println("<td> " + sc.getRate() + "</td>");
                    out.println("<td> " + sc.getY() + "</td>");
                    out.println("<td> " + sc.getPrice() + "</td>");
                    out.println("<td> " + sc.getQuantity() + "</td>");
                     %>
                    <td>
                        <a href="RemoveDvdToCartController?name=<%=sc.getDvdname()%>"><input type="submit" value="Remove" /></a></td>
                    <%
                    out.println("<tr>");
                }
            %>
        </table>
        <br/>
        <a href="chackOut.jsp"><input type="submit" value="Check Out" /></a>
</body>
</html>

