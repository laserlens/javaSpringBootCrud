<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav.jsp"%>

<div class="container" >
    <div class="col-xs-12 col-md-8 col-lg-6 col-md-offset-2 col-lg-offset-3 well">


        <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/add" method="post" name="test">


            <fieldset>
            <Legend>Vehicle Management</Legend>

            <div class="container">
                <div class="col-sm-6 col-sm-offset-4">
                    <h5><u>${successMsg}</u></h5>
                </div>
                <div class="col-sm-8 col-sm-offset-2">

                    <select name="selectMake" id="SelectMakeAdd" onchange="selectedMake(this)">

                        <option selected disabled="disabled">First Choose a Make</option>

                        <c:forEach var="make" items="${makeListAdd}">
                            <option id="${make.id}" value="${make.vehicleMakeName}">${make.vehicleMakeName}</option>
                        </c:forEach>

                    </select>

                </div>
            </div>

            <div class="form-group">
                <label for="inputNewVehicleMake"  class="col-sm-3 control-label">Add a Make:</label>
                <div class="col-sm-5">
                    <form:hidden  path="vehicleMakeId" id="selectedMakeId"/>
                    <form:input path="newVehicleMake" class="form-control" id="inputNewVehicleMake" placeholder="Enter or Select a Make" required="true"/>
                </div>
            </div>

            <div class="container">
                <div class="col-sm-8 col-sm-offset-2">

                    <c:forEach var="make" items="${makeListAdd}">


                        <select class="modelClass" id="model_${make.id}" name="selectModel" onchange="selectedModel(this)" style="display:none" >

                            <option id="model_0" selected disabled="disabled" >Select a Model</option>
                        <c:forEach var="model" items="${make.modelList}" >
                            <option  id="${model.id}" value="${model.vehicleModelName}">${model.vehicleModelName}</option>
                        </c:forEach>

                        </select>
                    </c:forEach>


                </div>
            </div>

            <div class="form-group">
                <label for="inputNewVehicleModel"  class="col-sm-3 control-label">Add a Model:</label>
                <div class="col-sm-5">
                    <form:hidden  path="vehicleModelId" id="selectedModelId"/>
                    <form:input path="newVehicleModel" class="form-control"  id="inputNewVehicleModel" required="true"/>
                </div>

            </div>

            <div class="form-group">
                <label for="inputNewVehicleVin"  class="col-sm-2 control-label">VIN:</label>
                <div class="col-sm-10">
                    <form:input path="newVehicleVin" class="form-control" rows="5" id="inputNewVehicleVin" placeholder="1VN23456789" required="true"/>
                </div>
            </div>

            <div class="form-group">
                <label for="inputNewVehicleVin"  class="col-sm-2 control-label">Plate:</label>
                <div class="col-sm-10">
                    <form:input path="newVehicleLicensePlate" class="form-control" rows="5" id="inputNewVehicleVin" placeholder="555-XXX" required="true"/>
                </div>
            </div>

            <div class="form-group">
                <label for="inputNewVehicleVin"  class="col-sm-2 control-label">Year:</label>
                <div class="col-sm-10">
                    <form:input type="number" path="newVehicleYear" class="form-control" rows="5" id="inputNewVehicleVin" placeholder="2001" required="true"/>
                </div>
            </div>

            <div class="form-group">
                <div class="col-sm-12">
                    <form:button type="reset" vlaue="cancel" class="btn btn-danger" onclick="hideModelSelect()" >Clear</form:button>
                    <form:button type="submit" value="Add" class="btn btn-primary btn-block" >Save</form:button>
                </div>
            </div>

        </fieldset>
        </form:form>
    </div>
</div>



<%@include file="../../includes/footer.jsp"%>