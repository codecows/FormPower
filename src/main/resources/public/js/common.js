var HttpHelper = function () {
    return {
        ajax: function (url, type, data, func) {
            if (!type) type = "GET";
            if (!data) data = {};
            if ((!url)) return;
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
                getWidgetInfo: _baseUrl + "management/widgetInfo/getWidgetInfo",
                getWidgetInfoType: HttpMethod.GET
            },
            userInfo: {
                getUserInfo: _baseUrl + "management/userInfo/getUserInfo/",
                getUserInfoType: HttpMethod.GET
            },
            form: {
                getFromList: _baseUrl + "form/getFormList/",
                getFromListType: HttpMethod.GET
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

var DataTablesSettings = function () {
    return {
        init: function () {
            return {
                "language": {
                    "decimal": ".",
                    "thousands": ",",
                    "emptyTable": "表格为空",
                    "info": "显示_START_~_END_行/共_TOTAL_行",
                    "infoEmpty": "共找到 0 条数据",
                    "infoFiltered": "(filtered from _MAX_ total entries)",
                    "infoPostFix": "",
                    "lengthMenu": "_MENU_行/页",
                    "loadingRecords": "数据载入中...",
                    "processing": "加载中...",
                    "search": "查找:",
                    "zeroRecords": "共找到 0 条数据",
                    "paginate": {
                        "first": "首页",
                        "last": "尾页",
                        "next": "下一页",
                        "previous": "上一页"
                    }
                },
                "pagingType": "full_numbers",
                "processing": true,
                "serverSide": true,
                "pageLength": 10,
                "dom": "" +
                "<'row'<'col-md-12'tr>>" +
                "<'row'<'col-md-3'l><'col-md-2'i><'col-md-7'p>>",
                "aria": {
                    "sortAscending": ": 升序",
                    "sortDescending": ": 降序"
                }
            };
        }
    }
}();
