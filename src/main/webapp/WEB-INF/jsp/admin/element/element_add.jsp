<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav.jsp"%>
<script>
    function incrementValue()
    {
        var value = parseInt(document.getElementById('numberOfAdded').value, 10);
        value = isNaN(value) ? 0 : value;
        value++;
        document.getElementById('numberOfAdded').value = value;
    }
</script>


    <div class="container" >
        <div class="col-xs-12 col-md-8 col-lg-6 col-md-offset-2 col-lg-offset-3 well">

            <form:form cssClass="form-horizontal" modelAttribute="elementVO" action="/admin/element/add" method="post">
                <fieldset>
                    <Legend>Element Management</Legend>

                    <div class="form-group">
                        <label for="inputNewElementType"  class="col-sm-3 control-label">Element Type:</label>
                        <div class="col-sm-9">
                            <form:input path="newElementType" class="form-control" id="inputNewElementType"/>
                        </div>
                    </div>

                    <div class="form-group">
                        <label for="inputNewElements"  class="col-sm-2 control-label">Elements:</label>
                        <div class="col-sm-10">
                            <form:textarea path="newElements" class="form-control" rows="5" id="inputNewElements"/>
                            <span class="help-block">Enter Each New Element on a New Line</span>
                        </div>
                    </div>

                    <div class="form-group">
                        <div class="col-sm-10 offset-sm-2 pull-right">
                            <form:button type="reset" vlaue="cancel" class="btn btn-default">Cancel</form:button>
                            <form:button type="submit" value="save" class="btn btn-success" onclick="incrementValue()">Save</form:button>
                        </div>
                    </div>

                </fieldset>
            </form:form>
            <div class="row">
                <div class="col-xs-6 col-xs-offset-3">
                    <p>Number of New Current Saves: ${aClick} </p>
                </div>
            </div>

        </div>
    </div>

<%@include file="../../includes/footer.jsp"%>