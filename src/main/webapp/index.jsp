<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ page import="pers.lnz.entity.User" %>
<%@ page import="java.util.List" %>
<%@ page import="pers.lnz.util.Constants" %>
<%@ page import="pers.lnz.entity.Product" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>(～￣▽￣)～</title>
    <link rel="icon" href="./img/favicon.ico">
    <style>
        @import url("https://fonts.googleapis.com/css2?family=Poppins:wght@200;300;400;500;600;700&display=swap");
        @import url(css/index_style.css);
    </style>
</head>
<body>
    <%! User user;List<String> merchants;List<String> productsKind;List<Product>products;int row;int remain;%>
    <% user = (User) request.getSession().getAttribute("user");
        merchants = (List<String>) request.getAttribute(Constants.MERCHANTS_NAME);
        productsKind = (List<String>) request.getAttribute(Constants.PRODUCTS_KIND);
        products = (List<Product>) request.getAttribute(Constants.PRODUCTS_LIST);
        if (products!=null) {
            if (products.size()%3==0) {
                remain=0;
            }else {
                remain=1;
            }

            row = products.size()/3+remain;
        }
    %>
       <div class="dark-light">
         <!-- 调整光暗 -->
           <svg viewBox="0 0 24 24" stroke="currentColor" stroke-width="1.5" fill="none" stroke-linecap="round" stroke-linejoin="round">
            <path d="M21 12.79A9 9 0 1111.21 3 7 7 0 0021 12.79z" />
          </svg>
       </div>
       <div class="app">
        <div class="header">
         <div class="menu-circle" onclick="goBack()"></div>
         <div class="header-menu">
           <!-- class决定右上角有没有蓝色的点 -->
          <a class="menu-link is-active" href="#">Products</a>
          <a class="menu-link notify" href="#">Your work</a>
          <a class="menu-link" href="#">Discover</a>
          <a class="menu-link notify" href="#">Market</a>
         </div>
         <!-- 搜索框 -->
         <div class="search-bar">
          <input id="search-product" type="text" placeholder="Search">
         </div>

         <!-- 右端的消息栏 -->
         <div class="header-profile">
          <div class="notification">
<%--           右上角的提示数字--%>
<%--           <span class="notification-number">3</span>--%>
            <a href="#" onclick="jump('<%=user.getAuthority()%>')" id="merchants_table">
                 <img src="img/account.svg">
            </a>
<%--           <a href="index_servlet?info=add_product" id="products_table">--%>
<%--                <img src="img/product.svg">--%>
<%--           </a>--%>

          </div>

          <a href="index_servlet?info=personal_page" id="info-page">
            <img class="profile-img" src=<%= user.getImg_src()%> alt="">
          </a>
         </div>
        </div>


        <div class="wrapper">
         <div class="left-side">


          <div class="side-wrapper">
            <!-- 最左端虚标题 -->
           <div class="side-title">Mall</div>
           <div class="side-menu">
            <a href="index_servlet?info=refresh&operation=all">
             <svg viewBox="0 0 512 512">
              <g xmlns="http://www.w3.org/2000/svg" fill="currentColor">
               <path d="M0 0h128v128H0zm0 0M192 0h128v128H192zm0 0M384 0h128v128H384zm0 0M0 192h128v128H0zm0 0" data-original="#bfc9d1" />
              </g>
              <path xmlns="http://www.w3.org/2000/svg" d="M192 192h128v128H192zm0 0" fill="currentColor" data-original="#82b1ff" />
              <path xmlns="http://www.w3.org/2000/svg" d="M384 192h128v128H384zm0 0M0 384h128v128H0zm0 0M192 384h128v128H192zm0 0M384 384h128v128H384zm0 0" fill="currentColor" data-original="#bfc9d1" />
             </svg>
             All Products
<%--         <span class="notification-number updates">3</span>--%>
            </a>

