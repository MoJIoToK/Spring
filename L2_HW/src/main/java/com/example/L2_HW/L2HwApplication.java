package com.example.L2_HW;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class L2HwApplication {

	public static void main(String[] args) {
		SpringApplication.run(L2HwApplication.class, args);
//		String str = HelloController.hello();
		Car car = new Car(new Engine());
	}

}
