package br.com.api.beneficiario.repository;

import br.com.api.beneficiario.entities.Documento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentoRepository extends JpaRepository<Documento, Long> {
    @Query("SELECT d FROM Documento d WHERE d.beneficiario.id = :beneficiarioId")
    List<Documento> encontrarPorBeneficiario(Long beneficiarioId);
}
