package com.github.kinoko_team.spectator2;

import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.block.Block;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.BlockIterator;

public final class Spectator2 extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);
    }

    public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args) {
        if(cmd.getName().equalsIgnoreCase("HideMe") && args.length == 1) {

            // コマンド実行者がプレイヤーかどうかを確認します。
            if (!(sender instanceof Player)) {
                sender.sendMessage("このコマンドはゲーム内から実行してください！");
                return true;
            }
            // sender instanceof Player の検査が終わっているので、Playerクラスへ安全にキャストできます。
            Player s = (Player) sender;

            // コマンドのパラメータに、対象のプレイヤーが指定されているかどうかを確認します。
            if (args.length != 1) {
                // onCommandでfalseを戻すと、plugin.ymlのusageに設定したメッセージを
                // コマンド実行者の画面に表示します。
                return false;
            }

            // 指定されたプレイヤーを取得します。
            // 指定されたプレイヤーがサーバーに接続していない場合、targetはnullになります。
            Player target = Bukkit.getPlayerExact(args[0]);
            if (target == null) {
                sender.sendMessage("Player " + args[0] + " というプレイヤーは見つかりません！");
                return true;
            }
            // プレイヤー "s" を、指定したプレイヤー "target" から、非表示に設定します。
            target.hidePlayer(s);
            return true;
        }
        return false;

    }




    /***
     * 稲妻（いなずま）を落とす
     * @param event
     */


}
