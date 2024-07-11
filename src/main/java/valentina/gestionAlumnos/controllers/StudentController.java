package valentina.gestionAlumnos.controllers;


import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import valentina.gestionAlumnos.domain.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private List<Student> students = new ArrayList<>(Arrays.asList(
            new Student(123,"Alexandra Orlas","alexa@gmail.com",30,"Baile"),
            new Student(456,"Stefania Giraldo","stefania@gmail.com",22,"Psicología"),
            new Student(789,"Paola Cueto","paola@gmail.com",29,"Contaduría"),
            new Student(234,"Sara Pachon","sofia@gmail.com",16,"Teatro")
    ));


}
