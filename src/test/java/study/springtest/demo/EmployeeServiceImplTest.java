package study.springtest.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.api.extension.Extensions;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.TestConstructor;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.validation.constraints.Null;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

@ExtendWith(MockitoExtension.class)
class EmployeeServiceImplTest {

    @InjectMocks
    EmployeeServiceImpl employeeService;
    @Mock
    EmployeeRepository repository;
    Employee employee;

    @BeforeEach
    void setUp() {
        //given
        employee = new Employee("Jack");
    }

    @Test
    @DisplayName("findById 테스트")
    void testFindById() {
        //given
        doReturn(Optional.of(employee)).when(repository).findById(1l);
        //when
        Optional<Employee> findemployee = employeeService.findById(1l);

        //then
        Assertions.assertAll(
                () -> assertTrue(findemployee.isPresent(), "찾을 수 없습니다."),
                () -> assertEquals(findemployee.get().getName(), "Jack", "동일한 employee를 찾았습니다.")
        );
    }

    @Test
    @DisplayName("Test findById Not Found")
    void testFindByIdNotFound() {
        doReturn(Optional.empty()).when(repository).findById(1l);
        Optional<Employee> returnedWidget = employeeService.findById(1l);
        // Assert the response
        Assertions.assertFalse(returnedWidget.isPresent(), "찾을 수 없습니다.");
    }
}

