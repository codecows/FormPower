var MainMenu = function () {
    return {
        loadModule:function () {
            alert("111");
            // if (window.UserInfo === null) return;
            // var sysMenus = window.UserInfo.systemMenus;
            // var html = "";
            // $.each(sysMenus, function (index, item) {
            //     var ico = "fa fa-book";//todo 需要替换
            //     html += "<li class=\"heading\">\n" +
            //         "   <h3 class=\"uppercase\">" + item.menuName + "</h3>\n" +
            //         "  </li>";
            //     $.each(item.groupMenuList, function (index, item1) {
            //         html += "<li>\n" +
            //             "    <a href=\"javascript:;\">\n" +
            //             "        <i class=\"" + ico + "\"></i>\n" +
            //             "        <span class=\"title\">" + item1.menuName + "</span>\n" +
            //             "        <span class=\"arrow\"></span>\n" +
            //             "    </a>\n" +
            //             "    <ul class=\"sub-menu\">\n";
            //
            //         $.each(item1.menuList, function (index, item2) {
            //             html += "<li>\n" +
            //                 "    <a class='ajaxify' href=\"/pages/forms/formList.html\">\n" +
            //                 "        <i class=\"" + ico + "\"></i>" + item2.menuName + "</a>\n" +
            //                 "    </li>";
            //         });
            //         html += "</ul></li>";
            //     });
            // });
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