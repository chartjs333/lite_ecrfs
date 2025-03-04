<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<html>
<head>
    <title>Изменение пароля</title>
</head>
<body>
    <h2>Изменение пароля</h2>
    <c:if test="${not empty error}">
        <div style="color:red;">${error}</div>
    </c:if>
    <c:if test="${not empty message}">
        <div style="color:green;">${message}</div>
    </c:if>
    <form:form method="post" modelAttribute="changePasswordDTO">
        <div>
            <label for="currentPassword">Текущий пароль:</label>
            <form:password path="currentPassword" id="currentPassword"/>
        </div>
        <div>
            <label for="newPassword">Новый пароль:</label>
            <form:password path="newPassword" id="newPassword"/>
        </div>
        <div>
            <label for="confirmNewPassword">Подтверждение нового пароля:</label>
            <form:password path="confirmNewPassword" id="confirmNewPassword"/>
        </div>
        <div>
            <button type="submit">Сохранить</button>
        </div>
    </form:form>
</body>
</html>
