package Hospital.service.impl;

import Hospital.dao.impl.PatientDaoImpl;
import Hospital.db.DataBase;
import Hospital.models.Hospital;
import Hospital.models.Patient;
import Hospital.service.GenericService;
import Hospital.service.PatientService;

import java.util.List;
import java.util.Map;

public class PatientServiceImpl implements PatientService , GenericService<Patient> {
    public PatientDaoImpl patientDaoImp;

    public PatientServiceImpl(PatientDaoImpl patientDaoImp) {
        this.patientDaoImp = patientDaoImp;
    }


    @Override
    public String add(Long hospitalId, Patient patient) {
        return patientDaoImp.add(hospitalId,patient);
    }

    @Override
    public void removeById(Long id) {
        patientDaoImp.removeById(id);
    }

    @Override
    public String updateById(Long id, Patient patient) {
        return patientDaoImp.updateById(id,patient) ;
    }

    @Override
    public String addPatientsToHospital(Long id, List<Patient> patients) {
        return patientDaoImp.addPatientsToHospital(id,patients);
    }

    @Override
    public Patient getPatientById(Long id) {
        return patientDaoImp.getPatientById(id);
    }

    @Override
    public Map<Integer, List<Patient>> getPatientByAge() {
        return patientDaoImp.getPatientByAge();
    }

    @Override
    public List<Patient> sortPatientsByAge(String ascOrDesc) {
        return patientDaoImp.sortPatientsByAge(ascOrDesc);
    }
}
