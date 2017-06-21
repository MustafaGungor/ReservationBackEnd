package com.mustafa.samples.reservation.web.controller.log;

import com.mebitech.robe.log.dao.OperationLogDao;
import com.mebitech.robe.log.entity.OperationLog;
import com.mebitech.robe.security.core.annotation.Auth;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by Ali Kızılırmak on 18.05.2017.
 */
@RestController
@RequestMapping(value = "logs")
@Transactional
public class OperationLogController {

    @Autowired
    private OperationLogDao operationLogDao;

    @Auth
    @ApiOperation(value = "Log Bilgilerini Görüntüleme",nickname = "logsGET")
    @RequestMapping(method = RequestMethod.GET)
    public List<OperationLog> findAll(){
        return operationLogDao.findAll();
    }
}
