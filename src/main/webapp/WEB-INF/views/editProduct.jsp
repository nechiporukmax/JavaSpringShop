<%@ taglib prefix="th" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@include file="templates/header.jsp"%>
<%@include file="templates/header-slider.jsp"%>
<div class="col-lg-8 col-sm-12">
    <div class="contact-form-right">
        <form:form method="post"   modelAttribute="product" action="/editProduct" enctype="multipart/form-data" >
            <div class="row">
                <div class="col-md-12 hidden">
                    <div class="form-group">
                        <form:input type="hidden" class="form-control" path="id" id="id" name="id" placeholder="Name"  required="required" />
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="name">Name:</label>
                        <form:input type="text" class="form-control" path="name" id="name" name="name"   required="required" />
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="description">Description:</label>

                        <form:textarea type="text" class="form-control" path="description" id="description" name="description" required="required" />
                        <div class="help-block with-errors"></div>
                    </div>
                </div>

                <div class="col-md-12">
                    <div class="form-group">
                        <label for="manufacture">Manufacture:</label>

                        <form:input type="text" class="form-control" path="manufacture" id="manufacture" name="manufacture" required="required"  />
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="image">Image:</label>

                        <form:input type="file" class="form-control" path="image" id="image" name="image"   />
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label >Category:</label>

                        <form:select path="category.id" items="${categories}" itemValue="id" itemLabel="name" />
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="price">Price:</label>

                        <form:input type="decimal" class="form-control" path="price" id="price" name="price"  required="required" value=""  />
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <div class="col-md-12">
                    <div class="form-group">
                        <label for="discount">Discount:</label>

                        <form:input type="decimal" class="form-control" path="discount" id="discount" name="discount"  required="required" value=""  />
                        <div class="help-block with-errors"></div>
                    </div>
                </div>
                <div class="form-group">
                    <div class="row">
                        <div class="width50"><input class="btn btn-success" type="submit"   value="Submit" style="font-weight: bold"></div>
                        <div class="width50"><input class="btn btn-danger" type="reset" value="Reset" style="font-weight: bold"></div>
                    </div>
                </div>
            </div>
        </form:form>
    </div>
</div>
<%@include file="templates/instagramFeed.jsp"%>
<%@include file="templates/footer.jsp"%>