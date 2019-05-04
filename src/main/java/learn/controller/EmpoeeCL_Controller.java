package learn.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import learn.model.Emploee;
import learn.repository.EmploeeRepository;

public class EmpoeeCL_Controller {

    private EmploeeRepository repository;

    ObjectMapper objectMapper = new ObjectMapper();

    public EmpoeeCL_Controller() {
        repository = new EmploeeRepository();
        repository.init();
    }


    public String getEmploeeById(String id) throws JsonProcessingException {
        Emploee e = repository.getOne(id);
        return objectMapper.writeValueAsString(e);
    }

    public String addEmployee(Emploee empl) {
        repository.addEmployee(empl);
        return empl.toString() + " added.";
    }


}
