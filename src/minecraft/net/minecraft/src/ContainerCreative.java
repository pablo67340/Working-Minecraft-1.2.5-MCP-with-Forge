package net.minecraft.src;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class ContainerCreative extends Container
{
    /** the list of items in this container */
    public List itemList = new ArrayList();

    public ContainerCreative(EntityPlayer par1EntityPlayer)
    {
        Block[] var2 = new Block[] {Block.cobblestone, Block.stone, Block.oreDiamond, Block.oreGold, Block.oreIron, Block.oreCoal, Block.oreLapis, Block.oreRedstone, Block.stoneBrick, Block.stoneBrick, Block.stoneBrick, Block.stoneBrick, Block.blockClay, Block.blockDiamond, Block.blockGold, Block.blockSteel, Block.bedrock, Block.blockLapis, Block.brick, Block.cobblestoneMossy, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.stairSingle, Block.obsidian, Block.netherrack, Block.slowSand, Block.glowStone, Block.wood, Block.wood, Block.wood, Block.wood, Block.leaves, Block.leaves, Block.leaves, Block.leaves, Block.dirt, Block.grass, Block.sand, Block.sandStone, Block.sandStone, Block.sandStone, Block.gravel, Block.web, Block.planks, Block.planks, Block.planks, Block.planks, Block.sapling, Block.sapling, Block.sapling, Block.sapling, Block.deadBush, Block.sponge, Block.ice, Block.blockSnow, Block.plantYellow, Block.plantRed, Block.mushroomBrown, Block.mushroomRed, Block.cactus, Block.melon, Block.pumpkin, Block.pumpkinLantern, Block.vine, Block.fenceIron, Block.thinGlass, Block.netherBrick, Block.netherFence, Block.stairsNetherBrick, Block.whiteStone, Block.mycelium, Block.waterlily, Block.tallGrass, Block.tallGrass, Block.chest, Block.workbench, Block.glass, Block.tnt, Block.bookShelf, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.cloth, Block.dispenser, Block.stoneOvenIdle, Block.music, Block.jukebox, Block.pistonStickyBase, Block.pistonBase, Block.fence, Block.fenceGate, Block.ladder, Block.rail, Block.railPowered, Block.railDetector, Block.torchWood, Block.stairCompactPlanks, Block.stairCompactCobblestone, Block.stairsBrick, Block.stairsStoneBrickSmooth, Block.lever, Block.pressurePlateStone, Block.pressurePlatePlanks, Block.torchRedstoneActive, Block.button, Block.trapdoor, Block.enchantmentTable, Block.redstoneLampIdle};
        int var3 = 0;
        int var4 = 0;
        int var5 = 0;
        int var6 = 0;
        int var7 = 0;
        int var8 = 0;
        int var9 = 0;
        int var10 = 0;
        int var11 = 1;
        int var12;
        int var13;

        for (var12 = 0; var12 < var2.length; ++var12)
        {
            var13 = 0;

            if (var2[var12] == Block.cloth)
            {
                var13 = var3++;
            }
            else if (var2[var12] == Block.stairSingle)
            {
                var13 = var4++;
            }
            else if (var2[var12] == Block.wood)
            {
                var13 = var5++;
            }
            else if (var2[var12] == Block.planks)
            {
                var13 = var6++;
            }
            else if (var2[var12] == Block.sapling)
            {
                var13 = var7++;
            }
            else if (var2[var12] == Block.stoneBrick)
            {
                var13 = var8++;
            }
            else if (var2[var12] == Block.sandStone)
            {
                var13 = var9++;
            }
            else if (var2[var12] == Block.tallGrass)
            {
                var13 = var11++;
            }
            else if (var2[var12] == Block.leaves)
            {
                var13 = var10++;
            }

            this.itemList.add(new ItemStack(var2[var12], 1, var13));
        }

        for (Block block : Block.blocksList)
        {
            if (block != null)
            {
                block.addCreativeItems((ArrayList)itemList);
            }
        }
        
        for (Item item : Item.itemsList)
        {
            if (item != null && !(item instanceof ItemBlock))
            {
                item.addCreativeItems((ArrayList)itemList);
            }
        }

        Iterator var15 = EntityList.entityEggs.keySet().iterator();

        while (var15.hasNext())
        {
            Integer var17 = (Integer)var15.next();
            this.itemList.add(new ItemStack(Item.monsterPlacer.shiftedIndex, 1, var17.intValue()));
        }

        InventoryPlayer var16 = par1EntityPlayer.inventory;

        for (var13 = 0; var13 < 9; ++var13)
        {
            for (int var14 = 0; var14 < 8; ++var14)
            {
                this.addSlot(new Slot(GuiContainerCreative.getInventory(), var14 + var13 * 8, 8 + var14 * 18, 18 + var13 * 18));
            }
        }

        for (var13 = 0; var13 < 9; ++var13)
        {
            this.addSlot(new Slot(var16, var13, 8 + var13 * 18, 184));
        }

        this.scrollTo(0.0F);
    }

    public boolean canInteractWith(EntityPlayer par1EntityPlayer)
    {
        return true;
    }

    /**
     * Updates the gui slots ItemStack's based on scroll position.
     */
    public void scrollTo(float par1)
    {
        int var2 = this.itemList.size() / 8 - 8 + 1;
        int var3 = (int)((double)(par1 * (float)var2) + 0.5D);

        if (var3 < 0)
        {
            var3 = 0;
        }

        for (int var4 = 0; var4 < 9; ++var4)
        {
            for (int var5 = 0; var5 < 8; ++var5)
            {
                int var6 = var5 + (var4 + var3) * 8;

                if (var6 >= 0 && var6 < this.itemList.size())
                {
                    GuiContainerCreative.getInventory().setInventorySlotContents(var5 + var4 * 8, (ItemStack)this.itemList.get(var6));
                }
                else
                {
                    GuiContainerCreative.getInventory().setInventorySlotContents(var5 + var4 * 8, (ItemStack)null);
                }
            }
        }
    }

    protected void retrySlotClick(int par1, int par2, boolean par3, EntityPlayer par4EntityPlayer) {}
}
