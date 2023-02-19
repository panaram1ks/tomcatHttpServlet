<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <%@ include file="head.jsp" %>
    <div>
        <span>Content. Русский</span>
        <p>Size: ${requestScope.flights.size()}</p>
        <p>Id: ${requestScope.flights.get(0).id}</p>
        <p>Id null save: ${requestScope.flights[1].id}</p>
        <p>Id null save session scope: ${not empty sessionScope.flightsMap}</p>
        <p>JSESSIONID: ${cookie["JSESSIONID"].value}, unique identifier</p>
        <p>Header: ${header["Cookie"]}</p>
        <p>Param id: ${param.id}</p>
        <p>Param test: ${param.test}</p>

    </div>
    <%@include file="footer.jsp" %>
</body>
</html>
