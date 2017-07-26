<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav.jsp"%>

<div class="container">
    <div class="col-xs-12 col-md-8 col-lg-8 col-md-offset-2 col-lg-offset-2 well">

        <div class="table-responsive">
            <table class="table table-striped table-hover">
                <thead>
                <tr>
                    <th>Make</th>
                    <th>Model</th>
                    <th>VIN</th>
                    <th>Plate</th>
                    <th>Year</th>
                </tr>
                </thead>
                <tbody>
                <c:set var="model_idx" value="0" scope="page"/>
                <c:set var="vehicle_idx" value="0" scope="page"/>

                <c:forEach var="vehicleMake" items="${vehicleMakeList}">
                        <c:forEach var="model" items="${vehicleMake.modelList}">

                            <c:forEach var="vehicle" items="${model.vehicleList}">

                                <tr>
                                    <td>${vehicleMake.vehicleMakeName}</td>
                                    <td> ${model.vehicleModelName}</td>
                                    <td>${vehicle.vin}</td>
                                    <td>${vehicle.licensePlate}</td>
                                    <td>${vehicle.year}</td>
                                    <td><a href="/admin/vehicle/edit/${vehicleMake.id}_${model.id}_${vehicle.id}">
                                        <button class="btn btn-info">Edit</button></a></td>
                                    <td class="actions">
                                        <a id="TakeAction">Delete Options</a>
                                        <ul id="actions">
                                            <ul><a href="/admin/vehicle/delete/${vehicle.id}">
                                                <button class="btn btn-warning btn-sm">Delete Vehicle</button></a></ul>
                                            <ul><a href="/admin/vehiclemodel/delete/${model.id}">
                                                <button class="btn btn-danger btn-sm">Delete Model All</button></a></ul>
                                            <ul><a href="/admin/vehiclemake/delete/${vehicleMake.id}">
                                                <button class="btn btn-danger btn-sm">Delete Make All</button></a></ul>
                                        </ul>
                                    </td>
                                </tr>
                                <c:set var="vehicle_idx" value="${vehicle_idx + 1}" scope="page"/>
                            </c:forEach>
                            <c:set var="model_idx" value="${model_idx + 1}" scope="page"/>
                        </c:forEach>

                </c:forEach>
                </tbody>
            </table>

        </div>

    </div>
</div>

<%@include file="../../includes/footer.jsp"%>