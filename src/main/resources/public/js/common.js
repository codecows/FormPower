function ajax(u,t,d ,s) {
    $.ajax({
        url: u,
        type: t,
        data: d,
        timeout: 5000,
        dataType: 'json',
        headers: {
            "x-access-token": "Bearer " + localStorage.getItem("visitor"),
            "visitor": localStorage.getItem("visitor")
        },
        contentType: 'application/json; charset=UTF-8',
        success: s,
        error:function () {

        }
    });
}