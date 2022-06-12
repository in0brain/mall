//判断登录的前台条件
function getLoginInfo(){
    const name = document.getElementById("login-user").value;
    const pwd = document.getElementById("login-password").value;
    if(isEmpty(name)){
        alert("Username can't be empty!");
        return;
    }
    if(isEmpty(pwd)){
        alert("Your password can't be empty!");
        return;
    }
    document.getElementById("loginInfo").submit();
}

//判断注册的条件
function getRegisterInfo(){
    const name = document.getElementById("sign-user").value;
    const email = document.getElementById("sign-email").value;
    const pwd = document.getElementById("sign-password").value;
    const pwdTwice = document.getElementById("sign-password-again").value;
    if(isEmpty(name)){
        alert("Username can't be empty!");
        return;
    }
    if(isEmpty(email)){
        alert("Your email address can't be empty!");
        return;
    }
    if(isEmpty(pwd)){
        alert("The password can't be empty!");
        return;
    }
    if(isEmpty(pwdTwice)){
        alert("Please write your password again!")
        return;
    }
    document.getElementById("registerInfo").submit();
}

function isEmpty(str){
    if(str===null||str.trim()==""){
        return true;
    }
    return false;
}

/*
    Logic：
        主要采用原生 JavaScript，
        只有在发送 Ajax 请求是才使用 JQuery

    ===
    1、登录注册页面的切换逻辑
    2、Ajax发送及接受响应逻辑
    ===
*/


// 封装选择器, 采用ES6箭头函数写法
const getSelector = ele => {
    return typeof ele === "string" ? document.querySelector(ele) : "";
}


// 登录注册载入

const containerShow = () => {
    const show = getSelector(".container");
    show.className += " container-show"
}


window.onload = containerShow;


// 登录注册页切换
((window, document) => {

    // 登录 -> 注册
    let toSignBtn = getSelector(".toSign"),
        toLoginBtn = getSelector(".toLogin")
    let loginBox = getSelector(".login-box"),
        signBox = getSelector(".sign-box");

    toSignBtn.onclick = () => {
        loginBox.className += ' animate_login';
        signBox.className += ' animate_sign';
    }

    toLoginBtn.onclick = () => {
        loginBox.classList.remove("animate_login");
        signBox.classList.remove("animate_sign");
    }


})(window, document);


function focusNextLoginInput(thisInput) {
    const inputs = document.getElementsByClassName("lo-input");
    for(let i = 0; i<inputs.length; i++){
        // 如果是最后一个，则焦点回到第一个
        if(i==(inputs.length-1)){
            break;
        }else if(thisInput == inputs[i]){
            if(inputs[i].value!==null) {
                inputs[i+1].focus();
            }
            break;
        }
    }
}

function focusNextRegisterInput(thisInput) {
    const inputs = document.getElementsByClassName("si-input");
    for(let i = 0; i<inputs.length; i++){
        // 如果是最后一个，则焦点回到第一个
        if(i==(inputs.length-1)){
            break;
        }else if(thisInput == inputs[i]){
            inputs[i+1].focus();
            break;
        }
    }
}

$(".si-input").keydown(function(event){
    if (event.keyCode == 40) {
        focusNextRegisterInput(this);
    }
    if (event.keyCode==13) {
        document.getElementById("registerInfo").submit();
    }
});

$(".lo-input").keydown(function(event){
    if (event.keyCode == 40) {
        focusNextLoginInput(this);
    }
    if (event.keyCode==13) {
        document.getElementById("loginInfo").submit();
    }
});

