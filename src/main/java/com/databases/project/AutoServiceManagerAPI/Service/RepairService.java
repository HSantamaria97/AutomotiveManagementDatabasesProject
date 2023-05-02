package com.databases.project.AutoServiceManagerAPI.Service;

import com.databases.project.AutoServiceManagerAPI.Entity.Parts;
import com.databases.project.AutoServiceManagerAPI.Entity.Repair;
import com.databases.project.AutoServiceManagerAPI.Entity.User;
import com.databases.project.AutoServiceManagerAPI.Repository.RepairRepository;
import com.databases.project.AutoServiceManagerAPI.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RepairService {
    @Autowired
    RepairRepository repairRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;
    @Autowired
    VehicleService vehicleService;


    public Repair getRepairById(long repairId)
    {
        return repairRepository.getRepairById(repairId);
    }
    public void assigntoTech(long repairId, long technicianId){
        User tech = userService.getUserById(3);
        tech.getRepairs().add(repairRepository.getRepairById(repairId));
        userRepository.save(tech);
    }

     public void createNewRepair(long customerId, long vehicleId, String repairDescription){
        Repair repair = Repair.builder().customer(customerService
                              .getCustomerById(customerId))
                              .vehicle(vehicleService.getVehicleById(vehicleId))
                              .repairDescription(repairDescription).build();
        repairRepository.save(repair);
     }
     public void addReqParts(long repairId,String partName, String partNumber,int partQuantity)
     {
         Repair repair = repairRepository.getRepairById(repairId);
         repair.getParts().add(Parts.builder().partName(partName).partNumber(partNumber).partQuantity(partQuantity).build());
         repairRepository.save(repair);
     }
     public void markAsCompleted(long repairId)
     {
         Repair repair = repairRepository.getRepairById(repairId);
         repair.setCompleted(true);
         repairRepository.save(repair);
     }
     public List<Repair> getAllRepairs()
     {
         return repairRepository.getAllRepairs();
     }
     public List<Repair> getRepairByCustomerId(long customerId)
     {
         return repairRepository.getRepairByCustomerID(customerId);
     }
}
