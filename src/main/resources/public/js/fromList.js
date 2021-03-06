var FormList = function () {
    //collapse状态初始化
    var collapseInit = function () {
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
        $("#formPrefix").text(DbConstant.FormPrefix);

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
            // alert("/operation/createFunction/" + $("#sqlTextArea").val().replace(/\n/g, "<br/>"));
            //FIXME 未完
            //TODO 测试用
            // var base64Data = Base64.encode($("#sqlTextArea").val().replace(/\n/g, "<br/>"));
            // HttpHelper.ajax("/operation/createFunction/" + base64Data, "GET", null,
            //     function (respose) {
            //
            //
            //     });
            toggleProtletFullscreen();
            showTableCollapse();
        });

        var designCanvas = $("#designCanvas");

        designCanvas.on('click', "[type='removeBtn']", function (event) {
            event.stopPropagation();
            $(this).parent().remove();
        });
        designCanvas.on('click', "[type='copyBtn']", function (event) {
            event.stopPropagation();
            var clone = $(this).parent().clone();
            if (clone.hasClass("control-active")) {
                clone.removeClass("control-active")
            }
            $(this).parent().after(clone);
        });
        designCanvas.on('click', "[type='addTabBtn']", function (event) {
            event.stopPropagation();
            // var clone = $(this).parent().clone();
            // if (clone.hasClass("control-active")) {
            //     clone.removeClass("control-active")
            // }
            // $(this).parent().after(clone);
            var tabId = getTabId();
            designCanvas.find(".nav-tabs").append(getTabTitleHtml(tabId, false));
            designCanvas.find(".tab-content").append(getTabPaneHtml(tabId, false));

        });
        designCanvas.on('click', "[type='editColumnBtn']", function (event) {
            event.stopPropagation();
            $("#editColModal").modal("show");
            var title = designCanvas.find(".nav-tabs li.active a").text();
            $("#editColModal").find("h4").text("[" + title + "] - 编辑列");

        });

        $("#dataSourceBtn").click(function () {
            $("#dataSourceModal").modal("show");
        });

        // elHtml = addTabBtn + "&nbsp;" + removeTabContrl +
        //     "<div class='tabbable-line'>" +
        //     "    <ul class='nav nav-tabs '>" +
        //     getTabTitleHtml(tabId, true) +
        //     "    </ul>" +
        //     "    <div class='tab-content'>" +
        //     getTabPaneHtml(tabId, true) +
        //     "    </div>" +
        //     "</div> ";


        //fixme  选中变色
        designCanvas.on('click', ".control-shadow", function () {
            var the = $(this);
            if (the.hasClass("control-active")) {
                return;
            }
            $(".control-active").removeClass("control-active");
            the.addClass("control-active")
            showProperty($(".control-active"));
        });
    }

    //显示控件属性
    function showProperty(activeControl) {
        // var the = $(".control-active");
        $("#propertyCanvas").empty();
        switch (activeControl.attr("controltype")) {
            case "1001":
                ControlProperty.showCode(activeControl);
                ControlProperty.showDesc(activeControl);
                ControlProperty.showWidth(activeControl);
                ControlProperty.showPrompt(activeControl);
                ControlProperty.showFormat(activeControl);
                ControlProperty.showLength(activeControl);
                ControlProperty.showDefault(activeControl);
                ControlProperty.showRegEx(activeControl);
                ControlProperty.showOptions(activeControl);

                break;
            case "1002":
                ControlProperty.showCode(activeControl);
                ControlProperty.showWidth(activeControl);
                ControlProperty.showFormat(activeControl);
                ControlProperty.showOptions(activeControl);
                ControlProperty.showDataSoucre(activeControl);
                break;
        }

    }

    //表格初始化
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
            [5, 10, 15, 20, 50, -1],
            [5, 10, 15, 20, 50, "全部"] // change per page values here
        ];

        setting.ajax = function (data, callback, settings) {
            var base64Data = Base64.encode(JSON.stringify(data));
            HttpHelper.ajax(URL.system.form.getFromList + base64Data, "GET", data,
                function (respose) {
                    //alert(JSON.stringify(respose.data));
                    callback(respose.data);
                    if (respose.data.size() > 0) {
                        appendOperationColumn();
                    }

                });
        };

        //datatable初始化
        var oTable = table.dataTable(setting);
        ~function appendOperationColumnHeader() {
            var nOpTh = document.createElement('th');
            nOpTh.innerHTML = "操作";
            table.find('thead tr').each(function () {
                // this.insertBefore(nCloneTh, this.childNodes[0]);
                this.appendChild(nOpTh.cloneNode(true));
            });
        }();


        //插入操作列
        function appendOperationColumn() {
            /*
                 * Insert a 'details' column to the table
                 */
            // var nCloneTh = document.createElement('th');
            // nCloneTh.className = "table-checkbox";
            //
            // var nCloneTd = document.createElement('td');
            // nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';


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
            var nCloneDetails = document.createElement("a");
            nCloneDetails.name = "tableDetBtn";
            nCloneDetails.classList.add("btn", "default", "btn-xs", "bg-green-haze");
            nCloneDetails.innerHTML = "<i class='fa fa-plus-square-o'></i>";

            opTd.appendChild(nCloneDetails);
            opTd.appendChild(nCloneSel);
            opTd.appendChild(nCloneEdit);
            opTd.appendChild(nCloneDel);


            table.find('tbody tr').each(function () {
                // this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
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

        table.on('click', " tbody td a[name = 'tableDetBtn']", function () {
            var nTr = $(this).parents('tr')[0];
            if (oTable.fnIsOpen(nTr)) {
                /* This row is already open - close it */
                $(this).find("i").addClass("fa-plus-square-o").removeClass("fa-minus-square-o");
                oTable.fnClose(nTr);
            } else {
                /* Open this row */
                $(this).find("i").addClass("fa-minus-square-o").removeClass("fa-plus-square-o");
                oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
            }
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
        // table.on('click', ' tbody td .row-details', function () {
        //     var nTr = $(this).parents('tr')[0];
        //     if (oTable.fnIsOpen(nTr)) {
        //         /* This row is already open - close it */
        //         $(this).addClass("row-details-close").removeClass("row-details-open");
        //         oTable.fnClose(nTr);
        //     } else {
        //         /* Open this row */
        //         $(this).addClass("row-details-open").removeClass("row-details-close");
        //         oTable.fnOpen(nTr, fnFormatDetails(oTable, nTr), 'details');
        //     }
        // });

        /* handle show/hide columns*/
        $('input[type="checkbox"]', tableColumnToggler).change(function () {
            /* Get the DataTables object again - this is not a recreation, just a get of the object */
            var iCol = parseInt($(this).attr("data-column"));
            var bVis = oTable.fnSettings().aoColumns[iCol].bVisible;
            oTable.fnSetColumnVis(iCol, (bVis ? false : true));

        });
    }

    var drake;

    //拖动初始化
    function drakeInit() {
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
                var html = "<a href='javascript:;' type='removeBtn' style='margin: 0px;padding: 0px' class='pull-right'>" +
                    "                    <i class='fa fa-times'></i>" +
                    "       </a>";
                return html;
            }

            function copyBtnBuilder() {
                var html = "<a href='javascript:;' type='copyBtn' style='margin: 0px;padding: 0px' class='pull-right'>" +
                    "                    <i class='fa fa-copy'></i> &nbsp;" +
                    "       </a>";
                return html;
            }

            function formGroupBuilder(el) {
                var html = "";
                // var html = "<div class='form-group'>";
                html += removeBtnBuilder();
                html += copyBtnBuilder();
                html += el;
                // html += "</div>";
                return html;
            }

            var elHtml = "";
            switch (cType) {
                case "1001":
                    // elHtml = formGroupBuilder("<label class='control-label'>标签</label>" +
                    //     "<div><input type='text' class='form-control input-sm' placeholder='文本'></div>");
                    elHtml = formGroupBuilder("<label class='control-label'>标签</label>" +
                        "<div><input type='text' class='form-control input-sm' placeholder='文本'></div>");
                    break;
                case "1002":
                    elHtml = formGroupBuilder("<label class='control-label'>多行文本</label>" +
                        "<div><textarea style='resize: none;' rows='3' class='form-control' placeholder='多行文本'></textarea>");
                    break;
                case "1003":
                    elHtml = formGroupBuilder("<label class='control-label'>日期</label>" +
                        "<div><input type='date' class='form-control input-sm' placeholder='日期'></div>");
                    break;
                case "1004":
                    elHtml = formGroupBuilder("<label class='control-label'>数字</label>" +
                        "<div><input type='number' class='form-control input-sm' placeholder='数字'></div>");
                    break;
                case "1005":
                    elHtml = formGroupBuilder("<label>单选按钮</label><div class='radio-list'>" +
                        "<label class='radio-inline'><div class='radio'><span><input type='radio' name='optionsRadios' value='option1'></span></div>单选1</label>" +
                        "<label class='radio-inline'><div class='radio'><span><input type='radio' name='optionsRadios' value='option2'></span></div>单选2</label>" +
                        "<label class='radio-inline'><div class='radio'><span><input type='radio' name='optionsRadios' value='option3'></span></div>单选3</label>" +
                        "</div>");
                    break;
                case "1006":
                    elHtml = formGroupBuilder("<label>选项</label><div class='checkbox-list'>" +
                        "<label class='checkbox-inline'><div class='checker'><span><input type='checkbox'></span></div>选项1</label>" +
                        "<label class='checkbox-inline'><div class='checker'><span><input type='checkbox'></span></div>选项2</label>" +
                        "<label class='checkbox-inline'><div class='checker'><span><input type='checkbox'></span></div>选项3</label>" +
                        "</div>");
                    break;
                case "1007":
                    elHtml = formGroupBuilder("<label class='control-label'>下拉列表</label>" +
                        "<select class='form-control input-sm'>" +
                        "<option>选项1</option>" +
                        "<option>选项2</option>" +
                        "<option>选项3</option>" +
                        "</select>");
                    break;

                case "2001":
                    elHtml = "分组标题";
                    break;
                case "2004":
                    var addTabBtn = "<a type='addTabBtn' href='javascript:;' class='btn btn-xs'><i class='fa fa-copy'></i> 添加子表 </a>";
                    var removeTabContrl = "<a type='removeTabContrl' href='javascript:;' class='btn btn-xs pull-right'><i class='fa fa-times'></i> </a>";


                    // var optionsHtml = "<div class='checkbox-list'>" +
                    //     "<label><div class='checker'><span><input type='checkbox'></span></div>合计</label>" +
                    //     "<label><div class='checker'><span><input type='checkbox'></span></div>排序</label>" +
                    //     "<label><div class='checker'><span><input type='checkbox'></span></div>显示</label>" +
                    //     "<label><div class='checker'><span><input type='checkbox'></span></div>可用</label>" +
                    //     "</div>";

                    var tabId = getTabId();

                    elHtml = addTabBtn + "&nbsp;" + removeTabContrl +
                        "<div class='tabbable-line'>" +
                        "    <ul class='nav nav-tabs '>" +
                        getTabTitleHtml(tabId, true) +
                        "    </ul>" +
                        "    <div class='tab-content'>" +
                        getTabPaneHtml(tabId, true) +
                        "    </div>" +
                        "</div> ";

                    break;

            }
            if (elHtml) {
                jqEl.append(elHtml);
                if (cType === "2001") {
                    jqEl.css('min-height', "0px");
                    jqEl.removeClass('form-group');
                    jqEl.removeClass('col-md-6');
                    jqEl.addClass('col-md-12');
                    jqEl.attr('colmdvalue', 12);
                    jqEl.addClass('form-section');
                }
                if (cType === "2004") {
                    jqEl.removeClass('form-group');
                    jqEl.removeClass('col-md-6');
                    jqEl.attr('colmdvalue', 12);
                    jqEl.addClass('col-md-12');
                    jqEl.css('padding', '0px 5px 0px 5px');
                }
                jqEl.attr("isReady", "true");
            }
        });
    }

    //生成子表Tab连接ID
    function getTabId() {
        return "tab" + new Date().getTime();
    }

    //生成子表TAB选项卡
    function getTabPaneHtml(tabId, active) {
        var delTabBtn = "<a type='delTabBtn' href='javascript:;' class='btn btn-xs'><i class='fa fa-recycle'></i> 删除子表 </a>";
        var editColumnBtn = "<a type='editColumnBtn' href='javascript:;' class='btn btn-xs'><i class='fa fa-edit'></i> 添加列 </a>";
        var tabHtml = "<table width='100%' class='table table-bordered'>" +
            "<thead>" +
            "<th>ID</th>" +
            "<th>列名</th>" +
            "<th>类型</th>" +
            "<th>标题</th>" +
            "<th>数据源</th>" +
            "<th>公式</th>" +
            "<th>合计</th>" +
            "<th>排序</th>" +
            "<th>显示</th>" +
            "<th>可用</th>" +
            "<th>最大值</th>" +
            "<th>最小值</th>" +
            "<th>数据长度</th>" +
            "</thead>" +
            "<tbody>" +
            "</tbody></table>";
        return "<div class='tab-pane " + (active ? "active" : "") + "' id='" + tabId + "'>" + tabHtml + delTabBtn + "&nbsp;" + editColumnBtn + "</div>";
    }

    //生成子表TAB选项卡标题
    function getTabTitleHtml(tabId, active) {
        return "<li " + (active ? "class = 'active'" : "") + "><a href='#" + tabId + "' data-toggle='tab' aria-expanded='true'> 子表 </a></li>";
    }

    //左侧控件栏初始化
    function controlInit() {
        HttpHelper.ajax(URL.system.widgetInfo.getWidgetInfo, URL.system.widgetInfo.getWidgetInfoType, null,
            function (respose) {
                var result = checkResult(respose);
                if (result === null) return;
                $.each(result, function (index, item) {
                    var html = "";
                    html += "<li groupId='" + item.groupId + "'><div><h4>" + item.groupName + "</h4></div>";
                    html += "<ul class='control'>";
                    $.each(item.widgets, function (index1, item1) {
                        html += "<li controltype='" + item1.fieldId + "'>";
                        html += "<a href='javascript:;'><i class='fa " + item1.img + "'></i>" + item1.fieldName + "</a>";
                        html += "</li>";
                    });
                    html += "</ul></li>";
                    $("ul.controls").append(html);
                });
                drakeInit();
            });
    }

    //FormList返回值
    return {
        init: function () {
            collapseInit();
            btnClickBind();
            datatableInit();
            controlInit();
        },
        drakeInit: function () {
            drakeInit()
        },
        drakeDispose: function () {
            if (drake) {
                drake.destroy();
            }
        }

    };
}();

