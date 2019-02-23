package net.minecraft.src;

import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import cpw.mods.fml.client.FMLClientHandler;
import cpw.mods.fml.common.registry.FMLRegistry;
import cpw.mods.fml.common.registry.IMinecraftRegistry;

public class ClientRegistry implements IMinecraftRegistry
{

    public static ClientRegistry instance() {
        return (ClientRegistry) FMLRegistry.instance();
    }
    @Override
    public void addRecipe(ItemStack output, Object... params)
    {
        CraftingManager.getInstance().addRecipe(output, params);
    }

    @Override
    public void addShapelessRecipe(ItemStack output, Object... params)
    {
        CraftingManager.getInstance().addShapelessRecipe(output, params);
    }

    @Override
    public void addRecipe(IRecipe recipe)
    {
        CraftingManager.getInstance().getRecipeList().add(recipe);
    }

    @Override
    public void addSmelting(int input, ItemStack output)
    {
        FurnaceRecipes.smelting().addSmelting(input, output);
    }

    @Override
    public void registerBlock(Block block)
    {
        registerBlock(block, ItemBlock.class);
    }

    @Override
    public void registerBlock(Block block, Class <? extends ItemBlock > itemclass)
    {
        try
        {
            assert block != null : "registerBlock: block cannot be null";
            assert itemclass != null : "registerBlock: itemclass cannot be null";
            int blockItemId = block.blockID - 256;
            itemclass.getConstructor(int.class).newInstance(blockItemId);
        }
        catch (Exception e)
        {
            //HMMM
        }
    }

    @Override
    public void registerEntityID(Class <? extends Entity > entityClass, String entityName, int id)
    {
        EntityList.addNewEntityListMapping(entityClass, entityName, id);
    }

    @Override
    public void registerEntityID(Class <? extends Entity > entityClass, String entityName, int id, int backgroundEggColour, int foregroundEggColour)
    {
        EntityList.addNewEntityListMapping(entityClass, entityName, id, backgroundEggColour, foregroundEggColour);
    }

    @Override
    public void registerTileEntity(Class <? extends TileEntity > tileEntityClass, String id)
    {
        TileEntity.addNewTileEntityMapping(tileEntityClass, id);
    }

    public void registerTileEntity(Class <? extends TileEntity > tileEntityClass, String id, TileEntitySpecialRenderer specialRenderer)
    {
        registerTileEntity(tileEntityClass, id);
        TileEntityRenderer.setTileEntityRenderer(tileEntityClass, specialRenderer);
    }

    @Override
    public void addBiome(BiomeGenBase biome)
    {
        FMLClientHandler.instance().addBiomeToDefaultWorldGenerator(biome);
    }

    @Override
    public void addSpawn(Class <? extends EntityLiving > entityClass, int weightedProb, int min, int max, EnumCreatureType typeOfCreature, BiomeGenBase... biomes)
    {
        for (BiomeGenBase biome : biomes)
        {
            @SuppressWarnings("unchecked")
            List<SpawnListEntry> spawns = biome.getSpawnableList(typeOfCreature);

            for (SpawnListEntry entry : spawns)
            {
                //Adjusting an existing spawn entry
                if (entry.entityClass == entityClass)
                {
                    entry.itemWeight = weightedProb;
                    entry.minGroupCount = min;
                    entry.maxGroupCount = max;
                    break;
                }
            }

            spawns.add(new SpawnListEntry(entityClass, weightedProb, min, max));
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void addSpawn(String entityName, int weightedProb, int min, int max, EnumCreatureType spawnList, BiomeGenBase... biomes)
    {
        Class <? extends Entity > entityClazz = EntityList.getEntityToClassMapping().get(entityName);

        if (EntityLiving.class.isAssignableFrom(entityClazz))
        {
            addSpawn((Class <? extends EntityLiving >) entityClazz, weightedProb, min, max, spawnList, biomes);
        }
    }

    @Override
    public void removeBiome(BiomeGenBase biome)
    {
        FMLClientHandler.instance().removeBiomeFromDefaultWorldGenerator(biome);
    }

    @Override
    public void removeSpawn(Class <? extends EntityLiving > entityClass, EnumCreatureType typeOfCreature, BiomeGenBase... biomes)
    {
        for (BiomeGenBase biome : biomes)
        {
            @SuppressWarnings("unchecked")
            Iterator<SpawnListEntry> spawns = biome.getSpawnableList(typeOfCreature).iterator();

            while (spawns.hasNext())
            {
                SpawnListEntry entry = spawns.next();
                if (entry.entityClass == entityClass)
                {
                    spawns.remove();
                }
            }
        }
    }

    @Override
    @SuppressWarnings("unchecked")
    public void removeSpawn(String entityName, EnumCreatureType spawnList, BiomeGenBase... biomes)
    {
        Class <? extends Entity > entityClazz = EntityList.getEntityToClassMapping().get(entityName);

        if (EntityLiving.class.isAssignableFrom(entityClazz))
        {
            removeSpawn((Class <? extends EntityLiving >) entityClazz, spawnList, biomes);
        }
    }

}
