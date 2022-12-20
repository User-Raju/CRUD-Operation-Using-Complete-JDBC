package org.crudDemo.service;

import org.crudDemo.model.Manager;

import java.util.List;

public interface ManagerDAO {
    int save(Manager manager);
    int update(Manager manager,int id);
    int delete(int id);

    List<Manager> getAll();

    Manager getById(int id);
}
