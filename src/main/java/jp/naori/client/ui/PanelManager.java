package jp.naori.client.ui;

import fr.arinonia.arilibfx.AriLibFX;
import fr.arinonia.arilibfx.ui.utils.ResizeHelper;
import javafx.geometry.VPos;
import javafx.scene.Scene;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.layout.RowConstraints;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import jp.naori.client.NaoClient;
import jp.naori.client.ui.panel.IPanel;
import jp.naori.client.ui.panels.includes.TopPanel;
import org.omg.CosNaming.BindingIterator;

import java.util.function.IntPredicate;

public class PanelManager {

    private final NaoClient NaoClient;
    private final Stage stage;

    private GridPane layout;
    private TopPanel topPanel = new TopPanel();

    private GridPane centerPanel = new GridPane();

    // Alt+Ins => Constructor
    // Constructor
    public PanelManager(jp.naori.client.NaoClient naoClient, Stage stage) {
        NaoClient = naoClient;
        this.stage = stage;
    }

    public void init(){
        this.stage.setTitle("NaoClient");
        this.stage.setMinWidth(1280);
        this.stage.setWidth(1280);
        this.stage.setMinHeight(720);
        this.stage.setHeight(720);
        this.stage.initStyle(StageStyle.TRANSPARENT);
        this.stage.centerOnScreen();
        this.stage.show();


        this.layout = new GridPane();
        this.layout.setStyle(AriLibFX.setResponsiveBackground("https://fr-minecraft.net/upload/wallpapers/images/fr-minecraft_wallpaper_LYKM.png"));
        this.stage.setScene(new Scene(this.layout));

        RowConstraints topPanelConstraints = new RowConstraints();
        topPanelConstraints.setValignment(VPos.TOP);
        topPanelConstraints.setMinHeight(25);
        topPanelConstraints.setMaxHeight(25);

        this.layout.getRowConstraints().addAll(topPanelConstraints, new RowConstraints());
        this.layout.add(this.topPanel.getLayout(), 0,0);

        this.topPanel.init(this);
        this.layout.add(centerPanel, 0,1);
        GridPane.setVgrow(this.centerPanel, Priority.ALWAYS);
        GridPane.setHgrow(this.centerPanel, Priority.ALWAYS);

        ResizeHelper.addResizeListener(this.stage);
    }

    public void showPanel(IPanel panel){
        this.centerPanel.getChildren().clear();
        this.centerPanel.getChildren().add(panel.getLayout());
        panel.init(this);
        panel.onShow();
    }

    public Stage getStage() { return stage; }
    public TopPanel getTopPanel() { return topPanel; }
    public NaoClient getNaoClient() { return NaoClient; }
}
