package learn.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Emploee {

    private String id;
    private String name;
    private String email;
    private BigDecimal salary;
    private int age;
    private String address;

    @Override
    public String toString() {
        return String.format("%s %S %d", name, email, age);
    }
}
