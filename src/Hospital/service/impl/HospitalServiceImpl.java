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
        for (Hospital hospital1 : DataBase.hospitals){
            if(hospital1.getHospitalName().equals(hospital.getHospitalName())){
                return "Hospital with this name already exist";
            }
        }
        return hospitalDaoImp.addHospital(hospital);
    }

    @Override
    public Hospital findHospitalById(Long id) {
        for(Hospital hospital : DataBase.hospitals){
            if(hospital.getId().equals(id)){
                return hospitalDaoImp.findHospitalById(DataBase.hospitals.indexOf(hospital));
            }
        }
        return null;
    }

    @Override
    public List<Hospital> getAllHospital() {
        return hospitalDaoImp.getAllHospital();
    }

    @Override
    public List<Patient> getAllPatientFromHospital(Long id) {
        for(Hospital hospital : DataBase.hospitals){
            if(hospital.getId().equals(id)){
                return hospitalDaoImp.getAllPatientFromHospital(DataBase.hospitals.indexOf(hospital));
            }
        }
        return List.of();
    }

    @Override
    public String deleteHospitalById(Long id) {
        for(Hospital hospital : DataBase.hospitals){
            if(hospital.getId().equals(id)){
                return hospitalDaoImp.deleteHospitalById(DataBase.hospitals.indexOf(hospital));
            }
        }
        return "Hospital with this id not found";
    }

    @Override
    public Map<Integer, Hospital> getAllHospitalByAddress(String address) {
        for(Hospital hospital : DataBase.hospitals ){
            if(hospital.getAddress().equals(address)){
                return hospitalDaoImp.getAllHospitalByAddress(address);
            }
        }
        System.out.println("the address you entred not exist");
        return Map.of();
    }
}
