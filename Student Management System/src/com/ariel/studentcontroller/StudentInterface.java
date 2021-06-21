package com.ariel.studentcontroller;

//imports
import com.ariel.student.Student;
import java.util.List;

//interface
public interface StudentInterface {
    
    //declaring methods
    public void save(Student students);
    public void update(Student students);
    public void delete(Student students);
    public Student get(int id);
    public List<Student> list();
    
}
