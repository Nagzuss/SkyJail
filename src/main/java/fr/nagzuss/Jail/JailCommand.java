package fr.nagzuss.Jail;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import fr.neskuik.core.api.player.PlayerAPI;
import org.bukkit.entity.Player;


@CommandAlias("jail")
@CommandPermission("jail.use")
public class JailCommand extends BaseCommand {

    PlayerAPI playerapi;
    Player player;


    public void onCommand(Player player) {


        playerapi.sendMessage("Vous venez d'être mis en jail pour les raison :" + reason + "pour une durer de :" + time);



    }

}
