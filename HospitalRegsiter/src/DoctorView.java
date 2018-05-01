import javafx.scene.control.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.collections.ObservableList;

public class DoctorView
{
	@FXML
	private Label ModeLabel;
    @FXML
    private Label LabelBegin;
    @FXML
    private Label LabelEnd;
    @FXML
    private DatePicker BeginDatePicker;
    @FXML
    private DatePicker EndDatePicker;

	private ConnectDB db = new ConnectDB();
    private Connection connection = db.getConnection();

	@FXML
    private void on_menu_Patient_clicked() throws Exception
    {
        LabelBegin.setVisible(true);
        LabelEnd.setVisible(true);
        BeginDatePicker.setVisible(true);
        EndDatePicker.setVisible(true);
    	ModeLabel.setText("病人列表");
        Statement state = connection.createStatement();
        String sql = "select * from t_brxx";
        ResultSet rs = state.executeQuery(sql);
    	TableView table = new TableView();
        
        // while(rs.next())
        // {
        //     table.setItems(ObservableList);
        // }
    }
    @FXML
    private void on_menu_Income_clicked() throws Exception
    {
        LabelBegin.setVisible(true);
        LabelEnd.setVisible(true);
        BeginDatePicker.setVisible(true);
        EndDatePicker.setVisible(true);
    	ModeLabel.setText("收入列表");
    	
    }
	@FXML
    private void on_menu_Exit_clicked()
    {
    	ModeLabel.getScene().getWindow().hide();
    }
}