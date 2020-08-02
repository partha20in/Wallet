package com.cepheid.cloud.skel.repository;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.cepheid.cloud.skel.model.*;

@Repository
public interface DescriptionRepository extends JpaRepository<Description, Long> {

Optional<Description> findById(Long Id);
List<Description> findAll();
void deleteById(Long Id);
Description save(Description d);
}
