package net.minecraft.src;

import java.net.URI;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.lwjgl.input.Keyboard;
import org.lwjgl.input.Mouse;

public class GuiChat extends GuiScreen
{
    private String field_50062_b = "";

    /**
     * keeps position of which chat message you will select when you press up, (does not increase for duplicated
     * messages sent immediately after each other)
     */
    private int sentHistoryCursor = -1;
    private boolean field_50060_d = false;
    private String field_50061_e = "";
    private String field_50059_f = "";
    private int field_50067_h = 0;
    private List field_50068_i = new ArrayList();

    /** used to pass around the URI to various dialogues and to the host os */
    private URI clickedURI = null;

    /** Chat entry field */
    protected GuiTextField inputField;

    /**
     * is the text that appears when you press the chat key and the input box appears pre-filled
     */
    private String defaultInputFieldText = "";

    public GuiChat() {}

    public GuiChat(String par1Str)
    {
        this.defaultInputFieldText = par1Str;
    }

    /**
     * Adds the buttons (and other controls) to the screen in question.
     */
    public void initGui()
    {
        Keyboard.enableRepeatEvents(true);
        this.sentHistoryCursor = this.mc.ingameGUI.getSentMessageList().size();
        this.inputField = new GuiTextField(this.fontRenderer, 4, this.height - 12, this.width - 4, 12);
        this.inputField.setMaxStringLength(100);
        this.inputField.setEnableBackgroundDrawing(false);
        this.inputField.setFocused(true);
        this.inputField.setText(this.defaultInputFieldText);
        this.inputField.setCanLoseFocus(false);
    }

    /**
     * Called when the screen is unloaded. Used to disable keyboard repeat events
     */
    public void onGuiClosed()
    {
        Keyboard.enableRepeatEvents(false);
        this.mc.ingameGUI.func_50014_d();
    }

    /**
     * Called from the main game loop to update the screen.
     */
    public void updateScreen()
    {
        this.inputField.updateCursorCounter();
    }

    /**
     * Fired when a key is typed. This is the equivalent of KeyListener.keyTyped(KeyEvent e).
     */
    protected void keyTyped(char par1, int par2)
    {
        if (par2 == 15)
        {
            this.completePlayerName();
        }
        else
        {
            this.field_50060_d = false;
        }

        if (par2 == 1)
        {
            this.mc.displayGuiScreen((GuiScreen)null);
        }
        else if (par2 == 28)
        {
            String var3 = this.inputField.getText().trim();

            if (var3.length() > 0 && !this.mc.lineIsCommand(var3))
            {
                this.mc.thePlayer.sendChatMessage(var3);
            }

            this.mc.displayGuiScreen((GuiScreen)null);
        }
        else if (par2 == 200)
        {
            this.getSentHistory(-1);
        }
        else if (par2 == 208)
        {
            this.getSentHistory(1);
        }
        else if (par2 == 201)
        {
            this.mc.ingameGUI.adjustHistoryOffset(19);
        }
        else if (par2 == 209)
        {
            this.mc.ingameGUI.adjustHistoryOffset(-19);
        }
        else
        {
            this.inputField.textboxKeyTyped(par1, par2);
        }
    }

    /**
     * Handles mouse input.
     */
    public void handleMouseInput()
    {
        super.handleMouseInput();
        int var1 = Mouse.getEventDWheel();

        if (var1 != 0)
        {
            if (var1 > 1)
            {
                var1 = 1;
            }

            if (var1 < -1)
            {
                var1 = -1;
            }

            if (!isShiftKeyDown())
            {
                var1 *= 7;
            }

            this.mc.ingameGUI.adjustHistoryOffset(var1);
        }
    }

    /**
     * Called when the mouse is clicked.
     */
    protected void mouseClicked(int par1, int par2, int par3)
    {
        if (par3 == 0)
        {
            ChatClickData var4 = this.mc.ingameGUI.getChatClickDataFromMouse(Mouse.getX(), Mouse.getY());

            if (var4 != null)
            {
                URI var5 = var4.getURI();

                if (var5 != null)
                {
                    this.clickedURI = var5;
                    this.mc.displayGuiScreen(new GuiChatConfirmLink(this, this, var4.func_50088_a(), 0, var4));
                    return;
                }
            }
        }

        this.inputField.mouseClicked(par1, par2, par3);
        super.mouseClicked(par1, par2, par3);
    }

