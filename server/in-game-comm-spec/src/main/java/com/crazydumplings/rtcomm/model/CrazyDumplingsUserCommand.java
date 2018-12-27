package com.crazydumplings.rtcomm.model;

import static com.crazydumplings.rtcomm.model.CrazyDumplingsUserCommandAction.*;
import static com.crazydumplings.rtcomm.model.CrazyDunplingsUserCommandState.*;

/**
 * Information sent by the client to the server when the user issues a command to the client
 */
public class CrazyDumplingsUserCommand extends CrazyDumplingsRealtimeData {
    CrazyDumplingsUserCommandAction commandAction = COMMAND_ACTION_NONE;
    CrazyDunplingsUserCommandState  commandState  = COMMAND_STATE_NONE;

    public CrazyDumplingsUserCommand(long source, long destination, CrazyDumplingsUserCommandAction commandAction,
            CrazyDunplingsUserCommandState commandState) {
        super(source, destination);
        this.commandAction = commandAction;
        this.commandState = commandState;
    }

    public CrazyDumplingsUserCommand(long source, long destination, CrazyDumplingsUserCommandAction commandAction) {
        super(source, destination);
        this.commandAction = commandAction;
    }
}
