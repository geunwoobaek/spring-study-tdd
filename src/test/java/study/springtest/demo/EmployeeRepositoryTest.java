package study.springtest.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@ExtendWith(SpringExtension.class)
class EmployeeRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;
    @Autowired EmployeeRepository employeeRepository;

    @Test
    public void whenFindByName_thenReturnEmployee() {
    //given
        Employee alex=new Employee("alex");
        entityManager.persist(alex);
        entityManager.flush();
    //when
        Employee found= employeeRepository.findByName(alex.getName());
    //then
        assertAll(
                ()->assertEquals(alex.getName(),found.getName())
        );
    }

}