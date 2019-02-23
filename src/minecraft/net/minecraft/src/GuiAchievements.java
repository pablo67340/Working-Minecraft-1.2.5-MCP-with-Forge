package net.minecraft.src;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

import net.minecraft.src.forge.MinecraftForge;

import org.lwjgl.input.Mouse;
import org.lwjgl.opengl.GL11;
import org.lwjgl.opengl.GL12;

public class GuiAchievements extends GuiScreen
{
    /** The top x coordinate of the achievement map */
    private static final int guiMapTop = AchievementList.minDisplayColumn * 24 - 112;

    /** The left y coordinate of the achievement map */
    private static final int guiMapLeft = AchievementList.minDisplayRow * 24 - 112;

    /** The bottom x coordinate of the achievement map */
    private static final int guiMapBottom = AchievementList.maxDisplayColumn * 24 - 77;

    /** The right y coordinate of the achievement map */
    private static final int guiMapRight = AchievementList.maxDisplayRow * 24 - 77;
    protected int achievementsPaneWidth = 256;
    protected int achievementsPaneHeight = 202;

    /** The current mouse x coordinate */
    protected int mouseX = 0;

    /** The current mouse y coordinate */
    protected int mouseY = 0;
    protected double field_27116_m;
    protected double field_27115_n;

    /** The x position of the achievement map */
    protected double guiMapX;

    /** The y position of the achievement map */
    protected double guiMapY;
    protected double field_27112_q;
    protected double field_27111_r;

    /** Whether the Mouse Button is down or not */
    private int isMouseButtonDown = 0;
    private StatFileWriter statFileWriter;
    
    private int currentPage = -1;
    private GuiSmallButton button;
    private LinkedList<Achievement> minecraftAchievements = new LinkedList<Achievement>();

    public GuiAchievements(StatFileWriter par1StatFileWriter)
    {
        this.statFileWriter = par1StatFileWriter;
        short var2 = 141;
        short var3 = 141;
        this.field_27116_m = this.guiMapX = this.field_27112_q = (double)(AchievementList.openInventory.displayColumn * 24 - var2 / 2 - 12);
        this.field_27115_n = this.guiMapY = this.field_27111_r = (double)(AchievementList.openInventory.displayRow * 24 - var3 / 2);

        minecraftAchievements.clear();
        for (Object achievement : AchievementList.achievementList)
        {
            if (!MinecraftForge.isAchievementInPages((Achievement)achievement))
            {
                minecraftAchievements.add((Achievement)achievement);
            }
        }
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        this.controlList.clear();
        this.controlList.add(new GuiSmallButton(1, this.width / 2 + 24, this.height / 2 + 74, 80, 20, StatCollector.translateToLocal("gui.done")));
        button = new GuiSmallButton(2, (width - achievementsPaneWidth) / 2 + 24, height / 2 + 74, 125, 20, getAchievementPageTitle(currentPage));
        this.controlList.add(button);
    }

    /**
     * Fired when a control is clicked. This is the equivalent of ActionListener.actionPerformed(ActionEvent e).
     */
    protected void actionPerformed(GuiButton par1GuiButton)
    {
        if (par1GuiButton.id == 1)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
        }
        
        if (par1GuiButton.id == 2) 
        {
            currentPage++;
            if (currentPage >= MinecraftForge.getAchievementPages().size())
            {
                currentPage = -1;
            }
            button.displayString = getAchievementPageTitle(currentPage);
        }

