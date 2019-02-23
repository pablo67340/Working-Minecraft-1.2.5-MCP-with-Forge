package net.minecraft.src;

public class EntityAIBreakDoor extends EntityAIDoorInteract
{
    private int field_48329_i;

    public EntityAIBreakDoor(EntityLiving par1EntityLiving)
    {
        super(par1EntityLiving);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return !super.shouldExecute() ? false : !this.targetDoor.func_48213_h(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        super.startExecuting();
        this.field_48329_i = 240;
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        double var1 = this.theEntity.getDistanceSq((double)this.entityPosX, (double)this.entityPosY, (double)this.entityPosZ);
        return this.field_48329_i >= 0 && !this.targetDoor.func_48213_h(this.theEntity.worldObj, this.entityPosX, this.entityPosY, this.entityPosZ) && var1 < 4.0D;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        super.updateTask();

        if (this.theEntity.getRNG().nextInt(20) == 0)
        {
            this.theEntity.worldObj.playAuxSFX(1010, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
        }

        if (--this.field_48329_i == 0 && this.theEntity.worldObj.difficultySetting == 3)
        {
            this.theEntity.worldObj.setBlockWithNotify(this.entityPosX, this.entityPosY, this.entityPosZ, 0);
            this.theEntity.worldObj.playAuxSFX(1012, this.entityPosX, this.entityPosY, this.entityPosZ, 0);
            this.theEntity.worldObj.playAuxSFX(2001, this.entityPosX, this.entityPosY, this.entityPosZ, this.targetDoor.blockID);
        }
    }
}
