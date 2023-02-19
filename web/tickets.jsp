<%@ page import="com.parom.dto.TicketDTO" %>
<%@ page import="java.util.List" %>
<%@ page import="com.parom.service.TicketService" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<%--<%@ taglib prefix="c" uri="http://mycompany.com" %>--%>
<%@ include file="index.html" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Купленные билеты</h1>
<ul>
    <%
        Long flightId = Long.valueOf(request.getParameter("flightId"));
        List<TicketDTO> allByFlightId = TicketService.getInstance().findAllByFlightId(flightId);
        for(TicketDTO ticketDTO : allByFlightId){
            out.write(String.format("<li>%s</li>", ticketDTO.getGetPassengerName()));
        }
    %>

</ul>

</body>
</html>

<%!
    public void jspInit(){
        System.out.println("Hello form Declaration!");
    }
%>
