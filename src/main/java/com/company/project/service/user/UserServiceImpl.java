package com.company.project.service.user;

import com.company.project.dao.userbase.UserBaseDao;
import com.company.project.dao.userbase.UserBaseEO;
import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("userService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserBaseDao userBaseDao = null;

    @Override
    public PageList<UserBaseEO> getUserPageLt(String prName, int pageNo, int pageSize) {
        return userBaseDao.getUserPageLt(prName, pageNo, pageSize);
    }
}
