package Hospital.dao;

import Hospital.models.Department;

import java.util.List;

public interface DepartmentDao {

    List<Department> getAllDepartmentByHospital(int index);

    Department findDepartmentByName(int index , int index2);
}
