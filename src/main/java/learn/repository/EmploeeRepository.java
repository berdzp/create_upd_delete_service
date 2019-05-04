package learn.repository;

import learn.model.Emploee;

import java.math.BigDecimal;
import java.util.*;
import java.util.stream.Collectors;

public class EmploeeRepository {

    private  Map<String, Emploee> emploeeDatabase = new HashMap<>();

    public void init() {
        emploeeDatabase.put("1", new Emploee("1", "Bob", "bob@gmail.com", new BigDecimal(2000.00), 25, "New York"));
        emploeeDatabase.put("2", new Emploee("2", "Jack", "jack@gmail.com", new BigDecimal(3000.00), 35, "New Jersey"));
        emploeeDatabase.put("3", new Emploee("3", "Mike", "mike@gmail.com", new BigDecimal(4000.00), 45, "LA"));
        emploeeDatabase.put("4", new Emploee("4", "Steve", "steve@gmail.com", new BigDecimal(5000.00), 55, "San Jose"));
    }

    public Emploee getOne(String id){
        return emploeeDatabase.get(id);
    }

    public List<Emploee> getAll(){
        return emploeeDatabase.entrySet().stream().map(e -> e.getValue()).collect(Collectors.toList());
    }

    public void addEmployee(Emploee newEmployee){
        if (newEmployee.getId() == null) {
            String newid = UUID.randomUUID().toString();
            newEmployee.setId(newid);
        }
        emploeeDatabase.put(newEmployee.getId(), newEmployee);
    }

    public void delete(String id){
        emploeeDatabase.remove(id);
    }



}
