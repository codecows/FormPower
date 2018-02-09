var MainMenu = function () {
    return {
        loadModule: function () {
            if (window.UserInfo === null) return;
            var sysMenus = window.UserInfo.systemMenus;

            var md1 = "<div class=\"col-md-4\">";
            var md2 = "<div class=\"col-md-4\">";
            var md3 = "<div class=\"col-md-4\">";
            $.each(sysMenus, function (index, item) {
                var ico = "fa fa-book";//todo 需要替换
                var _tempHtml = "<div menuId='" + item.menuId + "' class=\"top-news\">\n" +
                    "       <a href=\"#\" class=\"btn blue-hoki active\">\n" +
                    "       <span>" + item.menuName + "</span>";

                if (item.remark) {
                    var flags = item.remark.split(",");
                    $.each(flags, function (index1, item1) {
                        _tempHtml += "<em><i class=\"fa fa-tags\"></i>" + item1 + "</em>";
                    });
                }
                _tempHtml += "<i class=\"" + ico + " top-news-icon\"></i>\n" +
                    "       </a>\n" +
                    "    </div>";
                if (index % 3 === 0) {
                    md1 += _tempHtml;
                }
                if (index % 3 === 1) {
                    md2 += _tempHtml;
                }
                if (index % 3 === 2) {
                    md3 += _tempHtml;
                }
            });
            md1 += "</div>";
            md2 += "</div>";
            md3 += "</div>";
            var html = md1 + md2 + md3;
            // alert(html);
            if (html.length <= 0) return
            $(".news-page div.row").append(html);
        },
        loadMenus: function () {
            if (window.UserInfo === null) return;
            var sysMenus = window.UserInfo.systemMenus;
            var html = "";
            $.each(sysMenus, function (index, item) {
                var ico = "fa fa-book";//todo 需要替换
                html += "<li class=\"heading\">\n" +
                    "   <h3 class=\"uppercase\">" + item.menuName + "</h3>\n" +
                    "  </li>";
                $.each(item.groupMenuList, function (index, item1) {
                    html += "<li>\n" +
                        "    <a href=\"javascript:;\">\n" +
                        "        <i class=\"" + ico + "\"></i>\n" +
                        "        <span class=\"title\">" + item1.menuName + "</span>\n" +
                        "        <span class=\"arrow\"></span>\n" +
                        "    </a>\n" +
                        "    <ul class=\"sub-menu\">\n";

                    $.each(item1.menuList, function (index, item2) {
                        html += "<li>\n" +
                            "    <a class='ajaxify' href=\"/pages/forms/formList.html\">\n" +
                            "        <i class=\"" + ico + "\"></i>" + item2.menuName + "</a>\n" +
                            "    </li>";
                    });
                    html += "</ul></li>";
                });
            });
            if (html.length <= 0) return
            $(".page-sidebar-menu").remove("li:not(.start,.last,.sidebar-search-wrapper)");
            $(html).insertAfter($(".page-sidebar-menu li.start"));
            // Handle sidebar menu


        }
    }
}();