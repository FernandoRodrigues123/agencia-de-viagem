package com.agenciadeviagem.repository;

import com.agenciadeviagem.model.Depoimento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepoimentoRepository extends JpaRepository<Depoimento, Long> {
}
