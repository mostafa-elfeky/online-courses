
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<html>
<body>
	<h1>Error Page</h1>
	<p>Application has encountered an error. Please contact support on...</p>

	<ul>
	<c:forEach var="error" items="${errors}">
		<li><c:forEach var="code" items="${error.codes}"> ${code} </c:forEach> : ${error.defaultMessage}</li>
	</c:forEach>
	</ul>
	<!--
    Failed URL: ${url}
    Exception:  ${exception.message}
        <c:forEach items="${exception.stackTrace}" var="ste">    ${ste} 
    </c:forEach>
  -->
</body>
</html>