<%--           <a href="#">--%>
<%--                <svg viewBox="0 0 488.932 488.932" fill="currentColor">--%>
<%--                   <path d="M243.158 61.361v-57.6c0-3.2 4-4.9 6.7-2.9l118.4 87c2 1.5 2 4.4 0 5.9l-118.4 87c-2.7 2-6.7.2-6.7-2.9v-57.5c-87.8 1.4-158.1 76-152.1 165.4 5.1 76.8 67.7 139.1 144.5 144 81.4 5.2 150.6-53 163-129.9 2.3-14.3 14.7-24.7 29.2-24.7 17.9 0 31.8 15.9 29 33.5-17.4 109.7-118.5 192-235.7 178.9-98-11-176.7-89.4-187.8-187.4-14.7-128.2 84.9-237.4 209.9-238.8z" />--%>
<%--                </svg>--%>
<%--               Updates--%>
                   <%--             <span class="notification-number updates">3</span>--%>
           </a>
           </div>
          </div>

             <div class="side-wrapper">
                 <!-- 最左端虚标题 -->
                 <div class="side-title">Commodity category</div>
                 <div class="side-menu">
                     <% for(String p : productsKind){ %>
                        <a href="index_servlet?info=refresh&operation=kind&parameter=<%=p%>">
                            <img src="img/kind.svg">
                            &nbsp;&nbsp;<%= p%>
                        </a>
                     <%}%>
                 </div>
             </div>

             <div class="side-wrapper">
                 <!-- 最左端虚标题 -->
                 <div class="side-title">Merchant's goods</div>
                 <div class="side-menu">
                     <% for (String m:merchants){%>

                     <a href="index_servlet?info=refresh&operation=merchant&parameter=<%=m%>">
                         <img class="show" src="img/merchant.svg">
                          &nbsp;&nbsp;<%= m%>
                     </a>
                     <%}%>
                 </div>
             </div>


         </div>
         <div class="main-container">
          <div class="main-header">
           <a class="menu-link-main" href="#">All Products</a>
           <div class="header-menu">
<%--            <a class="main-header-link is-active" href="#">Desktop</a>--%>
<%--            <a class="main-header-link" href="#">Mobile</a>--%>
<%--            <a class="main-header-link" href="#">Web</a>--%>

           </div>
          </div>
          <div class="content-wrapper">
<%--           <div class="content-wrapper-header">--%>
<%--            <div class="content-wrapper-context">--%>
<%--             <h3 class="img-content">--%>
<%--              <svg viewBox="0 0 512 512">--%>
<%--               <path d="M467 0H45C20.099 0 0 20.099 0 45v422c0 24.901 20.099 45 45 45h422c24.901 0 45-20.099 45-45V45c0-24.901-20.099-45-45-45z" fill="#d6355b" data-original="#ff468c" />--%>
<%--               <path xmlns="http://www.w3.org/2000/svg" d="M512 45v422c0 24.901-20.099 45-45 45H256V0h211c24.901 0 45 20.099 45 45z" fill="#d6355b" data-original="#d72878" />--%>
<%--               <path xmlns="http://www.w3.org/2000/svg" d="M467 30H45c-8.401 0-15 6.599-15 15v422c0 8.401 6.599 15 15 15h422c8.401 0 15-6.599 15-15V45c0-8.401-6.599-15-15-15z" fill="#2e000a" data-original="#700029" />--%>
<%--               <path xmlns="http://www.w3.org/2000/svg" d="M482 45v422c0 8.401-6.599 15-15 15H256V30h211c8.401 0 15 6.599 15 15z" fill="#2e000a" data-original="#4d0e06" />--%>
<%--               <path xmlns="http://www.w3.org/2000/svg" d="M181 391c-41.353 0-75-33.647-75-75 0-8.291 6.709-15 15-15s15 6.709 15 15c0 24.814 20.186 45 45 45s45-20.186 45-45-20.186-45-45-45c-41.353 0-75-33.647-75-75s33.647-75 75-75 75 33.647 75 75c0 8.291-6.709 15-15 15s-15-6.709-15-15c0-24.814-20.186-45-45-45s-45 20.186-45 45 20.186 45 45 45c41.353 0 75 33.647 75 75s-33.647 75-75 75z" fill="#d6355b" data-original="#ff468c" />--%>
<%--               <path xmlns="http://www.w3.org/2000/svg" d="M391 361h-30c-8.276 0-15-6.724-15-15V211h45c8.291 0 15-6.709 15-15s-6.709-15-15-15h-45v-45c0-8.291-6.709-15-15-15s-15 6.709-15 15v45h-15c-8.291 0-15 6.709-15 15s6.709 15 15 15h15v135c0 24.814 20.186 45 45 45h30c8.291 0 15-6.709 15-15s-6.709-15-15-15z" fill="#d6355b" data-original="#d72878" />--%>
<%--              </svg>--%>
<%--              Adobe Stock--%>
<%--             </h3>--%>
<%--             <div class="content-text">Grab yourself 10 free images from Adobe Stock in a 30-day free trial plan and find perfect image, that will help you with your new project.</div>--%>
<%--            </div>--%>
<%--            <img class="content-wrapper-img" src="https://assets.codepen.io/3364143/glass.png" alt="">--%>
<%--           </div>--%>


           <div class="content-section">
            <div class="content-section-title">Manage Products</div>
           <ul>
                <li class="adobe-product">
                    <div class="products">
                        <img src="img/product.svg">
                        &nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp; PRODUCT
                    </div>
