var FormList = function () {
    var collapseInit = function () {
        //collapse状态初始化
        $(".collapse").collapse({toggle: false});
        $("#collapseTable").collapse('show');

        $("#btnAddForm").click(function () {
            $("#collapseAddForm").hasClass("in") ? showTableCollapse() : showAddFormCollapse();
        });

        $("#btnSelect").click(function () {
            $("#collapseSelect").hasClass("in") ? showTableCollapse() : showSelectCollapse();
        });
    }

    //显示查询面板
    function showSelectCollapse() {
        $(".collapse:not(#collapseSelect)").collapse('hide');
        $("#collapseSelect").collapse('show');
    }

    //显示新建表单
    function showAddFormCollapse() {
        $(".collapse:not(#collapseAddForm)").collapse('hide');
        $("#collapseAddForm").collapse('show');
        toggleProtletFullscreen();
    }

    //显示查询表格
    function showTableCollapse() {
        $(".collapse:not(#collapseTable)").collapse('hide');
        $("#collapseTable").collapse('show');
    }

    //portlet全屏切换
    function toggleProtletFullscreen() {
        var portlet = $(".portlet");
        if (portlet.hasClass('portlet-fullscreen')) {
            portlet.removeClass('on');
            portlet.removeClass('portlet-fullscreen');
            $('body').removeClass('page-portlet-fullscreen');
            portlet.children('.portlet-body').css('height', 'auto');
        } else {
            var height = Metronic.getViewPort().height -
                portlet.children('.portlet-title').outerHeight() -
                parseInt(portlet.children('.portlet-body').css('padding-top')) -
                parseInt(portlet.children('.portlet-body').css('padding-bottom'));

            $(this).addClass('on');
            portlet.addClass('portlet-fullscreen');
            $('body').addClass('page-portlet-fullscreen');
            portlet.children('.portlet-body').css('height', height);
        }
    }

    //按钮事件绑定
    function btnClickBind() {
        // $("#btnDesignForm").click(function () {
        //
        // });

        $("#btnSaveFormDesign").click(function () {
            alert("保存设计");
            //FIXME 未完
            toggleProtletFullscreen();
            showTableCollapse();
        });

        var designCanvas = $("#designCanvas");

        designCanvas.on('click', "[type='removeBtn']", function (event) {
            event.stopPropagation();
            $(this).parent().parent().remove();
        });
        designCanvas.on('click', "[type='copyBtn']", function (event) {
            event.stopPropagation();
            var clone = $(this).parent().parent().clone();
            if (clone.hasClass("control-shadow-active")) {
                clone.removeClass("control-shadow-active")
            }
            $(this).parent().parent().after(clone);
        });
        //fixme  选中变色
        designCanvas.on('click', ".control-shadow", function () {
            var the = $(this);
            if (the.hasClass("control-shadow-active")) {
                return;
            }
            $(".control-shadow-active").removeClass("control-shadow-active");
            the.addClass("control-shadow-active")
            showProperty();
        });
    }

    //显示控件属性
    function showProperty() {
        var the = $(".control-shadow-active");
        var html = "<div class='form-group'>\n" +
            "            <label class='control-label'>宽度</label>\n" +
            "            <div>" +
            "               <input propertyType='colMdValue' type='number' max='12' min='2' class='form-control input-sm' placeholder='2-12'" +
            "                    value='" + the.attr("colMdValue") + "'>" +
            "             </div>\n" +
            "       </div>"
        $("#propertyCanvas").empty();
        $("#propertyCanvas").append(html);
        $("input[propertyType='colMdValue']").on('input propertychange', function () {
            the.removeClass("col-md-" + the.attr("colMdValue"));
            the.addClass("col-md-" + $(this).val());
            the.attr("colMdValue", $(this).val())
        });

    }


    function datatableInit() {
        var table = $('#fromListTable');

        /* Formatting function for row expanded details */
        function fnFormatDetails(oTable, nTr) {
            var aData = oTable.fnGetData(nTr);
            var sOut = '<table>';
            sOut += '<tr><td>Platform(s):</td><td>' + aData[2] + '</td></tr>';
            sOut += '<tr><td>Engine version:</td><td>' + aData[3] + '</td></tr>';
            sOut += '<tr><td>CSS grade:</td><td>' + aData[4] + '</td></tr>';
            sOut += '<tr><td>Others:</td><td>Could provide a link here</td></tr>';
            sOut += '</table>';

            return sOut;
        }


        var setting = DataTablesSettings.init();
        setting.columnDefs = [{
            "orderable": false,
            "targets": [0]
        }];
        setting.order = [
            [0, 'asc']
        ];

        setting.columns = [
            // {
            //     "data": null,
            //     defaultContent: "<span class = 'row-details row-details-close'> </span>",
            //     "orderable": false
            // },
            {"data": "formId"},
            {"data": "formName"},
            {"data": "remark"},
            {"data": "inUse"}
        ];

        setting.lengthMenu = [
            [5, 15, 20, -1],
            [5, 15, 20, "全部"] // change per page values here
        ];

        setting.ajax = function (data, callback, settings) {
            var base64Data = Base64.encode(JSON.stringify(data));
            HttpHelper.ajax(URL.management.form.getFromList + base64Data, "GET", data,
                function (respose) {
                    callback(respose.data);
                    insertOperationColumn();
                });
        };

        //datatable初始化
        var oTable = table.dataTable(setting);

        //插入操作列
        function insertOperationColumn() {
            /*
                 * Insert a 'details' column to the table
                 */
            var nCloneTh = document.createElement('th');
            nCloneTh.className = "table-checkbox";

            var nCloneTd = document.createElement('td');
            nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';

            var nOpTh = document.createElement('th');
            nOpTh.innerHTML = "操作";
            var opTd = document.createElement('td');
            opTd.setAttribute('style', 'white-space : normal nowrap');
            opTd.style.setProperty("white-space", "nowrap")
            var nCloneSel = document.createElement("a");
            nCloneSel.name = "tableSelBtn";
            nCloneSel.classList.add("btn", "btn-xs", "yellow");
            nCloneSel.innerHTML = "<i class='fa fa-check'></i></a>";
            var nCloneEdit = document.createElement("a");
            nCloneEdit.name = "tableEditBtn";
            nCloneEdit.classList.add("btn", "default", "btn-xs", "green");
            nCloneEdit.innerHTML = "<i class='fa fa-edit'></i>";
            var nCloneDel = document.createElement("a");
            nCloneDel.name = "tableDelBtn";
            nCloneDel.classList.add("btn", "default", "btn-xs", "purple");
            nCloneDel.innerHTML = "<i class='fa fa-trash-o'></i>";
            opTd.appendChild(nCloneSel);
            opTd.appendChild(nCloneEdit);
            opTd.appendChild(nCloneDel);

            table.find('thead tr').each(function () {
                this.insertBefore(nCloneTh, this.childNodes[0]);
                this.appendChild(nOpTh.cloneNode(true));
            });

            table.find('tbody tr').each(function () {
                this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
                this.appendChild(opTd.cloneNode(true));
            });
        }

        // table.find("tbody").on('click', 'tr', function () {
        //     if ($(this).hasClass('active')) {
        //         $(this).removeClass('active');
        //     }
        //     else {
        //         table.find('tbody > tr.active').removeClass('active');
        //         $(this).addClass('active');
        //     }
        // });

        //表格内按钮事件 -- 选择
        table.on('click', " tbody td a[name = 'tableSelBtn']", function () {
            var tr = $(this).parents('tr');
            if (tr.hasClass('active')) {
                tr.removeClass('active');
            }
            else {
                table.find('tbody > tr.active').removeClass('active');
                tr.addClass('active');
            }
            // var nTr = $(this).parents('tr')[0];
            // if (oTable.fnIsOpen(nTr)) {
            //     /* This row is already open - close it */
            //     $(this).addClass("row-details-close").removeClass("row-details-open");
            //     oTable.fnClose(nTr);
            // } else {
            //     /* Open this row */
            //     $(this).addClass("row-details-open").removeClass("row-details-close");
            //     oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
            // }
        });

        table.on('click', " tbody td a[name = 'tableEditBtn']", function () {
            alert("我是编辑按钮");
        });

        table.on('click', " tbody td a[name = 'tableDelBtn']", function () {
            alert("我是删除按钮");
        });


        // { "data": null, defaultContent: "", "orderable": false },

        //var tableWrapper = $('#sample_4_wrapper'); // datatable creates the table wrapper by adding with id {your_table_jd}_wrapper
        var tableColumnToggler = $('#sample_4_column_toggler');

        /* modify datatable control inputs */
        //tableWrapper.find('.dataTables_length select').select2(); // initialize select2 dropdown

        /* Add event listener for opening and closing details
         * Note that the indicator for showing which row is open is not controlled by DataTables,
         * rather it is done here
         */
        table.on('click', ' tbody td .row-details', function () {
            var nTr = $(this).parents('tr')[0];
            if (oTable.fnIsOpen(nTr)) {
                /* This row is already open - close it */
                $(this).addClass("row-details-close").removeClass("row-details-open");
                oTable.fnClose(nTr);
            } else {
                /* Open this row */
                $(this).addClass("row-details-open").removeClass("row-details-close");
                oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
            }
        });

        /* handle show/hide columns*/
        $('input[type="checkbox"]', tableColumnToggler).change(function () {
            /* Get the DataTables object again - this is not a recreation, just a get of the object */
            var iCol = parseInt($(this).attr("data-column"));
            var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
            oTable.fnSetColumnVis(iCol, (bVis ? false : true));

        });
    }

    var drake;

    function drakeInit(colCount) {
        var panels = [];
        panels.push(document.getElementById("designCanvas"));
        var controls = document.getElementsByClassName("control");
        for (i = 0; i < controls.length; i++) {
            panels.push(controls[i]);
        }
        drake = dragula(panels, {
            mirrorContainer: $(".portlet")[0],//设置拖拽父容器,避免portlet全屏时候无法看到镜像
            controlStyle: "control-shadow",
            copy: function (el, source) {
                return source.classList[0] === "control";
                // alert(source.innerHTML);
                // return source.name === "control";
                //return source === document.getElementById("controlPanel");
            },
            accepts: function (el, target) {
                return target.classList[0] !== "control";
                // return target.id === "designCanvas";
            }
        }).on("drag", function (el, source) {

        }).on("shadow", function (el, container, source) {

        }).on("drop", function (el, target, source, sibling) {

            var cType = el.getAttribute("controltype");
            var jqEl = $(el);
            if (jqEl.attr("isReady")) {
                return;
            }

            function removeBtnBuilder() {
                var html = "<a href='javascript:;' type='removeBtn' class='btn btn-icon-only pull-right'>" +
                    "                    <i class='fa fa-times'></i>" +
                    "       </a>";
                return html;
            }

            function copyBtnBuilder() {
                var html = "<a href='javascript:;' type='copyBtn' class='btn btn-icon-only pull-right'>" +
                    "                    <i class='fa fa-copy'></i>\n" +
                    "       </a>";
                return html;
            }

            function formGroupBuilder(el) {
                var html = "<div class='form-group'>";
                html += removeBtnBuilder();
                html += copyBtnBuilder();
                html += el;
                html += "</div>";
                return html;
            }

            if (cType === "1") {
                var elHtml = "<label class='control-label'>标签</label>" +
                    "<div><input type='text' class='form-control input-sm' placeholder='提示'></div>";
                var html = formGroupBuilder(elHtml);
                jqEl.append(html)
                jqEl.attr("isReady", "true");
            }
            else if (cType === "2") {
                jqEl.text("啊啊啊22");
            } else {
                jqEl.text("啊啊啊333");
            }
        });
    }

    return {
        init: function () {
            collapseInit();
            btnClickBind();
            datatableInit();
        },
        drakeInit: function (colCount) {
            drakeInit(colCount)
        },
        drakeDispose: function () {
            if (drake) {
                drake.destroy();
            }
        },

    };
}
();