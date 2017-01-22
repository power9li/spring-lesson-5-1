package com.power.spring.lesson5_1.bean;

import com.power.lesson5.utils.Printer;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import java.util.Date;

@Component
//@Scope("prototype")
public class HelloWorldBean3 {

	public HelloWorldBean3()
	{
		Printer.print("HelloWorldBean3.HelloWorldBean3");
	}

	@PostConstruct
	public void init()
	{
		Printer.print("HelloWorldBean3.init");
		// open jdbc pool ,or thread pool 
		
	}
	public void hello() {
		System.out.println(new Date()+" hello "+ " @ "+ this);

	}

	@PreDestroy
	public void close()
	{
		Printer.print("HelloWorldBean3.close");
		// close jdbc pool ,or thread pool  ,release resource 
	}
}
