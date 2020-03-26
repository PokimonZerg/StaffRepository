package org.example.staff.repository;

import org.example.staff.model.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query("select e from Employee e where e.lastName like concat('%',:lastName,'%')")
    Page<Employee> filterByLastName(@Param("lastName") String lastName, Pageable pageable);
}
