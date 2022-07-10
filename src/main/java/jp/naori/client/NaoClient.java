package jp.naori.client;

import javafx.stage.Stage;
import jp.naori.client.ui.PanelManager;
import jp.naori.client.ui.panels.PanelLogin;

public class NaoClient {

    private PanelManager panelManager;
    public void init(Stage stage){
        this.panelManager = new PanelManager(this, stage);
        this.panelManager.init();
        this.panelManager.showPanel(new PanelLogin());

    }

}
