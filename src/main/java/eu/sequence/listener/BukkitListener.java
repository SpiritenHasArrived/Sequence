package eu.sequence.listener;

import eu.sequence.Sequence;
import eu.sequence.data.PlayerData;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

public class BukkitListener implements Listener {

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onJoin(PlayerJoinEvent e)
    {
        Sequence.getInstance().getPlayerDataManager().add(e.getPlayer());
        if(e.getPlayer().hasPermission(Sequence.getInstance().getMainConfig().getAlertPermission())) {
            PlayerData pD = Sequence.getInstance().getPlayerDataManager().getPlayerData(e.getPlayer());
            Sequence.getInstance().getAlerting().add(pD);
        }
    }

    @EventHandler(ignoreCancelled = true, priority = EventPriority.MONITOR)
    public void onQuit(PlayerQuitEvent e) {
        PlayerData data = Sequence.getInstance().getPlayerDataManager().getPlayerData(e.getPlayer());

        data.delete();

        Sequence.getInstance().getPlayerDataManager().remove(e.getPlayer());
    }


    /**
>>>>>>> Stashed changes
    @EventHandler
    public void onEDBE(EntityDamageByEntityEvent e) {
        if(e.getEntity() instanceof Player) {

            final PlayerData data = Sequence.getInstance().getPlayerDataManager().getPlayerData((Player) e.getEntity());
            data.getVelocityProcessor().handleEDBE(e);
        }
    }
<<<<<<< Updated upstream
=======
    **/

}
