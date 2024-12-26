package Hospital.service;

import Hospital.models.Department;

import java.util.List;

public interface DepartmentService {
    List<Department> getAllDepartmentByHospital(Long id);

    Department findDepartmentByName(String name);
}
