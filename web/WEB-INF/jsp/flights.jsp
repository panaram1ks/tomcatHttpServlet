<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1>Купленные билеты</h1>
    <c:if test="${not empty requestScope.flights}">
        <ul>
            <c:forEach var="flight" items="${requestScope.flights}">
                <li><a href="${pageContext.request.contextPath}/flights?flightId=${flight.id}">${flight.description}</a></li>
            </c:forEach>
        </ul>
    </c:if>

</body>
</html>
