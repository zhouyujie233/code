import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception {
        GridPane gp = new GridPane();
        gp.setVgap(15);
        gp.setAlignment(Pos.CENTER);
        gp.add(new Label("请输入三个1到200的整数:"), 0, 0);
        HBox[] hBoxes = new HBox[5];
        TextField textFieldA = new TextField(), textFieldB = new TextField(), textFieldC = new TextField(), textFieldGeo = new TextField();
        for (int i = 0; i < 5; i++) {
            hBoxes[i] = new HBox();
            if (i == 0) {
                hBoxes[i].getChildren().addAll(new Label("A       "), textFieldA);
            }
            else if (i == 1) {
                hBoxes[i].getChildren().addAll(new Label("B       "), textFieldB);
            }
            else if (i == 2) {
                hBoxes[i].getChildren().addAll(new Label("C       "), textFieldC);
            }
            else if (i == 3) {
                hBoxes[i].getChildren().addAll(new Label("形状   "), textFieldGeo);
            }
            else if (i == 4) {
                Button input = new Button("重新输入"), judge = new Button("判断形状");
                hBoxes[i].getChildren().addAll(judge, input);
                hBoxes[i].setSpacing(70);
                judge.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        try {
                            double a = Double.parseDouble(textFieldA.getText()), b = Double.parseDouble(textFieldB.getText()), c = Double.parseDouble(textFieldC.getText());

                            if (a + b <= c || a + c <= b || b + c <= a) {
                                textFieldGeo.setText("不能构成三角形");
                            } else {
                                if (a == b && b == c) {
                                    textFieldGeo.setText("等边三角形");
                                } else if (a == b || a == c || b == c) {
                                    textFieldGeo.setText("等腰三角形");
                                } else {
                                    textFieldGeo.setText("一般三角形");
                                }
                                if ((a > 200 || a < 1) || (b > 200 || b < 1) || (c > 200 || c < 1)) {
                                    try {
                                        throw new Exception();
                                    } catch (Exception outExp) {
                                        System.out.println("输入参数超限!");
                                        textFieldGeo.setText("输入参数超限!");
                                    }
                                }
                            }

                        } catch (Exception e) {
                            System.out.println("参数输入非法!");
                        }
                    }
                });
                input.setOnAction(new EventHandler<ActionEvent>() {
                    @Override
                    public void handle(ActionEvent actionEvent) {
                        textFieldA.setText("");
                        textFieldB.setText("");
                        textFieldC.setText("");
                    }
                });
            }
            gp.add(hBoxes[i], 0, i + 1);
        }
        primaryStage.setTitle("判断三角形");
        primaryStage.setScene(new Scene(gp, 300, 300));
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
