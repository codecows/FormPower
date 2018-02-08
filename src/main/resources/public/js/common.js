var HttpHelper = function () {
    return {
        ajax: function (url, type, data, func) {
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
                success: func,
                error: function (e) {
                    layer.msg(JSON.stringify(e));
                }
            });
        },
        syncGet: function (url, func) {
            if ((!url) || !(func)) return;
            $.ajax({
                url: url,
                type: "GET",
                async: false,
                data: {},
                timeout: 5000,
                dataType: 'json',
                headers: {
                    "x-access-token": "Bearer " + localStorage.getItem("token"),
                    "visitor": localStorage.getItem("visitor")
                },
                contentType: 'application/json; charset=UTF-8',
                success: func,
                error: function (e) {
                    layer.msg(JSON.stringify(e));
                }
            });

        }
    }
}();
var HttpMethod = function () {
    return {
        GET: "GET",
        POST: "POST",
        PUT: "PUT",
        DELETE: "DELETE"
    }
}();
var URL = function () {
    var _baseUrl = "/";
    return {
        management: {
            widgetInfo: {
                getWidgetInfo: _baseUrl + "management/widgetInfo/getWidgetInfo"
            },
            userInfo: {
                getUserInfo: _baseUrl + "management/userInfo/getUserInfo/"
            }
        }
    };
}();


var User = function () {
    return {
        setUserInfo: function () {
            var userId = localStorage.getItem("userId");
            if (!userId) return null;
            var _user = null;
            HttpHelper.syncGet(URL.management.userInfo.getUserInfo + localStorage.getItem("userId"), function (data, status, xhr) {
                var result = checkResult(data);
                if (result !== null) window.UserInfo = result;
            });
        }
    }
}();

function checkResult(data) {
    var result = eval('(' + JSON.stringify(data) + ')');
    if (result.code === 200) {
        return result.data;
    } else {
        layer.msg(result.message);
        return null;
    }
}
