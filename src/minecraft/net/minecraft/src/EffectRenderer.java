package net.minecraft.src;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;
import java.util.Map.Entry;
import java.util.Random;
import org.lwjgl.opengl.GL11;

import net.minecraft.src.forge.*;

public class EffectRenderer
{
    /** Reference to the World object. */
    protected World worldObj;
    private List[] fxLayers = new List[4];
    private RenderEngine renderer;

    /** RNG. */
    private Random rand = new Random();

    private Hashtable<String, ArrayList<EntityFX>> effectList = new Hashtable<String, ArrayList<EntityFX>>();
    
    public EffectRenderer(World par1World, RenderEngine par2RenderEngine)
    {
        if (par1World != null)
        {
            this.worldObj = par1World;
        }

        this.renderer = par2RenderEngine;

        for (int var3 = 0; var3 < 4; ++var3)
        {
            this.fxLayers[var3] = new ArrayList();
        }
    }

    public void addEffect(EntityFX par1EntityFX)
    {
        int var2 = par1EntityFX.getFXLayer();

        if (this.fxLayers[var2].size() >= 4000)
        {
            this.fxLayers[var2].remove(0);
        }

        this.fxLayers[var2].add(par1EntityFX);
    }

    public void updateEffects()
    {
        for (int var1 = 0; var1 < 4; ++var1)
        {
            for (int var2 = 0; var2 < this.fxLayers[var1].size(); ++var2)
            {
                EntityFX var3 = (EntityFX)this.fxLayers[var1].get(var2);
                var3.onUpdate();

                if (var3.isDead)
                {
                    this.fxLayers[var1].remove(var2--);
                }
            }
        }
        
        for (String key : effectList.keySet())
        {
            ArrayList<EntityFX> entry = effectList.get(key);
            for (int y = 0; y < entry.size(); y++) 
            {
                EntityFX var3 = entry.get(y);
                var3.onUpdate();
                if (var3.isDead) 
                {
                    entry.remove(y--);
                }
            }
            if (effectList.size() == 0)
            {
                effectList.remove(key);
            }
        }
    }

    /**
     * Renders all current particles. Args player, partialTickTime
     */
    public void renderParticles(Entity par1Entity, float par2)
    {
        float var3 = ActiveRenderInfo.rotationX;
        float var4 = ActiveRenderInfo.rotationZ;
        float var5 = ActiveRenderInfo.rotationYZ;
        float var6 = ActiveRenderInfo.rotationXY;
        float var7 = ActiveRenderInfo.rotationXZ;
        EntityFX.interpPosX = par1Entity.lastTickPosX + (par1Entity.posX - par1Entity.lastTickPosX) * (double)par2;
        EntityFX.interpPosY = par1Entity.lastTickPosY + (par1Entity.posY - par1Entity.lastTickPosY) * (double)par2;
        EntityFX.interpPosZ = par1Entity.lastTickPosZ + (par1Entity.posZ - par1Entity.lastTickPosZ) * (double)par2;

        for (int var8 = 0; var8 < 3; ++var8)
        {
            if (this.fxLayers[var8].size() != 0)
            {
                int var9 = 0;

                if (var8 == 0)
                {
                    var9 = this.renderer.getTexture("/particles.png");
                }

                if (var8 == 1)
                {
                    var9 = this.renderer.getTexture("/terrain.png");
                }

                if (var8 == 2)
                {
                    var9 = this.renderer.getTexture("/gui/items.png");
                }

                GL11.glBindTexture(GL11.GL_TEXTURE_2D, var9);
                Tessellator var10 = Tessellator.instance;
                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
                var10.startDrawingQuads();

                for (int var11 = 0; var11 < this.fxLayers[var8].size(); ++var11)
                {
                    EntityFX var12 = (EntityFX)this.fxLayers[var8].get(var11);
                    var10.setBrightness(var12.getBrightnessForRender(par2));
                    var12.renderParticle(var10, par2, var3, var7, var4, var5, var6);
                }

                var10.draw();
            }
        }

        Tessellator tessallator = Tessellator.instance;
        
        for (Entry<String, ArrayList<EntityFX>> entry : effectList.entrySet())
        {
            GL11.glBindTexture(GL11.GL_TEXTURE_2D, renderer.getTexture(entry.getKey()));
            tessallator.startDrawingQuads();
            for (EntityFX entryfx : entry.getValue())
            {
                if (entryfx.getFXLayer() != 3)
                {
                    tessallator.setBrightness(entryfx.getBrightnessForRender(par2));
                    entryfx.renderParticle(tessallator, par2, var3, var7, var4, var5, var6);
                }
            }
            tessallator.draw();
        }
    }