//控件属性HTML模板
var PropertyHtmlBuilder = function () {
    return {
        buildDivFormGroup: function (attr, name, input) {
            var html = "<div class='form-group' propertyType = '" + attr + "'>";
            html += "<label class='control-label'>" + name + "</label><div>";
            html += input;
            html += "</div></div>"
            return html;
        }
    }
}();

//属性类型
var PropertyType = {
    code: "0",
    width: "1",
    prompt: "2",
    digits: "3",//小数位数
    format: "4",//格式
    regEx: "5",//正则
    length: "6",//数据长度
    max: "7",//最大值
    min: "8",//最小值
    default: "9",//默认值
    formula: "10",//公式
    dataSource: "11",//数据源
    options: "12",//选项
    desc: "13"//描述
};

//控件属性
var ControlProperty = function () {
    return {
        //编码 FIXME JACK code需要赋值
        showCode: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.code, "控件编码",
                "<input class='form-control input-sm' readonly type='text'/>"
            ));
        },
        //宽度
        showWidth: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.width, "宽度",
                "<input class='form-control input-sm' " +
                "type='number' max='12' min='2' placeholder='2-12'" +
                "value='" + activeControl.attr('colMdValue') + "' />"
            ));
            var _tempInput = $("div[propertyType='" + PropertyType.width + "'] input");
            _tempInput.unbind();
            _tempInput.on('input propertychange', function () {
                activeControl.removeClass("col-md-" + activeControl.attr("colMdValue"));
                activeControl.addClass("col-md-" + $(this).val());
                activeControl.attr("colMdValue", $(this).val())
            });
        },
        //提示语
        showPrompt: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.prompt, "提示语",
                "<input class='form-control input-sm' type='text' placeholder='请输入提示语'/>"
            ));
            var _tempInput = $("div[propertyType='" + PropertyType.prompt + "'] input");
            _tempInput.unbind();
            _tempInput.on('input propertychange', function () {
                activeControl.attr("prompt", _tempInput.val())
                activeControl.find("input").attr("placeholder", _tempInput.val());
            });
        },
        //小数位数 FIXME JACK 未编写事件
        showDigits: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.digits, "小数位数",
                "<input class='form-control input-sm' type='number' max='0' min='6' value='0' placeholder='0-6'/>"
            ));
        },
        //格式 FIXME JACK 未编写事件
        showFormat: function (activeControl) {
            var html = "<div class='form-group'>\n" +
                "        <label>格式</label>\n" +
                "        <select class='form-control input-sm'>\n" +
                "        <option>普通</option>\n" +
                "        <option>邮箱</option>\n" +
                "        <option>手机</option>\n" +
                "        </select>\n" +
                "        </div>";
            $("#propertyCanvas").append(html);
        },
        //正则 FIXME JACK 未编写事件
        showRegEx: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.regEx, "正则",
                "<input class='form-control input-sm' type='text' placeholder='请输入正则表达式'/>"
            ));
        },
        //长度
        showLength: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.length, "数据长度",
                "<input class='form-control input-sm' type='number' placeholder='请输入长度限制'/>"
            ));
            var _tempInput = $("div[propertyType='" + PropertyType.length + "'] input");
            _tempInput.unbind();
            _tempInput.on('input propertychange', function () {
                activeControl.attr("length", _tempInput.val());
            });
        },
        //最大值 FIXME JACK 未编写事件
        showMax: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.max, "最大值",
                "<input class='form-control input-sm' type='number' placeholder='请输入最大值'/>"
            ));
        },
        //最小值 FIXME JACK 未编写事件
        showMin: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.min, "最小值",
                "<input class='form-control input-sm' type='number' placeholder='请输入最小值'/>"
            ));

        },
        //默认值
        showDefault: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.default, "默认值",
                "<input class='form-control input-sm' type='text' placeholder='请输入默认值'/>"
            ));
            var _tempInput = $("div[propertyType='" + PropertyType.default + "'] input");
            _tempInput.unbind();
            _tempInput.on('input propertychange', function () {
                activeControl.attr("defaultValue", _tempInput.val());
            });
        },
        //公式 FIXME JACK 未编写事件
        showFormula: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.formula, "公式",
                "<input class='form-control input-sm' type='text' placeholder='请输入公式'/>"
            ));
        },
        //数据源 FIXME JACK 未编写事件
        showDataSoucre: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.dataSource, "数据源",
                "<input class='form-control input-sm' type='text' placeholder='请输入数据源'/>"
            ));
        },
        //选项
        showOptions: function (activeControl) {
            var html = " <label>选项</label><div class='checkbox-list'>" +
                "<label><div class='checker'><span><input id='readonlyChecker' name='option' type='checkbox'></span></div>只读</label>" +
                "<label><div class='checker'><span><input id='hiddenChecker' name='option' type='checkbox'></span></div>隐藏</label>" +
                "<label><div class='checker'><span><input id='enableChecker' name='option' type='checkbox'></span></div>可用</label>" +
                "<label><div class='checker'><span><input id='sumChecker' name='option' type='checkbox'></span></div>合计</label>" +
                "</div>";
            $("#propertyCanvas").append(html);
            $("input[name='option']:checkbox").unbind();
            $("input[name='option']:checkbox").change(function () {
                var the = $(this);
                var isChecked = the.is(':checked');
                if (isChecked) {
                    if (!the.parent().hasClass("checked")) {
                        the.parent().addClass("checked");
                    }
                } else {
                    the.parent().removeClass("checked");
                }
                activeControl.attr("isReadonly", $("#readonlyChecker").is(':checked'));
                activeControl.attr("isHidden", $("#hiddenChecker").is(':checked'));
                activeControl.attr("isEnabled", $("#enableChecker").is(':checked'));
                activeControl.attr("isSum", $("#sumChecker").is(':checked'));
            });

        },
        //描述
        showDesc: function (activeControl) {
            $("#propertyCanvas").append(PropertyHtmlBuilder.buildDivFormGroup(
                PropertyType.desc, "描述",
                "<input class='form-control input-sm' type='text' placeholder='请输入提描述'/>"
            ));
            var _tempInput = $("div[propertyType='" + PropertyType.desc + "'] input");
            _tempInput.unbind();
            _tempInput.on('input propertychange', function () {
                activeControl.attr("desc", _tempInput.val())

                activeControl.find("label.control-label").text(_tempInput.val());
            });
        }

    };
}();

//FIXME Jack 控件与表单 编号生成
var SeqNo = function () {
    return {
        getSeqNo: function () {
            var canvas = $("#designCanvas");
            var count = canvas.children.length;
            canvas.each(function (index, el) {

            });

        }
    }
}();