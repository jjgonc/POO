package ficha5;

public class TesteTurmaAlunos {
    public static void main (String [] args){
        TurmaAlunos turma = new TurmaAlunos();
        turma.setNome("Nome da turma");
        turma.setCodigo("codigo da turma");
        Aluno a = new Aluno();
        a.setNome("Antonio");
        a.setNumero("1");
        turma.insereAluno(a);
        a.setNumero("2");
        turma.insereAluno(a);
        a.setNome("Maria");
        a.setNumero("3");
        turma.insereAluno(a);

        System.out.println("turma" +turma);
        System.out.println("Codigos" +turma.todosOsCodigos());
        System.out.println("ordem alfabetica" +turma.alunosOrdemAlfabetica());
        System.out.println("Ordem numerica" +turma.alunosOrdemDecrescenteNumero());
    }
}
