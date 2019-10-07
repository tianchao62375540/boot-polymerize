package com.tcboot.mapper.test2;

import com.tcboot.model.User;

import java.util.List;

/**
 * Description:
 * <p>
 * ModelName:【】模块
 *
 * @author: TianChao
 * Create at:  2019/10/7 09:32
 * Company: 沈阳艾尔时代科技发展有限公司
 * Copyright: (c)2018 AIR Times Inc. All rights reserved.
 * @version: 1.0
 */
public interface User2Mapper {
    List<User> getAll();

    User getOne(Long id);

    void insert(User user);

    void update(User user);

    void delete(Long id);
}
