import javafx.scene.control.*;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import javafx.fxml.FXML;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.cell.PropertyValueFactory;

@SuppressWarnings("unchecked")

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
    @FXML
    private TableView PatientTable;
    @FXML
    private TableColumn ghbhCol;
    @FXML
    private TableColumn brmcCol;
    @FXML
    private TableColumn rqsjCol;
    @FXML
    private TableColumn hzlbCol;
    @FXML
    private TableView IncomeTable;
    @FXML
    private TableColumn ksmcCol;
    @FXML
    private TableColumn ysbhCol;
    @FXML
    private TableColumn ysmcCol;
    @FXML
    private TableColumn hzlcCol;
    @FXML
    private TableColumn ghrcCol;
    @FXML
    private TableColumn srhjCol;


	private ConnectDB db = new ConnectDB();
    private Connection connection = db.getConnection();
    private ObservableList<PatientInfo> patientItems = FXCollections.observableArrayList();
    private ObservableList<IncomeInfo> incomeItems = FXCollections.observableArrayList();

	@FXML
    private void on_menu_Patient_clicked() throws Exception
    {
        LabelBegin.setVisible(true);
        LabelEnd.setVisible(true);
        BeginDatePicker.setVisible(true);
        EndDatePicker.setVisible(true);
        IncomeTable.setVisible(false);
        PatientTable.setVisible(true);
    	ModeLabel.setText("病人列表");

        ghbhCol.setCellValueFactory(new PropertyValueFactory<PatientInfo, String>("ghbhp"));
        brmcCol.setCellValueFactory(new PropertyValueFactory<PatientInfo, String>("brmcp"));
        rqsjCol.setCellValueFactory(new PropertyValueFactory<PatientInfo, String>("rqsjp"));
        hzlbCol.setCellValueFactory(new PropertyValueFactory<PatientInfo, String>("hzlbp"));

        Statement state = connection.createStatement();
        String sql = "select GHBH, BRMC, RQSJ, SFZJ FROM t_brxx, t_hzxx, t_ghxx where t_brxx.BRBH = t_ghxx.BRBH and t_ghxx.HZBH = t_hzxx.HZBH";
        ResultSet rs = state.executeQuery(sql);
        
        while(rs.next())
        {
            String GHBH = rs.getString("GHBH");
            String BRMC = rs.getString("BRMC");
            String RQ = rs.getDate("RQSJ").toString();
            String SJ = rs.getTime("RQSJ").toString();
            String HZLB = rs.getBoolean("SFZJ") ? "专家号" : "普通号";

            patientItems.add(new PatientInfo(GHBH, BRMC, RQ + " " + SJ, HZLB));
        }
        PatientTable.setItems(patientItems);
    }
    @FXML
    private void on_menu_Income_clicked() throws Exception
    {
        LabelBegin.setVisible(true);
        LabelEnd.setVisible(true);
        BeginDatePicker.setVisible(true);
        EndDatePicker.setVisible(true);
        PatientTable.setVisible(false);
        IncomeTable.setVisible(true);
    	ModeLabel.setText("收入列表");

        ksmcCol.setCellValueFactory(new PropertyValueFactory<IncomeInfo, String>("ksmcp"));
        ysbhCol.setCellValueFactory(new PropertyValueFactory<IncomeInfo, String>("ysbhp"));
        ysmcCol.setCellValueFactory(new PropertyValueFactory<IncomeInfo, String>("ysmcp"));
        hzlcCol.setCellValueFactory(new PropertyValueFactory<IncomeInfo, String>("hzlcp"));
        ghrcCol.setCellValueFactory(new PropertyValueFactory<IncomeInfo, String>("ghrcp"));
        srhjCol.setCellValueFactory(new PropertyValueFactory<IncomeInfo, String>("srhjp"));
    	
    }
	@FXML
    private void on_menu_Exit_clicked()
    {
    	ModeLabel.getScene().getWindow().hide();
    }
}

class PatientInfo
{
    private final StringProperty ghbhp;
    private final StringProperty brmcp;
    private final StringProperty rqsjp;
    private final StringProperty hzlbp;

    public PatientInfo(String ghbh, String brmc, String rqsj, String hzlb)
    {
        this.ghbhp = new SimpleStringProperty(ghbh);
        this.brmcp = new SimpleStringProperty(brmc);
        this.rqsjp = new SimpleStringProperty(rqsj);
        this.hzlbp = new SimpleStringProperty(hzlb);
    }
    public String getGhbh()
    {
        return ghbhp.get();
    }
    public void setghbh(String ghbh)
    {
        ghbhp.set(ghbh);
    }
    public StringProperty ghbhProperty()
    {
        return ghbhp;
    }
    public String getbrmc()
    {
        return brmcp.get();
    }
    public void setbrmc(String brmc)
    {
        brmcp.set(brmc);
    }
    public StringProperty brmcProperty()
    {
        return brmcp;
    }
    public String getrqsj()
    {
        return rqsjp.get();
    }
    public void setrqsj(String rqsj)
    {
        rqsjp.set(rqsj);
    }
    public StringProperty rqsjProperty()
    {
        return rqsjp;
    }
    public String gethzlb()
    {
        return hzlbp.get();
    }
    public void sethzlb(String hzlb)
    {
        hzlbp.set(hzlb);
    }
    public StringProperty hzlbProperty()
    {
        return hzlbp;
    }
}

class IncomeInfo
{
    private final StringProperty ksmcp;
    private final StringProperty ysbhp;
    private final StringProperty ysmcp;
    private final StringProperty hzlcp;
    private final StringProperty ghrcp;
    private final StringProperty srhjp;

    public IncomeInfo(String ksmc, String ysbh, String ysmc, String hzlc, String ghrc, String srhj)
    {
        this.ksmcp = new SimpleStringProperty(ksmc);
        this.ysbhp = new SimpleStringProperty(ysbh);
        this.ysmcp = new SimpleStringProperty(ysmc);
        this.hzlcp = new SimpleStringProperty(hzlc);
        this.ghrcp = new SimpleStringProperty(ghrc);
        this.srhjp = new SimpleStringProperty(srhj);
    }
    public String getksmc()
    {
        return ksmcp.get();
    }
    public void setksmc(String ksmc)
    {
        ksmcp.set(ksmc);
    }
    public StringProperty ksmcProperty()
    {
        return ksmcp;
    }
    public String getysbh()
    {
        return ysbhp.get();
    }
    public void setysbh(String ysbh)
    {
        ysbhp.set(ysbh);
    }
    public StringProperty ysbhProperty()
    {
        return ysbhp;
    }
    public String getysmc()
    {
        return ysmcp.get();
    }
    public void setysmc(String ysmc)
    {
        ysmcp.set(ysmc);
    }
    public StringProperty ysmcProperty()
    {
        return ysmcp;
    }
    public String gethzlc()
    {
        return hzlcp.get();
    }
    public void sethzlc(String hzlc)
    {
        hzlcp.set(hzlc);
    }
    public StringProperty hzlcProperty()
    {
        return hzlcp;
    }
    public String getghrc()
    {
        return ghrcp.get();
    }
    public void setghrc(String ghrc)
    {
        ghrcp.set(ghrc);
    }
    public StringProperty ghrcProperty()
    {
        return ghrcp;
    }
    public String getsrhj()
    {
        return srhjp.get();
    }
    public void setsrhj(String srhj)
    {
        srhjp.set(srhj);
    }
    public StringProperty srhjProperty()
    {
        return srhjp;
    }
}