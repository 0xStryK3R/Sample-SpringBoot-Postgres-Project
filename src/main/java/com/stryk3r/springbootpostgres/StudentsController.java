package com.stryk3r.springbootpostgres;

import com.stryk3r.springbootpostgres.pojos.StudentEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentsController {
    private StudentsRepository studentsRepository;

    public StudentsController(StudentsRepository studentsRepository) {
        this.studentsRepository = studentsRepository;
    }

    @GetMapping("")
    public List<StudentEntity> listAll() {
        return studentsRepository.findAll();
    }


    @GetMapping("/{id}")
    public StudentEntity listAll(@PathVariable Long id) {
        return studentsRepository.findById(id).orElseThrow(() -> new StudentNotFoundException(id));
    }

    @PostMapping("")
    public StudentEntity createStudent(@RequestBody StudentEntity studentEntity) {
        return studentsRepository.save(studentEntity);
    }

    static class StudentNotFoundException extends IllegalArgumentException{
        public StudentNotFoundException(Long id){
            super("Student with id: " + id + " not found.");
        }
    }


    @ExceptionHandler({
            StudentNotFoundException.class
    })
    ResponseEntity<String> handleError(Exception e){
        HttpStatus errorStatus;
        if (e instanceof StudentNotFoundException){
            errorStatus = HttpStatus.NOT_FOUND;
        }else {
            errorStatus = HttpStatus.INTERNAL_SERVER_ERROR;
        }
        System.out.println(e.getMessage());
        return ResponseEntity
                .status(errorStatus)
                .body(new String(e.getMessage()));
    }

}
