package com.burakenesdemir.reactiveprogramming;

import com.burakenesdemir.reactiveprogramming.data.entity.Employee;
import com.burakenesdemir.reactiveprogramming.data.repository.EmployeeRepository;
import org.bson.types.BSONTimestamp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.event.EventListener;

import java.time.LocalDate;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class ReactiveProgrammingApplication {

	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(ReactiveProgrammingApplication.class, args);
	}


	/**
	 * publisher datayı veri tabanına veren class
	 * subscribe veri tabanını sonucunu dinlememizi sağlar veri tabanından sonuç gelirse x gelmezse y metodunu
	 * çalıştır gibi özellikleri kullanabiliriz.
	 *
	 */
	@EventListener(ApplicationStartedEvent.class)
	public void appStart() {
		if (employeeRepository.count().block() == 0) {
			IntStream.range(0, 100)
					.mapToObj(this::generate)
					.map(employeeRepository::save)
					.collect(Collectors.toList())
					.forEach(item -> item.subscribe(System.out::println));
		}
	}


	private Employee generate(int i){
		return Employee.builder()
				.name("Name" + i)
				.surname("Surname" + i)
				.birthDate(LocalDate.now())
				.salary((float) (Math.random() * i))
				.build();

	}
}
