var MainMenu = function () {
    return {
        loadMenus: function () {
            if (window.UserInfo === null) return;
            var sysMenus = window.UserInfo.systemMenus;
            var html = "";
            $.each(sysMenus, function (index, item) {
                var ico = "fa fa-book";//todo 需要替换
                html += "<li class=\"heading\">\n" +
                    "   <h3 class=\"uppercase\"><i class=\"" + ico + "\"></i>" + item.menuName + "</h3>\n" +
                    "  </li>";
                $.each(item.groupMenuList, function (index, item1) {
                    html += "<li>\n" +
                        "    <a href=\"javascript:;\">\n" +
                        "        <i class=\"" + ico + "\"></i>\n" +
                        "        <span class=\"title\">" + item1.menuName + "</span>\n" +
                        "        <span class=\"arrow\"></span>\n" +
                        "    </a>\n" +
                        "    <ul class=\"sub-menu\">\n";

                    $.each(item1.menuPojoList, function (index, item2) {
                        html += "<li>\n" +
                            "    <a href=\"../../index.html\">\n" +
                            "        <i class=\"" + ico + "\"></i>" + item2.menuName + "</a>\n" +
                            "    </li>";
                    });
                    html += "</ul></li>";
                });


                // <li>
                // <a href="javascript:;">
                //     <i class="icon-home"></i>
                //     <span class="title">系统</span>
                //
                //     <span class="arrow open"></span>
                //     </a>
                //     <ul class="sub-menu">
                //     <li>
                //     <a href="../../index.html">
                //     <i class="icon-bar-chart"></i>
                // 设置</a>
                // </li>
                // <li>
                // <a href="index_2.html">
                //     <i class="icon-bulb"></i>
                // 初始化</a>
                // </li>
                // <li>
                // <a href="index_3.html">
                //     <i class="icon-graph"></i>
                // 用户</a>
                // </li>
                // </ul>
                // </li>


            });
            if (html.length <= 0) return
            $(".page-sidebar-menu").empty();
            $(".page-sidebar-menu").append(html);

        }
    }
}();