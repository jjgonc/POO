package ficha5;

import java.util.*;
import java.util.stream.Collectors;

public class TurmaAlunos {
    private String nome;
    private String codigo;
    private Map<String, Aluno> alunos;

    public TurmaAlunos (){
        nome = "";
        codigo = "";
        alunos = new HashMap<>();
    }

    public TurmaAlunos (TurmaAlunos turma) {
        this.nome = turma.getNome();
        this.codigo = turma.getCodigo();
        this.alunos = turma.getAlunos();
    }

    public void insereAluno (Aluno a) {
        alunos.put(a.getNumero(), a.clone());
    }

    public void removeAluno (String codAluno) {
        alunos.remove(codAluno);
    }

    public Set<String> todosOsCodigos () {
        return alunos.keySet(); //podemos retornar o keyset pq as chaves que estao la sao constantes
    }

    public int qtsAlunos () {
        return alunos.size();
    }

    public Set<Aluno> alunosOrdemAlfabetica () {
        //requesito para um objeto ser usado no treeSet é ser comparable (e é na classe aluno.java)
        return alunos
                .values()
                .stream()
                .map(Aluno:: clone)
                .collect(Collectors.toCollection(TreeSet::new)); //meter o objetos todos num treeSet para implementar um Set ORDENADO!!!
    }

    public  Set<Aluno> alunosOrdemDecrescenteNumero () {
        TreeSet<Aluno> res = new TreeSet<>(new Comparator<Aluno>() {
            //este codigo esta em memoria e deixa de ser possivel usar fora desta funçao
            public int compare(Aluno o1, Aluno o2) {
                return o2.getNumero().compareTo(o1.getNumero());
            }
        });

        for (Aluno a: alunos.values()) {
            res.add(a.clone());
        }

        return res;
    }

    public Aluno getAluno (String codAluno) {
        if (alunos.containsKey(codAluno)) {
            return alunos.get(codAluno).clone();
        }
        return null;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Map<String, Aluno> getAlunos() {
        /*
        //usando o keyset
        return alunos
                .keySet()
                .stream()
                .collect(Collectors.toMap(k -> k, k-> alunos.get(k).clone()));

         */

        //alternativa seria usando os values...
        return alunos.values().stream().map(Aluno:: clone).collect(Collectors.toMap(v -> v.getNumero(), v -> v));
    }

    public void setAlunos(Map<String, Aluno> alunos) {
        this.alunos = alunos
                .entrySet()
                .stream().collect((Collectors.toMap(k -> k.getKey(), k -> k.getValue().clone())));
    }

    @Override
    public String toString() {
        return "TurmaAlunos{" +
                "nome='" + nome + '\'' +
                ", codigo='" + codigo + '\'' +
                ", alunos=" + alunos +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TurmaAlunos that = (TurmaAlunos) o;
        return nome.equals(that.nome) &&
                codigo.equals(that.codigo) &&
                alunos.equals(that.alunos);
    }


    public TurmaAlunos (String nome, String codigo, Map <String, Aluno> alunos) {
        this.nome = nome;
        this.codigo = codigo;
        setAlunos(alunos);
    }
}
