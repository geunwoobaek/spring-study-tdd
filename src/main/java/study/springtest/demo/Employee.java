package study.springtest.demo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="person")
@Data
public class Employee {

    @Id
    @GeneratedValue
    private Long id;

    @Size(min=3,max=20)
    private String name;

    public Employee(String name) {this.name=name;}
}

