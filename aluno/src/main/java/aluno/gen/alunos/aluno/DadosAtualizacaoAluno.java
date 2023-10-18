package aluno.gen.alunos.aluno;

import javax.validation.constraints.NotNull;

public record DadosAtualizacaoAluno(

        //Para obrigar o usuário a informar id para alteração!
        @NotNull
        Long id,
        String nome,
        String idade,
        String nota1,
        String nota2,
        String professor,
        String sala) {
}
