<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
    <style>
        <%@include file='css/style.css' %>
    </style>

    <title>Start</title>
</head>
<body>

<table class="arrive">
    <form action="/findlocker" method="POST">
        <tr>
            <td><h3>Клиент пришел:</h3></td>
        </tr>
        <tr>
            <td>Номер карточки</td>
            <td><input name="cardnumber" type="text"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Выбрать ящик"></td>
        </tr>
    </form>
</table>
<table class="depart">
    <form action="/clear" method="POST">
        <tr>
            <td><h3>Клиент ушел:</h3></td>
        </tr>
        <tr>
            <td>Номер карточки</td>
            <td><input name="cardnumber" type="text"></td>
        </tr>
        <tr>
            <td><input type="submit" value="Освободить ящик"></td>
        </tr>
    </form>
</table>
<table class="check">

        <tr>
            <td><h3>Проверить рекомендацию:</h3></td>
        </tr>

        <tr>
            <form action="/check" method="POST">
            <td><input type="submit" value="Проверить"></td>
            </form>
            <form action="/checkback" method="POST">
                <td><input type="submit" value="Назад"></td>
            </form>
        </tr>

</table>





<table class="main">
    <c:forEach items="${lockers}" var="locker">
        <tr>
            <td><${lockertype} href="${action}?id=${locker.num}&cardnum=${cardnum}" class="${locker.status}"></${lockertype}></td> <td ${hidecardnum}>Номер карты: ${locker.cardnum}</td>
        </tr>
    </c:forEach>
</table>

<table class="example">
    <tr>
        <td><span  class="empty"></span></td>
        <td>-ПУСТОЙ ЯЩИК</td>
        <td><span class="recomend"></span></td>
        <td>-РЕКОМЕНДУЕТСЯ ЯЩИК</td>
        <td><span class="notrecomend"></span></td>
        <td>-НЕ РЕКОМЕНДУЕТСЯ ЯЩИК</td>
        <td><span class="engaged"></span></td>
        <td>-ЗАНЯТЫЙ ЯЩИК</td>
    </tr>
</table>
</body>
</html>
