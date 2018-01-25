package app.converter;

import app.dao.entities.SysAuthority;
import app.model.Authority;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

/**
 * Created by real on 2018/1/25.
 */
@Component
public class AuthorityConverter extends ConverterBase<Authority,SysAuthority> {
    @Override
    public Authority convert2Model(SysAuthority sysAuthority) {
        Authority authority = new Authority();
        BeanUtils.copyProperties(sysAuthority, authority);
        return authority;
    }

    @Override
    public SysAuthority convert2Entity(Authority authority) {
        SysAuthority sysAuthority = new SysAuthority();
        BeanUtils.copyProperties(authority, sysAuthority);
        return sysAuthority;
    }
}
