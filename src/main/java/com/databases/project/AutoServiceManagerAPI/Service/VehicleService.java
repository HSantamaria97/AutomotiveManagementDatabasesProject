package com.databases.project.AutoServiceManagerAPI.Service;

import com.databases.project.AutoServiceManagerAPI.Entity.Vehicle;
import com.databases.project.AutoServiceManagerAPI.Repository.VehicleRepository;
import com.google.common.base.Strings;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class VehicleService {
    VehicleRepository vehicleRepository;
    public Vehicle getVehicleById(long id)
    {
        return vehicleRepository.getVehicleById(id);
    }
    public List<Vehicle> getVehicleByMakeAndModel(String make, String model)
    {
        return vehicleRepository.getVehicleByMakeAndModel(make,model);
    }
    public void updateVehicleInfo(String make, String model, int year, long id)
    {
        if(!Strings.isNullOrEmpty(make))
            vehicleRepository.updateVehicleMake(make,id);
        if(!Strings.isNullOrEmpty(model))
            vehicleRepository.updateVehicleModel(model,id);
        if(year != 0)
            vehicleRepository.updateVehicleYear(year,id);
    }
    public void createVehicle(String make, String model, int year)
    {
        Vehicle vehicle = Vehicle.builder()
                                 .make(make)
                                 .model(model)
                                 .year(year)
                                 .build();
        vehicleRepository.save(vehicle);
    }
    public void deleteVehicleById(long id){
        vehicleRepository.deleteVehicleById(id);
    }
}
