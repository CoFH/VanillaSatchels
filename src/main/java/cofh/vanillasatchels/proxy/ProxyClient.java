package cofh.vanillasatchels.proxy;

import cofh.core.render.IModelRegister;
import cofh.vanillasatchels.VanillaSatchels;
import net.minecraft.client.Minecraft;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

import java.util.ArrayList;

public class ProxyClient extends Proxy {

	/* INIT */
	@Override
	public void preInit(FMLPreInitializationEvent event) {

		super.preInit(event);

		for (IModelRegister register : modelList) {
			register.registerModels();
		}
	}

	@Override
	public void initialize(FMLInitializationEvent event) {

		super.initialize(event);

		Minecraft.getMinecraft().getItemColors().registerItemColorHandler(VanillaSatchels.itemSatchel::colorMultiplier, VanillaSatchels.itemSatchel);

	}

	@Override
	public void postInit(FMLPostInitializationEvent event) {

		super.postInit(event);
	}

	/* HELPERS */
	public boolean addIModelRegister(IModelRegister modelRegister) {

		return modelList.add(modelRegister);
	}

	private static ArrayList<IModelRegister> modelList = new ArrayList<>();

}
