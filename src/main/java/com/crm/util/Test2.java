package com.crm.util;


import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class Test2 implements IAnnotationTransformer {
	
	public void transform(ITestAnnotation annotation,Class testclass,Constructor testconstructor,Method testmethod)
	{
		annotation.setRetryAnalyzer(Test1.class);
	}

}