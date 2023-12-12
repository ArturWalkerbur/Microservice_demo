package com.microservices.rentersserver.controllers;


import com.microservices.rentersserver.dto.Rental_dto;
import com.microservices.rentersserver.dto.Renters_dto;
import com.microservices.rentersserver.entity.CarRental;
import com.microservices.rentersserver.entity.Renters;
import com.microservices.rentersserver.services.CarRentalService;
import com.microservices.rentersserver.services.RentersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RestController
public class RentalControllers {

    @Autowired
    private RentersService rentersService;

    @Autowired
    private CarRentalService rentalService;

    @GetMapping("/getAllRenters")
    @ResponseBody
    public List<Renters> getRentersTable(HttpServletRequest request){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        List<Renters> renters = rentersService.getRenters();
        return renters;
    }

    @GetMapping("/getAllRentals")
    @ResponseBody
    public List<CarRental> getCarRentalTable(HttpServletRequest request){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        List<CarRental> rentals = rentalService.getCarRentals();
        return rentals;
    }

    @GetMapping("/getRenter/{id}")
    @ResponseBody
    public Renters getOneRenter(HttpServletRequest request, @PathVariable(name = "id")Long id){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        List<Renters> renters = rentersService.getRenters();
        Renters renter = null;
        for (int i = 0; i < renters.size(); i++) {
            if(renters.get(i).getId() == id){
                renter = renters.get(i);
            }
        }
        return renter;
    }

    @GetMapping("/getRental/{id}")
    @ResponseBody
    public CarRental getOneRental(HttpServletRequest request, @PathVariable(name = "id")Long id){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        List<CarRental> rentals = rentalService.getCarRentals();
        CarRental rental = null;
        for (int i = 0; i < rentals.size(); i++) {
            if(rentals.get(i).getId() == id){
                rental = rentals.get(i);
            }
        }
        return rental;
    }

    @PostMapping("/addNewRenter")
    @ResponseBody
    public String addNewRenter(HttpServletRequest request, @RequestBody Renters_dto newRenter){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = dateFormat.parse(newRenter.getDateOfBirth());

            rentersService.addRenter(new Renters(null, newRenter.getRenterName(), new java.sql.Date(utilDate.getTime()), newRenter.getAddress(), newRenter.getCellNumber(), newRenter.getTrustedCellNumber(), newRenter.getIin(), newRenter.getUser_id()));

        }catch (Exception e){
            e.printStackTrace();
        }


        return "New renter added!";
    }

    @PostMapping("/addNewRental")
    @ResponseBody
    public String addNewRental (HttpServletRequest request, @RequestBody Rental_dto newRental){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        try{

            Long car_id = newRental.getCar_id();
            Renters renter = rentersService.getRenter(newRental.getRenter_id());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDateStart = dateFormat.parse(newRental.getRentalStartDate());
            java.util.Date utilDateEnd = dateFormat.parse(newRental.getRentalEndDate());

            rentalService.addCarRental(new CarRental(null, car_id, renter, new java.sql.Date(utilDateStart.getTime()), new java.sql.Date(utilDateEnd.getTime())));

        }catch (Exception e){
            e.printStackTrace();
        }


        return "New rental added!";
    }

    @DeleteMapping("/deleteRenter/{id}")
    @ResponseBody
    public String deleteRenter(HttpServletRequest request, @PathVariable(name = "id")Long id){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        Renters renter = new Renters();

        try{
            renter = rentersService.getRenter(id);

            rentersService.deleteRenter(renter);

            return "Renter is deleted!";

        }catch (Exception e){

            e.printStackTrace();
            return "Something wrong!";

        }

    }

    @DeleteMapping("/deleteRental/{id}")
    @ResponseBody
    public String deleteRental(HttpServletRequest request, @PathVariable(name = "id")Long id){


        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        CarRental rental = new CarRental();

        try{
            rental = rentalService.getCarRental(id);

            rentalService.deleteCarRental(rental);

            return "Rental is deleted!";

        }catch (Exception e){

            e.printStackTrace();
            return "Something wrong!";

        }

    }

    @PostMapping("/editRenter")
    @ResponseBody
    public String updateRenter(HttpServletRequest request, @RequestBody Renters updateRenter){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        try{

            Renters renters = rentersService.getRenter(updateRenter.getId());

            rentersService.saveRenter(new Renters(updateRenter.getId(), updateRenter.getRenterName(), updateRenter.getDateOfBrith(), updateRenter.getAddress(), updateRenter.getCellNumber(), updateRenter.getTrustedCellNumber(), updateRenter.getIIN(), updateRenter.getUser_id()));

            return "The renter has been updated!";

        }catch (Exception e){
            e.printStackTrace();
            return "Something wrong!";
        }

    }

    @PostMapping("/editRental")
    @ResponseBody
    public String updateRental(HttpServletRequest request, @RequestBody CarRental updateRental){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        try{

            CarRental rental = rentalService.getCarRental(updateRental.getId());

            rentalService.saveCarRental(new CarRental(updateRental.getId(), updateRental.getCar_id(), updateRental.getRenter(), updateRental.getRentalStartDate(), updateRental.getRentalEndDate()));

            return "The rental has been updated!";

        }catch (Exception e){
            e.printStackTrace();
            return "Something wrong!";
        }

    }




}
