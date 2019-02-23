package net.minecraft.src;

import java.io.File;
import java.util.List;

public class SaveHandlerMP implements ISaveHandler
{
    /**
     * Loads and returns the world info
     */
    public WorldInfo loadWorldInfo()
    {
        return null;
    }

    /**
     * Checks the session lock to prevent save collisions
     */
    public void checkSessionLock() {}

    /**
     * Returns the chunk loader with the provided world provider
     */
    public IChunkLoader getChunkLoader(WorldProvider par1WorldProvider)
    {
        return null;
    }

    /**
     * saves level.dat and backs up the existing one to level.dat_old
     */
    public void saveWorldInfoAndPlayer(WorldInfo par1WorldInfo, List par2List) {}

    /**
     * Saves the passed in world info.
     */
    public void saveWorldInfo(WorldInfo par1WorldInfo) {}

    /**
     * Gets the file location of the given map
     */
    public File getMapFileFromName(String par1Str)
    {
        return null;
    }

    /**
     * Returns the name of the directory where world information is saved
     */
    public String getSaveDirectoryName()
    {
        return "none";
    }
}
