package ficha6;

//interfaces: determinado tipo de operaçoes que vamos ter que fazer
//interface é transparente
//existe herança multipla de interfaces

//para utilizar serializable, todos os objetos tem que ser serializable, se nao o programa vai estourar
//podemos definir nos nossos programas varios tipos de exceçoes
//exceçoes terminam com a palavra exception
/*
EXEMPLO:: public metodoA () throws exception x {

            throw new exception x();
                try{
                ....
                }
                catch (exception x e) {
                    ...
                }


          public metodoB () throws  exception x {
            metodoA();
 */

public interface BonificaKms {
    public void setPontosAtribuir (int pontosAtribuir);
    public int getPontosAtribuir();
    public int pontosAcumulados();
}
