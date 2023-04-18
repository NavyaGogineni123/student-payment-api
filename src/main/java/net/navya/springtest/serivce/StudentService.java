package net.navya.springtest.serivce;


import net.navya.springtest.dao.StudentDao;
import net.navya.springtest.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    StudentDao studentDao;

    public List<Student> getStudents(){

        return  studentDao.getStudentList();
    }

    public void create(Student student){
        studentDao.create(student);
    }

    public void update(Student student) {
        studentDao.update(student);
    }

    public void delete(int id) {
        studentDao.delete(id);
    }

    public Student getById(int id) {
        return studentDao.getById(id);
    }

    public List<Student> getByName(String name) {
        return studentDao.getByName(name);
    }
}
