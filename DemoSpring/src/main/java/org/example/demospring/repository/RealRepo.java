package org.example.demospring.repository;

import org.example.demospring.model.Real;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RealRepo extends JpaRepository<Real, Integer> {
}
