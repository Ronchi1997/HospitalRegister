import javafx.scene.control.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import java.sql.SQLException;
import java.math.BigDecimal;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Node;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

@SuppressWarnings("unchecked")

public class PatientView
{
    @FXML
    private ChoiceBox ksmc;
    @FXML
    private ChoiceBox ysxm;
	@FXML
	private ChoiceBox hzlb;
	@FXML
	private ChoiceBox hzmc;
	@FXML
	private TextField yjje;
	@FXML
	public TextField jkje;
	@FXML
	private TextField zlje;
	@FXML
	private TextField ghhm;

    private ConnectDB db = new ConnectDB();
    private Connection connection = db.getConnection();

    private ObservableList ysxmItems = FXCollections.observableArrayList();
    private ObservableList hzmcItems = FXCollections.observableArrayList();
    private ObservableList hzlbItems = FXCollections.observableArrayList();

    public void Init()
    {
        zlje.setEditable(false);
        ghhm.setEditable(false);

        ksmc.setItems(FXCollections.observableArrayList("神经科","感染科","保健科","皮肤科","口腔科","中医科"));

        ksmc.getSelectionModel().selectedIndexProperty().addListener((ov,oldv,newv)->{
            try
            {
                ysxmItems.clear();
                hzmcItems.clear();
                hzlbItems.clear();
                yjje.clear();
                zlje.clear();
                ghhm.clear();
                Statement state = connection.createStatement();
                String sql = new String();
                String sql1 = new String();
                switch(newv.intValue())
                {
                    case 0:
                        sql = "select YSMC from t_ksys where KSBH='000001'";
                        sql1 = "select HZMC from t_hzxx where KSBH='000001'";
                        break;
                    case 1:
                        sql = "select YSMC from t_ksys where KSBH='000002'";
                        sql1 = "select HZMC from t_hzxx where KSBH='000002'";
                        break;
                    case 2:
                        sql = "select YSMC from t_ksys where KSBH='000003'";
                        sql1 = "select HZMC from t_hzxx where KSBH='000003'";
                        break;
                    case 3:
                        sql = "select YSMC from t_ksys where KSBH='000004'";
                        sql1 = "select HZMC from t_hzxx where KSBH='000004'";
                        break;
                    case 4:
                        sql = "select YSMC from t_ksys where KSBH='000005'";
                        sql1 = "select HZMC from t_hzxx where KSBH='000005'";
                        break;
                    case 5:
                        sql = "select YSMC from t_ksys where KSBH='000006'";
                        sql1 = "select HZMC from t_hzxx where KSBH='000006'";
                        break;
                }
                ResultSet rs = state.executeQuery(sql);
                while(rs.next())
                {
                    String YSMC = rs.getString("YSMC");
                    ysxmItems.add(new String(YSMC));
                }
                ResultSet rs1 = state.executeQuery(sql1);
                while(rs1.next())
                {
                    String HZMC = rs1.getString("HZMC");
                    hzmcItems.add(new String(HZMC));
                }
                ysxm.setItems(ysxmItems);
                hzmc.setItems(hzmcItems);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        });
        hzmc.getSelectionModel().selectedIndexProperty().addListener((ov,oldv,newv)->{
            try
            {
                hzlbItems.clear();
                yjje.clear();
                zlje.clear();
                ghhm.clear();
                Statement state = connection.createStatement();
                String sql = "select SFZJ from t_hzxx where HZMC='"+ hzmc.getItems().get(0) +"'";
                ResultSet rs = state.executeQuery(sql);
                while(rs.next())
                {
                    String HZLB = rs.getBoolean("SFZJ") ? "专家号" : "普通号";
                    hzlbItems.add(new String(HZLB));
                }
                hzlb.setItems(hzlbItems);
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        });
        hzlb.getSelectionModel().selectedIndexProperty().addListener((ov,oldv,newv)->{
            try
            {
                yjje.clear();
                zlje.clear();
                ghhm.clear();
                Statement state = connection.createStatement();
                String sql = "select GHFY from t_hzxx where HZMC='"+ hzmc.getItems().get(0) +"'";
                ResultSet rs = state.executeQuery(sql);
                if(rs.next())
                {
                    yjje.setText(rs.getBigDecimal("GHFY").toString());
                }
                BigDecimal jkjed = new BigDecimal(jkje.getText());
                BigDecimal yjjed = new BigDecimal(yjje.getText());
                BigDecimal zl = jkjed.subtract(yjjed);
                if(zl.compareTo(BigDecimal.ZERO) == -1)
                {
                    Alert message = new Alert(Alert.AlertType.ERROR,"余额不足");
                    message.showAndWait();
                    zlje.setText("余额不足");
                }
                else
                    zlje.setText(zl.toString());
            }
            catch(SQLException e)
            {
                e.printStackTrace();
            }
        });
    }
	@FXML
    private void on_btn_OK_clicked(ActionEvent event)
    {
        on_btn_Exit_clicked(event);
    }
	@FXML
    private void on_btn_Clr_clicked(ActionEvent event)
    {
    	yjje.clear();
    	zlje.clear();
    	ghhm.clear();
        Init();
    }
    @FXML
    private void on_btn_Exit_clicked(ActionEvent event)
    {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }
    //获取挂号的编号
    private String getReg()
    {
        String GHBH = new String();
        return GHBH;
    }
}