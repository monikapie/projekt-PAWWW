<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>You are logged in!</title>
    <link rel="stylesheet" href="<c:url value='/static/css/afterlogin.css' />" />
    <link rel="stylesheet" href="<c:url value='http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.css' />" />
    <script src="<c:url value='http://code.jquery.com/jquery-1.11.3.min.js' />"></script>
    <script src="<c:url value='http://code.jquery.com/mobile/1.4.5/jquery.mobile-1.4.5.min.js' />"></script>
</head>
<body style="text-align: center">
<div data-role="header">
    <h1>Hi ${login}!<img src="../../static/images/wloczykij.png" width="100" height="100" />
    </h1>
</div>
<div id="wrapper">
<div id="journey">
    <h1>Journeys</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Country</th>
            <th>Cost</th>
            <th>Start_date</th>
            <th>End_date</th>
        </tr>
        <c:forEach items="${journeys}" var="ex">
            <tr>
                <td>${ex.name}</td>
                <td>${ex.country}</td>
                <td>${ex.cost}</td>
                <td>${ex.start_date}</td>
                <td>${ex.end_date}</td>
                <td><form action="/delete-${ex.id}-journey" method="get"><input type="submit" value="DELETE" /></form></td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action="/addJourney">
        <br /><label for="exname">Journey:</label>
        <input type="text" id="exname" name="exname" required/>
        <br /><label for="excountry">Country:</label>
        <input type="text" id="excountry" name="excountry" required/>
        <br /><label for="excost">Cost:</label>
        <input type="text" id="excost" name="excost" required/>
        <br /><label for="exstart_date">Start_date:</label>
        <input type="text" id="exstart_date" name="exstart_date" required/>
        <br /><label for="exend_date">End_date:</label>
        <input type="text" id="exend_date" name="exend_date" required/>
        <br /><input type="submit" value="Add journey" />
    </form>
</div>

<div id="couchsurfer">
    <h1>Couchsurfers</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Surname</th>
            <th>Address</th>
            <th>Arrival_date</th>
            <th>Departure_date</th>
        </tr>
        <c:forEach items="${couchsurfers}" var="couchsurfer">
            <tr>
                <td>${couchsurfer.name}</td>
                <td>${couchsurfer.surname}</td>
                <td>${couchsurfer.address}</td>
                <td>${couchsurfer.arrival_date}</td>
                <td>${couchsurfer.departure_date}</td>
                <td><form action="/delete-${couchsurfer.id}-couchsurfer" method="get"><input type="submit" value="DELETE" /></form></td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action="/addCouchsurfer">
        <br /><label for="cexname">Couchsurfer:</label>
        <input type="text" id="cexname" name="cexname" required/>
        <br /><label for="cexsurname">Surname:</label>
        <input type="text" id="cexsurname" name="cexsurname" required/>
        <br /><label for="cexaddress">Address:</label>
        <input type="text" id="cexaddress" name="cexaddress" required/>
        <br /><label for="cexarrival_date">Arriva_date:</label>
        <input type="text" id="cexarrival_date" name="cexarrival_date" required/>
        <br /><label for="cexdeparture_date">Departure_date:</label>
        <input type="text" id="cexdeparture_date" name="cexdeparture_date" required/>
        <br /><input type="submit" value="Add couchsurfer" />
    </form>
</div>

<div id="transport">
    <h1>Transport</h1>
    <table>
        <tr>
            <th>Name</th>
            <th>Type</th>
            <th>Who_buy</th>
            <th>Cost</th>
            <th>Date_purchase</th>
        </tr>
        <c:forEach items="${transports}" var="transport">
            <tr>
                <td>${transport.name}</td>
                <td>${transport.type}</td>
                <td>${transport.member_id}</td>
                <td>${transport.type}</td>
                <td>${transport.purchase_date}</td>
                <td><form action="/delete-${transport.id}-transport" method="get"><input type="submit" value="DELETE" /></form></td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action="/addTransport">
        <br /><label for="texname">Transport:</label>
        <input type="text" id="texname" name="texname" required/>
        <br /><label for="textype">Type:</label>
        <input type="text" id="textype" name="textype" required/>
        <br /><label for="texwho_buy">Who_buy:</label>
        <input type="text" id="texwho_buy" name="texwho_buy" required/>
        <br /><label for="texcost">Cost:</label>
        <input type="text" id="texcost" name="texcost" required/>
        <br /><label for="purchase_date">Date_purchase:</label>
        <input type="text" id="purchase_date" name="purchase_date" required/>
        <br /><input type="submit" value="Add transport" />
    </form>
</div>

<div id="expense">
    <h1>Expenses</h1>
    <table>
        <tr>
            <th>Expense</th>
            <th>Cost</th>
            <th>Member_id</th>
        </tr>
        <c:forEach items="${expenses}" var="u">
            <tr>
                <td>${u.name}</td>
                <td>${u.cost}</td>
                <td>${u.member_id}</td>
                <td><form action="/delete-${u.id}-expense" method="get"><input type="submit" value="DELETE" /></form></td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action="/addExpense">
        <br /><label for="eexname">Expense:</label>
        <input type="text" id="eexname" name="eexname" required/>
        <br /><label for="eexcost">Cost:</label>
        <input type="text" id="eexcost" name="eexcost" required/>
        <br /><label for="eexmember_id">Member_id:</label>
        <input type="text" id="eexmember_id" name="eexmember_id" required/>
        <br /><input type="submit" value="Add expense" />
    </form>
</div>

<div id="member">
    <h1>Companion</h1>
    <table>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Surname</th>
        </tr>
        <c:forEach items="${members}" var="q">
            <tr>
                <td>${q.id}</td>
                <td>${q.name}</td>
                <td>${q.surname}</td>
                <td><form action="/delete-${q.id}-member" method="get"><input type="submit" value="DELETE" /></form></td>
            </tr>
        </c:forEach>
    </table>
    <form method="get" action="/addMember">
        <br /><label for="mexname">Member:</label>
        <input type="text" id="mexname" name="mexname" required/>
        <br /><label for="mexsurname">Surname:</label>
        <input type="text" id="mexsurname" name="mexsurname" required/>
        <br /><input type="submit" value="Add member" />
    </form>
</div>
</div>

<%@ include file="footer.jsp" %>
