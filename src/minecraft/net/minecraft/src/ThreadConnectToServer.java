package net.minecraft.src;

import java.net.ConnectException;
import java.net.UnknownHostException;
import net.minecraft.client.Minecraft;

class ThreadConnectToServer extends Thread
{
    /** A reference to the Minecraft object. */
    final Minecraft mc;

    /** The IP address or domain used to connect. */
    final String ip;

    /** The port used to connect. */
    final int port;

    /** A reference to the GuiConnecting object. */
    final GuiConnecting connectingGui;

    ThreadConnectToServer(GuiConnecting par1GuiConnecting, Minecraft par2Minecraft, String par3Str, int par4)
    {
        this.connectingGui = par1GuiConnecting;
        this.mc = par2Minecraft;
        this.ip = par3Str;
        this.port = par4;
    }

    public void run()
    {
        try
        {
            GuiConnecting.setNetClientHandler(this.connectingGui, new NetClientHandler(this.mc, this.ip, this.port));

            if (GuiConnecting.isCancelled(this.connectingGui))
            {
                return;
            }

            GuiConnecting.getNetClientHandler(this.connectingGui).addToSendQueue(new Packet2Handshake(this.mc.session.username, this.ip, this.port));
        }
        catch (UnknownHostException var2)
        {
            if (GuiConnecting.isCancelled(this.connectingGui))
            {
                return;
            }

            this.mc.displayGuiScreen(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[] {"Unknown host \'" + this.ip + "\'"}));
        }
        catch (ConnectException var3)
        {
            if (GuiConnecting.isCancelled(this.connectingGui))
            {
                return;
            }

            this.mc.displayGuiScreen(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[] {var3.getMessage()}));
        }
        catch (Exception var4)
        {
            if (GuiConnecting.isCancelled(this.connectingGui))
            {
                return;
            }

            var4.printStackTrace();
            this.mc.displayGuiScreen(new GuiDisconnected("connect.failed", "disconnect.genericReason", new Object[] {var4.toString()}));
        }
    }
}
