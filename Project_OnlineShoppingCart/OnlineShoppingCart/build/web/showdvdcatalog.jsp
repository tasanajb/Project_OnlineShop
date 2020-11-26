<%-- 
    Document   : showdvdcatalog
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
        <title>Show DVD Catalog</title>
    </head>
    <jsp:useBean id="dvd" class="model.Dvd" scope="request"/>
    <%  
        EntityManager em = (EntityManager) session.getAttribute("entitymanager");
        Vector<Dvd> dvdList = DvdTable.findAllDvd(em);
        Iterator<Dvd> itr = dvdList.iterator();
    %>
    <body>
    <center>
        <h1>DVD Catalog</h1>
        <table border="1">
            <tr>
                <th>DVD Name</th>
                <th>Rate</th>
                <th>Year</th>
                <th>Price</th>
                <th>Add Cart</th>
            </tr>
            <tbody>
            <%
                while (itr.hasNext()) {
                    dvd = itr.next();
                    out.println("<td> " + dvd.getDvdname() + "</td>");
                    out.println("<td> " + dvd.getRate() + "</td>");
                    out.println("<td> " + dvd.getY() + "</td>");
                    out.println("<td> " + dvd.getPrice() + "</td>");
                    %>   
                    <td><a href="AddToCartController?name=<%=dvd.getDvdname()%>"><input type="submit" value="Add To Cart" /></a></td>
                    <%
                    out.println("<tr>");
                }
            %>
            </tbody>
        </table>
        <br/>
</body>
</html>

