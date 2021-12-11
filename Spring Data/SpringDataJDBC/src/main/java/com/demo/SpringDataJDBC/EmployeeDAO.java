package com.demo.SpringDataJDBC;

import java.util.List;
import java.util.Optional;

public interface EmployeeDAO<Table> {
    List<Table> list();

    Optional<Table> getById(int id);

    void add(Table table);
}
