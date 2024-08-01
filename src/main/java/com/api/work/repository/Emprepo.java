package com.api.work.repository;

import com.api.work.entities.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface Emprepo extends JpaRepository<employee, Long> {
}
