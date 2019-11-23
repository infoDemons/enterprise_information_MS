package com.demon.dbserver.controller;

import com.demon.dbserver.bean.Value;
import com.demon.dbserver.common.ResultCode;
import com.demon.dbserver.service.ValueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/value")
public class ValueController {

    @Autowired
    private ValueService valueService;

    @GetMapping("/all")
    public List<Value> getAllValues() {
        return valueService.getAllValues();
    }

    @GetMapping("/{id}")
    public Value getValueById(@PathVariable Integer id) {
        return valueService.getValueById(id);
    }

    @PostMapping("/add")
    public ResultCode addValue(Value value) {
        if (valueService.addValue(value)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }

    @PostMapping("/delete")
    public ResultCode deleteValue(Integer id) {
        if (valueService.deleteValue(id)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }

    @PostMapping("/update")
    public ResultCode updateValue(Value value) {
        if (valueService.updateValue(value)) {
            return ResultCode.SUCCESS;
        } else {
            return ResultCode.FAILED;
        }
    }
}
