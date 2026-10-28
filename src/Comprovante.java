interface Comprovante {
    String gerar(Aluno aluno, Curso curso, double valor);
}

class ComprovanteTexto implements Comprovante {
    public String gerar(Aluno aluno, Curso curso, double valor) {
        return "Matrícula: " + aluno.getNome() + "/" + curso.getTitulo() + "/ R$ " + valor;
    }
}

class ComprovanteResumido implements Comprovante {
    public String gerar(Aluno aluno, Curso curso, double valor) {
        return aluno.getNome() + " R$" + valor;
    }
}

abstract class CriadorComprovante {
    public abstract Comprovante criar();

    public String emitir(Aluno aluno, Curso curso, double valor) {
        return criar().gerar(aluno, curso, valor);
    }
}

class CriadorTexto extends CriadorComprovante {
    public Comprovante criar() {
        return new ComprovanteTexto();
    }
}

class CriadorResumido extends CriadorComprovante {
    public Comprovante criar() {
        return new ComprovanteResumido();
    }
}