var FormDesinger = function () {
    var drake;
    var drakeInit = function drakeInit(colCount) {
        var panels = [];
        panels.push(document.getElementById("formPanel"));
        var controls = document.getElementsByClassName("sub-menu");
        for (i = 0; i < controls.length; i++) {
            panels.push(controls[i]);
        }
        drake = dragula(panels, {
            columnsCount: colCount,
            controlStyle: "control-shadow",
            copy: function (el, source) {
                return source.classList[0] === "sub-menu";
                //return source === document.getElementById("controlPanel");
            },
            accepts: function (el, target) {
                return target.classList[0] !== "sub-menu";
            }
        }).on("drag", function (el, source) {

        }).on("shadow", function (el, container, source) {

        }).on("drop", function (el, target, source, sibling) {

            var cType = el.getAttribute("controltype");
            if (cType === "1") {
                var html = "<div class=\"form-group\">\n" +
                    "           <label class=\"control-label\">标签</label>\n" +
                    "           <div>\n" +
                    "               <input type=\"text\" class=\"form-control input-sm\" placeholder=\"提示\">\n" +
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

    function sizeInit() {
        $("#formPanel").css("height", "300px");
         // alert(3);
    }

    return {
        drakeInit: function (colCount) {
            drakeInit(colCount);
        },
        drakeDispose: function () {
            if (drake) {
                drake.destroy();
            }
        },
        sizeInit: function () {
            sizeInit();
        }
    };
}();

