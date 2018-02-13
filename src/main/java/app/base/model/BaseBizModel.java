package app.base.model;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class BaseBizModel {
    private String createdBy = "";
    private String modifiedBy = "";
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date created = new Date();
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date modified = new Date();

    public String getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    public String getModifiedBy() {
        return modifiedBy;
    }

    public void setModifiedBy(String modifiedBy) {
        this.modifiedBy = modifiedBy;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getModifed() {
        return modified;
    }

    public void setModifed(Date modifed) {
        this.modified = modifed;
    }
}
