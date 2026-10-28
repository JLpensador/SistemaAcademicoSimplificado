class FachadaAcademica {
    private final ServicoMatricula servico;
    private final CriadorComprovante criador;

    public FachadaAcademica(ServicoMatricula servico, CriadorComprovante criador) {
        this.servico = servico;
        this.criador = criador;
    }

    public String matricularEEmitir(Aluno aluno, Curso curso) {
        double total = servico.matricular(aluno, curso);
        return criador.emitir(aluno, curso, total);
    }
}