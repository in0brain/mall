const $merchantItem = $('.merchant-item');
const $page = $('.page');
const $pagination = $('.pagination');
const $paginationList = $('.pagination__list');
const $merchantSearch = $('.merchant__search');
const itemTotal = 10;

// hide all
function hideAll() {
    $merchantItem.hide();
    console.log($merchantItem.length);
}

hideAll();

// display first 10
function displayRange(a,b) {
    hideAll();
    // display 0 - 1 students
    $merchantItem.slice(a,b).fadeIn();

}
//[0,itemTotal)

displayRange(0, itemTotal);

// create pagination links
let pagination = '';
console.log($merchantItem.length);
for(let i = 0; i <= ($merchantItem.length-1) / 10 ; i ++) {
    pagination += `
    <li><span class ="pagination__num">${i}</span></li>
`;
}
$paginationList.append(pagination);
// click on pagination num
// pass into display range
// calc and show range
$('body').on('click', '.pagination__num', function () {

    hideAll();

    // get text number 1 - 5
    // get ranges for start and end
    let paginationText = Number($(this).text());
    let startFrom = paginationText * itemTotal;
    let end = (paginationText+1) * itemTotal;
    // display ranges
    displayRange(startFrom, end);

});


$merchantSearch.on('input', function () {
    hideAll();
    $merchantItem.each(function() {
        $(this).removeClass("result");

    });


    // value of searched
    const text = $(this).val().toLowerCase();
    // results of search
    const results = $("ul.merchant-list li:contains('" + text.toLowerCase() + "')");

    results.addClass("result");


    // if merchant has result class
    // dispaly
    // else hide


    if($merchantItem.hasClass('result')) {
        $('.result').show();
        $merchantItem.removeClass('result');

    }


});

$merchantSearch.keyup(function()
{
    if (!this.value) {
        hideAll();
        displayRange(0, itemTotal);
    }
});

function goBack() {
    window.location.href="index_servlet?info=refresh";
}

function toChange(id) {
    console.log(id);
    $("#info").val(id);
    window.location.href="#popup";
}

function toDelete(id) {
    const alert = "Do you want to delete this user?";
    if (confirm(alert)==true) {
        const tmp = document.createElement("form");
        tmp.action = "merchants_servlet?info="+id+"&operation=delete";
        tmp.method = "post";
        document.body.appendChild(tmp);
        tmp.submit();
    }else {
        return;
    }
}

$("#inpt_search").bind('keypress',function (event) {
    const name = $("#inpt_search").val();
    if (event.keyCode=="13") {
        const tmp = document.createElement("form");
        tmp.action = "merchants_servlet?info="+name+"&operation=search";
        tmp.method = "post";
        document.body.appendChild(tmp);
        tmp.submit();
    }
});