    public void func_1187_b(Entity par1Entity, float par2)
    {
        float var4 = MathHelper.cos(par1Entity.rotationYaw * 0.017453292F);
        float var5 = MathHelper.sin(par1Entity.rotationYaw * 0.017453292F);
        float var6 = -var5 * MathHelper.sin(par1Entity.rotationPitch * 0.017453292F);
        float var7 = var4 * MathHelper.sin(par1Entity.rotationPitch * 0.017453292F);
        float var8 = MathHelper.cos(par1Entity.rotationPitch * 0.017453292F);
        byte var9 = 3;

        if (this.fxLayers[var9].size() != 0)
        {
            Tessellator var10 = Tessellator.instance;

            for (int var11 = 0; var11 < this.fxLayers[var9].size(); ++var11)
            {
                EntityFX var12 = (EntityFX)this.fxLayers[var9].get(var11);
                var10.setBrightness(var12.getBrightnessForRender(par2));
                var12.renderParticle(var10, par2, var4, var8, var5, var6, var7);
            }
        }
    }

    public void clearEffects(World par1World)
    {
        this.worldObj = par1World;

        for (int var2 = 0; var2 < 4; ++var2)
        {
            this.fxLayers[var2].clear();
        }
        
        for (ArrayList<EntityFX> entry : effectList.values())
        {
            entry.clear();
        }
        effectList.clear();
    }

    public void addBlockDestroyEffects(int par1, int par2, int par3, int par4, int par5)
    {
        if (par4 != 0)
        {
            Block var6 = Block.blocksList[par4];
            byte var7 = 4;

            for (int var8 = 0; var8 < var7; ++var8)
            {
                for (int var9 = 0; var9 < var7; ++var9)
                {
                    for (int var10 = 0; var10 < var7; ++var10)
                    {
                        double var11 = (double)par1 + ((double)var8 + 0.5D) / (double)var7;
                        double var13 = (double)par2 + ((double)var9 + 0.5D) / (double)var7;
                        double var15 = (double)par3 + ((double)var10 + 0.5D) / (double)var7;
                        int var17 = this.rand.nextInt(6);
                        this.addEffect((new EntityDiggingFX(this.worldObj, var11, var13, var15, var11 - (double)par1 - 0.5D, var13 - (double)par2 - 0.5D, var15 - (double)par3 - 0.5D, var6, var17, par5)).func_4041_a(par1, par2, par3), var6);
                    }
                }
            }
        }
    }

    /**
     * Adds block hit particles for the specified block. Args: x, y, z, sideHit
     */
    public void addBlockHitEffects(int par1, int par2, int par3, int par4)
    {
        int var5 = this.worldObj.getBlockId(par1, par2, par3);

        if (var5 != 0)
        {
            Block var6 = Block.blocksList[var5];
            float var7 = 0.1F;
            double var8 = (double)par1 + this.rand.nextDouble() * (var6.maxX - var6.minX - (double)(var7 * 2.0F)) + (double)var7 + var6.minX;
            double var10 = (double)par2 + this.rand.nextDouble() * (var6.maxY - var6.minY - (double)(var7 * 2.0F)) + (double)var7 + var6.minY;
            double var12 = (double)par3 + this.rand.nextDouble() * (var6.maxZ - var6.minZ - (double)(var7 * 2.0F)) + (double)var7 + var6.minZ;

            if (par4 == 0)
            {
                var10 = (double)par2 + var6.minY - (double)var7;
            }

            if (par4 == 1)
            {
                var10 = (double)par2 + var6.maxY + (double)var7;
            }

            if (par4 == 2)
            {
                var12 = (double)par3 + var6.minZ - (double)var7;
            }

            if (par4 == 3)
            {
                var12 = (double)par3 + var6.maxZ + (double)var7;
            }

            if (par4 == 4)
            {
                var8 = (double)par1 + var6.minX - (double)var7;
            }

            if (par4 == 5)
            {
                var8 = (double)par1 + var6.maxX + (double)var7;
            }

            this.addEffect((new EntityDiggingFX(this.worldObj, var8, var10, var12, 0.0D, 0.0D, 0.0D, var6, par4, this.worldObj.getBlockMetadata(par1, par2, par3))).func_4041_a(par1, par2, par3).multiplyVelocity(0.2F).func_405_d(0.6F), var6);
        }
    }

    public String getStatistics()
    {
        int size = 0;
        for (List x : fxLayers)
        {
            size += x.size();
        }
        for (ArrayList<EntityFX> entry : effectList.values())
        {
            size += entry.size();
        }
        return Integer.toString(size);
    }
     
    public void addEffect(EntityFX effect, Object effectObject)
    {
        if (effectObject == null || !(effect instanceof EntityDiggingFX || effect instanceof EntityBreakingFX))
        {
            addEffect(effect);
            return;
        }

        String texture = "/terrain.png";
        if (effect.getFXLayer() == 0)
        {
            texture = "/particles.png";
        }
        else if (effect.getFXLayer() == 2)
        {
            texture = "/gui/items.png";
        }        
        texture = ForgeHooksClient.getTexture(texture, effectObject);
        
        ArrayList<EntityFX> set = effectList.get(texture);
        if (set == null)
        {
            set = new ArrayList<EntityFX>();
            effectList.put(texture, set);
        }
        set.add(effect);
    }
}
