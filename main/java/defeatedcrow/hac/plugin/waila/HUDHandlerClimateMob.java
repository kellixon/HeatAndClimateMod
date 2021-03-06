package defeatedcrow.hac.plugin.waila;

import java.util.List;

import javax.annotation.Nonnull;

import defeatedcrow.hac.api.damage.DamageAPI;
import defeatedcrow.hac.config.CoreConfigDC;
import defeatedcrow.hac.core.ClimateCore;
import mcp.mobius.waila.addons.core.HUDHandlerEntities;
import mcp.mobius.waila.api.IWailaConfigHandler;
import mcp.mobius.waila.api.IWailaEntityAccessor;
import mcp.mobius.waila.api.IWailaRegistrar;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityLivingBase;

public class HUDHandlerClimateMob extends HUDHandlerEntities {

	@Nonnull
	@Override
	public List<String> getWailaBody(Entity entity, List<String> currenttip, IWailaEntityAccessor accessor,
			IWailaConfigHandler config) {
		if (!ClimateCore.isDebug || !config.getConfig("dcs_climate.showclimate") || entity == null)
			return currenttip;

		if (entity instanceof EntityLivingBase) {
			float heat = DamageAPI.resistantData.getHeatResistant(entity) + 2.0F;
			float cold = DamageAPI.resistantData.getColdResistant(entity) + 2.0F;
			if (entity.isImmuneToFire) {
				heat += CoreConfigDC.infernalInferno ? 8.0F : 4.0F;
				cold -= 2.0F;
			}
			if (((EntityLivingBase) entity).isEntityUndead()) {
				heat -= 2.0F;
				cold += 2.0F;
			}

			currenttip.add(String.format("Climate Resistant : %.1f / %.1f", heat, cold));
		}

		return currenttip;
	}

	public static void register(IWailaRegistrar registrar) {
		HUDHandlerClimateMob provider = new HUDHandlerClimateMob();
		registrar.registerBodyProvider(provider, EntityLivingBase.class);
	}

}
