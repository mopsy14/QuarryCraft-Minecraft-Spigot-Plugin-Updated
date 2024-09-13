package com.nullbyte.quarrycraft;

import me.ryanhamshire.GriefPrevention.Claim;
import me.ryanhamshire.GriefPrevention.ClaimPermission;
import me.ryanhamshire.GriefPrevention.GriefPrevention;
import org.bukkit.Location;
import org.bukkit.entity.Player;

import java.util.function.Supplier;

public class GriefPreventionHandler {
	
	public static boolean checkLocation(Player owner, Location l) {
		Claim claim = GriefPrevention.instance.dataStore.getClaimAt(l, true, null);
		if(claim != null){
			Supplier<String> stringSupplier = claim.checkPermission(owner,ClaimPermission.Build,null);
			return stringSupplier != null && stringSupplier.get() == null;
		}
		return true;
	}
}
