package Hospital.dao.impl;

import Hospital.dao.GenericService;
import Hospital.dao.DepartmentDao;
import Hospital.db.DataBase;
import Hospital.models.Department;
import Hospital.models.Hospital;

import java.util.List;

public class DepartmentDaoImpl implements DepartmentDao, GenericService<Department> {
    @Override
    public List<Department> getAllDepartmentByHospital(Long id) {
        return DataBase.hospitals.stream()
                .filter(x -> x.getId().equals(id))
                .findFirst()
                .map(Hospital::getDepartments)
                .orElse(null);
    }

    @Override
    public Department findDepartmentByName(String name) {
        return DataBase.hospitals.stream()
                .flatMap(x -> x.getDepartments().stream()
                        .filter(d -> d.getDepartmentName().equals(name))
                        .map(d -> x.getDepartments().get(x.getDepartments().indexOf(d))))
                .findFirst()
                .orElse(null);
    }

    @Override
    public String add(Long hospitalId, Department department) {
        return DataBase.hospitals.stream()
                .filter(x -> x.getId().equals(hospitalId))
                .findFirst()
                .map(h -> {
                    h.getDepartments().add(department);
                    return "successfully added";
                })
                .orElse("Hospital with this id not found");
    }

    @Override
    public void removeById(Long id) {
        try {
            boolean delete = DataBase.hospitals.stream()
               .flatMap(x-> x.getDepartments().stream()
                       .filter(d->d.getId().equals(id))
                       .map(d -> {
                           x.getDepartments().remove(d);
                           System.out.println("Successfully deleted!");
                           return true;
                       }))
               .findFirst()
               .orElse(false);
            if (!delete) {
                System.out.println("Department with this id not found");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public String updateById(Long id, Department department) {
        return DataBase.hospitals.stream()
                .flatMap(x-> x.getDepartments().stream()
                        .filter(d-> d.getId().equals(id))
                        .map(d-> {
                            x.getDepartments().set(x.getDepartments().indexOf(d),department);
                            return "Successfully updated!";
                        }))
                .findFirst()
                .orElse("Department with this id not found");

    }
}
