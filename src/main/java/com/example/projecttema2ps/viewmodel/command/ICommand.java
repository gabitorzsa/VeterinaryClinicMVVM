package com.example.projecttema2ps.viewmodel.command;

import java.io.IOException;
import java.sql.SQLException;

public interface ICommand {
    void execute() throws SQLException, IOException;
}
