<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav.jsp"%>


<div class="container" >
    <div class="col-xs-12 col-md-8 col-lg-6 col-md-offset-2 col-lg-offset-3 well">


        <form:form cssClass="form-horizontal" modelAttribute="vehicleVO" action="/admin/vehicle/edit" method="post" name="edit">


            <fieldset>
                <Legend>Edit Vehicle</Legend>

                <div class="container">

                    <div class="col-sm-8 col-sm-offset-2">

                        <select name="selectMake" id="SelectMakeAdd" onchange="selectedMake(this)">

                            <%--<option selected disabled="disabled">First Choose a Make</option>--%>
                            <c:set var = "makeEdit" scope = "page" value = "${makeEdit}"/>
                            <c:set var = "modelEdit" scope = "page" value = "${modelEdit}"/>
                            <c:set var = "vehicleEdit" scope = "page" value = "${vehicleEdit}"/>


                            <c:forEach var="make" items="${makeListEdit}">
                                <c:choose>
                                    <c:when test="${makeEdit.id == make.id}">
                                        <option selected id="${make.id}" value="${make.vehicleMakeName}">${make.vehicleMakeName}</option>
                                    </c:when>
                                    <c:otherwise>
                                        <option id="${make.id}" value="${make.vehicleMakeName}">${make.vehicleMakeName}</option>
                                    </c:otherwise>
                                </c:choose>
                            </c:forEach>

                        </select>

                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewVehicleMake"  class="col-sm-3 control-label">Add a Make:</label>
                    <div class="col-sm-5">
                        <form:hidden  path="vehicleMakeId" id="selectedMakeId"/>
                        <form:input path="newVehicleMake" class="form-control" id="inputNewVehicleMake" value="${makeEdit.vehicleMakeName}" required="true"/>
                    </div>
                </div>

                <div class="container">
                    <div class="col-sm-8 col-sm-offset-2">

                        <c:forEach var="make" items="${makeListEdit}">
                            <c:choose>
                                <c:when test="${makeEdit.id == make.id}">
                            <select class="modelClass" id="model_${make.id}" name="selectModel" onchange="selectedModel(this)" style="display:block" >
                                <option id="model_0" disabled="disabled" >Select a Model</option>
                                </c:when>
                                <c:otherwise>
                                    <select class="modelClass" id="model_${make.id}" name="selectModel" onchange="selectedModel(this)" style="display:none" >
                                        <option selected id="model_0" disabled="disabled" >Select a Model</option>
                                </c:otherwise>
                            </c:choose>





                                <c:forEach var="model" items="${make.modelList}" >
                                    <c:choose>
                                        <c:when test="${modelEdit.id == model.id}">
                                            <option selected id="${model.id}" value="${model.vehicleModelName}">${model.vehicleModelName}</option>
                                        </c:when>
                                        <c:otherwise>
                                            <option  id="${model.id}" value="${model.vehicleModelName}">${model.vehicleModelName}</option>
                                        </c:otherwise>
                                    </c:choose>
                                </c:forEach>

                            </select>
                        </c:forEach>


                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewVehicleModel"  class="col-sm-3 control-label">Add a Model:</label>
                    <div class="col-sm-5">
                        <form:hidden  path="vehicleModelId" id="selectedModelId"/>
                        <form:input path="newVehicleModel" class="form-control"  id="inputNewVehicleModel" value="${modelEdit.vehicleModelName}" required="true"/>
                    </div>

                </div>

                <div class="form-group">
                    <label for="inputNewVehicleVin"  class="col-sm-2 control-label">VIN:</label>
                    <div class="col-sm-10">
                        <form:input path="newVehicleVin" class="form-control" rows="5" id="inputNewVehicleVin" value="${vehicleEdit.vin}" required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewVehicleVin"  class="col-sm-2 control-label">Plate:</label>
                    <div class="col-sm-10">
                        <form:input path="newVehicleLicensePlate" class="form-control" rows="5" id="inputNewVehicleVin" value="${vehicleEdit.licensePlate}" required="true"/>
                    </div>
                </div>

                <div class="form-group">
                    <label for="inputNewVehicleVin"  class="col-sm-2 control-label">Year:</label>
                    <div class="col-sm-10">
                        <form:input type="number" path="newVehicleYear" class="form-control" rows="5" id="inputNewVehicleVin" value="${vehicleEdit.year}" required="true"/>
                    </div>
                </div>


                <div class="form-group">
                    <div class="col-sm-12">
                        <div class="btn-group btn-group-justified">


                            <div class="btn-group" role="group">
                                <button type="reset" class="btn btn-danger" onclick="window.location.reload()" >Reset To Orginal</button>
                            </div>
                            <div class="btn-group" role="group">
                                <form:button type="submit" value="Edit" class="btn btn-primary" >Update</form:button>
                            </div>



                        </div>


                    </div>
                </div>

            </fieldset>
        </form:form>
    </div>
</div>
<%@include file="../../includes/footer.jsp"%>