package com.delala.maleda.Repository;

import com.delala.maleda.Model.HouseRent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

public interface HouseRentRepository extends JpaRepository<HouseRent, Integer>, JpaSpecificationExecutor<HouseRent> {
}
