<%@ page contentType="text/html" pageEncoding="UTF-8" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<html>
    <head>
        <c:url value="/webjars/bootstrap\3.3.4/css/bootstrap.min.css" var="bootstrap"/>
            <link href="${bootstrap}" rel="stylesheet" media="screen">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>

        <c:url value="/static/js/common.js" var="common"/>
            <script src="${common}"></script>

        <c:url value="/static/css/stylesheet.css" var="customCSS"/>
            <link href="${customCSS}" rel="stylesheet" media="screen">

        <title>Aston Tech HR Application</title>


    </head>
    <body>



