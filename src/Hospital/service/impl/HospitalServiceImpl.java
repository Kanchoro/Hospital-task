package Hospital.service.impl;

import Hospital.dao.impl.HospitalDaoImpl;
import Hospital.db.DataBase;
import Hospital.models.Hospital;
import Hospital.models.Patient;
import Hospital.service.HospitalService;

import java.util.List;
import java.util.Map;

public class HospitalServiceImpl implements HospitalService {
    public HospitalDaoImpl hospitalDaoImp ;

    public HospitalServiceImpl(HospitalDaoImpl hospitalDaoImp) {
        this.hospitalDaoImp = hospitalDaoImp;
    }


    @Override
    public String addHospital(Hospital hospital) {
        return hospitalDaoImp.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        return hospitalDaoImp.findHospitalById(id);
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDaoImp.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        return hospitalDaoImp.getAllPatientFromHospital(id);
    }

    @Override
    public String deleteHospitalById(Long id) {
        return hospitalDaoImp.deleteHospitalById(id);
    }

    @Override
    public Map<Integer, Hospital> getAllHospitalByAddress(String address) {
        return hospitalDaoImp.getAllHospitalByAddress(address);
    }
}
