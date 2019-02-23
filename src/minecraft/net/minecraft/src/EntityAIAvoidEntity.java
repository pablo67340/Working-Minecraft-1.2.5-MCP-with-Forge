package net.minecraft.src;

import java.util.List;

public class EntityAIAvoidEntity extends EntityAIBase
{
    /** The entity we are attached to */
    private EntityCreature theEntity;
    private float field_48242_b;
    private float field_48243_c;
    private Entity field_48240_d;
    private float field_48241_e;
    private PathEntity field_48238_f;

    /** The PathNavigate of our entity */
    private PathNavigate entityPathNavigate;

    /** The class of the entity we should avoid */
    private Class targetEntityClass;

    public EntityAIAvoidEntity(EntityCreature par1EntityCreature, Class par2Class, float par3, float par4, float par5)
    {
        this.theEntity = par1EntityCreature;
        this.targetEntityClass = par2Class;
        this.field_48241_e = par3;
        this.field_48242_b = par4;
        this.field_48243_c = par5;
        this.entityPathNavigate = par1EntityCreature.getNavigator();
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (this.targetEntityClass == EntityPlayer.class)
        {
            if (this.theEntity instanceof EntityTameable && ((EntityTameable)this.theEntity).isTamed())
            {
                return false;
            }

            this.field_48240_d = this.theEntity.worldObj.getClosestPlayerToEntity(this.theEntity, (double)this.field_48241_e);

            if (this.field_48240_d == null)
            {
                return false;
            }
        }
        else
        {
            List var1 = this.theEntity.worldObj.getEntitiesWithinAABB(this.targetEntityClass, this.theEntity.boundingBox.expand((double)this.field_48241_e, 3.0D, (double)this.field_48241_e));

            if (var1.size() == 0)
            {
                return false;
            }

            this.field_48240_d = (Entity)var1.get(0);
        }

        if (!this.theEntity.getEntitySenses().canSee(this.field_48240_d))
        {
            return false;
        }
        else
        {
            Vec3D var2 = RandomPositionGenerator.func_48623_b(this.theEntity, 16, 7, Vec3D.createVector(this.field_48240_d.posX, this.field_48240_d.posY, this.field_48240_d.posZ));

            if (var2 == null)
            {
                return false;
            }
            else if (this.field_48240_d.getDistanceSq(var2.xCoord, var2.yCoord, var2.zCoord) < this.field_48240_d.getDistanceSqToEntity(this.theEntity))
            {
                return false;
            }
            else
            {
                this.field_48238_f = this.entityPathNavigate.getPathToXYZ(var2.xCoord, var2.yCoord, var2.zCoord);
                return this.field_48238_f == null ? false : this.field_48238_f.isDestinationSame(var2);
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.entityPathNavigate.noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.entityPathNavigate.setPath(this.field_48238_f, this.field_48242_b);
    }

    /**
     * Resets the task
     */
    public void resetTask()
    {
        this.field_48240_d = null;
    }

    /**
     * Updates the task
     */
    public void updateTask()
    {
        if (this.theEntity.getDistanceSqToEntity(this.field_48240_d) < 49.0D)
        {
            this.theEntity.getNavigator().setSpeed(this.field_48243_c);
        }
        else
        {
            this.theEntity.getNavigator().setSpeed(this.field_48242_b);
        }
    }
}
