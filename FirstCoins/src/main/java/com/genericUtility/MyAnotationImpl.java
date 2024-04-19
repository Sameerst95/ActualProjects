package com.genericUtility;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

public class MyAnotationImpl implements IAnnotationTransformer{

	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor, Method testMethod) {
		
//		IAnnotationTransformer.super.transform(annotation, testClass, testConstructor, testMethod);
		annotation.setRetryAnalyzer(com.genericUtility.MyRetryAnalyzer.class);
	}

	

	

}
