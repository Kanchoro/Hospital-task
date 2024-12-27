package Hospital.service.impl;

import Hospital.dao.impl.DepartmentDaoImpl;
import Hospital.db.DataBase;
import Hospital.models.Department;
import Hospital.models.Hospital;
import Hospital.service.DepartmentService;
import Hospital.service.GenericService;

import java.util.List;

public class DepartmentServiceImpl implements DepartmentService , GenericService <Department> {
    public DepartmentDaoImpl daoImp ;

    public DepartmentServiceImpl(DepartmentDaoImpl daoImp) {
        this.daoImp = daoImp;
    }

    @Override
    public String add(Long hospitalId, Department department) {
        return daoImp.add(hospitalId,department);
    }

    @Override
    public void removeById(Long id) {
        daoImp.removeById(id);
    }

    @Override
    public String updateById(Long id, Department department) {
        return daoImp.updateById(id,department);
    }

    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return daoImp.getAllDepartmentByHospital(id);
    }

    @Override
    public Department findDepartmentByName(String name) {
       return daoImp.findDepartmentByName(name);
    }
}
