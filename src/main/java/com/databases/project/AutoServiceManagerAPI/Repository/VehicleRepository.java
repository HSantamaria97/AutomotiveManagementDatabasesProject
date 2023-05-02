package com.databases.project.AutoServiceManagerAPI.Repository;

import com.databases.project.AutoServiceManagerAPI.Entity.User;
import com.databases.project.AutoServiceManagerAPI.Entity.Vehicle;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
public interface VehicleRepository extends CrudRepository<Vehicle, Long> {
    @Query("SELECT u FROM vehicle u WHERE u.vehicleId = :vehicleId")
    Vehicle getVehicleById(@Param("vehicleId") long vehicleId);

    @Query("Select u from vehicle u where u.make = :make and u.model = :model")
    List<Vehicle> getVehicleByMakeAndModel(@Param("make") String make, @Param("model") String model);

    @Modifying
    @Transactional
    @Query("update vehicle set make = :make where vehicleId = :vehicleId")
    void updateVehicleMake(@Param("make") String make, @Param("vehicleId") long vehicleId);

    @Modifying
    @Transactional
    @Query("update vehicle set model = :model where vehicleId = :vehicleId")
    void updateVehicleModel(@Param("model") String model, @Param("vehicleId") long vehicleId);

    @Modifying
    @Transactional
    @Query("update vehicle set year = :year where vehicleId = :vehicleId")
    void updateVehicleYear(@Param("year") int year, @Param("vehicleId") long vehicleId);

    @Modifying
    @Transactional
    @Query("delete from vehicle where vehicleId = :vehicleId")
    void deleteVehicleById(@Param("vehicleId") long vehicleId);
}
