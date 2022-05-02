package com.RM.Challengue.Controller;

import com.RM.Challengue.dto.RootObjectSchema;
import com.RM.Challengue.Service.RMService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RMController {

    @Autowired
    private RMService rMService;

    @RequestMapping("/{id}")
    public RootObjectSchema rMapi(@PathVariable("id") int id) {
        return rMService.rMService(id);
    }
}
