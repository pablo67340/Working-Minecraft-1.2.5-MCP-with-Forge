package net.minecraft.src;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;

public class Packet202PlayerAbilities extends Packet
{
    /** Disables player damage. */
    public boolean disableDamage = false;

    /** Indicates whether the player is flying or not. */
    public boolean isFlying = false;

    /** Whether or not to allow the player to fly when they double jump. */
    public boolean allowFlying = false;

    /**
     * Used to determine if creative mode is enabled, and therefore if items should be depleted on usage
     */
    public boolean isCreativeMode = false;

    public Packet202PlayerAbilities() {}

    public Packet202PlayerAbilities(PlayerCapabilities par1PlayerCapabilities)
    {
        this.disableDamage = par1PlayerCapabilities.disableDamage;
        this.isFlying = par1PlayerCapabilities.isFlying;
        this.allowFlying = par1PlayerCapabilities.allowFlying;
        this.isCreativeMode = par1PlayerCapabilities.isCreativeMode;
    }

    /**
     * Abstract. Reads the raw packet data from the data stream.
     */
    public void readPacketData(DataInputStream par1DataInputStream) throws IOException
    {
        this.disableDamage = par1DataInputStream.readBoolean();
        this.isFlying = par1DataInputStream.readBoolean();
        this.allowFlying = par1DataInputStream.readBoolean();
        this.isCreativeMode = par1DataInputStream.readBoolean();
    }

    /**
     * Abstract. Writes the raw packet data to the data stream.
     */
    public void writePacketData(DataOutputStream par1DataOutputStream) throws IOException
    {
        par1DataOutputStream.writeBoolean(this.disableDamage);
        par1DataOutputStream.writeBoolean(this.isFlying);
        par1DataOutputStream.writeBoolean(this.allowFlying);
        par1DataOutputStream.writeBoolean(this.isCreativeMode);
    }

    /**
     * Passes this Packet on to the NetHandler for processing.
     */
    public void processPacket(NetHandler par1NetHandler)
    {
        par1NetHandler.handlePlayerAbilities(this);
    }

    /**
     * Abstract. Return the size of the packet (not counting the header).
     */
    public int getPacketSize()
    {
        return 1;
    }
}
