package com.microservices.carserver.controllers;


import com.microservices.carserver.entity.Cars;
import com.microservices.carserver.services.CarsService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RestController
public class CarsController {

    @Autowired
    private CarsService carsService;


    @GetMapping("/getAllCars")
    @ResponseBody
    public List<Cars> getCarsTable(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }
        List<Cars> cars = carsService.getALlCars();
        return cars;
    }

    @GetMapping("/getCar/{id}")
    @ResponseBody
    public Cars getOneCar(HttpServletRequest request, @PathVariable(name = "id")Long id){
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }
        List<Cars> cars = carsService.getALlCars();
        Cars car = null;
        for (int i = 0; i < cars.size(); i++) {
            if(cars.get(i).getId() == id){
                car = cars.get(i);
            }
        }
        return car;
    }


    @PostMapping("/addNewCar")
    @ResponseBody
    public String addNewCar(HttpServletRequest request, @RequestBody Cars newCar){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        try{

            carsService.addCar(new Cars(null, newCar.getCarname(), newCar.getModel(), newCar.getYear(), newCar.getVolume()));

        }catch (Exception e){
            e.printStackTrace();
        }


        return "New car added!";
    }

    @DeleteMapping("/deleteCar/{id}")
    @ResponseBody
    public String deleteCar(HttpServletRequest request, @PathVariable(name = "id")Long id){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        Cars car = new Cars();

        try{
            car = carsService.getCar(id);

            carsService.deleteCars(car);

            return "Car is deleted!";

        }catch (Exception e){

            e.printStackTrace();
            return "Something wrong!";

        }

    }

    @PostMapping("/editCar")
    @ResponseBody
    public String updateCar(HttpServletRequest request, @RequestBody Cars updateCar){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        try{

            Cars cars = carsService.getCar(updateCar.getId());

            carsService.saveCars(new Cars(updateCar.getId(), updateCar.getCarname(), updateCar.getModel(), updateCar.getYear(), updateCar.getVolume()));

            return "The car has been updated!";

        }catch (Exception e){
            e.printStackTrace();
            return "Something wrong!";
        }

    }



}
