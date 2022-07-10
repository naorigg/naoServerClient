package jp.naori.client.ui.panel;

import javafx.scene.layout.GridPane;
import jp.naori.client.ui.PanelManager;

public interface IPanel {
    void init(PanelManager panelManager);
    GridPane getLayout();
    void onShow();
}
