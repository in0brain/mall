function goBack() {
    window.location.href = "./login.jsp";
}

$(function () {
    $(".menu-link").click(function () {
        $(".menu-link").removeClass("is-active");
        $(this).addClass("is-active");
    });
});

$(function () {
    $(".main-header-link").click(function () {
        $(".main-header-link").removeClass("is-active");
        $(this).addClass("is-active");
    });
});

const dropdowns = document.querySelectorAll(".dropdown");
dropdowns.forEach((dropdown) => {
    dropdown.addEventListener("click", (e) => {
        e.stopPropagation();
        dropdowns.forEach((c) => c.classList.remove("is-active"));
        dropdown.classList.add("is-active");
    });
});

$(".search-bar input")
    .focus(function () {
        $(".header").addClass("wide");
    })
    .blur(function () {
        $(".header").removeClass("wide");
    });

$(document).click(function (e) {
    var container = $(".status-button");
    var dd = $(".dropdown");
    if (!container.is(e.target) && container.has(e.target).length === 0) {
        dd.removeClass("is-active");
    }
});

$(function () {
    $(".dropdown").on("click", function (e) {
        $(".content-wrapper").addClass("overlay");
        e.stopPropagation();
    });
    $(document).on("click", function (e) {
        if ($(e.target).is(".dropdown") === false) {
            $(".content-wrapper").removeClass("overlay");
        }
    });
});

$(function () {
    $(".status-button:not(.open)").on("click", function (e) {
        $(".overlay-app").addClass("is-active");
    });
    $(".pop-up .close").click(function () {
        $(".overlay-app").removeClass("is-active");
    });
});

$(".status-button:not(.open)").click(function () {
    $(".pop-up").addClass("visible");
});

$(".pop-up .close").click(function () {
    $(".pop-up").removeClass("visible");
});

const toggleButton = document.querySelector('.dark-light');

toggleButton.addEventListener('click', () => {
    document.body.classList.toggle('light-mode');
});

/* Demo purposes only */
$(".hover").mouseleave(
    function () {
        $(this).removeClass("hover");
    }
);

function jump(authority) {
    if (authority==="Admin") {
        window.location.href="index_servlet?info=merchants_table";
    }else {
        alert("You are not an administrator!");
    }
}


function toAddProduct(authority) {
    if (authority=="Admin"){
        alert("You are not a merchant!");
        return;
    }
    window.location.href="product_servlet?info=add_product";
}

function deleteProduct(name) {
    window.location.href="index_servlet?info=refresh&operation=delete&parameter="+name;
}

$("#search-product").bind('keypress',function (event) {
    const name = $("#search-product").val();
    if (event.keyCode=="13") {
        const tmp = document.createElement("form");
        tmp.action = "index_servlet?info=refresh&operation=search&parameter="+name;
        tmp.method = "post";
        document.body.appendChild(tmp);
        tmp.submit();
    }
});

function modifyProduct(merchantName,userName,productName) {
    if (merchantName!==userName) {
        alert("You are not the merchant that manages this product!");
        return;
    }

    window.location.href="product_servlet?info=modify_product&merchant="+merchantName+"&productName="+productName;
}