        super.actionPerformed(par1GuiButton);
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2)
    {
        if (par2 == this.mc.gameSettings.keyBindInventory.keyCode)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
            this.mc.setIngameFocus();
        }
        else
        {
            super.keyTyped(par1, par2);
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        if (Mouse.isButtonDown(0))
        {
            int var4 = (this.width - this.achievementsPaneWidth) / 2;
            int var5 = (this.height - this.achievementsPaneHeight) / 2;
            int var6 = var4 + 8;
            int var7 = var5 + 17;

            if ((this.isMouseButtonDown == 0 || this.isMouseButtonDown == 1) && par1 >= var6 && par1 < var6 + 224 && par2 >= var7 && par2 < var7 + 155)
            {
                if (this.isMouseButtonDown == 0)
                {
                    this.isMouseButtonDown = 1;
                }
                else
                {
                    this.guiMapX -= (double)(par1 - this.mouseX);
                    this.guiMapY -= (double)(par2 - this.mouseY);
                    this.field_27112_q = this.field_27116_m = this.guiMapX;
                    this.field_27111_r = this.field_27115_n = this.guiMapY;
                }

                this.mouseX = par1;
                this.mouseY = par2;
            }

            if (this.field_27112_q < (double)guiMapTop)
            {
                this.field_27112_q = (double)guiMapTop;
            }

            if (this.field_27111_r < (double)guiMapLeft)
            {
                this.field_27111_r = (double)guiMapLeft;
            }

            if (this.field_27112_q >= (double)guiMapBottom)
            {
                this.field_27112_q = (double)(guiMapBottom - 1);
            }

            if (this.field_27111_r >= (double)guiMapRight)
            {
                this.field_27111_r = (double)(guiMapRight - 1);
            }
        }
        else
        {
            this.isMouseButtonDown = 0;
        }

        this.drawDefaultBackground();
        this.genAchievementBackground(par1, par2, par3);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        this.func_27110_k();
        GL11.glEnable(GL11.GL_LIGHTING);
        GL11.glEnable(GL11.GL_DEPTH_TEST);
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        this.field_27116_m = this.guiMapX;
        this.field_27115_n = this.guiMapY;
        double var1 = this.field_27112_q - this.guiMapX;
        double var3 = this.field_27111_r - this.guiMapY;

        if (var1 * var1 + var3 * var3 < 4.0D)
        {
            this.guiMapX += var1;
            this.guiMapY += var3;
        }
        else
        {
            this.guiMapX += var1 * 0.85D;
            this.guiMapY += var3 * 0.85D;
        }
    }

    protected void func_27110_k()
    {
        int var1 = (this.width - this.achievementsPaneWidth) / 2;
        int var2 = (this.height - this.achievementsPaneHeight) / 2;
        this.fontRenderer.drawString("Achievements", var1 + 15, var2 + 5, 4210752);
    }

    protected void genAchievementBackground(int par1, int par2, float par3)
    {
        int var4 = MathHelper.floor_double(this.field_27116_m + (this.guiMapX - this.field_27116_m) * (double)par3);
        int var5 = MathHelper.floor_double(this.field_27115_n + (this.guiMapY - this.field_27115_n) * (double)par3);

        if (var4 < guiMapTop)
        {
            var4 = guiMapTop;
        }

        if (var5 < guiMapLeft)
        {
            var5 = guiMapLeft;
        }

        if (var4 >= guiMapBottom)
        {
            var4 = guiMapBottom - 1;
        }

        if (var5 >= guiMapRight)
        {
            var5 = guiMapRight - 1;
        }

        int var6 = this.mc.renderEngine.getTexture("/terrain.png");
        int var7 = this.mc.renderEngine.getTexture("/achievement/bg.png");
        int var8 = (this.width - this.achievementsPaneWidth) / 2;
        int var9 = (this.height - this.achievementsPaneHeight) / 2;
        int var10 = var8 + 16;
        int var11 = var9 + 17;
        this.zLevel = 0.0F;
        GL11.glDepthFunc(GL11.GL_GEQUAL);
        GL11.glPushMatrix();
        GL11.glTranslatef(0.0F, 0.0F, -200.0F);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        this.mc.renderEngine.bindTexture(var6);
        int var12 = var4 + 288 >> 4;
        int var13 = var5 + 288 >> 4;
        int var14 = (var4 + 288) % 16;
        int var15 = (var5 + 288) % 16;
        Random var21 = new Random();
        int var22;
        int var24;
        int var25;
        int var26;

        for (var22 = 0; var22 * 16 - var15 < 155; ++var22)
        {
            float var23 = 0.6F - (float)(var13 + var22) / 25.0F * 0.3F;
            GL11.glColor4f(var23, var23, var23, 1.0F);

            for (var24 = 0; var24 * 16 - var14 < 224; ++var24)
            {
                var21.setSeed((long)(1234 + var12 + var24));
                var21.nextInt();
                var25 = var21.nextInt(1 + var13 + var22) + (var13 + var22) / 2;
                var26 = Block.sand.blockIndexInTexture;

                if (var25 <= 37 && var13 + var22 != 35)
                {
                    if (var25 == 22)
                    {
                        if (var21.nextInt(2) == 0)
                        {
                            var26 = Block.oreDiamond.blockIndexInTexture;
                        }
                        else
                        {
                            var26 = Block.oreRedstone.blockIndexInTexture;
                        }
                    }
                    else if (var25 == 10)
                    {
                        var26 = Block.oreIron.blockIndexInTexture;
                    }
                    else if (var25 == 8)
                    {
                        var26 = Block.oreCoal.blockIndexInTexture;
                    }
                    else if (var25 > 4)
                    {
                        var26 = Block.stone.blockIndexInTexture;
                    }
                    else if (var25 > 0)
                    {
                        var26 = Block.dirt.blockIndexInTexture;
                    }
                }
                else
                {
                    var26 = Block.bedrock.blockIndexInTexture;
                }

                this.drawTexturedModalRect(var10 + var24 * 16 - var14, var11 + var22 * 16 - var15, var26 % 16 << 4, var26 >> 4 << 4, 16, 16);
            }
        }

        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glDisable(GL11.GL_TEXTURE_2D);
        int var27;
        int var30;

        List<Achievement> achievementList = (currentPage == -1 ? minecraftAchievements : MinecraftForge.getAchievementPage(currentPage).getAchievements());
        for (var22 = 0; var22 < achievementList.size(); ++var22)
        {
            Achievement var33 = achievementList.get(var22);

            if (var33.parentAchievement != null && achievementList.contains(var33.parentAchievement))
            {
                var24 = var33.displayColumn * 24 - var4 + 11 + var10;
                var25 = var33.displayRow * 24 - var5 + 11 + var11;
                var26 = var33.parentAchievement.displayColumn * 24 - var4 + 11 + var10;
                var27 = var33.parentAchievement.displayRow * 24 - var5 + 11 + var11;
                boolean var28 = this.statFileWriter.hasAchievementUnlocked(var33);
                boolean var29 = this.statFileWriter.canUnlockAchievement(var33);
                var30 = Math.sin((double)(System.currentTimeMillis() % 600L) / 600.0D * Math.PI * 2.0D) > 0.6D ? 255 : 130;
                int var31 = -16777216;

                if (var28)
                {
                    var31 = -9408400;
                }
                else if (var29)
                {
                    var31 = 65280 + (var30 << 24);
                }

                this.drawHorizontalLine(var24, var26, var25, var31);
                this.drawVerticalLine(var26, var25, var27, var31);
            }
        }

        Achievement var32 = null;
        RenderItem var34 = new RenderItem();
        RenderHelper.enableGUIStandardItemLighting();
        GL11.glDisable(GL11.GL_LIGHTING);
        GL11.glEnable(GL12.GL_RESCALE_NORMAL);
        GL11.glEnable(GL11.GL_COLOR_MATERIAL);
        int var39;
        int var40;

        for (var24 = 0; var24 < achievementList.size(); ++var24)
        {
            Achievement var35 = achievementList.get(var24);
            var26 = var35.displayColumn * 24 - var4;
            var27 = var35.displayRow * 24 - var5;

            if (var26 >= -24 && var27 >= -24 && var26 <= 224 && var27 <= 155)
            {
                float var38;

                if (this.statFileWriter.hasAchievementUnlocked(var35))
                {
                    var38 = 1.0F;
                    GL11.glColor4f(var38, var38, var38, 1.0F);
                }
                else if (this.statFileWriter.canUnlockAchievement(var35))
                {
                    var38 = Math.sin((double)(System.currentTimeMillis() % 600L) / 600.0D * Math.PI * 2.0D) < 0.6D ? 0.6F : 0.8F;
                    GL11.glColor4f(var38, var38, var38, 1.0F);
                }
                else
                {
                    var38 = 0.3F;
                    GL11.glColor4f(var38, var38, var38, 1.0F);
                }

                this.mc.renderEngine.bindTexture(var7);
                var39 = var10 + var26;
                var40 = var11 + var27;

                if (var35.getSpecial())
                {
                    this.drawTexturedModalRect(var39 - 2, var40 - 2, 26, 202, 26, 26);
                }
                else
                {
                    this.drawTexturedModalRect(var39 - 2, var40 - 2, 0, 202, 26, 26);
                }

                if (!this.statFileWriter.canUnlockAchievement(var35))
                {
                    float var41 = 0.1F;
                    GL11.glColor4f(var41, var41, var41, 1.0F);
                    var34.field_27004_a = false;
                }

                GL11.glEnable(GL11.GL_LIGHTING);
                GL11.glEnable(GL11.GL_CULL_FACE);
                var34.renderItemIntoGUI(this.mc.fontRenderer, this.mc.renderEngine, var35.theItemStack, var39 + 3, var40 + 3);
                GL11.glDisable(GL11.GL_LIGHTING);

                if (!this.statFileWriter.canUnlockAchievement(var35))
                {
                    var34.field_27004_a = true;
                }

                GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);

                if (par1 >= var10 && par2 >= var11 && par1 < var10 + 224 && par2 < var11 + 155 && par1 >= var39 && par1 <= var39 + 22 && par2 >= var40 && par2 <= var40 + 22)
                {
                    var32 = var35;
                }
            }
        }

        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_BLEND);
        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        this.mc.renderEngine.bindTexture(var7);
        this.drawTexturedModalRect(var8, var9, 0, 0, this.achievementsPaneWidth, this.achievementsPaneHeight);
        GL11.glPopMatrix();
        this.zLevel = 0.0F;
        GL11.glDepthFunc(GL11.GL_LEQUAL);
        GL11.glDisable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_TEXTURE_2D);
        super.drawScreen(par1, par2, par3);

        if (var32 != null)
        {
            String var36 = StatCollector.translateToLocal(var32.getName());
            String var37 = var32.getDescription();
            var26 = par1 + 12;
            var27 = par2 - 4;

            if (this.statFileWriter.canUnlockAchievement(var32))
            {
                var39 = Math.max(this.fontRenderer.getStringWidth(var36), 120);
                var40 = this.fontRenderer.splitStringWidth(var37, var39);

                if (this.statFileWriter.hasAchievementUnlocked(var32))
                {
                    var40 += 12;
                }

                this.drawGradientRect(var26 - 3, var27 - 3, var26 + var39 + 3, var27 + var40 + 3 + 12, -1073741824, -1073741824);
                this.fontRenderer.drawSplitString(var37, var26, var27 + 12, var39, -6250336);

                if (this.statFileWriter.hasAchievementUnlocked(var32))
                {
                    this.fontRenderer.drawStringWithShadow(StatCollector.translateToLocal("achievement.taken"), var26, var27 + var40 + 4, -7302913);
                }
            }
            else
            {
                var39 = Math.max(this.fontRenderer.getStringWidth(var36), 120);
                String var42 = StatCollector.translateToLocalFormatted("achievement.requires", new Object[] {StatCollector.translateToLocal(var32.parentAchievement.getName())});
                var30 = this.fontRenderer.splitStringWidth(var42, var39);
                this.drawGradientRect(var26 - 3, var27 - 3, var26 + var39 + 3, var27 + var30 + 12 + 3, -1073741824, -1073741824);
                this.fontRenderer.drawSplitString(var42, var26, var27 + 12, var39, -9416624);
            }

            this.fontRenderer.drawStringWithShadow(var36, var26, var27, this.statFileWriter.canUnlockAchievement(var32) ? (var32.getSpecial() ? -128 : -1) : (var32.getSpecial() ? -8355776 : -8355712));
        }

        GL11.glEnable(GL11.GL_DEPTH_TEST);
        GL11.glEnable(GL11.GL_LIGHTING);
        RenderHelper.disableStandardItemLighting();
    }

    /**
     * Returns true if this GUI should pause the game when it is displayed in single-player
     */
    public boolean doesGuiPauseGame()
    {
        return true;
    }
    
    /**
     * FORGE: Gets the name for an achievement page by its index
     */
    public static String getAchievementPageTitle(int index)
    {
        return index == -1 ? "Minecraft" : MinecraftForge.getAchievementPage(index).getName();
    }
}
