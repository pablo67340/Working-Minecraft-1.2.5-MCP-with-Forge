package net.minecraft.src;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class SoundPool
{
    /** The RNG used by SoundPool. */
    private Random rand = new Random();

    /**
     * Maps a name (can be sound/newsound/streaming/music/newmusic) to a list of SoundPoolEntry's.
     */
    private Map nameToSoundPoolEntriesMapping = new HashMap();

    /** A list of all SoundPoolEntries that have been loaded. */
    private List allSoundPoolEntries = new ArrayList();

    /**
     * The number of soundPoolEntry's. This value is computed but never used (should be equal to
     * allSoundPoolEntries.size()).
     */
    public int numberOfSoundPoolEntries = 0;
    public boolean isGetRandomSound = true;

    /**
     * Adds a sound to this sound pool.
     */
    public SoundPoolEntry addSound(String par1Str, File par2File)
    {
        try 
        {
            return addSound(par1Str, par2File.toURI().toURL());
        }
        catch (MalformedURLException ex)
        {
            ex.printStackTrace();
            throw new RuntimeException(ex);
        }
    }
    /**
     * URL version of addSound, as the back-end sound engine has full support for various types of URLs
     * 
     * @param par1Str The name of the sound to add
     * @param url The url of the sound resource
     * @return A SoundPoolEntry for the newly added sound
     */
    public SoundPoolEntry addSound(String par1Str, URL url)
    {
        try
        {
            String var3 = par1Str;
            par1Str = par1Str.substring(0, par1Str.indexOf("."));

            if (this.isGetRandomSound)
            {
                while (Character.isDigit(par1Str.charAt(par1Str.length() - 1)))
                {
                    par1Str = par1Str.substring(0, par1Str.length() - 1);
                }
            }

            par1Str = par1Str.replaceAll("/", ".");

            if (!this.nameToSoundPoolEntriesMapping.containsKey(par1Str))
            {
                this.nameToSoundPoolEntriesMapping.put(par1Str, new ArrayList());
            }

            SoundPoolEntry var4 = new SoundPoolEntry(var3, url);
            ((List)this.nameToSoundPoolEntriesMapping.get(par1Str)).add(var4);
            this.allSoundPoolEntries.add(var4);
            ++this.numberOfSoundPoolEntries;
            return var4;
        }
        catch (Exception var5)
        {
            var5.printStackTrace();
            throw new RuntimeException(var5);
        }
    }

    /**
     * gets a random sound from the specified (by name, can be sound/newsound/streaming/music/newmusic) sound pool.
     */
    public SoundPoolEntry getRandomSoundFromSoundPool(String par1Str)
    {
        List var2 = (List)this.nameToSoundPoolEntriesMapping.get(par1Str);
        return var2 == null ? null : (SoundPoolEntry)var2.get(this.rand.nextInt(var2.size()));
    }

    /**
     * Gets a random SoundPoolEntry.
     */
    public SoundPoolEntry getRandomSound()
    {
        return this.allSoundPoolEntries.size() == 0 ? null : (SoundPoolEntry)this.allSoundPoolEntries.get(this.rand.nextInt(this.allSoundPoolEntries.size()));
    }
}
