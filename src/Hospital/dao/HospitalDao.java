package Hospital.dao;

import Hospital.models.Hospital;
import Hospital.models.Patient;

import java.util.List;
import java.util.Map;

public interface HospitalDao {

    String addHospital(Hospital hospital);

    Hospital findHospitalById(int index);

    List<Hospital> getAllHospital();

    List<Patient> getAllPatientFromHospital(int index);

    String deleteHospitalById(int index);

    Map<Integer,Hospital> getAllHospitalByAddress(String address);
}
