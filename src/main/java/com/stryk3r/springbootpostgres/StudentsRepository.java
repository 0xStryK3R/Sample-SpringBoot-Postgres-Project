package com.stryk3r.springbootpostgres;

import com.stryk3r.springbootpostgres.pojos.StudentEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentsRepository extends JpaRepository<StudentEntity, Long> {
}
