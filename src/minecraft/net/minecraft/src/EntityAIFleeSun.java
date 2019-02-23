package net.minecraft.src;

import java.util.Random;

public class EntityAIFleeSun extends EntityAIBase
{
    private EntityCreature theCreature;
    private double shelterX;
    private double shelterY;
    private double shelterZ;
    private float field_48299_e;
    private World theWorld;

    public EntityAIFleeSun(EntityCreature par1EntityCreature, float par2)
    {
        this.theCreature = par1EntityCreature;
        this.field_48299_e = par2;
        this.theWorld = par1EntityCreature.worldObj;
        this.setMutexBits(1);
    }

    /**
     * Returns whether the EntityAIBase should begin execution.
     */
    public boolean shouldExecute()
    {
        if (!this.theWorld.isDaytime())
        {
            return false;
        }
        else if (!this.theCreature.isBurning())
        {
            return false;
        }
        else if (!this.theWorld.canBlockSeeTheSky(MathHelper.floor_double(this.theCreature.posX), (int)this.theCreature.boundingBox.minY, MathHelper.floor_double(this.theCreature.posZ)))
        {
            return false;
        }
        else
        {
            Vec3D var1 = this.findPossibleShelter();

            if (var1 == null)
            {
                return false;
            }
            else
            {
                this.shelterX = var1.xCoord;
                this.shelterY = var1.yCoord;
                this.shelterZ = var1.zCoord;
                return true;
            }
        }
    }

    /**
     * Returns whether an in-progress EntityAIBase should continue executing
     */
    public boolean continueExecuting()
    {
        return !this.theCreature.getNavigator().noPath();
    }

    /**
     * Execute a one shot task or start executing a continuous task
     */
    public void startExecuting()
    {
        this.theCreature.getNavigator().tryMoveToXYZ(this.shelterX, this.shelterY, this.shelterZ, this.field_48299_e);
    }

    private Vec3D findPossibleShelter()
    {
        Random var1 = this.theCreature.getRNG();

        for (int var2 = 0; var2 < 10; ++var2)
        {
            int var3 = MathHelper.floor_double(this.theCreature.posX + (double)var1.nextInt(20) - 10.0D);
            int var4 = MathHelper.floor_double(this.theCreature.boundingBox.minY + (double)var1.nextInt(6) - 3.0D);
            int var5 = MathHelper.floor_double(this.theCreature.posZ + (double)var1.nextInt(20) - 10.0D);

            if (!this.theWorld.canBlockSeeTheSky(var3, var4, var5) && this.theCreature.getBlockPathWeight(var3, var4, var5) < 0.0F)
            {
                return Vec3D.createVector((double)var3, (double)var4, (double)var5);
            }
        }

        return null;
    }
}
