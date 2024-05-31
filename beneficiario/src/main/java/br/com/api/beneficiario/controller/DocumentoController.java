package br.com.api.beneficiario.controller;

import br.com.api.beneficiario.entities.Documento;
import br.com.api.beneficiario.service.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/beneficiario/{beneficiarioId}/documento")
@Tag(name = "Beneficiários", description = "API para cadastro beneficiarios e documentos")
public class DocumentoController {

    @Autowired
    private DocumentoService documentoService;

    @Operation(summary = "Retorna uma lista de documentos",
            description = "Retorna todos os documentos cadastrados")
    @GetMapping
    public ResponseEntity<List<Documento>> listarTodosOsDocumentos() {
        List<Documento> doc = documentoService.listarDocumentos();
        return ResponseEntity.ok(doc);
    }

    @Operation(summary = "Retorna uma lista de documentos de um beneficiarios",
            description = "Retorna um documento de um beneficiário, através de seu id")
    @GetMapping("/{documentoId}")
    public ResponseEntity<Documento> documentoPeloId(@PathVariable("documentoId") Long id) {
        Documento doc = documentoService.documentoPorId(id);
        return ResponseEntity.ok(doc);
    }

    @Operation(summary = "Cadastra um documento",
            description = "Cadastra um documento para o beneficiario com o id declarado no endpoint")
    @PostMapping
    public ResponseEntity<?> criarDocumento(@PathVariable("beneficiarioId") Long beneficarioId, @RequestBody Documento documento) {
        Documento doc = documentoService.criarDocumento(beneficarioId, documento);
        if(doc != null) {
            URI location = getUri(doc.getId());
            return ResponseEntity.created(location).build();
        } else {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }

    }

    @Operation(summary = "Atualiza um documento",
            description = "Atualiza um documento de um beneficiário com o id declarado no endpoint")
    @PutMapping("/{documentoId}")
    public ResponseEntity<?> atualizarDocumento(@PathVariable("beneficiarioId") Long beneficarioId, @PathVariable("documentoId") Long documentoId, @RequestBody Documento documento) {
        Documento doc = documentoService.atualizarDocumento(beneficarioId, documentoId, documento);
        return ResponseEntity.noContent().build();
    }

    @Operation(summary = "Exclui um documento",
            description = "Exclui um documento de um beneficiário com o id declarado no endpoint. Acao Irreversível")
    @DeleteMapping("/{documentoId}")
    public ResponseEntity<?> deletarDocumento(@PathVariable("beneficiarioId") Long beneficiarioId, @PathVariable("documentoId") Long documentoId) {
        documentoService.deletarDocumento(beneficiarioId, documentoId);
        return ResponseEntity.noContent().build();
    }

    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }
}
