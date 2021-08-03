package eu.sequence.data;

import eu.sequence.event.PacketEvent;

public abstract class Processor {

    /**
     * @author Salers
     **/

    public abstract void handleReceive(PacketEvent event);

    public abstract void handleSending(PacketEvent event);
}
