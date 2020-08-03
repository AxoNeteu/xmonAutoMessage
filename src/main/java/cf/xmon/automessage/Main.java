package cf.xmon.automessage;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.NamespacedKey;
import org.bukkit.boss.BarColor;
import org.bukkit.boss.BarFlag;
import org.bukkit.boss.BarStyle;
import org.bukkit.boss.BossBar;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Main extends JavaPlugin {
    private Integer numerek = 0;
    @Override
    public void onEnable() {
        this.saveDefaultConfig();
        this.getLogger().info("Author Xmon");
        /*
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () ->{
            if (Bukkit.getOnlinePlayers().size() >= 1) {
                Bukkit.broadcastMessage(ChatColor.translateAlternateColorCodes('&', "&6[GLaDOS] &aSerwer sponsorowany jest przez hosting &2OctopusVPS.pl&a. Sprawdź ich ofertę!"));
            }
        }, this.getConfig().getInt("czas2"), this.getConfig().getInt("czas2"));
         */
        Bukkit.getScheduler().runTaskTimerAsynchronously(this, () ->{
            if (Bukkit.getOnlinePlayers().size() >= 1) {
                NamespacedKey nk = NamespacedKey.randomKey();
                Bukkit.createBossBar(nk , ChatColor.translateAlternateColorCodes('&', this.getConfig().getStringList("list").get(numerek)), BarColor.valueOf(this.getConfig().getStringList("colorlist").get(numerek)), BarStyle.valueOf(this.getConfig().getStringList("barstyle").get(numerek)), BarFlag.valueOf(this.getConfig().getStringList("barflag").get(numerek))).setProgress(0.00D);
                Bukkit.getOnlinePlayers().forEach(player -> Objects.requireNonNull(Bukkit.getBossBar(nk)).addPlayer(player));
                for(int i=0; i<50; i++){
                    Objects.requireNonNull(Bukkit.getBossBar(nk)).setProgress(Objects.requireNonNull(Bukkit.getBossBar(nk)).getProgress() + 0.019D);
                    try {
                        Thread.sleep(150);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                Objects.requireNonNull(Bukkit.getBossBar(nk)).removeAll();
                Bukkit.removeBossBar(nk);
                numerek++;
                if (numerek == this.getConfig().getStringList("list").size()){
                    numerek = 0;
                }
            }
        }, this.getConfig().getInt("czas"), this.getConfig().getInt("czas"));
    }

    @Override
    public void onLoad() {
        this.getLogger().info("Author Xmon");
    }

    @Override
    public void onDisable() {
        this.getLogger().info("Author Xmon");
    }
}
