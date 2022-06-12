<%@ page import="java.util.List" %>
<%@ page import="pers.lnz.entity.User" %>
<%@ page import="pers.lnz.util.SqlHelper" %><%--
  Created by IntelliJ IDEA.
  User: LNZ
  Date: 2022/6/3
  Time: 23:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <style>
        @import url(css/merchants_style.css);
        @import url(css/input_style.css);
    </style>
    <link rel="icon" href="./img/favicon.ico">

</head>
<body>
<div class="page">
    <%! List<User> list;int i=0;%>
    <%  list = (List<User>) request.getAttribute("merchants");%>
    <div class="cntr">
        <div class="cntr-innr">
            <label class="search" for="inpt_search">
                <input id="inpt_search" type="text" placeholder="search..." />
            </label>
        </div>
    </div>
    <div class="menu-circle" onclick="goBack()"></div>
    <div class="page-header cf">
        <h2>merchants</h2>
    </div>
    <div id="refresh-table">
        <a id="refresh-href" href="index_servlet?info=merchants_table">
            <img src="img/refresh.svg">
        </a>
    </div>
    <ul class="merchant-list">

        <% for (User user: list) { %>
            <li class="merchant-item cf">
                <div class="merchant-details" onclick="toChange('<%=user.getUserName()%>')">
                    <img class="avatar" src="<%= user.getImg_src()%>">
                    <h3><%= user.getUserName() %></h3>
                    <span class="email"><%=user.getEmail()%></span>
                </div>
                <div class="joined-details" onclick="toChange('<%=user.getUserName()%>')">
                    <span class="date"><%=user.getDescription()%></span>
                </div>
                <div class="del" onclick="toDelete('<%=user.getUserName()%>')">
                    <img src="img/delete.svg">
                </div>
            </li>
        <% } %>
    </ul>

    <div class = "pagination">
        <ul class = "pagination__list">
        </ul>
    </div>
</div>
<div class="container">
<%--    <a id="button" href="#popup">Open Modal</a>--%>
    <div class="popup" id="popup">
        <div class="popup-inner">
            <div class="popup__photo">
                <img src="https://images.unsplash.com/photo-1515224526905-51c7d77c7bb8?ixlib=rb-0.3.5&s=9980646201037d28700d826b1bd096c4&auto=format&fit=crop&w=700&q=80" alt="">
            </div>

                <div class="popup__text">
                    <h1>Modify Merchant Information </h1>


                <form action="merchants_servlet" method="post">
                    <div class="name">
                        <div class="row">
                     <span>
                       <input class="balloon" id="name" name = "name" onKeyPress="if(window.event.keyCode==13) this.blur()"
                              placeholder="Input New Merchant Name" type="text" required>
                         <label for="email">Name</label>
                     </span>
                        </div>
                    </div>
                    <div class="email">
                        <div class="row">
                     <span>
                       <input class="balloon" id="email" name = "email" onKeyPress="if(window.event.keyCode==13) this.blur()"
                              placeholder="Input Your New Email Address" type="text" required>
                         <label for="email">Email</label>
                     </span>
                        </div>
                    </div>
                    <div class="email">
                        <div class="row">
                     <span>
                       <input class="balloon" id="describe" name = "describe" onKeyPress="if(window.event.keyCode==13) this.blur()"
                              placeholder="Input Your Description" type="text">
                         <label for="describe">Assess</label>
                     </span>
                        </div>
                    </div>
                    <input id="info" name="info" value="" hidden>
                    <input id="operation" name="operation" value="modify" hidden>
                    <button class="submit" id="modify"> SUBMIT </button>
                </form>
                </div>
            <a class="popup__close" href="#">X</a>
        </div>
    </div>
</div>
</body>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script src="js/merchantsController.js"></script>
</html>
