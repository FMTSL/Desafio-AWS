package aluno.gen.alunos.domain.aluno;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

//Entidade JPA (Java Persistence API)
@Table(name = "alunos")
@Entity(name = "Aluno")
@Getter //Gerar os getters
@NoArgsConstructor //Gerar o Default
@AllArgsConstructor
@EqualsAndHashCode (of = "id")
public class Aluno {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String idade;
    private String nota1;
    private String nota2;
    private String professor;
    private String sala;

    private Boolean ativo;

    public Aluno(DadosCadastroAluno dados) {
        this.ativo = true;
        this.nome = dados.nome();
        this.idade = dados.idade();
        this.nota1 = dados.nota1();
        this.nota2 = dados.nota2();
        this.professor = dados.professor();
        this.sala = dados.sala();
    }

    public void atualizarInformacoes(DadosAtualizacaoAluno dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.idade() != null){
            this.idade = dados.idade();
        }
        if(dados.nota1() != null){
            this.nota1 = dados.nota1();
        }
        if(dados.nota2() != null){
            this.nota2 = dados.nota2();
        }
        if(dados.professor() != null){
            this.professor = dados.professor();
        }
        if(dados.sala() != null){
            this.sala = dados.sala();
        }

    }

    public void excluir() {
        this.ativo = false;
    }
}
