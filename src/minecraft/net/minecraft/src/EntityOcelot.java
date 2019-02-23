package net.minecraft.src;

public class EntityOcelot extends EntityTameable
{
    /**
     * The tempt AI task for this mob, used to prevent taming while it is fleeing.
     */
    private EntityAITempt aiTempt;

    public EntityOcelot(World par1World)
    {
        super(par1World);
        this.texture = "/mob/ozelot.png";
        this.setSize(0.6F, 0.8F);
        this.getNavigator().setAvoidsWater(true);
        this.tasks.addTask(1, new EntityAISwimming(this));
        this.tasks.addTask(2, this.aiSit);
        this.tasks.addTask(3, this.aiTempt = new EntityAITempt(this, 0.18F, Item.fishRaw.shiftedIndex, true));
        this.tasks.addTask(4, new EntityAIAvoidEntity(this, EntityPlayer.class, 16.0F, 0.23F, 0.4F));
        this.tasks.addTask(5, new EntityAIFollowOwner(this, 0.3F, 10.0F, 5.0F));
        this.tasks.addTask(6, new EntityAIOcelotSit(this, 0.4F));
        this.tasks.addTask(7, new EntityAILeapAtTarget(this, 0.3F));
        this.tasks.addTask(8, new EntityAIOcelotAttack(this));
        this.tasks.addTask(9, new EntityAIMate(this, 0.23F));
        this.tasks.addTask(10, new EntityAIWander(this, 0.23F));
        this.tasks.addTask(11, new EntityAIWatchClosest(this, EntityPlayer.class, 10.0F));
        this.targetTasks.addTask(1, new EntityAITargetNonTamed(this, EntityChicken.class, 14.0F, 750, false));
    }

    protected void entityInit()
    {
        super.entityInit();
        this.dataWatcher.addObject(18, Byte.valueOf((byte)0));
    }

    /**
     * main AI tick function, replaces updateEntityActionState
     */
    public void updateAITick()
    {
        if (!this.getMoveHelper().func_48186_a())
        {
            this.setSneaking(false);
            this.setSprinting(false);
        }
        else
        {
            float var1 = this.getMoveHelper().getSpeed();

            if (var1 == 0.18F)
            {
                this.setSneaking(true);
                this.setSprinting(false);
            }
            else if (var1 == 0.4F)
            {
                this.setSneaking(false);
                this.setSprinting(true);
            }
            else
            {
                this.setSneaking(false);
                this.setSprinting(false);
            }
        }
    }

    /**
     * Determines if an entity can be despawned, used on idle far away entities
     */
    protected boolean canDespawn()
    {
        return !this.isTamed();
    }

    /**
     * Returns the texture's file path as a String.
     */
    public String getTexture()
    {
        switch (this.func_48148_ad())
        {
            case 0:
                return "/mob/ozelot.png";
            case 1:
                return "/mob/cat_black.png";
            case 2:
                return "/mob/cat_red.png";
            case 3:
                return "/mob/cat_siamese.png";
            default:
                return super.getTexture();
        }
    }

    /**
     * Returns true if the newer Entity AI code should be run
     */
    public boolean isAIEnabled()
    {
        return true;
    }

    public int getMaxHealth()
    {
        return 10;
    }

    /**
     * Called when the mob is falling. Calculates and applies fall damage.
     */
    protected void fall(float par1) {}

