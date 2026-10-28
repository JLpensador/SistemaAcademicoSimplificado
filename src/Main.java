public class Main {
    public static void main(String[] args) {
        System.out.println(Configuracao.getInstancia().getNome());
        
        Aluno aluno = new Aluno("Ana");
        Curso curso = new Curso("Java", 200.0);
        
        ServicoMatricula servico = new ServicoMatricula(
            new DescontoEstudante(), 
            new AdaptadorPagamento(new SistemaLegado())
        );
        
        servico.inscrever(new AvisoEmail());
        servico.inscrever(new Auditoria());
        
        System.out.println(servico.matricular(aluno, curso));
        System.out.println("Cursos do aluno: " + aluno.getQuantidadeCursos());
    }
}