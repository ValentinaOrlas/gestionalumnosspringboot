package valentina.gestionAlumnos.controllers;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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


    @RequestMapping(method = RequestMethod.GET)
    public List<Student> getStudents (){
        return students;
    }


    @RequestMapping(value = "/{email}", method = RequestMethod.GET)
    public Student getStudentEmail ( @PathVariable String email){
        for(Student i : students){
            if(i.getEmail().equalsIgnoreCase(email)){
                 return i;
            }
        }
        return null;
    }


    private String messageExistStudent(){
        return "it already exists";
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<?> createStudent(@RequestBody Student student){

        for(Student i : students){
            if(i.getId() == student.getId() || i.getEmail().equalsIgnoreCase(student.getEmail())) {
                return new ResponseEntity<>(messageExistStudent(), HttpStatus.CONFLICT);
            }

        }
        students.add(student);
        return new ResponseEntity<>(student, HttpStatus.CREATED);
    }


    @RequestMapping(method = RequestMethod.PUT)
    public Student updateStudent(@RequestBody Student student){

        for(Student i : students){
            if(i.getId() == student.getId()){
                i.setName(student.getName());
                i.setEmail(student.getEmail());
                i.setAge(student.getAge());
                i.setCourse(student.getCourse());
                return i;
            }
        }
        return null;
    }


    @RequestMapping(method = RequestMethod.PATCH)
    public Student patchStudent(@RequestBody Student student){

        for(Student i : students){
            if(i.getId() == student.getId()){
                if(student.getName() != null){
                    i.setName(student.getName());
                }
                if(student.getEmail() != null){
                    i.setEmail(student.getEmail());
                }
                if(student.getAge() != 0){
                    i.setAge(student.getAge());
                }
                if(student.getCourse() != null){
                    i.setCourse(student.getCourse());
                }
                return i;
            }
        }
        return null;
    }
}
