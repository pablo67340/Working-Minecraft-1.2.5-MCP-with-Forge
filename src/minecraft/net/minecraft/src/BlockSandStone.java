package net.minecraft.src;

public class BlockSandStone extends Block
{
    public BlockSandStone(int par1)
    {
        super(par1, 192, Material.rock);
    }

    /**
     * From the specified side and block metadata retrieves the blocks texture. Args: side, metadata
     */
    public int getBlockTextureFromSideAndMetadata(int par1, int par2)
    {
        return par1 != 1 && (par1 != 0 || par2 != 1 && par2 != 2) ? (par1 == 0 ? 208 : (par2 == 1 ? 229 : (par2 == 2 ? 230 : 192))) : 176;
    }

    /**
     * Returns the block texture based on the side being looked at.  Args: side
     */
    public int getBlockTextureFromSide(int par1)
    {
        return par1 == 1 ? this.blockIndexInTexture - 16 : (par1 == 0 ? this.blockIndexInTexture + 16 : this.blockIndexInTexture);
    }

    /**
     * Determines the damage on the item the block drops. Used in cloth and wood.
     */
    protected int damageDropped(int par1)
    {
        return par1;
    }
}
