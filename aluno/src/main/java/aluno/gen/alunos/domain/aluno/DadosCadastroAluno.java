package aluno.gen.alunos.domain.aluno;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

//DTO (Data Transfer Object)
public record DadosCadastroAluno(
        @NotBlank
        String nome,
        @NotNull
        String idade,
        @NotNull
        String nota1,
        @NotNull
        String nota2,
        @NotBlank
        String professor,
        @NotNull
        String sala) {
}