    /**
     * (abstract) Protected helper method to write subclass entity data to NBT.
     */
    public void writeEntityToNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.writeEntityToNBT(par1NBTTagCompound);
        par1NBTTagCompound.setInteger("CatType", this.func_48148_ad());
    }

    /**
     * (abstract) Protected helper method to read subclass entity data from NBT.
     */
    public void readEntityFromNBT(NBTTagCompound par1NBTTagCompound)
    {
        super.readEntityFromNBT(par1NBTTagCompound);
        this.setTameSkin(par1NBTTagCompound.getInteger("CatType"));
    }

    /**
     * Returns the sound this mob makes while it's alive.
     */
    protected String getLivingSound()
    {
        return this.isTamed() ? (this.isInLove() ? "mob.cat.purr" : (this.rand.nextInt(4) == 0 ? "mob.cat.purreow" : "mob.cat.meow")) : "";
    }

    /**
     * Returns the sound this mob makes when it is hurt.
     */
    protected String getHurtSound()
    {
        return "mob.cat.hitt";
    }

    /**
     * Returns the sound this mob makes on death.
     */
    protected String getDeathSound()
    {
        return "mob.cat.hitt";
    }

    /**
     * Returns the volume for the sounds this mob makes.
     */
    protected float getSoundVolume()
    {
        return 0.4F;
    }

    /**
     * Returns the item ID for the item the mob drops on death.
     */
    protected int getDropItemId()
    {
        return Item.leather.shiftedIndex;
    }

    public boolean attackEntityAsMob(Entity par1Entity)
    {
        return par1Entity.attackEntityFrom(DamageSource.causeMobDamage(this), 3);
    }

    /**
     * Called when the entity is attacked.
     */
    public boolean attackEntityFrom(DamageSource par1DamageSource, int par2)
    {
        this.aiSit.setIsSitting(false);
        return super.attackEntityFrom(par1DamageSource, par2);
    }

    /**
     * Drop 0-2 items of this living's type
     */
    protected void dropFewItems(boolean par1, int par2) {}

    /**
     * Called when a player interacts with a mob. e.g. gets milk from a cow, gets into the saddle on a pig.
     */
    public boolean interact(EntityPlayer par1EntityPlayer)
    {
        ItemStack var2 = par1EntityPlayer.inventory.getCurrentItem();

        if (!this.isTamed())
        {
            if (this.aiTempt.func_48270_h() && var2 != null && var2.itemID == Item.fishRaw.shiftedIndex && par1EntityPlayer.getDistanceSqToEntity(this) < 9.0D)
            {
                --var2.stackSize;

                if (var2.stackSize <= 0)
                {
                    par1EntityPlayer.inventory.setInventorySlotContents(par1EntityPlayer.inventory.currentItem, (ItemStack)null);
                }

                if (!this.worldObj.isRemote)
                {
                    if (this.rand.nextInt(3) == 0)
                    {
                        this.setTamed(true);
                        this.setTameSkin(1 + this.worldObj.rand.nextInt(3));
                        this.setOwner(par1EntityPlayer.username);
                        this.playTameEffect(true);
                        this.aiSit.setIsSitting(true);
                        this.worldObj.setEntityState(this, (byte)7);
                    }
                    else
                    {
                        this.playTameEffect(false);
                        this.worldObj.setEntityState(this, (byte)6);
                    }
                }
            }

            return true;
        }
        else
        {
            if (par1EntityPlayer.username.equalsIgnoreCase(this.getOwnerName()) && !this.worldObj.isRemote && !this.isWheat(var2))
            {
                this.aiSit.setIsSitting(!this.isSitting());
            }

            return super.interact(par1EntityPlayer);
        }
    }

    /**
     * This function is used when two same-species animals in 'love mode' breed to generate the new baby animal.
     */
    public EntityAnimal spawnBabyAnimal(EntityAnimal par1EntityAnimal)
    {
        EntityOcelot var2 = new EntityOcelot(this.worldObj);

        if (this.isTamed())
        {
            var2.setOwner(this.getOwnerName());
            var2.setTamed(true);
            var2.setTameSkin(this.func_48148_ad());
        }

        return var2;
    }

    /**
     * Checks if the parameter is an wheat item.
     */
    public boolean isWheat(ItemStack par1ItemStack)
    {
        return par1ItemStack != null && par1ItemStack.itemID == Item.fishRaw.shiftedIndex;
    }

    /**
     * Returns true if the mob is currently able to mate with the specified mob.
     */
    public boolean canMateWith(EntityAnimal par1EntityAnimal)
    {
        if (par1EntityAnimal == this)
        {
            return false;
        }
        else if (!this.isTamed())
        {
            return false;
        }
        else if (!(par1EntityAnimal instanceof EntityOcelot))
        {
            return false;
        }
        else
        {
            EntityOcelot var2 = (EntityOcelot)par1EntityAnimal;
            return !var2.isTamed() ? false : this.isInLove() && var2.isInLove();
        }
    }

    public int func_48148_ad()
    {
        return this.dataWatcher.getWatchableObjectByte(18);
    }

    public void setTameSkin(int par1)
    {
        this.dataWatcher.updateObject(18, Byte.valueOf((byte)par1));
    }

    /**
     * Checks if the entity's current position is a valid location to spawn this entity.
     */
    public boolean getCanSpawnHere()
    {
        if (this.worldObj.rand.nextInt(3) == 0)
        {
            return false;
        }
        else
        {
            if (this.worldObj.checkIfAABBIsClear(this.boundingBox) && this.worldObj.getCollidingBoundingBoxes(this, this.boundingBox).size() == 0 && !this.worldObj.isAnyLiquid(this.boundingBox))
            {
                int var1 = MathHelper.floor_double(this.posX);
                int var2 = MathHelper.floor_double(this.boundingBox.minY);
                int var3 = MathHelper.floor_double(this.posZ);

                if (var2 < 63)
                {
                    return false;
                }

                int var4 = this.worldObj.getBlockId(var1, var2 - 1, var3);

                Block block = Block.blocksList[var4];
                if (var4 == Block.grass.blockID || (block != null && block.isLeaves(worldObj, var1, var2 - 1, var3)))
                {
                    return true;
                }
            }

            return false;
        }
    }
}
