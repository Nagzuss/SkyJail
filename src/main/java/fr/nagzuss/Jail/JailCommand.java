package fr.nagzuss.Jail;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import fr.neskuik.core.api.player.PlayerAPI;
import org.bukkit.entity.Player;

@CommandAlias("jail")
@CommandPermission("jail.use")
public class JailCommand extends BaseCommand {

    PlayerAPI playerAPI;

    public JailCommand(PlayerAPI playerAPI) {
        this.playerAPI = playerAPI;
    }

    public void onCommand(Player player, String reason, String time) {
        playerAPI.sendMessage("Vous venez d'être mis en prison pour les raison : " + reason + " pour une durée de : " + time, player);
    }
}