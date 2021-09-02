package ficha6;

import com.sun.source.tree.LiteralTree;

import java.io.Serializable;
import java.lang.invoke.VarHandle;
import java.util.*;
import java.util.stream.Collectors;

public class Driveit implements Serializable {
    private Map<String, Veiculo> driveit_v; //nunca podemos ter chaves repetidas pq K é um set!!!       //neste caso usamos para o map, como key a Matricula!
    public boolean desconto;
    String nome;
    public static Map <String, Comparator<Veiculo>> comparadores = new HashMap<>();
    static final long serialVersionUID = 42L;

    public Driveit () {
        this.driveit_v = new HashMap<>();
        this.desconto = false;
    }

    public Driveit (String nome, Map <String, Veiculo> v) {
        setDriveit_v(v);
        this.desconto = false;
        this.nome = nome;
    }

    public Driveit (String nome, Map <String, Veiculo> v, boolean desconto) {
        setDriveit_v(v);
        this.desconto = desconto;
        this.nome = nome;
    }

    public Driveit (Driveit o) {
        driveit_v = o.getDriveit_v();
        this.desconto = o.getDesconto();

    }

    public String getNome () {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public boolean getDesconto () {
        return this.desconto;
    }

    public void setDesconto (boolean emDesconto) {
        this.desconto = emDesconto;
    }

    public Map <String, Veiculo> getDriveit_v () {
        return driveit_v
                .entrySet()
                .stream()
                .collect(Collectors.toMap(k-> k.getKey(), v-> v.getValue().clone()));
    }

    public void setDriveit_v (Map <String, Veiculo> driveit_v) {
        this.driveit_v
                .entrySet()
                .stream()
                .collect(Collectors.toMap(k-> k.getKey(), v-> v.getValue().clone()));
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driveit driveit = (Driveit) o;
        return driveit_v.equals(driveit.getDriveit_v());
    }

    public boolean existeVeiculo (String cod) {     //se estiver a matricula lá, o containsKey devolve true
        return this.driveit_v.containsKey(cod);
    }

    public int quantosVeiculos ()  {
        return this.driveit_v.size();
    }

    public int quantosMarca (String marca) {
        return (int) driveit_v
                     .values()
                     .stream()
                     .filter(v->v.getMarca().equals(marca))
                     .count();
    }

    public Veiculo getVeiculo (String cod) {    //get de uma key
        if (this.existeVeiculo(cod)) {
            return this.driveit_v
                    .get(cod).clone();
        }
        else return null;
    }

    public void adiciona (Veiculo v) {
        this.driveit_v.put(v.getMatricula(), v.clone());
    }

    public List<Veiculo> getVeiculos () {
        return this.driveit_v
                .values()
                .stream()
                .map(Veiculo::clone)
                .collect(Collectors.toList());
    }

    public void adiciona (Set<Veiculo> vs) {
        for (Veiculo v : vs) {
            this.driveit_v.put (v.getMatricula(), v);
        }
    }

    public void registarAluguer (String codVeiculo, int numKms) {
        if (driveit_v.containsKey(codVeiculo)) {
            this.driveit_v.get(codVeiculo).addViagem(numKms);
        }
    }

    public void classificarVeiculo (String cod, int classificacao) throws VeiculoInexistenteException, ValoresInvalidosException{  
        if (! driveit_v.containsKey(cod)) {
            throw new VeiculoInexistenteException();
        }
        else if (classificacao < 0 || classificacao > 10) {
            throw new ValoresInvalidosException();
        }
        else {
            driveit_v.get(cod).addClassificacao(classificacao);
        }
    }

    public double custoRealKm (String cod) {
        double custoReal = this.getVeiculos().stream().filter(v -> v.getMatricula().equals(cod)).mapToDouble(Veiculo::getPrecokm).sum();
        custoReal *= 1.1;
        return custoReal;
    }

    public void alteraPromocao (boolean estado) {
        this.setDesconto(estado);
        this.driveit_v.values()
                .stream()
                .filter(v-> v instanceof VeiculoOcasiao)
                .forEach(v->((VeiculoOcasiao)v).setemPromocao(estado));
    }

//para o ex3 da fase1
    public int quantosT (String tipo) {                 //EXPLICAR ESTE SFF
        return (int) this.driveit_v.values()
                .stream()
                .filter(v -> v.getClass().toString().split(" ")[1].equals(tipo))
                .count();
    }

    public List <Veiculo> veiculosOrdenadosCusto () {
        return this.driveit_v.values().stream()
                    .sorted(Comparator.comparingDouble(Veiculo::getPrecokm))    //se quisesse por ordem decrescente fazia .reversed() dentro do sorted
                    .collect(Collectors.toList());
    }


    public Veiculo veiculoMaisBarato () {
        List <Veiculo> list = this.veiculosOrdenadosCusto();
        return list.get(0);
        /*
        return this.driveit_v.values().stream()
                .sorted(Comparator.comparingDouble(Veiculo :: getPrecokm))
                .limit(1)
                .findFirst()
                .orElse(null);
        */
    }

    public Veiculo veiculoMenosUtilizado () {
        return this.driveit_v.values()
                .stream()
                .sorted(Comparator.comparingDouble(Veiculo::getKms))
                .limit(1)
                .map(Veiculo::clone)
                .findFirst()
                .orElse(null);
        /*
        //outro modo:
        return this.veiculosMap.values().stream()
                .min(Comparator.comparingDouble(Veiculo::getKms))
                .orElse(null);
         */
        /*
        //ainda outro modo

        if (this.driveit_v.size() > 0) {
            int min = Integer.MAX_VALUE;
            Veiculo ans = null;
            for (Veiculo v : this.driveit_v.values()) {
                if (v.getKms() < min) {
                    min = v.getKms();
                    ans = v;
                }
            }
            return v;
        }
        return null;
         */
    }

    public void defOcupacao () {
        AutocarroInteligente ai = new AutocarroInteligente();
        int i = 1;
        for (Veiculo v : this.driveit_v.values()) {
            if (this.driveit_v.size() > 0) {
                ai.setOcupacao((int) (85 * ai.getLotacao()) / 100);
            }
        }
    }

    public double valorMedioKm () {
        defOcupacao();
        int sum = 0;
        for (Veiculo v : this.driveit_v.values()) {
            sum += v.custoRealKM();
        }
        return (double) sum / this.driveit_v.size();
    }

//Fase 2

//alinea a)
    public Set <Veiculo> ordenarVeiculos() {
        return this.driveit_v.values().stream().map(Veiculo::clone).collect(Collectors.toCollection(TreeSet::new));
    }

    //alinea b)
    public List <Veiculo> odenarVeiculos () {
        List <Veiculo> res = new ArrayList<>();
        for (Veiculo v : this.driveit_v.values()) {
            res.add(v);
        }
        res.sort(Veiculo::compareTo);
        return res;
    }

    //alinea c)
    public Set <Veiculo> ordenarVeiculos (Comparator<Veiculo> c) {
        return this.driveit_v.values().stream()
                .sorted(c)
                .map(Veiculo::clone)
                .collect(Collectors.toCollection(TreeSet::new));    // o professor fez:  ()-> new TreeSet <> (c)
    }

    //alinea e)
    public Iterator <Veiculo> ordenarVeiculo (String criterio) {
        Comparator<Veiculo> comparator = comparadores.get(criterio);
        if (comparator == null) return null;
        return this.driveit_v.values().stream()
                .sorted(comparator)
                .iterator();
    }


//Fase 3
    public List <BonificaKms> daoPontos () {
        return driveit_v.values().stream().filter(v->v instanceof BonificaKms)
                .map(v-> (BonificaKms) v.clone()).collect(Collectors.toList());
    }
}

