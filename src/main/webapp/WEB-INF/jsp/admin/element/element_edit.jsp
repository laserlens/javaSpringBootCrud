<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav.jsp"%>

<script>
    $(document).ready(function(){
       //listen for remove button click and clear that field then update
        $('.removeButton').click(function(){
            $('#' + this.name).val('');
            $('#elementType').submit();
        });


    });
</script>

<div class="container">
    <div class="col-xs-12 col-md-8 col-lg-6 col-md-offset-2 col-lg-offset-3 well">

        <c:set var="idx" value="0" scope="page"/>

        <form:form cssClass="form-horizontal" modelAttribute="elementType" action="/admin/element/update" method="post" >

            <form:hidden path="id"/>
            <form:hidden path="version"/>

            <fieldset>
                <Legend>Element Update</Legend>

                <div class="row">
                    <div class="form-group">
                        <label for="inputElementTypeName"  class="col-sm-3 control-label">Element Type:</label>
                        <div class="col-sm-8">
                            <form:input path="elementTypeName" class="form-control" id="inputElementTypeName"/>
                        </div>
                     </div>
                </div>

                <div class="row">
                    <div class="col-sm-10">
                        <hr>
                    </div>
                </div>

                <c:forEach items="${elementType.elementList}" var="element">
                    <form:hidden path="elementList[${idx}].id"/>
                    <form:hidden path="elementList[${idx}].version"/>

                    <div class="row">
                        <div class="form-group">
                            <label for="${idx}"  class="col-sm-3 control-label">Element:</label>
                            <div class="col-sm-7">
                                <div class="input-group">
                                    <div class="col-sm-9">
                                        <form:input path="elementList[${idx}].elementName" class="form-control" id="${idx}"/>
                                    </div>

                                    <div class="col-sm-3">
                                        <button name="${idx}" class="btn btn-warning removeButton" type="button">Remove</button>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>

                    <c:set var="idx" value="${idx + 1}" scope="page"/>

                </c:forEach>

                <div class="row">
                    <div class="form-group">
                        <label for="${idx}"  class="col-sm-3 control-label">New Element:</label>
                        <div class="col-sm-7">
                            <input type="text" class="form-control" name="inputNewElement">
                        </div>
                        <div class="col-sm-2">
                            <button class="btn btn-success">Add</button>
                        </div>
                    </div>
                </div>

                <div class="row">
                    <div class="col-sm-10">
                        <hr>
                    </div>
                </div>


                <div class="row col-sm-10 col-sm-offset-1">
                    <button class="btn btn-block btn-primary">Update</button>
                </div>

            </fieldset>
        </form:form>
        <div class="row">
            <div class="col-xs-6 col-xs-offset-4">
                <h4>Updated Successfully</h4>
            </div>
        </div>


    </div>
</div>

<%@include file="../../includes/footer.jsp"%>