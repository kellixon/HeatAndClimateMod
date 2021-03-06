package defeatedcrow.hac.plugin;

import defeatedcrow.hac.api.damage.DamageAPI;
import net.minecraft.entity.EntityList;
import net.minecraft.util.ResourceLocation;

public class MobResistantData {
	public static final MobResistantData INSTANCE = new MobResistantData();

	private MobResistantData() {}

	public static void load() {
		Class blizz = EntityList.getClass(new ResourceLocation("thermalfoundation", "blizz"));
		Class blitz = EntityList.getClass(new ResourceLocation("thermalfoundation", "blitz"));
		Class basalz = EntityList.getClass(new ResourceLocation("thermalfoundation", "basalz"));

		Class chast = EntityList.getClass(new ResourceLocation("schr0chastmob", "chast"));

		DamageAPI.resistantData.registerEntityResistant(blizz, 0.0F, 6.0F);
		DamageAPI.resistantData.registerEntityResistant(blitz, 2.0F, 2.0F);
		DamageAPI.resistantData.registerEntityResistant(basalz, 6.0F, 0.0F);
		DamageAPI.resistantData.registerEntityResistant(chast, 2.0F, 2.0F);
	}

}
