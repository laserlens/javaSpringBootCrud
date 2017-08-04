<%@include file="../../includes/header.jsp"%>
<%@include file="../../includes/navbar.jsp"%>




<div class="container">
    <h2>Employee Page</h2>
    <table id="employeeTable" class="table table-striped table-hover">
        <thead>
            <tr>
                <th>Id</th>
                <th>Name</th>
                <th>Background</th>
                <th>Project</th>
            </tr>
        </thead>
        <tbody>
            <%--jquery append data here--%>
        </tbody>
    </table>
</div>

<script>
    $.getJSON('/api/employee/', {
        ajax: 'true'
    }, function (data){
        console.log(data)
        $.each(data, function(index, employee){
            console.log(employee.id);
            var fullName = employee.firstName + ' ' + employee.lastName;
            $('#employeeTable').find('tbody')
                .append($('<tr>\n')
                    .append($('<td>').text(employee.id))
                    .append($('<td>').text(fullName))
                    .append($('<td>').text(employee.background))
                    .append($('<td>').text($.each(employee.projects,function(index, project){
                        this.text(project.projectName);
                    }))
                    .append('</tr>'));

        });
    });

</script>

<%@include file="../../includes/footer.jsp"%>