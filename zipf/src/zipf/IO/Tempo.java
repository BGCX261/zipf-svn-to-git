package zipf.IO;

public class Tempo {

    public int tick;
    public int tack;
    public int timebase;
    public int tempo;
    public int takt;

    public Tempo(int tempo, int timebase) {
        this.tempo = tempo;
        this.timebase = timebase;
        setTempo(tempo);
    }

    public void setTempo(int tempo) {
        tick = 60000 / ((tempo / 4) * timebase);
        tack = 60000 / tempo;
    }
}
