function load_img() {
    const val = document.getElementById("img-newSrc").value;
    const fake_src = val;
    if (fake_src!=null) {
        const new_src = "img/product_src/"+fake_src.substring(12,fake_src.length);
        document.getElementById("photo").src = new_src;
        $("#img").val(new_src);
    }
}

function modifyPhoto() {
    $("#img-newSrc").click();
}

