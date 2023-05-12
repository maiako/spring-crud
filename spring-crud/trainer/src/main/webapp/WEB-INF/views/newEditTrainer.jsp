<%-- 
    Document   : newTrainer
    Created on : Jun 23, 2021, 8:20:06 PM
    Author     : Μ
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="f"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>${title}</title>
    </head>
    <body>
        <h1>${h1}</h1>
         <f:form action="${action}" method="POST" modelAttribute="trainer">
            First Name:<f:input path="fname"/>
            Last Name:<f:input path="lname"/>
            Subject:<f:input path="subject"/>
             <f:hidden path="id" readonly="true"/>
            <input type="submit" value="${submit}" />
        </f:form>
    </body>
</html>
