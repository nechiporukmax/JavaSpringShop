<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp"%>

<div class="col-lg-8 col-sm-12">
    <div class="contact-form-right">
        <form:form method="post" modelAttribute="category" action="/addCategory" enctype="multipart/form-data" >
            <div class="row">

                <div class="col-md-12">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <form:input type="text" class="form-control" path="name" id="name" name="name"   required="required" />
                        <div class="help-block with-errors"></div>
                    </div>
                </div>                <div class="col-md-12">

            <div class="form-group">
                    <div class="row">
                        <c:if test="${not empty error}">
                            <div style="color: #ff0000;">${error}
                            </div>
                        </c:if>
                    </div>
                </div>
            </div>
                <div class="form-group">
                    <div class="row">
                        <div class="width50"><input class="btn btn-success" type="submit"   value="Submit" style="font-weight: bold"></div>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>
<%@include file="templates/footer.jsp"%>