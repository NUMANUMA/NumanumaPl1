package com.github.NUMANUMA.NumanumaPl1;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.World;
import org.bukkit.block.Block;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.BlockPlaceEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

public class Event implements Listener
{
    public Event(NumanumaPl1 plugin){
    }

    //イベントたち
    @EventHandler
    public void onBlockPlace(BlockPlaceEvent e) {

        Player player = e.getPlayer();

        //ガラスの上に金ブロック置いたらスポーンってスポンジが飛んでいくのとダイヤモンドが16個出てくる
        if(e.getBlockPlaced().getType() == Material.GLASS) {
            Location loc = e.getBlockPlaced().getLocation();
            World w = loc.getWorld();
            Block bg = w.getBlockAt(loc);

            loc.setY(loc.getY() - 1);
            Block b = w.getBlockAt(loc);

            if(b.getType() == Material.GOLD_BLOCK) {
                bg.setType(Material.AIR);
                b.setType(Material.NETHERRACK);
                loc.setY(loc.getY() + 1);

                player.getWorld().dropItem(loc,new ItemStack(Material.DIAMOND,16));

                loc.setY(loc.getY() + 1);
                Entity ent = player.getWorld().spawnFallingBlock(loc,Material.SPONGE,(byte) 0);
                ent.setVelocity(new Vector(0,2,0));
            }
        }
    }
}
