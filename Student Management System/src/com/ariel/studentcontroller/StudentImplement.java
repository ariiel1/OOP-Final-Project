package com.ariel.studentcontroller;

//imports
import com.ariel.student.Student;
import com.ariel.studentsql.StudentSQL;
import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;
import java.sql.ResultSet;


public class StudentImplement implements StudentInterface{
    
    //saves the user input into the database
    @Override
    public void save(Student students) {
        
        try{
            java.sql.Connection con = StudentSQL.getConnection();
            String sql = "INSERT INTO students(fname, lname, grade) VALUES (?,?,?)";    //xql statement
            java.sql.PreparedStatement ps = con.prepareStatement(sql);                  //(insert into database)
            //getting the values for the statement  
            ps.setString(1, students.getFname());
            ps.setString(2, students.getLname());
            ps.setInt(3, students.getGrade());
            ps.executeUpdate(); //executes xql statement
            JOptionPane.showMessageDialog(null, "Saved");
        } 
        catch (Exception e){        
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    //update values of database
    @Override
    public void update(Student students) {
        
        try{
            java.sql.Connection con = StudentSQL.getConnection();
            String sql = "UPDATE students SET fname=?,lname=?,grade=? WHERE id=?";  //xql statement
            java.sql.PreparedStatement ps = con.prepareStatement(sql);              //(update values wherever id is)
            //getting the values for the statement
            ps.setString(1, students.getFname());
            ps.setString(2, students.getLname());
            ps.setInt(3, students.getGrade());
            ps.setInt(4, students.getId());
            ps.executeUpdate(); //executes xql statement
            JOptionPane.showMessageDialog(null, "Updated");
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
    }

    //delete instance from database
    @Override
    public void delete(Student students) {
        
        try{
            java.sql.Connection con = StudentSQL.getConnection();
            String sql = "delete from students WHERE id=?";             //xql statement                          
            java.sql.PreparedStatement ps = con.prepareStatement(sql);  //(delete from database wherever id is)
            //getting the values for the statement
            ps.setInt(1, students.getId());
            ps.executeUpdate(); //executes xql statement
            JOptionPane.showMessageDialog(null, "Deleted Successfully");
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        
    }

    //select from database based on id
    @Override
    public Student get(int id) {
        
        Student st = new Student();
        try{
            java.sql.Connection con = StudentSQL.getConnection();
            String sql = "SELECT * FROM students WHERE id=?";           //xql statement
            java.sql.PreparedStatement ps = con.prepareStatement(sql);  //(select from database wherever id is)
            //getting the value for the statement
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if(rs.next()){
                st.setId(rs.getInt("id"));
                st.setFname(rs.getString("fname"));
                st.setLname(rs.getString("lname"));
                st.setGrade(rs.getInt("grade"));
            }
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Error");
        }
        return st;
    }

    //array list that contain values from the database
    @Override
    public List<Student> list() {
        
        List<Student> list = new ArrayList<Student>();
        try{
            java.sql.Connection con = StudentSQL.getConnection();
            String sql = "SELECT * FROM students";                      //xql statement
            java.sql.PreparedStatement ps = con.prepareStatement(sql);  //(select everything from database)
            ResultSet rs = ps.executeQuery();
            
            while(rs.next()){
                Student st = new Student();
                st.setId(rs.getInt("id"));
                st.setFname(rs.getString("fname"));
                st.setLname(rs.getString("lname"));
                st.setGrade(rs.getInt("grade"));
            
                list.add(st);
            }
        }
        catch (Exception e){
            
            JOptionPane.showMessageDialog(null, "Error");
        }
        
        return list;
    }
    
    
}
