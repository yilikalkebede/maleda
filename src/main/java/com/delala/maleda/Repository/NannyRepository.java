package com.delala.maleda.Repository;

import com.delala.maleda.Model.Nanny;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface NannyRepository extends JpaRepository<Nanny, Integer>, JpaSpecificationExecutor<Nanny> {
}
