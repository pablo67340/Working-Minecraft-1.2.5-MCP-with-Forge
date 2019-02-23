package net.minecraft.src;

public class ItemSlab extends ItemBlock
{
    public ItemSlab(int par1)
    {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
    }

    /**
     * Gets an icon index based on an item's damage value
     */
    public int getIconFromDamage(int par1)
    {
        return Block.stairSingle.getBlockTextureFromSideAndMetadata(2, par1);
    }

    /**
     * Returns the metadata of the block which this Item (ItemBlock) can place
     */
    public int getMetadata(int par1)
    {
        return par1;
    }

    public String getItemNameIS(ItemStack par1ItemStack)
    {
        int var2 = par1ItemStack.getItemDamage();

        if (var2 < 0 || var2 >= BlockStep.blockStepTypes.length)
        {
            var2 = 0;
        }

        return super.getItemName() + "." + BlockStep.blockStepTypes[var2];
    }

    /**
     * Callback for item usage. If the item does something special on right clicking, he will have one of those. Return
     * True if something happen and false if it don't. This is for ITEMS, not BLOCKS !
     */
    public boolean onItemUse(ItemStack par1ItemStack, EntityPlayer par2EntityPlayer, World par3World, int par4, int par5, int par6, int par7)
    {
        if (par1ItemStack.stackSize == 0)
        {
            return false;
        }
        else if (!par2EntityPlayer.canPlayerEdit(par4, par5, par6))
        {
            return false;
        }
        else
        {
            int var8 = par3World.getBlockId(par4, par5, par6);
            int var9 = par3World.getBlockMetadata(par4, par5, par6);
            int var10 = var9 & 7;
            boolean var11 = (var9 & 8) != 0;

            if ((par7 == 1 && !var11 || par7 == 0 && var11) && var8 == Block.stairSingle.blockID && var10 == par1ItemStack.getItemDamage())
            {
                if (par3World.checkIfAABBIsClear(Block.stairDouble.getCollisionBoundingBoxFromPool(par3World, par4, par5, par6)) && par3World.setBlockAndMetadataWithNotify(par4, par5, par6, Block.stairDouble.blockID, var10))
                {
                    par3World.playSoundEffect((double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), (double)((float)par6 + 0.5F), Block.stairDouble.stepSound.getStepSound(), (Block.stairDouble.stepSound.getVolume() + 1.0F) / 2.0F, Block.stairDouble.stepSound.getPitch() * 0.8F);
                    --par1ItemStack.stackSize;
                }

                return true;
            }
            else
            {
                return func_50087_b(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7) ? true : super.onItemUse(par1ItemStack, par2EntityPlayer, par3World, par4, par5, par6, par7);
            }
        }
    }

    private static boolean func_50087_b(ItemStack par0ItemStack, EntityPlayer par1EntityPlayer, World par2World, int par3, int par4, int par5, int par6)
    {
        if (par6 == 0)
        {
            --par4;
        }

        if (par6 == 1)
        {
            ++par4;
        }

        if (par6 == 2)
        {
            --par5;
        }

        if (par6 == 3)
        {
            ++par5;
        }

        if (par6 == 4)
        {
            --par3;
        }

        if (par6 == 5)
        {
            ++par3;
        }

        int var7 = par2World.getBlockId(par3, par4, par5);
        int var8 = par2World.getBlockMetadata(par3, par4, par5);
        int var9 = var8 & 7;

        if (var7 == Block.stairSingle.blockID && var9 == par0ItemStack.getItemDamage())
        {
            if (par2World.checkIfAABBIsClear(Block.stairDouble.getCollisionBoundingBoxFromPool(par2World, par3, par4, par5)) && par2World.setBlockAndMetadataWithNotify(par3, par4, par5, Block.stairDouble.blockID, var9))
            {
                par2World.playSoundEffect((double)((float)par3 + 0.5F), (double)((float)par4 + 0.5F), (double)((float)par5 + 0.5F), Block.stairDouble.stepSound.getStepSound(), (Block.stairDouble.stepSound.getVolume() + 1.0F) / 2.0F, Block.stairDouble.stepSound.getPitch() * 0.8F);
                --par0ItemStack.stackSize;
            }

            return true;
        }
        else
        {
            return false;
        }
    }
}
