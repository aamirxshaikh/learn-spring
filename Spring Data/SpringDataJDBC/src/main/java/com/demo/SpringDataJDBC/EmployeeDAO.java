package com.demo.SpringDataJDBC;

import java.util.List;

public interface EmployeeDAO<Table> {
    List<Table> list();
}
