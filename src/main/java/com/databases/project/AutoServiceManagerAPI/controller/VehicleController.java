package com.databases.project.AutoServiceManagerAPI.controller;

import com.databases.project.AutoServiceManagerAPI.Entity.Vehicle;
import com.databases.project.AutoServiceManagerAPI.Service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping("/getvehiclebyid")
    public ResponseEntity<Vehicle> getVehicleById(long vehicleId){
        return ResponseEntity.ok(vehicleService.getVehicleById(vehicleId));
    }
    @GetMapping("/getvehiclebymakeandmodel")
    public ResponseEntity<List<Vehicle>> getVehicleByMakeAndModel(String make, String model){
        return ResponseEntity.ok(vehicleService.getVehicleByMakeAndModel(make, model));
    }
    @PostMapping("/servicemanager/updatevehicleinfo")
    public ResponseEntity<String> updateVehicle(String make, String model, int year, long id)
    {
        vehicleService.updateVehicleInfo(make, model, year, id);
        return ResponseEntity.ok("Vehicle updated!");
    }
    @PostMapping("/servicemanager/deletevehicle")
    public ResponseEntity<String> deleteVehicle(long id)
    {
        vehicleService.deleteVehicleById(id);
        return ResponseEntity.ok("Vehicle deleted!");
    }
    @PostMapping("/servicemanager/newvehicle")
    public ResponseEntity<String> createNewVehicle(String make, String model, int year)
    {
        vehicleService.createVehicle(make, model, year);
        return ResponseEntity.ok("Vehicle Created!");
    }


}
