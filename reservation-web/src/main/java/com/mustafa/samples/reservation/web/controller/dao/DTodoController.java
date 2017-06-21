package com.mustafa.samples.reservation.web.controller.dao;

import com.mebitech.robe.log.entity.CrudType;
import com.mebitech.robe.log.service.OperationLogService;
import com.mebitech.robe.persistence.api.criteria.Result;
import com.mebitech.robe.persistence.api.query.search.SearchModel;
import com.mebitech.robe.security.core.annotation.Auth;
import com.mustafa.samples.reservation.dao.TodoDao;
import com.mustafa.samples.reservation.domain.Todo;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * Created by kamilbukum on 06/03/2017.
 */
@RestController
@RequestMapping(value = "dao-todos")
@Transactional
public class DTodoController {

    @Autowired
    private TodoDao todoDao;
    @Autowired
    private OperationLogService operationLogService;

    @RequestMapping(method = RequestMethod.GET)
    public List<Todo> findAll(SearchModel model) {
        operationLogService.saveLog("Deneme", CrudType.SELECT);
        return todoDao.findAllStrict(model).getList();
    }

    @ApiOperation(value = "Todo Bilgilerini Görüntüleme", nickname = "dao-todosSecureGET")
    @Auth
    @RequestMapping(value = "secure", method = RequestMethod.GET)
    public List<Todo> findAllSecure(SearchModel model) {
        return todoDao.findAllStrict(model).getList();
    }

    @RequestMapping(method = RequestMethod.POST)
    public Todo create(@RequestBody Todo todo) {
        return todoDao.create(todo);
    }


    @RequestMapping(method = RequestMethod.DELETE, value = "{oid}")
    public Todo delete(@PathVariable("oid") Long id) {
        return todoDao.delete(id);
    }

    @RequestMapping(value = "select", method = RequestMethod.GET)
    public Result<Map<String, Object>> findAllSelect(SearchModel model) {
        String[] fields = {"oid","header"};
        model.setFields(fields);
        return todoDao.findAll(model);
    }

    @RequestMapping(value = "properties", method = RequestMethod.GET)
    public List properties() {
        return todoDao.getProperties();
    }
}
