package net.minecraft.src;

import java.io.File;
import java.util.List;

public interface ISaveHandler
{
    /**
     * Loads and returns the world info
     */
    WorldInfo loadWorldInfo();

    /**
     * Checks the session lock to prevent save collisions
     */
    void checkSessionLock();

    /**
     * Returns the chunk loader with the provided world provider
     */
    IChunkLoader getChunkLoader(WorldProvider var1);

    /**
     * saves level.dat and backs up the existing one to level.dat_old
     */
    void saveWorldInfoAndPlayer(WorldInfo var1, List var2);

    /**
     * Saves the passed in world info.
     */
    void saveWorldInfo(WorldInfo var1);

    /**
     * Gets the file location of the given map
     */
    File getMapFileFromName(String var1);

    /**
     * Returns the name of the directory where world information is saved
     */
    String getSaveDirectoryName();
}
