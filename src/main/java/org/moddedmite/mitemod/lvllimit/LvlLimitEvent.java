package org.moddedmite.mitemod.lvllimit;

import moddedmite.rustedironcore.api.event.Handlers;
import moddedmite.rustedironcore.api.event.listener.IPlayerAttributeListener;

public class LvlLimitEvent extends Handlers {
	static void register() {
		Handlers.PlayerAttribute.register(new IPlayerAttributeListener() {
			@Override
			public int onLevelLimitModify(int original) {
				return LvlLimitConfig.PLAYER_MAX_LEVEL.getIntegerValue();
			}
			
			@Override
			public int onLevelMinLimitModify(int original) {
				return LvlLimitConfig.PLAYER_MIN_LEVEL.getIntegerValue();
			}
		});
	}
}
