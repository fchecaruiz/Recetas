<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>Mostrar recetas</title>
</head>
<body>
<%@ include file="/header.jsp" %>
<div class="center-page">
  <div class="container">
    <h2>Recetas</h2>

    <c:choose>
      <c:when test="${empty recetas}">
        <p>No hay recetas para mostrar.</p>
      </c:when>
      <c:otherwise>
        <div class="table-wrap">
          <table>
            <thead>
              <tr>
                <th>ID</th>
                <th>Nombre</th>
                <th>Dificultad</th>
              </tr>
            </thead>
            <tbody>
              <c:forEach var="receta" items="${recetas}">
                <tr>
                  <td><c:out value="${receta.id}" /></td>
                  <td><c:out value="${receta.nombre}" /></td>
                  <td><c:out value="${receta.dificultad}" /></td>
                </tr>
              </c:forEach>
            </tbody>
          </table>
        </div>
      </c:otherwise>
    </c:choose>

  </div>
</div>
</body>
</html>