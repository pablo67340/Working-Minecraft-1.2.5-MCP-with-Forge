package net.minecraft.src;

import java.util.Iterator;
import java.util.List;

public class EntityAIHurtByTarget extends EntityAITarget
{
    boolean field_48395_a;

    public EntityAIHurtByTarget(EntityLiving par1EntityLiving, boolean par2)
    {
        super(par1EntityLiving, 16.0F, false);
        this.field_48395_a = par2;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        return this.func_48376_a(this.taskOwner.getAITarget(), true);
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.taskOwner.setAttackTarget(this.taskOwner.getAITarget());

        if (this.field_48395_a)
        {
            List var1 = this.taskOwner.worldObj.getEntitiesWithinAABB(this.taskOwner.getClass(), AxisAlignedBB.getBoundingBoxFromPool(this.taskOwner.posX, this.taskOwner.posY, this.taskOwner.posZ, this.taskOwner.posX + 1.0D, this.taskOwner.posY + 1.0D, this.taskOwner.posZ + 1.0D).expand((double)this.targetDistance, 4.0D, (double)this.targetDistance));
            Iterator var2 = var1.iterator();

            while (var2.hasNext())
            {
                Entity var3 = (Entity)var2.next();
                EntityLiving var4 = (EntityLiving)var3;

                if (this.taskOwner != var4 && var4.getAttackTarget() == null)
                {
                    var4.setAttackTarget(this.taskOwner.getAITarget());
                }
            }
        }

        super.startExecuting();
    }
}
