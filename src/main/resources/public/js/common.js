var HttpHelper = function () {
    return {
        ajax: function (url, type, data, sucFun) {
            if (!type) type = "GET";
            if (!data) data = {};
            if ((!url) || !(sucFun)) return;
            $.ajax({
                url: url,
                type: type,
                data: data,
                timeout: 5000,
                dataType: 'json',
                headers: {
                    "x-access-token": "Bearer " + localStorage.getItem("token"),
                    "visitor": localStorage.getItem("visitor")
                },
                contentType: 'application/json; charset=UTF-8',
                success: sucFun,
                error: function (e) {
                    alert(JSON.stringify(e));
                }
            });
        },
        method: function () {
            return {
                GET: "GET",
                POST: "POST",
                PUT: "PUT",
                DELETE: "DELETE"
            };
        }
    };
}();
