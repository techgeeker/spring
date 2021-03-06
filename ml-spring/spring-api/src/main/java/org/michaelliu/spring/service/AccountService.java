package org.michaelliu.spring.service;

import com.github.miemiedev.mybatis.paginator.domain.PageList;
import org.michaelliu.spring.beans.dto.Account;
import org.michaelliu.spring.beans.vo.AccountVo;

import javax.jws.WebService;
import java.util.List;

/**
 * Created by Michael on 7/14/16
 *
 * RMI: rmi://localhost:1199/rmi/AccountService
 * Hessian: http://localhost:8080/hessian/AccountService
 * cxf: http://localhost:8080/cxf/AccountService
 */
@WebService
public interface AccountService {

    int saveOrUpdateSelective(Account account) throws Exception;

    AccountVo findById(Long id);

    List<AccountVo> findByName(String name);

    PageList findPageListByName(String name, Integer page, Integer pageSize);

    PageList findPageListByIdList(List<Long> idList, Integer page, Integer pageSize);

}
