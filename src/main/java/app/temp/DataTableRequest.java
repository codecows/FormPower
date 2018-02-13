package app.temp;

import java.util.List;

public class DataTableRequest {
    private int draw;
    private List<DataTableColumn> columns;
    private List<DataTableOrder> order;
    private int start;
    private int length;
    private DataTableSearch search;

    public int getDraw() {
        return draw;
    }

    public void setDraw(int draw) {
        this.draw = draw;
    }

    public List<DataTableColumn> getColumns() {
        return columns;
    }

    public void setColumns(List<DataTableColumn> columns) {
        this.columns = columns;
    }

    public List<DataTableOrder> getOrder() {
        return order;
    }

    public void setOrder(List<DataTableOrder> order) {
        this.order = order;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public DataTableSearch getSearch() {
        return search;
    }

    public void setSearch(DataTableSearch search) {
        this.search = search;
    }
}

