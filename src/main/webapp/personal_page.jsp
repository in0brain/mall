<%@ page import="pers.lnz.entity.User" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8"%>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>(*･ω< )</title>
    <link rel="icon" href="./img/favicon.ico">
    <style>
        @import url(./css/personal_style.css);
        @import url(./css/input_style.css);
        @import url(./css/button_style.css);
    </style>
</head>
<body>

    <%! User user; boolean isAdmin;%>
    <% user = (User) request.getSession().getAttribute("user");%>
    <% isAdmin= user.getAuthority().equals("Admin");%>
    <div class="wrapper">

            <div class="header">
                <div class="dot1" onclick="goBack()"></div>
                <div class="dot2"></div>
                <div class="dot3"></div>
                <i class="fa fa-info"></i>
            </div>



           <div class="personal-info" >
               <input type="file" id="img-newSrc" name="img-newSrc" onchange="load_img()" hidden>
               <span class="headerSpan "  onclick="modifyPhoto()">
                    <img id="photo" src="" alt="" />
               </span>
               <h1><span><%=user.getAuthority().toUpperCase()%></span><br><%=user.getUserName()%></h1>
           </div>

        <form id="new-info" action="info_servlet" method="post">

                <input id="img-src" name="img-src" type="hidden">

                <div class="name">
                   <div class = "row">
                       <span id = "select_box">
                        <select id="options" name="options" >
                          <option value="Merchant">
                            <label>Merchant</label>
                           </option>
                          <option value="Admin"  <%=isAdmin?"selected":""%> >
                            <label >Admin</label>
                          </option>
                        </select>
                      </span>
                   </div>
               </div>

              <div class="email">
               <div class="row">
                 <span>
                   <input class="balloon" id="email" name = "email" onKeyPress="if(window.event.keyCode==13) this.blur()"
                          placeholder="Input Your New Email Address" type="text" value=<%=user.getEmail()%>>
                     <label for="email">Email</label>
                 </span>
               </div>
              </div>

                <div class="name">
                    <div class="row">
                        <span>
                          <input class="balloon" id="password" name="password" onKeyPress="if(window.event.keyCode==13) this.blur()"
                                 placeholder="Input Your New Password!" type="password" value=<%=user.getPassword()%>>
                          <label for="password">Pwd</label>
                        </span>
                    </div>
                </div>
            <div class="bio">
                <h3>Description:</h3>
            </div>
            <div class="bio-box">
                <p>
                    <%=user.getDescription()%>
                </p>
            </div>

            <div class="panel borderless">
                <button onclick="submit_form()">submit</button>
            </div>
        </form>
    </div>

    <script>
        const cur_src = "<%=user.getImg_src()%>";
        document.getElementById("photo").src=cur_src;

        function load_img() {
            const val = document.getElementById("img-newSrc").value;
            const fake_src = val;
            if (fake_src!=null) {
                const new_src = "./img/user_src/"+fake_src.substring(12,fake_src.length);
                document.getElementById("photo").src = new_src;
                document.getElementById("img-src").value = new_src;
            }
        }
    </script>

   <script src="./js/infoController.js"> </script>
    <script src="https://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>

</body>
</html>