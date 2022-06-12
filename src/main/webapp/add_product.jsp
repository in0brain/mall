<%@ page import="pers.lnz.entity.Product" %>
<%@ page import="pers.lnz.util.Constants" %><%--
  Created by IntelliJ IDEA.
  User: LNZ
  Date: 2022/5/29
  Time: 17:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>(*･ω< )</title>
    <link rel="icon" href="./img/favicon.ico">
    <style>
        @import url(css/addproduct_style.css);
    </style>
</head>
<body>
<%! Product product; String op;boolean isModify;%>
<% product=(Product) request.getAttribute("product");
    op = (String) request.getAttribute("button");%>

<% if (op==null) { %>
    <script>
        window.location.href="index_servlet?info=refresh";
    </script>

<% } %>
<%
    if (op!=null) {
        isModify = op.equals("MODIFY");
    }
%>

<div class="login-card">
    <div class="login-card-content">
        <div class="header">
            <div class="logo">
                <input type="file" id="img-newSrc" name="img-newSrc" onchange="load_img()" hidden>
                <span class="headerSpan "  onclick="modifyPhoto()">
                    <img id="photo" src="" alt="" />
               </span>
            </div>
            <h2><%=isModify?"MODIFY":"ADD"%>
                <span class="highlight"> Product</span></h2>
<%--            <h3>company slogan</h3>--%>
        </div>
        <form class="form" action="product_servlet" method="post">
            <input type="text" id="operation" name="operation" value="<%=op%>" hidden>
            <input type="text" id = "product-id" name="product-id" value=" " hidden>
            <input type="text" id="img" name="img" value="" hidden>
            <div class="form-field username">
                <div class="icon">
                    <i class="far fa-user"></i>
                </div>
                <input type="text" id="product-name" name="product-name" value="" placeholder="Product Name" required>
            </div>
            <div class="form-field price">
                <div class="icon">
                    <i class="fas fa-lock"></i>
                </div>
                <input type="text" id="price" name="price" value=""  placeholder="Price" required>
            </div>
            <div class="form-field kind">
                <div class="icon">
                    <i class="fas fa-lock"></i>
                </div>
                <input type="text" id="kind" name="kind" value="" placeholder="Kind" required>
            </div>
            <div class="form-field message">
                <div class="icon">
                    <i class="fas fa-lock"></i>
                </div>
                <input type="text" id="message" name="message" value="" placeholder="Message" required>
            </div>
            <button type="submit">
                <%=isModify?"MODIFY":"ADD"%>
            </button>
        </form>
    </div>

</div>
<script src="js/productsController.js"></script>
<script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<% if (product!=null) { %>
<script>
    $("#photo").attr('src',"<%=product.getImage_src()%>");
    $("#img").attr('value',"<%=product.getImage_src()%>");
    $("#product-id").attr('value',"<%=product.getId()%>");
    $("#product-name").attr('value',"<%=product.getName()%>")
    $("#price").attr('value',"<%=product.getPrice()%>");
    $("#kind").attr('value',"<%=product.getKind()%>");
    $("#message").attr('value',"<%=product.getMessage()%>")
</script>
<% } %>
</body>

</html>
