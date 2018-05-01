import javafx.scene.control.*;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.Connection;
import javafx.fxml.FXML;
import javafx.event.ActionEvent;
import javafx.scene.Node;

public class PatientView
{
	@FXML
	private TextField hzlb;
	@FXML
	private TextField hzmc;
	@FXML
	private TextField yjje;
	@FXML
	private TextField jkje;
	@FXML
	private TextField zlje;
	@FXML
	private TextField ghhm;
	@FXML
	private TextField ksmc;
	@FXML
	private TextField ysxm;

    private ConnectDB db = new ConnectDB();
    private Connection connection = db.getConnection();

    

	@FXML
    private void on_btn_OK_clicked(ActionEvent event)
    {
    	// System.out.println(hzlb.getText());
    	// System.out.println(hzmc.getText());
    	// System.out.println(yjje.getText());
    	// System.out.println(jkje.getText());
    	// System.out.println(zlje.getText());
    	// System.out.println(ghhm.getText());
    	// System.out.println(ksmc.getText());
    	// System.out.println(ysxm.getText());
    }
	@FXML
    private void on_btn_Clr_clicked(ActionEvent event)
    {
    	hzlb.clear();
    	hzmc.clear();
    	yjje.clear();
    	jkje.clear();
    	zlje.clear();
    	ghhm.clear();
    	ksmc.clear();
    	ysxm.clear();
    }
    @FXML
    private void on_btn_Exit_clicked(ActionEvent event)
    {
    	((Node)(event.getSource())).getScene().getWindow().hide();
    }
    //自动获取挂号的编号
    private String getHZBH()
    {
        String HZBH = new String("000001");
        return HZBH;
    }
}