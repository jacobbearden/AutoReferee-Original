package org.mctourney.autoreferee.event.match;

import org.bukkit.event.Cancellable;
import org.bukkit.event.HandlerList;

import org.mctourney.autoreferee.AutoRefMatch;

/**
 * Called when match statistics are generated and uploaded.
 *
 * @author authorblues
 */
public class MatchUploadStatsEvent extends MatchEvent implements Cancellable
{
	private static final HandlerList handlers = new HandlerList();
	private boolean cancelled = false;
	private String webstats = null;

	public MatchUploadStatsEvent(AutoRefMatch match, String webstats)
	{
		super(match);
		this.webstats = webstats;
	}

	/**
	 * Returns the webstats generated by the server.
	 * @return web stats in HTML format
	 */
	public String getWebstats()
	{ return this.webstats; }

	/**
	 * Sets the webstats to be saved and uploaded.
	 * @param webstats web stats in HTML format
	 */
	public void setWebstats(String webstats)
	{ this.webstats = webstats; }

	/**
	 * Checks the cancelled state of the event.
	 * @return true if the event has been cancelled, false otherwise
	 */
	public boolean isCancelled()
	{ return this.cancelled; }

	/**
	 * Sets the cancelled state of the event.
	 * @param cancel true to cancel the event, false to uncancel the event
	 */
	public void setCancelled(boolean cancel)
	{ this.cancelled = cancel; }

	@Override
	public HandlerList getHandlers()
	{ return handlers; }

	public static HandlerList getHandlerList()
	{ return handlers; }
}
