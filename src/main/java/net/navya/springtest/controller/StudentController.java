package net.navya.springtest.controller;


import net.navya.springtest.model.Student;
import net.navya.springtest.serivce.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController()
@RequestMapping("/student/")
public class StudentController {


    @Autowired
    StudentService studentService; //reflection




    @GetMapping("name/{id}")
    public String getStudentNameById(@PathVariable int id){
      Map<Integer, String > map = getData();
        return map.get(id);
    }

    @GetMapping("all")
    public Map<Integer, String> getAllStudents(){
        Map<Integer, String > map = getData();
        return map;
    }

    private Map<Integer, String> getData(){

        Map<Integer, String> map = new HashMap<>();
        map.put(1, "Navya");
        map.put(2,"Sai");
        map.put(3, "Vijay");
        return map;

    }

    @GetMapping("student-list")
    public List<Student> getListOfStudent(){
      return   studentService.getStudents();
    }

    @PostMapping("create")
    public void create(@RequestBody Student student){
        studentService.create(student);
    }

    @PutMapping("update")
    public void update(@RequestBody Student student){
        studentService.update(student);
    }

    @DeleteMapping("delete/{id}")
    public void delete(@PathVariable int id){
        studentService.delete(id);


    }

    @GetMapping("{id}")
    public Student getById(@PathVariable int id){
       return studentService.getById(id);
    }
    @GetMapping("/name")
    public List<Student> getByname(@RequestParam String name){
        return studentService.getByName(name);

    }


}
