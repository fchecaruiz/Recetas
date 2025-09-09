<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Insertar receta</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<div class="center-page">
  <div class="container">
    <h2>Insertar receta</h2>

    <c:if test="${not empty msg}">
      <div class="msg success"><c:out value="${msg}" /></div>
    </c:if>

    <form method="post" action="insertar">
      <label>Nombre:</label>
      <input type="text" name="nombre" required />
      <br/><br/>
      <label>Dificultad:</label>
      <select name="dificultad" required>
        <c:forEach var="d" items="${dificultades}">
          <option value="${d.id}"><c:out value="${d.dificultad}" /></option>
        </c:forEach>
      </select>
      <br/><br/>
      <button type="submit">Insertar</button>
    </form>

  </div>
</div>
</body>
</html>