<%--                    <span class="status">--%>
<%--                   <span class="status-circle green"></span>--%>
<%--                   Updated</span>--%>
                    <div class="button-wrapper">
                        <button class="content-button status-button open" onclick="toAddProduct('<%=user.getAuthority()%>')">ADD</button>
<%--                        <div class="menu">--%>
<%--                            <button class="dropdown">--%>
<%--                                <ul>--%>
<%--                                    <li><a href="#">Go to Discover</a></li>--%>
<%--                                    <li><a href="#">Learn more</a></li>--%>
<%--                                    <li><a href="#">Uninstall</a></li>--%>
<%--                                </ul>--%>
<%--                            </button>--%>
<%--                        </div>--%>
                    </div>
                </li>
           <!-- 一个块就是一个商品展示 -->
            </ul>
           </div>




           <div class="content-section">
            <div class="content-section-title">Mall</div>

               <% if (products!=null&&products.size()!=0){%>
               <%! int i; %>
                <% for(i=0;i<row;i++) { %>
                <div class="apps-card">
                   <%! int k; Product product;%>
                   <% for(k=0;k<3&&(3*i+k)<products.size();k++) {%>
                       <% product = products.get(3*i+k); %>
                       <figure class="snip1249">
                           <div class="image">
                               <img src="<%= product.getImage_src() %>" alt=""/>
                               <i class="ion-ios-trash-outline" onclick="deleteProduct('<%=product.getName()%>')"></i>
                           </div>
                           <figcaption>
                               <h3><%=product.getName()%></h3>
                               <p><%=product.getMessage()%></p>
                               <div class="price">
                                   <s>$<%=product.getPrice()+product.getPrice()/5%></s>$<%=product.getPrice()%>
                               </div>
                               <a href="#" onclick="modifyProduct('<%=product.getMerchantName()%>','<%=user.getUserName()%>','<%=product.getName()%>')"  class="add-to-cart">MODIFY PRODUCT</a>
                           </figcaption>
                       </figure>
                   <% } %>
                <%}%>
                <%} else {%>


                    <div>
                        nothing to show
                    </div>


                <%}%>
               </div>
           </div>
          </div>
         </div>
        </div>
        <div class="overlay-app"></div>
       </div>
       <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
       <script src="./js/indexController.js"> </script>
</body>
</html>