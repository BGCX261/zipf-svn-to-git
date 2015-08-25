package zipf.IO;

import java.util.logging.Level;
import java.util.logging.Logger;

public class MidiClock implements Runnable {

    public long start;
    public Tempo systemTempo;
    long syncValue;
    static long tickCount;
    double syncQuality;
    double dropTime;
    long pendingDrops;
    long tick;
    long dropOuts;

    public MidiClock() {
        systemTempo = new Tempo(1875, 20);
        tick = systemTempo.tick;
    }

    @Override
    public void run() {

        start = System.currentTimeMillis();
        while (true) {
            syncValue = System.currentTimeMillis() - start - ((long) tickCount * tick);
            try {
                Thread.sleep(tick - syncValue);
                tick();
            } catch (IllegalArgumentException e) {
                pendingDrops = Math.abs(syncValue);
                for (int i = 0; i < (pendingDrops / tick); i++) {
                    tick();
                    dropOuts++;
                }
                syncValue = pendingDrops % tick;
                continue;
            } catch (InterruptedException ex) {
                Logger.getLogger(MidiClock.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    private void sync() {
    }

    public void tick() {
        tickCount++;

    }

    public String getQuality() {
        if (syncValue != 0) {
            dropOuts++;
        }
        dropTime += syncValue;
        syncQuality = Math.abs(((dropOuts / tickCount) * 100) - 100);
        StringBuilder sb = new StringBuilder();
        sb.append("tickCount: ").append(tickCount);
        sb.append("|  tick : ").append(systemTempo.tick);
        sb.append("|  sync : ").append(syncValue);
        sb.append("|  dropouts : ").append(dropOuts);
        sb.append("|  syncedTime : ").append(dropTime);
        sb.append("|  Quality: ").append(syncQuality);

        return sb.toString();
    }
}
