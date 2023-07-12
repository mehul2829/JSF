package com.ss.bean;

import javax.faces.bean.ManagedBean;

@ManagedBean(name = "test", eager = true)
public class TestBean {
  public TestBean() {
    System.out.println("started!");
  }

  public String getMessage() {
    return "Welcome to JSF Application!!";
  }
}
