package net.minecraft.src;

class OsMap
{
    /** List of OS values in ordinal form. */
    static final int[] osValues = new int[EnumOS1.values().length];

    static
    {
        try
        {
            osValues[EnumOS1.linux.ordinal()] = 1;
        }
        catch (NoSuchFieldError var4)
        {
            ;
        }

        try
        {
            osValues[EnumOS1.solaris.ordinal()] = 2;
        }
        catch (NoSuchFieldError var3)
        {
            ;
        }

        try
        {
            osValues[EnumOS1.windows.ordinal()] = 3;
        }
        catch (NoSuchFieldError var2)
        {
            ;
        }

        try
        {
            osValues[EnumOS1.macos.ordinal()] = 4;
        }
        catch (NoSuchFieldError var1)
        {
            ;
        }
    }
}
