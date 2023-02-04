package com.example.demo;

import org.aspectj.lang.annotation.Before;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class MockTest 
{
	@Mock
	private StudentRepository studentRepo;
	@InjectMocks
	private ServiceLayer serviceLayer;
	@Before(value = "")
	public void setUp() throws Exception
	{
		MockitoAnnotations.initMocks(this);
	}
}
