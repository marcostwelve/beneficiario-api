package br.com.api.beneficiario.service;

import br.com.api.beneficiario.entities.Beneficiario;
import br.com.api.beneficiario.exception.ObjectNotFoundException;
import br.com.api.beneficiario.repository.BeneficiarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class BeneficiarioService {

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public List<Beneficiario> listarBeneficiarios() {
        return beneficiarioRepository.findAll();
    }

    public Beneficiario buscarBeneficiarioPorId(Long id) {
        Optional<Beneficiario> beneficiario = beneficiarioRepository.findById(id);
        return beneficiario.orElseThrow(() -> new ObjectNotFoundException("Beneficiário não encontrado"));
    }

    public Beneficiario adicionar(Beneficiario beneficiario) {
        Assert.isNull(beneficiario.getId(), "Não foi possível adicionar beneficiário");
        return beneficiarioRepository.save(beneficiario);
    }

    public Beneficiario atualizarBeneficiario(Beneficiario beneficiario, Long id) {
        Assert.notNull(id, "Não foi possível atualizar o beneficiário");

        Optional<Beneficiario> beneficiarioOp = beneficiarioRepository.findById(id);

        if (beneficiarioOp.isPresent()) {
            Beneficiario beneficiarioDb = beneficiarioOp.get();
            beneficiarioDb.setNome(beneficiario.getNome());
            beneficiarioDb.setTelefone(beneficiario.getTelefone());
            beneficiarioDb.setDataNascimento(beneficiario.getDataNascimento());
            beneficiarioDb.setDataAtualizacao(beneficiario.getDataAtualizacao());

           return beneficiarioRepository.save(beneficiarioDb);
        }
        else  {
            throw new RuntimeException("Não foi possível atualizar o beneficiario");
        }
    }

    public void deletarBeneficiario(Long id) {
        if (!beneficiarioRepository.existsById(id)) {
           throw new IllegalArgumentException("Beneficiário não encontrado com o ID:" + id);
        }
        beneficiarioRepository.deleteById(id);
    }
}
