package Hospital.dao.impl;

import Hospital.dao.GenericService;
import Hospital.dao.DoctorDao;
import Hospital.db.DataBase;
import Hospital.models.Department;
import Hospital.models.Doctor;
import Hospital.models.Hospital;

import java.util.List;

public class DoctorDaoImpl implements DoctorDao , GenericService <Doctor> {
    @Override
    public Doctor findDoctorById(int index,int index2) {
        return DataBase.hospitals.get(index).getDoctors().get(index2);
    }

    @Override
    public String assignDoctorToDepartment(Long id, List<Doctor> doctorsId) {
        for(Hospital hospital : DataBase.hospitals){
            for(Department department : hospital.getDepartments()){
                if(department.getId().equals(id)){
                    department.getDoctors().addAll(doctorsId);
                }
            }
        }
        return "successfully assigned";
    }

    @Override
    public List<Doctor> getAllDoctorsByHospitalId(int index) {
        return DataBase.hospitals.get(index).getDoctors();
    }

    @Override
    public List<Doctor> getAllDoctorsByDepartmentId(int index, int index2) {
        return DataBase.hospitals.get(index).getDepartments().get(index2).getDoctors();
    }

    @Override
    public String add(int index, Doctor doctor) {
        DataBase.hospitals.get(index).getDoctors().add(doctor);
        return "successfully added";
    }

    @Override
    public void removeById(int index,int hosIndex) {
        DataBase.hospitals.get(hosIndex).getDoctors().remove(index);
        System.out.println("successfully deleted");
    }

    @Override
    public String updateById(int index,int index2, Doctor doctor) {
        DataBase.hospitals.get(index).getDoctors().set(index2,doctor);
        return "successfully updated";
    }
}