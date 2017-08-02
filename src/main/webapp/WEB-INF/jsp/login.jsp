<%@include file="includes/header.jsp"%>
<div class="container well">

    <div class="col-sm-6">
        <img src="${pageContext.servletContext.contextPath}/static/images/header-logo.png" >
    </div>

    <br/>

    <div class="col-sm-4">
        <form id="form" action="<c:url value='login.do'/>" method="POST">

            <c:if test="${not empty param.err}">
                <div class="msg-conatiner error">
                    <c:out value="${SPRING_SECURITY_LAST_EXCEPTION.message}"/>
                </div>
            </c:if>

            <c:if test="${not empty param.out}">
                <div class="msg-container logout">
                    You Have Logged Out
                </div>
            </c:if>

            <c:if test="${not empty param.time}">
                <div class="msg-container time">
                    You Have Been Logged Out, Do To Inactivity
                </div>
            </c:if>

            <span>Username:</span>
            <input name="username" value="" />
            <br/>
            <span>Password:</span>
            <input name="password" value="" />

            <input type="hidden" name="${_carf.parameterName}" value="${_carf.token}"/>

            <br/>
            <br/>

            <input type="submit" name="submit" value="Login" class="btn btn-default"/>


        </form>
    </div>

</div>
<%@include file="includes/footer.jsp"%>