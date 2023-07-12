package com.ss.bean;

import java.util.List;
import javax.faces.bean.ManagedBean;
import com.ss.dao.DatabseOperations;

@SuppressWarnings("deprecation")
@ManagedBean(name = "student", eager = true)
public class Student implements java.io.Serializable {
  
  private int id;
  private String name;
  private String department;
  private List<Student> studentList;   
  public static DatabseOperations dbObj;
  private static final long serialVersionUID = 1L;

  public Student() { }

  public Student(int id) {
      this.id = id;
  }

  public Student(int id, String name, String department) {
      this.id = id;
      this.name = name;
      this.department = department;
  }

  public int getId() {
      return this.id;
  }

  public void setId(int id) {
      this.id = id;
  }

  public String getName() {
      return this.name;
  }

  public void setName(String name) {
      this.name = name;
  }
  public String getDepartment() {
      return this.department;
  }

  public void setDepartment(String department) {
      this.department = department;
  }

  public List<Student> getStudentList() {
      return studentList;
  }

  public void setStudentList(List<Student> studentList) {
      this.studentList = studentList;
  }

  // Method To Add New Student Details In Database
  public String saveStudentRecord() {
      System.out.println("Calling saveStudentRecord() Method To Save Student Record");
      dbObj = new DatabseOperations();
      dbObj.addStudentInDb(this);
      return "success";
  }

  // Method To Delete A Particular Student Record From The Database
  public void deleteStudentRecord() {
      System.out.println("Calling deleteStudentRecord() Method To Delete Student Record");
      dbObj = new DatabseOperations();
      dbObj.deleteStudentInDb(id);
  }

  // Method To Fetch Particular Student Details From The Database
  public List<Student> getStudentDetailsById() {
      System.out.println("Calling getStudentDetailsById() Method Details For Student Id?= " + id);
      dbObj = new DatabseOperations();     
      studentList = dbObj.getStudentById(id);
      
      for (Student student : studentList) {
        name = student.getName();
        department = student.getDepartment();
      }
      System.out.println("Fetched Id? " + id + " Details Are: Name=" + name + ", Department=" + department);
      return studentList;
  }

  // Method To Update Particular Student Details In Database
  public void updateStudentDetails() {
      System.out.println("Calling updateStudentDetails() Method To Update Student Record");
      dbObj = new DatabseOperations();    
      dbObj.updateStudentRecord(this);
  }
}