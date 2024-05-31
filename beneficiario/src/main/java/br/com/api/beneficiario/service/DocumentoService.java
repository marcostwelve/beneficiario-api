package br.com.api.beneficiario.service;

import br.com.api.beneficiario.entities.Documento;
import br.com.api.beneficiario.exception.ObjectNotFoundException;
import br.com.api.beneficiario.repository.BeneficiarioRepository;
import br.com.api.beneficiario.repository.DocumentoRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Optional;

@Service
public class DocumentoService {

    @Autowired
    private DocumentoRepository documentoRepository;

    @Autowired
    private BeneficiarioRepository beneficiarioRepository;

    public List<Documento> listarDocumentos() {
        return documentoRepository.findAll();
    }

    public List<Documento> documentosPorBeneficiarios(Long id) {
        return documentoRepository.encontrarPorBeneficiario(id);
    }

    public Documento documentoPorId(Long id) {
        Optional<Documento> doc = documentoRepository.findById(id);
        return doc.orElseThrow(() -> new ObjectNotFoundException("Documento não encontrado"));
    }

    @Transactional
    public Documento criarDocumento(Long beneficarioId, Documento doc) {
        Assert.isNull(doc.getId(), "Não foi possível adicionar documento");
        return beneficiarioRepository.findById(beneficarioId).map(beneficiario -> {
            doc.setBeneficiario(beneficiario);
            return documentoRepository.save(doc);
        }).orElseThrow(() -> new ObjectNotFoundException("Usuário não encontrado com o ID: " + beneficarioId));
    }

    @Transactional
    public Documento atualizarDocumento(Long beneficarioId,  Long documentoId, Documento requestDocumento) {
        if(!beneficiarioRepository.existsById(beneficarioId)) {
            throw new ObjectNotFoundException("Usuário não encontrado com o id " + beneficarioId);
        }

        return documentoRepository.findById(documentoId).map(doc -> {
            doc.setTipoDocumento(requestDocumento.getTipoDocumento());
            doc.setDescricao(requestDocumento.getDescricao());
            doc.setDataAtualizacao(requestDocumento.getDataAtualizacao());
            return documentoRepository.save(requestDocumento);
        }).orElseThrow(() -> new ObjectNotFoundException("Documento não encontrado com o Id " + documentoId));
    }

    @Transactional
    public void deletarDocumento(Long beneficarioId, Long documentoId) {
        if (!beneficiarioRepository.existsById(beneficarioId)) {
           throw new ObjectNotFoundException("Documento não encontrado com ID: " + beneficarioId);
        }
       documentoRepository.findById(documentoId).map(doc -> {
           documentoRepository.delete(doc);
           return doc;
       }).orElseThrow(() -> new ObjectNotFoundException("Documento não encontrado com o ID " + documentoId));
    }
}
