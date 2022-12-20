package org.crudDemo.controller;

import org.crudDemo.model.Manager;
import org.crudDemo.service.ManagerDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.List;

@RestController
public class ManagerController {

    @Autowired
     private ManagerDAO dao;

    @GetMapping("/manager")
    public List<Manager> get(){
        return dao.getAll();
    }

    @GetMapping("/manager/{id}")
    public Manager get(@PathVariable int id){
        return dao.getById(id);
    }


    @PostMapping("/manager")
    public  String save(@RequestBody Manager manager)
    {
        return dao.save(manager)+"Rows Added";
    }


    @PutMapping("/manager/{id}")
    public int update(@RequestBody Manager manager,@PathVariable int id)
    {
        return dao.update(manager,id);
    }

    @DeleteMapping("/manager/{id}")
     public  int delete(@PathVariable int id)
    {
        return dao.delete(id);
    }

}
