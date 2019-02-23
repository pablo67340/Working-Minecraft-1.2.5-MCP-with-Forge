package net.minecraft.src;

public class GuiPlayerInfo
{
    /** The string value of the object */
    public final String name;

    /** Player name in lowercase. */
    private final String nameinLowerCase;

    /** Player response time to server in milliseconds */
    public int responseTime;

    public GuiPlayerInfo(String par1Str)
    {
        this.name = par1Str;
        this.nameinLowerCase = par1Str.toLowerCase();
    }

    /**
     * Returns true if the current player name starts with string specified value.
     */
    public boolean nameStartsWith(String par1Str)
    {
        return this.nameinLowerCase.startsWith(par1Str);
    }
}
