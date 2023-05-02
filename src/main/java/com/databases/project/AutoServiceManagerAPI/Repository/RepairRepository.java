package com.databases.project.AutoServiceManagerAPI.Repository;

import com.databases.project.AutoServiceManagerAPI.Entity.Repair;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RepairRepository extends CrudRepository<Repair, Long> {
    @Query("select u from repair u")
    List<Repair> getAllRepairs();

    @Query("select u from repair u where repairId = :repairId")
    Repair getRepairById(@Param("repairId") long repairId);

    @Query("select u from repair u inner join u.customer c where c.customerId = :customerId")
    List<Repair> getRepairByCustomerID(@Param("customerId") long customerId);

    @Query("select u from repair u inner join u.vehicle c where c.vehicleId = :vehicleId")
    List<Repair> getRepairByVehicleId(@Param("vehicleId")long vehicleId);
}
