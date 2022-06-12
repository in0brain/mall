<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>(*^▽^*)</title>
    <link rel="icon" href="./img/favicon.ico">
    <link rel="stylesheet" href="css/login_style.css">
</head>
<body>
    <script>
        const msg = "<%=request.getAttribute("message")%>";
        if(msg!== "null") {
                alert(msg);
            }
    </script>
    <div class="spinner">
      <div class="dot1"></div>
      <div class="dot2"></div>
    </div>
    <div class="container">
       <form id="loginInfo" class="login-box" action="login_servlet" method="post">
            <div class="apple-btn login-apple">
                <li class="red-btn"></li>
                <li class="yellow-btn"></li>
                <li class="green-btn"></li>
            </div>
            <div class="title">Login</div>
            <div id="slogan">
                Long May The Sunshine
            </div>
            <div class="input">
                <input class="lo-input" type="text" id="login-user" name="login-user" placeholder="Input your username">
                <script>
                    const kind = "<%=request.getAttribute("kind")%>";
                    const userName = "<%=request.getAttribute("userName")%>";
                    if(userName!=="null"&&kind==="login") {
                            document.getElementById("login-user").value = userName;
                        }
                 </script>
            </div>
            <div class="input">
                <input class="lo-input" type="password" id="login-password" name="login-password" placeholder="Input your password">
            </div>

            <div id="warning">
                <br>
            </div>
            <div class="btn login-btn" onclick="getLoginInfo()">
                <span>sign in</span>
            </div>
            <div class="change-box login-change">
                <div class="change-btn toSign">
                    <span>REGISTER</span>
                </div>
            </div>
       </form>

       <form id="registerInfo" class="sign-box" action="register_servlet" method="post">
            <div class="apple-btn sign-apple">
                <li class="red-btn"></li>
                <li class="yellow-btn"></li>
                <li class="green-btn"></li>
            </div>
            <div class="title">Sign</div>
            <div class="input">
                <input class="si-input" type="text" id="sign-user" name = "sign-user" placeholder="Have A Good Name?">
                <script>
                    <%--const kind = "<%=request.getAttribute("kind")%>";--%>
                    <%--const userName = "<%=request.getAttribute("userName")%>";--%>
                    if(userName!=="null"&&kind==="register") {
                        document.getElementById("sign-user").value = userName;
                    }
                </script>
            </div>
            <div class="input">
                <input class="si-input" type="text" id="sign-email" name = "sign-email" placeholder="Enter your email address">
                <script>
                    <%--const kind = "<%=request.getAttribute("kind")%>";--%>
                    const email = "<%=request.getAttribute("email")%>";
                    if(email!=="null"&&kind==="register") {
                        document.getElementById("sign-email").value = email;
                    }
                </script>
            </div>
            <div class="input">
                <input class="si-input" type="password" id="sign-password" name = "sign-password" placeholder="Enter your password">
            </div>
            <div class="input">
                <input class="si-input" type="password" id="sign-password-again" name = "sign-password-again" placeholder="Please enter your password again">
            </div>
            <div class="btn sign-btn" onclick="getRegisterInfo()">
                <span>sign up</span>
            </div>
            <div class="change-box sign-change">
                <div class="change-btn toLogin">
                    <span>LOGIN</span>
                </div>
            </div>
       </form>
    </div>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

    <script src="./js/loginController.js"></script>
    <!-- 点击特效，可以打开 -->
    <%--<script src="./js/click_firework.js"></script>--%>
    <div>
    </div>
</body>
</html>