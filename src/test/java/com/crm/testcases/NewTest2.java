package com.crm.testcases;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class NewTest2 {
  @Test
  public void f() {
	  System.out.println("f()");
  }
  @Test
  public void f1() {
	  System.out.println("f1()");
  }
  @BeforeMethod
  public void beforeMethod() {
	  System.out.println("Before method------");
  }

  @BeforeClass
  public void beforeClass() {
	  System.out.println("Before class-------");
  }

  @AfterClass
  public void afterClass() {
	  System.out.println("after class-------");
  }

  @BeforeTest
  public void beforeTest() {
	  System.out.println("Before tes------");
  }

  @AfterTest
  public void afterTest() {
	  System.out.println("after test----");
  }

  @BeforeSuite
  public void beforeSuite() {
	  System.out.println("Before suite-----");
  }

  @AfterSuite
  public void afterSuite() {
	  System.out.println("after suite-----");
  }

}
