package aluno.gen.alunos.aluno;

public record DadosDetalhamentoAluno(
        Long id,
        String nome,
        String idade,
        String nota1,
        String nota2,
        String professor,
        String sala) {

    public DadosDetalhamentoAluno(Aluno aluno){
        this(aluno.getId(), aluno.getNome(), aluno.getIdade(), aluno.getNota1(), aluno.getNota2(), aluno.getProfessor(), aluno.getSala());
    }
}
