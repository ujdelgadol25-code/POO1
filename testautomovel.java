package lab1;

public class testautomovel {
    public static void main(String[] args) {
       
        
        automovel carro1=new automovel("12-34-AB","Toyota",1800);
        automovel carro2=new automovel("56-78-CD","Honda");

        System.out.println("Carro 1: Matricula: " + carro1.getMatricula() + ", Marca: " + carro1.getMarca() + ", Cilindrada: " + carro1.getCilindrada());
        System.out.println("Carro 2: Matricula: " + carro2.getMatricula() + ", Marca: " + carro2.getMarca() + ", Cilindrada: " + carro2.getCilindrada());
    }
}