    public void confirmClicked(boolean par1, int par2)
    {
        if (par2 == 0)
        {
            if (par1)
            {
                try
                {
                    Class var3 = Class.forName("java.awt.Desktop");
                    Object var4 = var3.getMethod("getDesktop", new Class[0]).invoke((Object)null, new Object[0]);
                    var3.getMethod("browse", new Class[] {URI.class}).invoke(var4, new Object[] {this.clickedURI});
                }
                catch (Throwable var5)
                {
                    var5.printStackTrace();
                }
            }

            this.clickedURI = null;
            this.mc.displayGuiScreen(this);
        }
    }

    /**
     * Autocompletes player name
     */
    public void completePlayerName()
    {
        Iterator var2;
        GuiPlayerInfo var3;

        if (this.field_50060_d)
        {
            this.inputField.func_50021_a(-1);

            if (this.field_50067_h >= this.field_50068_i.size())
            {
                this.field_50067_h = 0;
            }
        }
        else
        {
            int var1 = this.inputField.func_50028_c(-1);

            if (this.inputField.func_50035_h() - var1 < 1)
            {
                return;
            }

            this.field_50068_i.clear();
            this.field_50061_e = this.inputField.getText().substring(var1);
            this.field_50059_f = this.field_50061_e.toLowerCase();
            var2 = ((EntityClientPlayerMP)this.mc.thePlayer).sendQueue.playerInfoList.iterator();

            while (var2.hasNext())
            {
                var3 = (GuiPlayerInfo)var2.next();

                if (var3.nameStartsWith(this.field_50059_f))
                {
                    this.field_50068_i.add(var3);
                }
            }

            if (this.field_50068_i.size() == 0)
            {
                return;
            }

            this.field_50060_d = true;
            this.field_50067_h = 0;
            this.inputField.func_50020_b(var1 - this.inputField.func_50035_h());
        }

        if (this.field_50068_i.size() > 1)
        {
            StringBuilder var4 = new StringBuilder();

            for (var2 = this.field_50068_i.iterator(); var2.hasNext(); var4.append(var3.name))
            {
                var3 = (GuiPlayerInfo)var2.next();

                if (var4.length() > 0)
                {
                    var4.append(", ");
                }
            }

            this.mc.ingameGUI.addChatMessage(var4.toString());
        }

        this.inputField.func_50031_b(((GuiPlayerInfo)this.field_50068_i.get(this.field_50067_h++)).name);
    }

    /**
     * input is relative and is applied directly to the sentHistoryCursor so -1 is the previous message, 1 is the next
     * message from the current cursor position
     */
    public void getSentHistory(int par1)
    {
        int var2 = this.sentHistoryCursor + par1;
        int var3 = this.mc.ingameGUI.getSentMessageList().size();

        if (var2 < 0)
        {
            var2 = 0;
        }

        if (var2 > var3)
        {
            var2 = var3;
        }

        if (var2 != this.sentHistoryCursor)
        {
            if (var2 == var3)
            {
                this.sentHistoryCursor = var3;
                this.inputField.setText(this.field_50062_b);
            }
            else
            {
                if (this.sentHistoryCursor == var3)
                {
                    this.field_50062_b = this.inputField.getText();
                }

                this.inputField.setText((String)this.mc.ingameGUI.getSentMessageList().get(var2));
                this.sentHistoryCursor = var2;
            }
        }
    }

    /**
     * Draws the screen and all the components in it.
     */
    public void drawScreen(int par1, int par2, float par3)
    {
        drawRect(2, this.height - 14, this.width - 2, this.height - 2, Integer.MIN_VALUE);
        this.inputField.drawTextBox();
        super.drawScreen(par1, par2, par3);
    }
}
