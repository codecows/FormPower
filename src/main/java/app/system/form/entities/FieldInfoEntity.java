package app.system.form.entities;

import app.dao.entities.SysAttributeInformation;
import app.dao.entities.SysFormInformation;

import java.util.List;

/**
 * Created by real on 2018/3/12.
 */
public class FieldInfoEntity extends SysFormInformation {

    List<SysAttributeInformation> sysAttributeInformations;

    public List<SysAttributeInformation> getSysAttributeInformations() {
        return sysAttributeInformations;
    }

    public void setSysAttributeInformations(List<SysAttributeInformation> sysAttributeInformations) {
        this.sysAttributeInformations = sysAttributeInformations;
    }
}
