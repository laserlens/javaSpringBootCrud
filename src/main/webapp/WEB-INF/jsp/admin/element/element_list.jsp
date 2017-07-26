<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>
<%@include file="../../includes/subnav.jsp"%>

    <div class="container">
        <div class="col-xs-12 col-md-8 col-lg-8 col-md-offset-2 col-lg-offset-2 well">

            <div class="table-responsive">
                <table class="table table-striped table-hover">
                    <thead>
                        <tr>
                            <th>ID</th>
                            <th>Element Type</th>
                            <th>Elements</th>
                            <th>Edit</th>
                            <th>Delete</th>
                        </tr>
                    </thead>
                    <tbody>
                        <c:forEach var="elementType" items="${elementTypeList}">

                            <tr>
                                <td>${elementType.id}</td>
                                <td>${elementType.elementTypeName}</td>
                                <td><c:forEach var="element" items="${elementType.elementList}"> ${element.elementName},
                                </c:forEach></td>
                                <td><a href="/admin/element/edit/${elementType.id}">
                                    <button class="btn btn-info">Edit</button></a></td>
                                <td><a href="/admin/element/delete/${elementType.id}">
                                    <button class="btn btn-danger">Delete</button></a></td>
                            </tr>
                        </c:forEach>
                    </tbody>
                </table>

            </div>

        </div>
    </div>

<%@include file="../../includes/footer.jsp"%>