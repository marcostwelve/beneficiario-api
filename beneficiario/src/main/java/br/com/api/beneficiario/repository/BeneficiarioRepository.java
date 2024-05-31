package br.com.api.beneficiario.repository;

import br.com.api.beneficiario.entities.Beneficiario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BeneficiarioRepository  extends JpaRepository<Beneficiario, Long> {
}
