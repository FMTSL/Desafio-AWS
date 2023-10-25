package aluno.gen.alunos.domain.aluno;

public record DadosListagemAluno(
        Long id,
        String nome,
        String idade,
        String nota1,
        String nota2,
        String professor,
        String sala) {

    public DadosListagemAluno (Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getNota1(), aluno.getNota2(), aluno.getProfessor(), aluno.getSala());
    }
}
