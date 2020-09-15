package kmitl.demo.wnmk;

import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
@SpringBootApplication
@RestController
@EnableAutoConfiguration
public class Car {
	private int Speed;
	private boolean Sunroof;
	private int Displacement;
	private String Color;
	private String Type;
	private  static ArrayList cars = new ArrayList<Car>();
	public static void main(String[] args) {
		SpringApplication.run(Car.class, args);
	}

	
//	@RequestMapping(value = "/get")
//	public ResponseEntity<Car> get() {
//	Car car = new Car();
//	car.setColor("Blue");
//	car.setType("Truck");
//	car.setDisplacement(1500);
//	car.setSunroof(false);
//	car.setSpeed(60);
//	return new ResponseEntity<Car>(car, HttpStatus.OK);
//	}
//	
//	@RequestMapping(value="/update",method=RequestMethod.POST)
//	public ResponseEntity<Car> update(@RequestBody Car car) {
//	String color = car.getColor();
//	String type = car.getType();
//	int displacement = car.getDisplacement();
//	boolean Sunroof = car.isSunroof();
//	int Speed = car.getSpeed();
//	return new ResponseEntity<Car>(car, HttpStatus.OK);
//	}
	@RequestMapping(value="/car",method=RequestMethod.POST)
	public ResponseEntity<List<Car>> update(@RequestBody Car car){
		String Color = car.getColor();
		String Type = car.getType();
		int Displacement = car.getDisplacement();
		boolean Sunroof = car.isSunroof();
		int Speed = car.getSpeed();
		cars.add(car);
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);	
	}
	@RequestMapping(value="/car/{id}", method=RequestMethod.PATCH)
	public ResponseEntity<List<Car>> patch(@RequestBody Car car, @PathVariable("id") int id){
		String color = car.getColor();
		String type = car.getType();
		int displacement = car.getDisplacement();
		boolean Sunroof = car.isSunroof();
		int Speed = car.getSpeed();
		cars.set(id-1, car);
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);	
	}
	@RequestMapping(value="/car/{id}", method=RequestMethod.GET)
	public ResponseEntity<Car> get(@PathVariable("id") int id){
		return new ResponseEntity<Car>((Car) cars.get(id-1), HttpStatus.OK);
	}
	@RequestMapping(value="/car/{id}", method=RequestMethod.DELETE)
	public ResponseEntity<List<Car>> delete(@PathVariable("id") int id){
		cars.remove(id-1);
		return new ResponseEntity<List<Car>>(cars, HttpStatus.OK);
	}

	


	
	public int getSpeed() {
		return Speed;
	}
	public void setSpeed(int speed) {
		Speed = speed;
	}
	public boolean isSunroof() {
		return Sunroof;
	}
	public void setSunroof(boolean sunroof) {
		Sunroof = sunroof;
	}
	public int getDisplacement() {
		return Displacement;
	}
	public void setDisplacement(int displacement) {
		Displacement = displacement;
	}
	public String getColor() {
		return Color;
	}
	public void setColor(String color) {
		Color = color;
	}
	public String getType() {
		return Type;
	}
	public void setType(String type) {
		Type = type;
	}




}