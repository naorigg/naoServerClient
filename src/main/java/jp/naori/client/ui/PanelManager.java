package jp.naori.client.ui;

import javafx.stage.Stage;
import jp.naori.client.NaoClient;

public class PanelManager {

    private final NaoClient NaoClient;
    private final Stage stage;

    // Alt+Ins => Constructor

    public PanelManager(jp.naori.client.NaoClient naoClient, Stage stage) {
        NaoClient = naoClient;
        this.stage = stage;
    }

    public Stage getStage(){
        return stage;
    }
}
