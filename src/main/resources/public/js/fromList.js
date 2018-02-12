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
    }

    //显示查询表格
    function showTableCollapse() {
        $(".collapse:not(#collapseTable)").collapse('hide');
        $("#collapseTable").collapse('show');
    }

    return {
        init: function () {
            collapseInit();

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

            /*
             * Insert a 'details' column to the table
             */
            var nCloneTh = document.createElement('th');
            nCloneTh.className = "table-checkbox";

            var nCloneTd = document.createElement('td');
            nCloneTd.innerHTML = '<span class="row-details row-details-close"></span>';

            table.find('thead tr').each(function () {
                this.insertBefore(nCloneTh, this.childNodes[0]);
            });

            table.find('tbody tr').each(function () {
                this.insertBefore(nCloneTd.cloneNode(true), this.childNodes[0]);
            });


            var setting = DataTablesSettings.init();
            setting.columnDefs = [{
                "orderable": false,
                "targets": [0]
            }];
            setting.order = [
                [1, 'asc']
            ];

            setting.lengthMenu = [
                [5, 15, 20, -1],
                [5, 15, 20, "全部"] // change per page values here
            ];

            var oTable = table.dataTable(setting);

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
                oTable.fnset
            });

        }
    };
}();