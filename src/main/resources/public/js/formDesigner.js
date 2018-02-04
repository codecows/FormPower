var FormDesinger = function () {
    var drake;
    var formInit = function formInit(colCount) {
        drake = dragula([document.getElementById("formPanel")
            , document.getElementById("controlPanel")], {
            columnsCount: colCount,
            controlStyle: "control-shadow",
            copy: function (el, source) {
                return source === document.getElementById("controlPanel");
            },
            accepts: function (el, target) {
                return target !== document.getElementById("controlPanel");
            }
        }).on("drag", function (el, source) {
            var a = $("<div><button>11111</button></div>")
            el = a[0];

        }).on("shadow", function (el, container, source) {
            var b = $("<div>2222</div>");
            el = b[0];

        }).on("drop", function (el, target, source, sibling) {

            var cType = el.getAttribute("controltype");
            if (cType === "1") {
                var html = "<div id='F001' class=\"form-group\">\n" +
                    "           <label class=\"control-label col-md-3\">标签</label>\n" +
                    "           <div class=\"col-md-9\">\n" +
                    "               <input type=\"text\" class=\"form-control\" placeholder=\"提示\">\n" +
                    "           </div>\n" +
                    "       </div>";
                $(el).append(html)
            }
            else if (cType === "2") {
                $(el).text("啊啊啊22");
            } else {
                $(el).text("啊啊啊333");
            }
        });
    }

    return {
        init: function (colCount) {
            formInit(colCount);
        },
        dispose: function () {
            if (drake) {
                drake.destroy();
            }
        }
    };
}();

