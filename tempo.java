package lab1;


public class tempo{
    private int hora;
    private int  minuto;
    private int segundo;
//construtores
    public tempo(int hora, int minuto, int segundo){
        if(hora<0 || hora>23){
            this.hora=0;
            return;
        }this.hora=hora;

        if(minuto<0 || minuto>59){
            this.minuto=0;
            return;
        }this.minuto=minuto;

        if(segundo<0 ||  segundo>59){
            this.segundo=0;
            return;
        }this.segundo=segundo;

    }


    public tempo(int hora, int minuto){
        if(hora<0 || hora>23){
            this.hora=0;
            return;
        }this.hora=hora;

        if(minuto<0 || minuto>59){
            this.minuto=0;
            return;
        }this.minuto=minuto;

        this.segundo=0;
    }

    public tempo(int hora){
        if(hora<0|| hora>23){
            this.hora=0;
            return;
        }this.hora=hora;

        this.minuto=0;
        this.segundo=0;
    }

    public tempo(){
        this.hora=0;
        this.minuto=0;
        this.segundo=0;
    }

      // Construtor que recebe a string "013005" e usa substring
    public tempo(String texto) {
        if (texto != null && texto.length() == 6) {
            // Corta a string em pedaços de 2 caracteres
            String strH = texto.substring(0, 2); // "01"
            String strM = texto.substring(2, 4); // "30"
            String strS = texto.substring(4, 6); // "05"

            // Converte para inteiro e valida usando os teus métodos set
            this.hora = 0;
            this.minuto = 0;
            this.segundo = 0;

            try {
                setHora(Integer.parseInt(strH));
                setMinuto(Integer.parseInt(strM));
                setSegundo(Integer.parseInt(strS));
            } catch (NumberFormatException e) {
                // Se vierem letras em vez de números, fica a 0
                this.hora = 0;
                this.minuto = 0;
                this.segundo = 0;
            }
        } else {
            this.hora = 0;
            this.minuto = 0;
            this.segundo = 0;
        }
    }   

//getters e setters
    public int getHora(){
        return hora;
    }

    public int getMinuto(){
        return minuto;
    }

    public int getSegundo(){
        return segundo;
    }

    public boolean setHora(int hora){
        if(hora<0 || hora>23){
            return false;
        }this.hora=hora;
        return true;
    }

    public boolean setMinuto(int minuto){
        if(minuto<0 || minuto>59){
            return false;
        }this.minuto=minuto;
        return true;
    }

    public boolean setSegundo(int segundo){
        if(segundo<0 || segundo>59){
            return false;
        }this.segundo=segundo;
        return true;
    }

    //metodo
    public String Hhmmss() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);
    }

    // Converte para formato AM/PM usando if-else
    public String paraAmPm() {
        int h12;
        String ampm;

        // Define se é AM ou PM com base na hora atual
        if (this.hora < 12) {
            ampm = "AM";
        } else {
            ampm = "PM";
        }

        // Ajusta a hora para o formato de 12 horas
        if (this.hora == 0) {
            h12 = 12; // Meia-noite é 12 AM
        } else if (this.hora > 12) {
            h12 = this.hora - 12; // Horas da tarde/noite (ex: 13 vira 1)
        } else {
            h12 = this.hora; // 12 PM ou horas normais da manhã (ex: 12 vira 12)
        }

        return String.format("%02d:%02d:%02d %s", h12, this.minuto, this.segundo, ampm);
    }

    // Soma um segundo, gerindo a viragem de minutos e horas[cite: 9]
    public void acrescentarSegundo() {
        this.segundo++;
        if (this.segundo > 59) {
            this.segundo = 0;
            this.minuto++;
            if (this.minuto > 59) {
                this.minuto = 0;
                this.hora++;
                if (this.hora > 23) {
                    this.hora = 0;
                }
            }
        }
    }

    // Retorna o total de segundos desde as 00:00:00[cite: 9]
    public int emSegundos() {
        return (this.hora * 3600) + (this.minuto * 60) + this.segundo;
    }

    // Cria um objeto Tempo a partir de um total de segundos (método estático)[cite: 9]
    public static tempo deSegundos(int total) {
        total = Math.abs(total) % 86400; // Garante que fica dentro do dia (24h)
        int h = total / 3600;
        int m = (total % 3600) / 60;
        int s = total % 60;
        return new tempo(h, m, s);
    }

    // Calcula a diferença para outro Tempo (sempre positiva)[cite: 9]
    public tempo diferenca(tempo outro) {
        int diff = Math.abs(this.emSegundos() - outro.emSegundos());
        return tempo.deSegundos(diff);
    }

    @Override
    public String toString() {
        return String.format("%02d:%02d:%02d", this.hora, this.minuto, this.segundo);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        tempo outro = (tempo) obj;
        return this.emSegundos() == outro.emSegundos();
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(hora, minuto, segundo);
    }
}