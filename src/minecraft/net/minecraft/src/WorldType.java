package net.minecraft.src;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WorldType
{
    /** List of world types. */
    public static final WorldType[] worldTypes = new WorldType[16];

    /** Default world type. */
    public static final WorldType DEFAULT = (new WorldType(0, "default", 1)).func_48631_f();

    /** Flat world type. */
    public static final WorldType FLAT = new WorldType(1, "flat");

    /** Default (1.1) world type. */
    public static final WorldType DEFAULT_1_1 = (new WorldType(8, "default_1_1", 0)).setCanBeCreated(false);

    /** 'default' or 'flat' */
    private final String worldType;

    /** The int version of the ChunkProvider that generated this world. */
    private final int generatorVersion;

    /**
     * Whether this world type can be generated. Normally true; set to false for out-of-date generator versions.
     */
    private boolean canBeCreated;
    private boolean field_48638_h;

    protected BiomeGenBase[] biomesForWorldType;

    protected WorldType(int par1, String par2Str)
    {
        this(par1, par2Str, 0);
    }

    protected WorldType(int par1, String par2Str, int par3)
    {
        this.worldType = par2Str;
        this.generatorVersion = par3;
        this.canBeCreated = true;
        worldTypes[par1] = this;
        switch (par1) {
            case 8:
                biomesForWorldType = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.taiga};
                break;
            default:
                biomesForWorldType = new BiomeGenBase[] {BiomeGenBase.desert, BiomeGenBase.forest, BiomeGenBase.extremeHills, BiomeGenBase.swampland, BiomeGenBase.plains, BiomeGenBase.taiga, BiomeGenBase.jungle};
        }
    }

    public String func_48628_a()
    {
        return this.worldType;
    }

    /**
     * Gets the translation key for the name of this world type.
     */
    public String getTranslateName()
    {
        return "generator." + this.worldType;
    }

    /**
     * Returns generatorVersion.
     */
    public int getGeneratorVersion()
    {
        return this.generatorVersion;
    }

    public WorldType func_48629_a(int par1)
    {
        return this == DEFAULT && par1 == 0 ? DEFAULT_1_1 : this;
    }

    /**
     * Sets canBeCreated to the provided value, and returns this.
     */
    private WorldType setCanBeCreated(boolean par1)
    {
        this.canBeCreated = par1;
        return this;
    }

    /**
     * Gets whether this WorldType can be used to generate a new world.
     */
    public boolean getCanBeCreated()
    {
        return this.canBeCreated;
    }

    private WorldType func_48631_f()
    {
        this.field_48638_h = true;
        return this;
    }

    public boolean func_48626_e()
    {
        return this.field_48638_h;
    }

    public static WorldType parseWorldType(String par0Str)
    {
        for (int var1 = 0; var1 < worldTypes.length; ++var1)
        {
            if (worldTypes[var1] != null && worldTypes[var1].worldType.equalsIgnoreCase(par0Str))
            {
                return worldTypes[var1];
            }
        }

        return null;
    }

    public WorldChunkManager getChunkManager(World var1)
    {
        return this == FLAT ? new WorldChunkManagerHell(BiomeGenBase.plains, 0.5F, 0.5F) : new WorldChunkManager(var1);
    }

    public IChunkProvider getChunkGenerator(World var1)
    {
        return this == FLAT ? new ChunkProviderFlat(var1, var1.getSeed(), var1.getWorldInfo().isMapFeaturesEnabled()) : new ChunkProviderGenerate(var1, var1.getSeed(), var1.getWorldInfo().isMapFeaturesEnabled());
    }

    /**
     * @deprecated Use {@link #getMinimumSpawnHeight(World)} instead
     */
    public int getSeaLevel(World var1)
    {
        return getMinimumSpawnHeight(var1);
    }

    public int getMinimumSpawnHeight(World world)
    {
        return this == FLAT ? 4 : 64;
    }

    public double getHorizon(World world)
    {
        return this == FLAT ? 0.0D : 63.0D;
    }

    public boolean hasVoidParticles(boolean var1)
    {
        return this != FLAT && !var1;
    }

    public double voidFadeMagnitude()
    {
        return this == FLAT ? 1.0D : 0.03125D;
    }

    public BiomeGenBase[] getBiomesForWorldType() {
        return biomesForWorldType;
    }
    
	public void addNewBiome(BiomeGenBase biome) {
		List<BiomeGenBase> newBiomesForWorld = new ArrayList<BiomeGenBase>();
		newBiomesForWorld.addAll(Arrays.asList(biomesForWorldType));
		
		if (!newBiomesForWorld.contains(biome))
			newBiomesForWorld.add(biome);
		biomesForWorldType = newBiomesForWorld.toArray(new BiomeGenBase[0]);
	}
    
    public void removeBiome(BiomeGenBase biome) {
		List<BiomeGenBase> newBiomesForWorld = new ArrayList<BiomeGenBase>();
		newBiomesForWorld.addAll(Arrays.asList(biomesForWorldType));
		
		newBiomesForWorld.remove(biome);
		biomesForWorldType = newBiomesForWorld.toArray(new BiomeGenBase[0]);
    }
    
    /**
     * Called when 'Create New World' button is pressed before starting game
     */
    public void onGUICreateWorldPress() { }
    
}
