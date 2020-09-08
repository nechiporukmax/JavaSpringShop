<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp"%>
<div class="container">
    <div class="row">
        <div class="col mt-4 mb-4">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                Check product list	                <h2>
                                 Welcome: ${pageContext.request.userPrincipal.name} |
                <a href="<c:url value="/j_spring_security_logout" />">Logout</a>
            </h2>
            </c:if>
            <p>
                Check product list
            </p>


            <ul>
                <li>
                    <a href="<c:url value="/admin/productInventory/" />">Show Product List</a>
                </li>
                <li>
                    <a href="<spring:url value="/addProduct" />" >Add Product</a>

                </li>
            </ul>
        </div>
    </div>
</div>

<%@include file="templates/footer.jsp"%>