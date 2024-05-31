package br.com.api.beneficiario.controller;

import br.com.api.beneficiario.entities.Beneficiario;
import br.com.api.beneficiario.service.BeneficiarioService;
import br.com.api.beneficiario.service.DocumentoService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/beneficiario")
@Tag(name = "Beneficiários", description = "API para cadastro beneficiarios e documentos")
public class BeneficiarioController {

    @Autowired
    private BeneficiarioService beneficiario;
    private DocumentoService documento;

    @Operation(summary = "Retorna uma lista de beneficiarios",
            description = "Retorna todos os beneficiarios cadastrados")
    @GetMapping
    public ResponseEntity<List<Beneficiario>> listarBeneficiarios() {
        return ResponseEntity.ok(beneficiario.listarBeneficiarios());
    }

    @Operation(summary = "Retorna um beneficiario",
            description = "Retorna um beneficario, atraves de seu id")
    @GetMapping("/{id}")
    public ResponseEntity<Beneficiario> beneficiarioPeloId(@PathVariable("id") Long id) {
        Beneficiario bf = beneficiario.buscarBeneficiarioPorId(id);
        return ResponseEntity.ok(bf);
    }

    @Operation(summary = "Cadastra um beneficiario",
            description = "Cadastra um beneficiario na base de dados")
    @PostMapping
    public  ResponseEntity<Beneficiario> adicionarBeneficiario(@RequestBody Beneficiario bf) {

        Beneficiario b = beneficiario.adicionar(bf);
        URI location = getUri(b.getId());
        return ResponseEntity.created(location).build();
    }

    @Operation(summary = "Atualiza dados de um beneficiario",
            description = "Atualiza todos os dados de um beneficiario, atraves de seu id")
    @PutMapping("/{id}")
    public ResponseEntity<Beneficiario> atualizarBeneficiario(@PathVariable("id") Long id, @RequestBody Beneficiario bf) {
        bf.setId(id);
        Beneficiario b = beneficiario.atualizarBeneficiario(bf, id);
        return b != null ?  ResponseEntity.ok(b) : ResponseEntity.notFound().build();
    }

    @Operation(summary = "Exclui um beneficiario da base de dados",
            description = "Exclui um beneficiario da base de dados. Acao irreversível")
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletarBeneficiario(@PathVariable("id") Long id) {
        beneficiario.deletarBeneficiario(id);
        return ResponseEntity.noContent().build();
    }


    private URI getUri(Long id) {
        return ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(id).toUri();
    }
}


