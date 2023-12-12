package com.microservices.ownersserver.controllers;


import com.microservices.ownersserver.dto.Owners_dto;
import com.microservices.ownersserver.dto.Ownership_dto;
import com.microservices.ownersserver.entity.CarOwnership;
import com.microservices.ownersserver.entity.Owners;
import com.microservices.ownersserver.services.CarOwnershipService;
import com.microservices.ownersserver.services.OwnersService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.text.SimpleDateFormat;
import java.util.List;

@Controller
@RestController
public class OwnershipController {

    @Autowired
    private OwnersService ownersService;

    @Autowired
    private CarOwnershipService ownershipService;


    @GetMapping("/getAllOwners")
    @ResponseBody
    public List<Owners> getOwnersTable(HttpServletRequest request){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        List<Owners> owners = ownersService.getOwners();
        return owners;
    }

    @GetMapping("/getAllOwnerships")
    @ResponseBody
    public List<CarOwnership> getCarOwnershipTable(HttpServletRequest request){
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }
        List<CarOwnership> ownerships = ownershipService.getCarOwnerships();
        return ownerships;
    }

    @GetMapping("/getOwner/{id}")
    @ResponseBody
    public Owners getOneOwner(HttpServletRequest request, @PathVariable(name = "id")Long id){
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }
        List<Owners> owners = ownersService.getOwners();
        Owners owner = null;
        for (int i = 0; i < owners.size(); i++) {
            if(owners.get(i).getId() == id){
                owner = owners.get(i);
            }
        }
        return owner;
    }

    @GetMapping("/getOwnership/{id}")
    @ResponseBody
    public CarOwnership getOneOwnership(HttpServletRequest request, @PathVariable(name = "id")Long id){
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }
        List<CarOwnership> ownerships = ownershipService.getCarOwnerships();
        CarOwnership ownership = null;
        for (int i = 0; i < ownerships.size(); i++) {
            if(ownerships.get(i).getId() == id){
                ownership = ownerships.get(i);
            }
        }
        return ownership;
    }

    @PostMapping("/addNewOwner")
    @ResponseBody
    public String addNewOwner(HttpServletRequest request, @RequestBody Owners_dto newOwner){
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }
        try{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDate = dateFormat.parse(newOwner.getDateOfBirth());
            ownersService.addOwner(new Owners(null, newOwner.getOwnerName(), new java.sql.Date(utilDate.getTime()), newOwner.getAddress(), newOwner.getCellNumber(), newOwner.getUser_id()));

        }catch (Exception e){
            e.printStackTrace();
        }


        return "New owner added!";
    }

    @PostMapping("/addNewOwnership")
    @ResponseBody
    public String addNewOwnership (HttpServletRequest request, @RequestBody Ownership_dto newOwnership){
        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }
        try{
            Long car_id = newOwnership.getCar_id();
            Owners owner = ownersService.getOwner(newOwnership.getOwner_id());
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
            java.util.Date utilDateStart = dateFormat.parse(newOwnership.getOwnershipStartDate());
            java.util.Date utilDateEnd = dateFormat.parse(newOwnership.getOwnershipEndDate());
            ownershipService.addCarOwnership(new CarOwnership(null, car_id, owner, new java.sql.Date(utilDateStart.getTime()), new java.sql.Date(utilDateEnd.getTime())));

        }catch (Exception e){
            e.printStackTrace();
        }


        return "New ownership added!";
    }

    @DeleteMapping("/deleteOwner/{id}")
    @ResponseBody
    public String deleteOwner(HttpServletRequest request, @PathVariable(name = "id")Long id){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        Owners owner = new Owners();

        try{
            owner = ownersService.getOwner(id);

            ownersService.deleteOwner(owner);

            return "Owner is deleted!";

        }catch (Exception e){

            e.printStackTrace();
            return "Something wrong!";

        }

    }

    @DeleteMapping("/deleteOwnership/{id}")
    @ResponseBody
    public String deleteOwnership(HttpServletRequest request, @PathVariable(name = "id")Long id){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        CarOwnership ownership = new CarOwnership();

        try{
            ownership = ownershipService.getCarOwnership(id);

            ownershipService.deleteCarOwnership(ownership);

            return "Ownership is deleted!";

        }catch (Exception e){

            e.printStackTrace();
            return "Something wrong!";

        }

    }

    @PostMapping("/editOwner")
    @ResponseBody
    public String updateOwner(HttpServletRequest request, @RequestBody Owners updateOwner){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        try{

            Owners owners = ownersService.getOwner(updateOwner.getId());

            ownersService.saveOwner(new Owners(updateOwner.getId(), updateOwner.getOwnerName(), updateOwner.getDateOfBrith(), updateOwner.getAddress(), updateOwner.getCellNumber(), updateOwner.getUser_id()));

            return "The owner has been updated!";

        }catch (Exception e){
            e.printStackTrace();
            return "Something wrong!";
        }

    }

    @PostMapping("/editOwnership")
    @ResponseBody
    public String updateOwnership(HttpServletRequest request, @RequestBody CarOwnership updateOwnership){

        String token = request.getHeader("Authorization");
        if (token == null || token.isEmpty()) {
            return null;
        }

        try{

            CarOwnership ownership = ownershipService.getCarOwnership(updateOwnership.getId());

            System.out.println(updateOwnership.getCar_id());

            ownershipService.saveCarOwnership(new CarOwnership(updateOwnership.getId(), updateOwnership.getCar_id(), updateOwnership.getOwner(), updateOwnership.getOwnershipStartDate(), updateOwnership.getOwnershipEndDate()));

            return "The ownership has been updated!";

        }catch (Exception e){
            e.printStackTrace();
            return "Something wrong!";
        }

    }

}
