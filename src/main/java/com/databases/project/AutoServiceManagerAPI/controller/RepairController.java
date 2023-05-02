package com.databases.project.AutoServiceManagerAPI.controller;

import com.databases.project.AutoServiceManagerAPI.Entity.Repair;
import com.databases.project.AutoServiceManagerAPI.Service.RepairService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RepairController {
    @Autowired
    RepairService repairService;

    @GetMapping("/getrepairbyid")
    public ResponseEntity<Repair> getRepairById(long repairId)
    {
        return ResponseEntity.ok(repairService.getRepairById(repairId));
    }

    @PostMapping("/servicemanager/assigntotech")
    public ResponseEntity<String> assigntotech(long repairId, long userId)
    {
        repairService.assigntoTech(repairId,userId);
        return ResponseEntity.ok("Work was assigned to technician!");
    }
    @PostMapping("/servicemanager/createrepair")
    public ResponseEntity<String> createRepair(long customerId, long vehicleId, String repairDescription)
    {
        repairService.createNewRepair(customerId, vehicleId, repairDescription);
        return ResponseEntity.ok("New repair was created!");
    }
    @PostMapping("/markcompleted")
    public ResponseEntity<String> markAsCompleted(long repairId)
    {
        repairService.markAsCompleted(repairId);
        return ResponseEntity.ok("Marked as Completed");
    }
    @PostMapping("/addparts")
    public ResponseEntity<String> addParts(long repairId,String partName, String partNumber,int partQuantity)
    {
        repairService.addReqParts(repairId, partName, partNumber, partQuantity);
        return ResponseEntity.ok("Parts were added!");
    }
    @GetMapping("/getallrepairs")
    public ResponseEntity<List<Repair>> getAllRepairs(){
        return ResponseEntity.ok(repairService.getAllRepairs());
    }

    @GetMapping("/getrepairbycustomerid")
    public ResponseEntity<List<Repair>> getRepairByCustomerId(long customerId){return ResponseEntity.ok(repairService.getRepairByCustomerId(customerId));}

    @GetMapping("/getrepairbyvehicleid")
    public ResponseEntity<List<Repair>> getRepairByVehicleId(long vehicleId){return ResponseEntity.ok(repairService.getRepairByVehicleId(vehicleId));}
}
