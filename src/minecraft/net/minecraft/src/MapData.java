package net.minecraft.src;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapData extends WorldSavedData
{
    public int xCenter;
    public int zCenter;
    public byte dimension;
    public byte scale;

    /** colours */
    public byte[] colors = new byte[16384];

    /**
     * Incremented each update of the map item, used for the patchy updating map effect and the spinning player icons
     * while in the End and Nether.
     */
    public int randomEffect;

    /**
     * Holds a reference to the MapInfo of the players who own a copy of the map
     */
    public List playersArrayList = new ArrayList();

    /**
     * Holds a reference to the players who own a copy of the map and a reference to their MapInfo
     */
    private Map playersHashMap = new HashMap();
    public List playersVisibleOnMap = new ArrayList();

    public MapData(String par1Str)
    {
        super(par1Str);
    }

    /**
     * reads in data from the NBTTagCompound into this MapDataBase
     */
    public void readFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        this.dimension = par1NBTTagCompound.getByte("dimension");
        this.xCenter = par1NBTTagCompound.getInteger("xCenter");
        this.zCenter = par1NBTTagCompound.getInteger("zCenter");
        this.scale = par1NBTTagCompound.getByte("scale");

        if (this.scale < 0)
        {
            this.scale = 0;
        }

        if (this.scale > 4)
        {
            this.scale = 4;
        }

        short var2 = par1NBTTagCompound.getShort("width");
        short var3 = par1NBTTagCompound.getShort("height");

        if (var2 == 128 && var3 == 128)
        {
            this.colors = par1NBTTagCompound.getByteArray("colors");
        }
        else
        {
            byte[] var4 = par1NBTTagCompound.getByteArray("colors");
            this.colors = new byte[16384];
            int var5 = (128 - var2) / 2;
            int var6 = (128 - var3) / 2;

            for (int var7 = 0; var7 < var3; ++var7)
            {
                int var8 = var7 + var6;

                if (var8 >= 0 || var8 < 128)
                {
                    for (int var9 = 0; var9 < var2; ++var9)
                    {
                        int var10 = var9 + var5;

                        if (var10 >= 0 || var10 < 128)
                        {
                            this.colors[var10 + var8 * 128] = var4[var9 + var7 * var2];
                        }
                    }
                }
            }
        }
    }

    /**
     * write data to NBTTagCompound from this MapDataBase, similar to Entities and TileEntities
     */
    public void writeToNBT(NBTTagCompound par1NBTTagCompound)
    {
        par1NBTTagCompound.setByte("dimension", this.dimension);
        par1NBTTagCompound.setInteger("xCenter", this.xCenter);
        par1NBTTagCompound.setInteger("zCenter", this.zCenter);
        par1NBTTagCompound.setByte("scale", this.scale);
        par1NBTTagCompound.setShort("width", (short)128);
        par1NBTTagCompound.setShort("height", (short)128);
        par1NBTTagCompound.setByteArray("colors", this.colors);
    }

    /**
     * Adds the player passed to the list of visible players and checks to see which players are visible
     */
    public void updateVisiblePlayers(EntityPlayer par1EntityPlayer, ItemStack par2ItemStack)
    {
        if (!this.playersHashMap.containsKey(par1EntityPlayer))
        {
            MapInfo var3 = new MapInfo(this, par1EntityPlayer);
            this.playersHashMap.put(par1EntityPlayer, var3);
            this.playersArrayList.add(var3);
        }

        this.playersVisibleOnMap.clear();

        for (int var14 = 0; var14 < this.playersArrayList.size(); ++var14)
        {
            MapInfo var4 = (MapInfo)this.playersArrayList.get(var14);

            if (!var4.entityplayerObj.isDead && var4.entityplayerObj.inventory.hasItemStack(par2ItemStack))
            {
                float var5 = (float)(var4.entityplayerObj.posX - (double)this.xCenter) / (float)(1 << this.scale);
                float var6 = (float)(var4.entityplayerObj.posZ - (double)this.zCenter) / (float)(1 << this.scale);
                byte var7 = 64;
                byte var8 = 64;

                if (var5 >= (float)(-var7) && var6 >= (float)(-var8) && var5 <= (float)var7 && var6 <= (float)var8)
                {
                    byte var9 = 0;
                    byte var10 = (byte)((int)((double)(var5 * 2.0F) + 0.5D));
                    byte var11 = (byte)((int)((double)(var6 * 2.0F) + 0.5D));
                    byte var12 = (byte)((int)((double)(par1EntityPlayer.rotationYaw * 16.0F / 360.0F) + 0.5D));

                    if (this.dimension < 0)
                    {
                        int var13 = this.randomEffect / 10;
                        var12 = (byte)(var13 * var13 * 34187121 + var13 * 121 >> 15 & 15);
                    }

                    if (var4.entityplayerObj.dimension == this.dimension)
                    {
                        this.playersVisibleOnMap.add(new MapCoord(this, var9, var10, var11, var12));
                    }
                }
            }
            else
            {
                this.playersHashMap.remove(var4.entityplayerObj);
                this.playersArrayList.remove(var4);
            }
        }
    }

    public void func_28170_a(int par1, int par2, int par3)
    {
        super.markDirty();

        for (int var4 = 0; var4 < this.playersArrayList.size(); ++var4)
        {
            MapInfo var5 = (MapInfo)this.playersArrayList.get(var4);

            if (var5.field_28119_b[par1] < 0 || var5.field_28119_b[par1] > par2)
            {
                var5.field_28119_b[par1] = par2;
            }

            if (var5.field_28124_c[par1] < 0 || var5.field_28124_c[par1] < par3)
            {
                var5.field_28124_c[par1] = par3;
            }
        }
    }

    /**
     * Updates the client's map with information from other players in MP
     */
    public void updateMPMapData(byte[] par1ArrayOfByte)
    {
        int var2;

        if (par1ArrayOfByte[0] == 0)
        {
            var2 = par1ArrayOfByte[1] & 255;
            int var3 = par1ArrayOfByte[2] & 255;

            for (int var4 = 0; var4 < par1ArrayOfByte.length - 3; ++var4)
            {
                this.colors[(var4 + var3) * 128 + var2] = par1ArrayOfByte[var4 + 3];
            }

            this.markDirty();
        }
        else if (par1ArrayOfByte[0] == 1)
        {
            this.playersVisibleOnMap.clear();

            for (var2 = 0; var2 < (par1ArrayOfByte.length - 1) / 3; ++var2)
            {
                byte var7 = (byte)(par1ArrayOfByte[var2 * 3 + 1] % 16);
                byte var8 = par1ArrayOfByte[var2 * 3 + 2];
                byte var5 = par1ArrayOfByte[var2 * 3 + 3];
                byte var6 = (byte)(par1ArrayOfByte[var2 * 3 + 1] / 16);
                this.playersVisibleOnMap.add(new MapCoord(this, var7, var8, var5, var6));
            }
        }
    }
}
