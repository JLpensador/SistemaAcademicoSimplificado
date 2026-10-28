import java.util.ArrayList;
import java.util.List;

class ServicoMatricula {
    private final Desconto desconto;
    private final RegistradorPagamento pagamento;
    private final List<ObservadorMatricula> observadores = new ArrayList<>();

    public ServicoMatricula(Desconto desconto, RegistradorPagamento pagamento) {
        this.desconto = desconto;
        this.pagamento = pagamento;
    }

    public void inscrever(ObservadorMatricula observador) {
        observadores.add(observador);
    }

    public double matricular(Aluno aluno, Curso curso) {
        double total = desconto.aplicar(curso.getPreco());
        pagamento.registrar(total);
        aluno.adicionarCurso(curso);
        
        for (ObservadorMatricula o : observadores) {
            o.atualizar(aluno.getNome() + " matriculado em " + curso.getTitulo());
        }
        return total;
    }
}