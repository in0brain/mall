
function submit_newInfo() {
    const new_name = document.getElementById("password").value;
    const new_email = document.getElementById("email").value;

    if (isEmpty(new_name)) {
        alert("Username can't be empty!")
        return;
    }

    if (isEmpty(new_email)) {
        alert("Your email address can't be empty!");
        return;
    }

    const msg = "Are you sure you want to modify your personal information?"

    if (confirm(msg)) {
        Toast("Modified successfully!");
        document.getElementById("new-info").submit();
    }
}
//提示信息 封装
function Toast(msg,duration){
    duration=isNaN(duration)?3000:duration;
    const m = document.createElement('div');
    m.innerHTML = msg;
    m.style.cssText="font-size: .32rem;color: rgb(255, 255, 255);background-color: rgba(0, 0, 0, 0.6);padding: 10px 15px;margin: 0 0 0 -60px;border-radius: 4px;position: fixed;    top: 50%;left: 50%;width: 130px;text-align: center;";
    document.body.appendChild(m);
    setTimeout(function() {
        const d = 0.5;
        m.style.opacity = '0';
        setTimeout(function() { document.body.removeChild(m) }, d * 1000);
    }, duration);
}

function isEmpty(str){
    if(str===null||str.trim()==""){
        return true;
    }
    return false;
}

function goBack() {
    window.location.href="index_servlet?info=refresh";
}

function modifyPhoto() {
    $("#img-newSrc").click();
}

function submit_form() {
    const val = document.getElementById("img-src").value;
    console.log(val);
    Toast("Submitted Successfully!",10000);

}

