<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
    <link href="<c:url value='/static/css/web.css' />" rel="stylesheet" type="text/css" media="all" />
</head>
<body>

<div id="container_demo">
    <a class="hiddenanchor" id="toregister"></a>
    <a class="hiddenanchor" id="tologin"></a>
    <div id="wrapper">
        <h1>Welcome! Login or create new account.</h1>
        <div id="log_in" class="animate form">
            <h1>Login:</h1>
            <div>
                <form name="myForm" method="post" action="/login">
                    <p>
                        <label for="login" class="uname"  > Your username </label>
                        <input type="text" id="login" name="login" placeholder="Login" required/>
                    </p>
                    <p>
                        <label for="password" class="youpasswd" d> Your password </label>
                        <input type="password" id="password" name="password" placeholder="password" required/>
                    </p>
                    <p class="login button">
                        <input type="submit" onclick="myFunction()" value="Login"/>
                    </p>
                    <p class="change_link">
                        Not a member yet ? <a href="#toregister" class="to_register">Join us</a></p>
                </form>
            </div>
        </div>

        <div id="register" class="animate form">
            <h1>New Account:</h1>
            <div>
                <form name="myForm" method="post" action="/register">
                    <p>
                        <label for="reglogin" class="uname" >Your username</label>
                        <input type="text" id="reglogin" name="reglogin" placeholder="Username" required/>
                    </p>
                    <p>
                        <label for="regpassword" class="youpasswd" >Your password</label>
                        <input type="password" id="regpassword" name="regpassword" placeholder="password" required/>
                    </p>
                    <p class="signin button">
                        <input type="submit" onclick="myFunction()" value="Register" />
                    </p>
                    <p class="change_link">
                        Already member?
                        <a href="#tologin" class="to_register"> Go and log in </a>
                    </p>
                </form>
            </div>
        </div>


    </div>
</div>
</body>

<%@ include file="footer.jsp" %>