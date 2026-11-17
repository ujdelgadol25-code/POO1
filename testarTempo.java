package lab1;


public class testarTempo {
   
        

    public static void main(String[] args) {
        tempo horario = new tempo(9, 30, 5);
        System.out.println("Hora: " + horario.getHora() + ":" + horario.getMinuto() + ":" + horario.getSegundo());
        tempo t = new tempo(23, 59, 59);
        tempo t3 = new tempo("013005");
        
        System.out.println(t.Hhmmss());
        tempo t2 = new tempo(7,45,50);
        System.out.println(t.paraAmPm());
        System.out.println(horario.diferenca(t2));
        t.acrescentarSegundo();
        System.out.println(t);
        System.out.println(t3.Hhmmss());
    }
}
