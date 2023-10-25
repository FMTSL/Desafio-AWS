package aluno.gen.alunos.controller;

import aluno.gen.alunos.domain.aluno.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;


@RestController
@RequestMapping ("alunos")
public class AlunoController {

    @Autowired
    private AlunoRepository repository;

    //Método Post - Para Inserir Dados no Banco de Dados
    @PostMapping
    @Transactional
    public ResponseEntity cadastrar(@RequestBody @Valid DadosCadastroAluno dados, UriComponentsBuilder uriBuilder){
        var aluno = new Aluno(dados);
        repository.save(aluno);

        var uri = uriBuilder.path("/medicos/{id}").buildAndExpand(aluno.getId()).toUri();

        return ResponseEntity.created(uri).body(new DadosDetalhamentoAluno(aluno));
        //Código 201 - Created (Devolve no corpo da resposta os dados criados junto com o cabeçalho do protocolo HTTP - location)
    }

    //Método GET - Para Listar Dados do Banco de Dados
    @GetMapping
    public ResponseEntity <Page<DadosListagemAluno>> listar (Pageable paginacao){
        var page = repository.findAllByAtivoTrue(paginacao).map(DadosListagemAluno::new);

        return ResponseEntity.ok(page);
    }

    //Método Put - Para Atualizar os Dados inseridos no Banco de Dados
    @PutMapping
    @Transactional
    public ResponseEntity atualizar(@RequestBody @Valid DadosAtualizacaoAluno dados){
        var aluno = repository.getReferenceById(dados.id());
        aluno.atualizarInformacoes(dados);
        
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno));
    }

    //Método Delete - Para Excluir os Dados inseridos na tabela do Banco de Dados
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluir(@PathVariable Long id){
        var aluno = repository.getReferenceById(id);
        aluno.excluir();

        return ResponseEntity.noContent().build(); //Código 204 requisição processada e sem Conteúdo
    }

    //Detalhamento
    @GetMapping("/{id}")
    public ResponseEntity detalhar (@PathVariable Long id){
        var aluno = repository.getReferenceById(id);
        return ResponseEntity.ok(new DadosDetalhamentoAluno(aluno)); //Código 204 requisição processada e sem Conteúdo
    }


}
