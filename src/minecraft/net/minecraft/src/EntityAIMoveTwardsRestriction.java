package net.minecraft.src;

public class EntityAIMoveTwardsRestriction extends EntityAIBase
{
    private EntityCreature theEntity;
    private double movePosX;
    private double movePosY;
    private double movePosZ;
    private float field_48352_e;

    public EntityAIMoveTwardsRestriction(EntityCreature par1EntityCreature, float par2)
    {
        this.theEntity = par1EntityCreature;
        this.field_48352_e = par2;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.theEntity.isWithinHomeDistanceCurrentPosition())
        {
            return false;
        }
        else
        {
            ChunkCoordinates var1 = this.theEntity.getHomePosition();
            Vec3D var2 = RandomPositionGenerator.func_48620_a(this.theEntity, 16, 7, Vec3D.createVector((double)var1.posX, (double)var1.posY, (double)var1.posZ));

            if (var2 == null)
            {
                return false;
            }
            else
            {
                this.movePosX = var2.xCoord;
                this.movePosY = var2.yCoord;
                this.movePosZ = var2.zCoord;
                return true;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.theEntity.getNavigator().noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.theEntity.getNavigator().tryMoveToXYZ(this.movePosX, this.movePosY, this.movePosZ, this.field_48352_e);
    }
}
