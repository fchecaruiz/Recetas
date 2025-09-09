<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
    String uri = request.getRequestURI();
%>
<c:url var="css" value="/css/styles.css" />
<c:url var="urlInsertar" value="/insertar" />
<c:url var="urlMostrar" value="/mostrar" />

<link rel="stylesheet" href="/Recetas/css/styles.css" />

<div class="topmenu">
    <span class="brand">Recetas</span>
    <a href="${urlInsertar}" class="<%= uri.endsWith("/insertar") ? "active" : "" %>">Insertar</a>
    <a href="${urlMostrar}" class="<%= uri.endsWith("/mostrar") ? "active" : "" %>">Mostrar</a>
</div>