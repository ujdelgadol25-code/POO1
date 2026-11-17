package lab1;
public class automovel {
    private String matricula;
    private String marca;
    private int cilindrada;
    private final int CILINDRADA_POR_OMISSAO=1000;

    public automovel(String matricula, String marca, int cilindrada){
        this.matricula=matricula;
        this.marca=marca;
       if (cilindrada<0){
            this.cilindrada=CILINDRADA_POR_OMISSAO;
            return;
        }
        this.cilindrada=cilindrada;

    }
    public automovel(String matricula, String marca){
        this.matricula=matricula;
        this.marca=marca;
        this.cilindrada=CILINDRADA_POR_OMISSAO;
        
    }


    public String getMatricula(){
        return matricula;
    }

    public String getMarca(){
        return marca;
    }

    public int getCilindrada(){
        return cilindrada;
    }

    public boolean setMatricula(String matricula){
        if(matricula.isEmpty()) return false;
        if (matricula == null) return false;
        this.matricula=matricula;
        return true; 
    }
}
